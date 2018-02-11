package cz.cvut.fit.android.cerberus.business.managers.implementation

import android.content.Context
import cz.cvut.fit.android.cerberus.business.managers.interfaces.IActualizationManager
import cz.cvut.fit.android.cerberus.data.dao.DAOFactory
import java.util.*

object ActualizationManager : IActualizationManager {

    override fun getDate(context: Context): Date {
        val dao = DAOFactory.getActualizationDAO(context)
        return dao.getDateOfLastActualization() ?: Date()
    }
}