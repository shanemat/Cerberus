package cz.cvut.fit.android.cerberus.data.database.tables

import android.database.sqlite.SQLiteDatabase
import cz.cvut.fit.android.cerberus.data.database.prototype.Column
import cz.cvut.fit.android.cerberus.data.database.prototype.Column.*
import cz.cvut.fit.android.cerberus.data.database.prototype.Table

class GameTable
    : Table(TABLE_NAME) {

    companion object Columns {
        const val TABLE_NAME = "game_points"

        const val ID = "id"
        const val POINTS = "points"
    }

    init {
        addColumn(Column(ID, ValueType.INTEGER, KeyType.PRIMARY, Incrementation.NO, Nullability.NOT_NULL))

        addColumn(Column(POINTS, ValueType.INTEGER, nullability = Nullability.CAN_BE_NULL))
    }

    override fun initializeValues(database: SQLiteDatabase) {
        (0 until 10)
                .map { createEmptyValues(ID, it) }
                .forEach { database.insert(TABLE_NAME, null, it) }
    }
}