package cz.cvut.fit.android.cerberus.data.dao.implementation

import android.content.Context
import cz.cvut.fit.android.cerberus.data.dao.DAO
import cz.cvut.fit.android.cerberus.data.dao.interfaces.IActualizationDAO
import java.util.*

class ActualizationDAO(context: Context) : DAO(context), IActualizationDAO {

    override fun getDateOfLastActualization(): Date? {
        val preferences = getPreferences()
        val actualizationSeconds = preferences.getLong(PREFERENCES_ACTUALIZATION, 0)

        return if (actualizationSeconds != 0L) {
            Date(actualizationSeconds)
        } else {
            null
        }
    }

    override fun notifyDataActualized() {
        val preferences = getPreferences()
        val currentSeconds = Date().time

        preferences.edit()
                .putLong(PREFERENCES_ACTUALIZATION, currentSeconds)
                .apply()
    }
}