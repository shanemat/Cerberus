package cz.cvut.fit.android.cerberus.data.dao.implementation

import android.content.ContentValues
import android.content.Context
import cz.cvut.fit.android.cerberus.data.dao.DAO
import cz.cvut.fit.android.cerberus.data.dao.interfaces.IGameDAO
import cz.cvut.fit.android.cerberus.data.database.tables.GameTable
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole

class GameDAO(context: Context) : DAO(context), IGameDAO {

    override fun getPoints(role: PlayerRole): Int? {
        val database = getDatabase()

        val whereClause = prepareWhereClause(GameTable.ID)
        val whereArgs = arrayOf(role.ID.toString())

        val cursor = database.query(GameTable.TABLE_NAME, null,
                whereClause, whereArgs, null, null, null, null)

        cursor.use { it ->
            if (cursor.moveToFirst()) {
                return extractNullableInt(it, GameTable.POINTS)
            }
        }

        return null
    }

    override fun getAllPoints(): HashMap<PlayerRole, Int?> {
        val database = getDatabase()
        val allPoints = HashMap<PlayerRole, Int?>()

        val cursor = database.query(GameTable.TABLE_NAME, null, null, null,
                null, null, null, null)

        cursor.use { it ->
            while (it.moveToNext()) {
                val roleID = cursor.getLong(cursor.getColumnIndex(GameTable.ID))
                val role = PlayerRole.getRole(roleID)

                val points = extractNullableInt(cursor, GameTable.POINTS)

                if (role != null) {
                    allPoints[role] = points
                }
            }
        }

        return allPoints
    }

    override fun updatePoints(role: PlayerRole, points: Int) {
        val database = getDatabase()

        val whereClause = prepareWhereClause(GameTable.ID)
        val whereArgs = arrayOf(role.ID.toString())

        val values = ContentValues()
        values.put(GameTable.POINTS, points)

        database.update(GameTable.TABLE_NAME, values, whereClause, whereArgs)
    }

    override fun resetAllPoints() {
        val database = getDatabase()

        val values = ContentValues()
        values.putNull(GameTable.POINTS)

        database.update(GameTable.TABLE_NAME, values, null, null)
    }
}