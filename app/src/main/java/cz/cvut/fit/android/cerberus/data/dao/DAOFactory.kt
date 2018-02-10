package cz.cvut.fit.android.cerberus.data.dao

import android.content.Context
import cz.cvut.fit.android.cerberus.data.dao.implementation.*
import cz.cvut.fit.android.cerberus.data.dao.interfaces.*

object DAOFactory {

    fun getActualizationDAO(context: Context): IActualizationDAO {
        return ActualizationDAO(context)
    }

    fun getGameDAO(context: Context): IGameDAO {
        return GameDAO(context)
    }

    fun getPlayerDAO(context: Context): IPlayerDAO {
        return PlayerDAO(context)
    }

    fun getRecognitionDAO(context: Context): IRecognitionDAO {
        return RecognitionDAO(context)
    }
}