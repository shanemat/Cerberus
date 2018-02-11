package cz.cvut.fit.android.cerberus.business.managers.interfaces

import android.content.Context

interface IRecognitionManager {

    fun isAnswered(context: Context, questionID: Long): Boolean

    fun setAnswered(context: Context, questionID: Long, answered: Boolean)
}