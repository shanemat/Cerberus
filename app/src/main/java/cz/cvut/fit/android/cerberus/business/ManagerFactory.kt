package cz.cvut.fit.android.cerberus.business

import cz.cvut.fit.android.cerberus.business.managers.implementation.*
import cz.cvut.fit.android.cerberus.business.managers.interfaces.*

object ManagerFactory {

    fun getActualizationManager(): IActualizationManager {
        return ActualizationManager
    }
}