package cz.cvut.fit.android.cerberus.business.managers.interfaces

import android.content.Context

interface IStoryPointsManager {

    fun get(context: Context): Int

    fun add(context: Context, points: Int)

    fun subtract(context: Context, points: Int)

    fun reset(context: Context)
}