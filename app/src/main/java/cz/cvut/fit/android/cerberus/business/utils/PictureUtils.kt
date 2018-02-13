package cz.cvut.fit.android.cerberus.business.utils

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Point

object PictureUtils {

    fun getScaledBitmap(path: String, activity: Activity): Bitmap {
        val size = Point()
        activity.windowManager.defaultDisplay.getSize(size)

        return getScaledBitmap(path, size.x, size.y)
    }

    private fun getScaledBitmap(path: String, requiredWidth: Int, requiredHeight: Int): Bitmap {
        var options = BitmapFactory.Options()
        options.inJustDecodeBounds = true

        BitmapFactory.decodeFile(path, options)

        val originalWidth = options.outWidth
        val originalHeight = options.outHeight

        var resamplingFactor = 1
        if (needsToBeResized(originalWidth, originalHeight, requiredWidth, requiredHeight)) {
            resamplingFactor = if (isLandscape(originalWidth, originalHeight)) {
                roundFraction(originalHeight, requiredHeight)
            } else {
                roundFraction(originalWidth, requiredWidth)
            }
        }

        options = BitmapFactory.Options()
        options.inSampleSize = resamplingFactor

        return BitmapFactory.decodeFile(path, options)
    }

    private fun needsToBeResized(originalWidth: Int, originalHeight:Int,
                                 requiredWidth: Int, requiredHeight: Int): Boolean {
        return originalWidth > requiredWidth || originalHeight > requiredHeight
    }

    private fun isLandscape(originalWidth: Int, originalHeight: Int): Boolean {
        return originalWidth > originalHeight
    }

    private fun roundFraction(numerator: Int, denominator: Int): Int {
        return Math.round(numerator.toFloat() / denominator.toFloat())
    }
}