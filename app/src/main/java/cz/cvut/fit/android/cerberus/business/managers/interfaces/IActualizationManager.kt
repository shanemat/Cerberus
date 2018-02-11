package cz.cvut.fit.android.cerberus.business.managers.interfaces

import android.content.Context
import java.util.*

interface IActualizationManager {

    fun getDate(context: Context): Date
}