package cz.cvut.fit.android.cerberus.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import cz.cvut.fit.android.cerberus.data.database.prototype.Table
import cz.cvut.fit.android.cerberus.data.database.tables.GameTable
import cz.cvut.fit.android.cerberus.data.database.tables.PlayerTable
import cz.cvut.fit.android.cerberus.data.database.tables.RecognitionTable
import cz.cvut.fit.android.cerberus.data.database.tables.StoryNodeTable
import cz.cvut.fit.android.cerberus.structures.prototype.SingletonHolder

class DatabaseHelper private constructor (context: Context)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object : SingletonHolder<DatabaseHelper, Context>(::DatabaseHelper) {
        const val DATABASE_NAME = "Cerberus-DB"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(database: SQLiteDatabase?) {
        val tables = getTables()
        for (table in tables) {
            table.initialize(database)
        }
    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, currentVersion: Int) {
        // intentionally left blank -  add handling for different versions if necessary
    }

    private fun getTables(): ArrayList<Table> {
        val tables = ArrayList<Table>()

        tables.add(GameTable())
        tables.add(PlayerTable())
        tables.add(StoryNodeTable())
        tables.add(RecognitionTable())

        return tables
    }
}