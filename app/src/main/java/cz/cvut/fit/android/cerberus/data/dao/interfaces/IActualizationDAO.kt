package cz.cvut.fit.android.cerberus.data.dao.interfaces

import java.util.*

interface IActualizationDAO {

    fun getDateOfLastActualization(): Date?

    fun notifyDataActualized()
}