package com.nomaddeveloper.batucodegenerator.canvas

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable

class CanvasToBatuCode(private val encryptedProduct: String) : Drawable() {
    private val firstPaint = Paint()
    private val secondPaint = Paint()
    private val thirdPaint = Paint()

    init {
        firstPaint.isAntiAlias = true
        firstPaint.style = Paint.Style.STROKE
        firstPaint.textSize = 50f
        firstPaint.strokeWidth = 4f

        secondPaint.isAntiAlias = true
        secondPaint.style = Paint.Style.FILL

        thirdPaint.isAntiAlias = true
        thirdPaint.style = Paint.Style.FILL
    }

    private fun getColorForFirstLetter(letter: String): Int {
        return when (letter.lowercase()) {
            "a", "b", "c" -> Color.RED
            "d", "e", "f" -> Color.GREEN
            "g", "h", "i" -> Color.BLUE
            "j", "k", "l" -> Color.MAGENTA
            "m", "n", "o" -> Color.CYAN
            else -> Color.BLACK
        }
    }

    private fun getColorForSecondLetter(letter: String): Int {
        return when (letter.lowercase()) {
            "a", "b", "c" -> Color.RED
            "d", "e", "f" -> Color.GREEN
            "g", "h", "i" -> Color.BLUE
            "j", "k", "l" -> Color.MAGENTA
            "m", "n", "o" -> Color.CYAN
            else -> Color.BLACK
        }
    }

    private fun getColorForThirdLetter(letter: String): Int {
        return when (letter.lowercase()) {
            "a", "b", "c" -> Color.RED
            "d", "e", "f" -> Color.GREEN
            "g", "h", "i" -> Color.BLUE
            "j", "k", "l" -> Color.MAGENTA
            "m", "n", "o" -> Color.CYAN
            else -> Color.BLACK
        }
    }

    override fun draw(canvas: Canvas) {
        val firstLetter = encryptedProduct[0].toString()
        val secondLetter = encryptedProduct[1].toString()
        val thirdLetter = encryptedProduct[2].toString()
        firstPaint.color = getColorForFirstLetter(firstLetter)
        secondPaint.color = getColorForSecondLetter(secondLetter)
        thirdPaint.color = getColorForThirdLetter(thirdLetter)
        val centerX = bounds.centerX().toFloat()
        val centerY = bounds.centerY().toFloat()
        val radius = (bounds.width().coerceAtMost(bounds.height()) / 2).toFloat()
        canvas.drawCircle(centerX, centerY, radius, firstPaint)
        canvas.drawRect(
            centerX - (radius / 2),
            centerY - (radius / 2),
            centerX,
            centerY,
            secondPaint
        )
        canvas.drawRect(
            centerX,
            centerY,
            centerX + (radius / 2),
            centerY + (radius / 2),
            thirdPaint
        )
    }

    override fun setAlpha(p0: Int) {
        TODO("Not yet implemented")
    }

    override fun setColorFilter(p0: ColorFilter?) {
        TODO("Not yet implemented")
    }

    override fun getOpacity(): Int {
        return PixelFormat.UNKNOWN
    }
}