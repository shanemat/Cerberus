package cz.cvut.fit.android.cerberus.business.managers.interfaces

import android.content.Context
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole

interface IGameManager {

    fun isScored(context: Context, role: PlayerRole): Boolean

    fun getScore(context: Context, role: PlayerRole): Int?

    fun getAllScores(context: Context): HashMap<PlayerRole, Int?>

    fun setScore(context: Context, role: PlayerRole, points: Int)

    fun resetAllScores(context: Context)
}