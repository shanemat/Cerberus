package cz.cvut.fit.android.cerberus.data.dao.implementation

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import cz.cvut.fit.android.cerberus.data.dao.DAO
import cz.cvut.fit.android.cerberus.data.dao.interfaces.IPlayerDAO
import cz.cvut.fit.android.cerberus.data.database.tables.PlayerTable
import cz.cvut.fit.android.cerberus.structures.players.Player

class PlayerDAO(context: Context) : DAO(context), IPlayerDAO {

    override fun insertPlayers(players: ArrayList<Player>) {
        val database = getDatabase()

        players
                .map { getValuesFrom(it) }
                .forEach { database.insert(PlayerTable.TABLE_NAME, null, it) }
    }

    override fun getCurrentTeam(): Long {
        val preferences = getPreferences()
        return preferences.getLong(PREFERENCES_TEAM_ID, 1L)
    }

    override fun getTeamPlayers(teamID: Long): ArrayList<Player> {
        val database = getDatabase()
        val players = ArrayList<Player>()

        val whereClause = prepareWhereClause(PlayerTable.TEAM_ID)
        val whereArgs = arrayOf(teamID.toString())

        val cursor = database.query(PlayerTable.TABLE_NAME, null,
                whereClause, whereArgs, null, null, null)

        cursor.use { it ->
            while (it.moveToNext()) {
                players.add(getPlayerFrom(it))
            }
        }

        return players
    }

    override fun updateCurrentTeam(teamID: Long) {
        val preferences = getPreferences()
        preferences.edit()
                .putLong(PREFERENCES_TEAM_ID, teamID)
                .apply()
    }

    override fun deleteAllPlayers() {
        val database = getDatabase()
        database.delete(PlayerTable.TABLE_NAME, null, null)
    }

    private fun getValuesFrom(player: Player): ContentValues {
        val values = ContentValues()

        values.put(PlayerTable.TEAM_ID, player.teamID)
        values.put(PlayerTable.ROLE_ID, player.roleID)

        values.put(PlayerTable.NAME, player.name)
        values.put(PlayerTable.SURNAME, player.surname)

        return values
    }

    private fun getPlayerFrom(cursor: Cursor): Player {
        val playerID = cursor.getLong(cursor.getColumnIndex(PlayerTable.ID))
        val teamID = cursor.getLong(cursor.getColumnIndex(PlayerTable.TEAM_ID))
        val roleID = cursor.getLong(cursor.getColumnIndex(PlayerTable.ROLE_ID))

        val name = cursor.getString(cursor.getColumnIndex(PlayerTable.NAME))
        val surname = cursor.getString(cursor.getColumnIndex(PlayerTable.SURNAME))

        return Player(playerID, teamID, roleID, name, surname)
    }
}