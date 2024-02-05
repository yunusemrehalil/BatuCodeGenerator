package com.nomaddeveloper.batucodegenerator.canvas

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable

class CanvasToBatuCode(private val encryptedProduct: String) : Drawable() {
    private val paint = Paint()

    init {
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.textSize = 50f
        paint.strokeWidth = 4f
    }

    private fun getColorForLetter(letter: String): Int {
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
        val firstLetter = encryptedProduct.firstOrNull()?.toString() ?: ""
        paint.color = getColorForLetter(firstLetter)
        val centerX = bounds.centerX().toFloat()
        val centerY = bounds.centerY().toFloat()
        val radius = bounds.width() / 2f
        canvas.drawCircle(centerX, centerY, radius, paint)
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