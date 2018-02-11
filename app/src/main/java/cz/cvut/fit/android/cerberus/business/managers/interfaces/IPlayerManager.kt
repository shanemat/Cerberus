package cz.cvut.fit.android.cerberus.business.managers.interfaces

import android.content.Context
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.players.Player

interface IPlayerManager {

    fun fetchPlayers(context: Context)

    fun getPlayer(context: Context, role: PlayerRole): Player?

    fun getTeam(context: Context): HashMap<PlayerRole, Player>

    fun setCurrentTeam(context: Context, teamID: Long)

    fun deleteAll(context: Context)

    fun getCalledName(baseName: String): String
}