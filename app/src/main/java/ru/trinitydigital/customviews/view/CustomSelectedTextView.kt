package ru.trinitydigital.customviews.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import ru.trinitydigital.customviews.R

class CustomSelectedTextView(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    var selected: Int? = null
    var unselected: Int? = null

    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val typedStylable =
                context.obtainStyledAttributes(attrs, R.styleable.CustomSelectedTextView)
            selected =
                typedStylable.getColor(
                    R.styleable.CustomSelectedTextView_textColorSelected,
                    ContextCompat.getColor(context, R.color.black)
                )

            unselected =
                typedStylable.getColor(
                    R.styleable.CustomSelectedTextView_textColorUnSelected,
                    ContextCompat.getColor(context, R.color.black)
                )
            typedStylable.recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        changeSelected()
    }

    private fun changeSelected() {
        if (isSelected) {
            selected?.let { this.setTextColor(it) }
        } else {
            unselected?.let { this.setTextColor(it) }
        }
    }
}