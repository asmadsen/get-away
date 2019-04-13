package no.asmadsen.getaway.adapters

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import java.util.*

class RxDataSource<LayoutBinding : ViewDataBinding, DataType>(@LayoutRes private val itemLayout: Int, var dataSet: List<DataType>) {
    private val adapter = RxAdapterWithOnClick<DataType, LayoutBinding>(itemLayout, dataSet)


    fun bindRecyclerView(recyclerView: RecyclerView): Observable<SimpleViewHolder<DataType, LayoutBinding>> {
        recyclerView.adapter = adapter
        return adapter.asObservable()
    }

    fun asObservable() = adapter.asObservable()

    fun onClickObservable() = adapter.onClickObservable()

    fun updateDataSet(dataSet: List<DataType>): RxDataSource<LayoutBinding, DataType> {
        this.dataSet = dataSet
        return this
    }

    fun updateAdapter() {
        adapter.updateDataSet(dataSet)
    }

    fun map(mapper: (DataType) -> DataType): RxDataSource<LayoutBinding, DataType> {
        dataSet = Observable.fromIterable(dataSet).map(mapper).toList().blockingGet()
        adapter.updateDataSet(dataSet)
        return this
    }

    fun filter(predicate: (DataType) -> Boolean): RxDataSource<LayoutBinding, DataType> {
        dataSet = Observable.fromIterable(dataSet).filter(predicate).toList().blockingGet()
        adapter.updateDataSet(dataSet)
        return this
    }

    fun last(): RxDataSource<LayoutBinding, DataType> {
        dataSet = listOf(Observable.fromIterable(dataSet).blockingLast())
        return this
    }

    fun first(): RxDataSource<LayoutBinding, DataType> {
        dataSet = listOf(Observable.fromIterable(dataSet).blockingFirst())
        return this
    }

    fun lastOrDefault(defaultValue: DataType): RxDataSource<LayoutBinding, DataType> {
        dataSet = Observable.fromIterable(dataSet)
            .takeLast(1)
            .defaultIfEmpty(defaultValue)
            .toList()
            .blockingGet()
        return this
    }

    fun limit(count: Int): RxDataSource<LayoutBinding, DataType> {
        dataSet = Observable.fromIterable(dataSet).take(count.toLong()).toList().blockingGet()
        return this
    }

    fun repeat(count: Long): RxDataSource<LayoutBinding, DataType> {
        dataSet = Observable.fromIterable(dataSet).repeat(count).toList().blockingGet()
        return this
    }

    fun empty(): RxDataSource<LayoutBinding, DataType> {
        dataSet = Collections.emptyList<DataType>()
        return this
    }

    fun concatMap(func: (DataType) -> Observable<out DataType>): RxDataSource<LayoutBinding, DataType> {
        dataSet = Observable.fromIterable(dataSet).concatMap(func).toList().blockingGet()
        return this
    }

    fun concatWith(observable: Observable<out DataType>): RxDataSource<LayoutBinding, DataType> {
        dataSet = Observable.fromIterable(dataSet).concatWith(observable).toList().blockingGet()
        return this
    }

    fun distinct(): RxDataSource<LayoutBinding, DataType> {
        dataSet = Observable.fromIterable(dataSet).distinct().toList().blockingGet()
        return this
    }

    fun elementAt(index: Long): RxDataSource<LayoutBinding, DataType> {
        dataSet = listOf(Observable.fromIterable(dataSet).elementAt(index).blockingGet())
        return this
    }

    fun elementAtOrDefault(index: Long, defaultValue: DataType): RxDataSource<LayoutBinding, DataType> {
        dataSet = listOf(Observable.fromIterable(dataSet).elementAt(index, defaultValue)
            .blockingGet())
        return this
    }

    fun first(defaultItem: DataType): RxDataSource<LayoutBinding, DataType> {
        dataSet = listOf(Observable.fromIterable(dataSet).first(defaultItem).blockingGet())
        return this
    }

    fun flatMap(func: (DataType) -> Observable<out DataType>): RxDataSource<LayoutBinding, DataType> {
        dataSet = Observable.fromIterable(dataSet).flatMap(func).toList().blockingGet()
        return this
    }

    fun reduce(initialValue: DataType, reducer: (DataType, DataType) -> DataType): RxDataSource<LayoutBinding, DataType> {
        dataSet = listOf(Observable.fromIterable(dataSet).reduce(initialValue, reducer).blockingGet())
        return this
    }

    fun take(count: Long): RxDataSource<LayoutBinding, DataType> {
        dataSet = Observable.fromIterable(dataSet).take(count).toList().blockingGet()
        return this
    }
}