package cz.cvut.fit.android.cerberus.business.managers.interfaces

import android.content.Context

interface IRecognitionManager {

    fun getCurrent(context: Context): Int

    fun isAnswered(context: Context): Boolean

    fun moveBack(context: Context)

    fun moveForward(context: Context)

    fun setAnswered(context: Context, answered: Boolean)

    fun resetAll(context: Context)
}