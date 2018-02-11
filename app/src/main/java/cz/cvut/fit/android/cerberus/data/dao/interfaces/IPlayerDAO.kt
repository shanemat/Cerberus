package cz.cvut.fit.android.cerberus.data.dao.interfaces

import cz.cvut.fit.android.cerberus.structures.players.Player

interface IPlayerDAO {

    fun insertPlayers(players: ArrayList<Player>)

    fun getCurrentTeam(): Long?

    fun getTeamPlayers(teamID: Long): ArrayList<Player>

    fun updateCurrentTeam(teamID: Long)

    fun deleteAllPlayers()
}