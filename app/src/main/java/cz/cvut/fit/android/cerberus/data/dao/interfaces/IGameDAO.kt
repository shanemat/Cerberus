package cz.cvut.fit.android.cerberus.data.dao.interfaces

import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole

interface IGameDAO {

    fun getPoints(role: PlayerRole): Int?

    fun getAllPoints(): HashMap<PlayerRole, Int?>

    fun updatePoints(role: PlayerRole, points: Int)

    fun resetAllPoints()
}