package ru.trinitydigital.customviews.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import ru.trinitydigital.customviews.R
import ru.trinitydigital.customviews.ui.ResultData

class CustomResultView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    init {
        View.inflate(context, R.layout.view_custom_result, this)
    }

    private val firstResult = findViewById<TextView>(R.id.firstResult)
    private val secondResult = findViewById<TextView>(R.id.secondResult)
    private val tvTitle = findViewById<TextView>(R.id.title)

    fun setupViews(data: ResultData) {
        firstResult.text = data.firstRes
        secondResult.text = data.secondRes
        tvTitle.text = data.title
    }
}