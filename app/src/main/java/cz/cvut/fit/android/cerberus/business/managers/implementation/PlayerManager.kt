package cz.cvut.fit.android.cerberus.business.managers.implementation

import android.content.Context
import cz.cvut.fit.android.cerberus.business.managers.interfaces.IPlayerManager
import cz.cvut.fit.android.cerberus.data.dao.DAOFactory
import cz.cvut.fit.android.cerberus.data.dao.interfaces.IPlayerDAO
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.players.Player

object PlayerManager : IPlayerManager {

    private val team = HashMap<PlayerRole, Player>()

    private var teamID: Long = 1
    private var isNotCached = true

    override fun fetchPlayers(context: Context) {
        // TODO implement fetching players via network from web APP

        val actualizationDAO = DAOFactory.getActualizationDAO(context)
        actualizationDAO.notifyDataActualized()
    }

    override fun getPlayer(context: Context, role: PlayerRole): Player? {
        val dao = obtainDAO(context)
        loadCurrentIfNecessary(dao)

        return team[role]
    }

    override fun getTeamID(context: Context): Long {
        val dao = obtainDAO(context)
        loadCurrentIfNecessary(dao)

        return teamID
    }

    override fun getTeam(context: Context): HashMap<PlayerRole, Player> {
        val dao = obtainDAO(context)
        loadCurrentIfNecessary(dao)

        return team
    }

    override fun setCurrentTeam(context: Context, teamID: Long) {
        val dao = obtainDAO(context)
        dao.updateCurrentTeam(teamID)

        this.teamID = teamID
        isNotCached = false
    }

    override fun deleteAll(context: Context) {
        val dao = obtainDAO(context)
        dao.deleteAllPlayers()

        team.clear()
    }

    override fun getCalledName(baseName: String): String {
        // TODO add transformation of base name to its called form
        return baseName
    }

    private fun obtainDAO(context: Context): IPlayerDAO {
        return DAOFactory.getPlayerDAO(context)
    }

    private fun loadCurrentIfNecessary(dao: IPlayerDAO) {
        if (isNotCached) {
            teamID = dao.getCurrentTeam() ?: 1
            isNotCached = false
        }

        if (team.isEmpty()) {
            val players = dao.getTeamPlayers(teamID)
            for (player in players) {
                val role = PlayerRole.getRole(player.roleID)
                if (role != null) {
                    team[role] = player
                }
            }
        }
    }
}