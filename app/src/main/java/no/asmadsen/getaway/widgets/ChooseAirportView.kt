package no.asmadsen.getaway.widgets

import android.content.Context
import android.graphics.Rect
import android.os.Parcel
import android.os.Parcelable
import android.text.InputFilter
import android.text.InputType
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.databinding.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.choose_airport_fragment.*
import no.asmadsen.getaway.R

@InverseBindingMethods(
    InverseBindingMethod(type = ChooseAirportView::class, attribute = "app:editable", method = "isEditable"),
    InverseBindingMethod(type = ChooseAirportView::class, attribute = "app:search", method = "getSearch")
)
class ChooseAirportView(context: Context, private val attrs: AttributeSet? = null, private val defStyle: Int = 0) : FrameLayout(context, attrs, defStyle) {
    constructor(context: Context, attrs: AttributeSet): this(context, attrs, 0)
    constructor(context: Context) : this(context, null, 0)

    private var mOnCloseListener: (() -> Unit)? = null

    private val bag = CompositeDisposable()
    private val mEditable = BehaviorSubject.create<Boolean>()
    private var mSearch = BehaviorSubject.create<String>()
    private var airportName: String = ""
    private var airportIata: String = ""
    private var airportCity: String = ""

    init {
        val view = View.inflate(context, R.layout.view_choose_airport, null)
        addView(view)
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ChooseAirportView,
            defStyle, 0
        ).apply {
            try {
                setEditable(getBoolean(R.styleable.ChooseAirportView_editable, false))
            } finally {
                recycle()
            }
        }
        this.background = view.background
        this.elevation = view.elevation

        view.findViewById<ImageButton>(R.id.closeButtonYourAirport).setOnClickListener {
            mOnCloseListener?.invoke()
        }
        view.findViewById<EditText>(R.id.editTextYourAirport).apply {
            filters = arrayOf(InputFilter.AllCaps())
            doOnTextChanged { text, start, count, after ->
                setSearch(text?.toString() ?: "")
            }
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (mEditable.value == false) return true
        return super.onInterceptTouchEvent(ev)
    }

    fun setOnCloseListener(listener: (() -> Unit)?) {
        mOnCloseListener = listener
    }

    fun isEditable(): Boolean = mEditable.value ?: false

    fun setEditable(value : Boolean) {
        if (mEditable.value == value) return
        mEditable.onNext(value)
        findViewById<EditText>(R.id.editTextYourAirport).apply {
            background = context.theme
                .getDrawable(if (value) R.drawable.edit_text_background else R.drawable.edit_text_transparent)
            isFocusable = value
            isFocusableInTouchMode = value
            inputType = if (value) InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS else InputType.TYPE_NULL
        }
        findViewById<ImageButton>(R.id.closeButtonYourAirport).visibility = if (value) View.VISIBLE else View.GONE
    }

    fun getSearch() = mSearch.value ?: ""

    fun setSearch(value: String) {
        if (mSearch.value != value) {
            mSearch.onNext(value)
            if (isEditable()) {
                val searchBox = findViewById<EditText>(R.id.editTextYourAirport)
                if (!searchBox.text.toString().equals(value, true)) {
                    searchBox.setText(value)
                }
                if (value.equals(airportName, true)) {
                    findViewById<TextView>(R.id.airportIata).visibility = View.VISIBLE
                    findViewById<TextView>(R.id.airportCity).visibility = View.VISIBLE
                } else {
                    findViewById<TextView>(R.id.airportIata).visibility = View.INVISIBLE
                    findViewById<TextView>(R.id.airportCity).visibility = View.INVISIBLE
                }
            }
        }
    }

    fun setAirportName(value: String) {
        airportName = value
        findViewById<EditText>(R.id.editTextYourAirport).setText(value)
    }

    fun getAirportName() = airportName

    fun setAirportIata(value: String) {
        airportIata = value
        findViewById<TextView>(R.id.airportIata).text = value
    }

    fun getAirportIata() = airportIata

    fun setAirportCity(value: String) {
        airportCity = value
        findViewById<TextView>(R.id.airportCity).text = value
    }

    fun getAirportCity() = airportCity

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        bag.clear()
    }

    override fun requestFocus(direction: Int, previouslyFocusedRect: Rect?): Boolean {
        val editText = findViewById<EditText>(R.id.editTextYourAirport)
        return editText.requestFocus(direction, previouslyFocusedRect).apply {
            if (this) {
                val imm = ContextCompat.getSystemService(context!!, InputMethodManager::class.java)
                imm!!.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
                editText.selectAll()
            }
        }
    }


    companion object {
        @BindingAdapter(value = ["app:editableAttrChanged"], requireAll = false)
        @JvmStatic fun setEditableAttrChanged(view: ChooseAirportView, attrChange : InverseBindingListener?) {
            if (attrChange != null) {
                view.mEditable.subscribe {
                    attrChange.onChange()
                }.addTo(view.bag)
            }
        }

        @BindingAdapter(value = ["app:searchAttrChanged"], requireAll = false)
        @JvmStatic fun setSearchChanged(view: ChooseAirportView, attrChange: InverseBindingListener?) {
            if (attrChange != null) {
                view.mSearch.subscribe {
                    attrChange.onChange()
                }.addTo(view.bag)
            }
        }
    }
}