package cz.cvut.fit.android.cerberus.data.dao

import android.content.Context
import android.content.SharedPreferences
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import cz.cvut.fit.android.cerberus.data.database.DatabaseHelper

abstract class DAO (private val context: Context) {

    companion object Preferences {
        const val PREFERENCES_NAME = "Cerberus Preferences"

        const val PREFERENCES_STORY_POINTS = "Story points"
        const val PREFERENCES_STORY_NODE_ID = "Story node ID"
        const val PREFERENCES_TEAM_ID = "Team ID"
        const val PREFERENCES_ACTUALIZATION = "Actualization"
    }

    protected fun getDatabase(): SQLiteDatabase {
        return DatabaseHelper.getInstance(context).writableDatabase
    }

    protected fun getPreferences(): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_NAME, 0)
    }

    protected fun prepareWhereClause(columnName: String): String {
        return columnName + " = ?"
    }

    protected fun extractNullableInt(cursor: Cursor, columnName: String): Int? {
        return if (!isValueNull(cursor, columnName)) {
            cursor.getInt(cursor.getColumnIndex(columnName))
        } else {
            null
        }
    }

    protected fun extractNullableLong(cursor: Cursor, columnName: String): Long? {
        return if (!isValueNull(cursor, columnName)) {
            cursor.getLong(cursor.getColumnIndex(columnName))
        } else {
            null
        }
    }

    private fun isValueNull(cursor: Cursor, columnName: String): Boolean {
        return cursor.isNull(cursor.getColumnIndex(columnName))
    }
}