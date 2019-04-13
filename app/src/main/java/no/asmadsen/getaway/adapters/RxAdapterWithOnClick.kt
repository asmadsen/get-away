package no.asmadsen.getaway.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.minimize.android.rxrecycleradapter.OnViewHolderInflated
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.airport_item.view.*
import no.asmadsen.getaway.R

class RxAdapterWithOnClick<DataType, LayoutBinding : ViewDataBinding>(@param:LayoutRes private val mItem_layout: Int,
                                                                      private var dataSet: List<DataType>
) : RecyclerView.Adapter<SimpleViewHolder<DataType, LayoutBinding>>() {
    private val mPublishSubject: PublishSubject<SimpleViewHolder<DataType, LayoutBinding>> = PublishSubject.create()
    private val mOnClickPublishSubject: PublishSubject<DataType> = PublishSubject.create()
    private var mOnViewHolderInflate: OnViewHolderInflated? = null

    fun setOnViewHolderInflate(onViewHolderInflate: OnViewHolderInflated) {
        mOnViewHolderInflate = onViewHolderInflate
    }

    fun asObservable() : Observable<SimpleViewHolder<DataType, LayoutBinding>> = mPublishSubject

    fun onClickObservable() : Observable<DataType> = mOnClickPublishSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder<DataType, LayoutBinding> {
        val view = LayoutInflater.from(parent.context).inflate(mItem_layout, parent, false)
        mOnViewHolderInflate?.onInflated(view, parent, viewType)
        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder<DataType, LayoutBinding>, position: Int) {
        holder.item = dataSet[position]
        mPublishSubject.onNext(holder)
    }

    override fun getItemCount() = dataSet.size

    fun updateDataSet(dataSet: List<DataType>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

}

open class SimpleViewHolder<T, out V : ViewDataBinding>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val viewDataBinding: V? = DataBindingUtil.bind(itemView)

    var item: T? = null

    init {
        itemView.setOnClickListener( View.OnClickListener {
            print(adapterPosition)
        })
    }
}
