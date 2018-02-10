package cz.cvut.fit.android.cerberus.data.database.tables

import android.database.sqlite.SQLiteDatabase
import cz.cvut.fit.android.cerberus.data.database.prototype.Column
import cz.cvut.fit.android.cerberus.data.database.prototype.Column.*
import cz.cvut.fit.android.cerberus.data.database.prototype.Table

class StoryNodeTable
    : Table(TABLE_NAME) {

    companion object {
        const val TABLE_NAME = "story_nodes"

        const val ID = "id"
        const val PREVIOUS_ID = "previous_id"
        const val ANSWER_ID = "answer_id"
    }

    init {
        addColumn(Column(ID, ValueType.INTEGER, KeyType.PRIMARY, Incrementation.NO, Nullability.NOT_NULL))

        addColumn(Column(PREVIOUS_ID, ValueType.INTEGER, nullability = Nullability.CAN_BE_NULL))
        addColumn(Column(ANSWER_ID, ValueType.INTEGER, nullability = Nullability.CAN_BE_NULL))
    }

    override fun initializeValues(database: SQLiteDatabase) {
        (0 until 75)
                .map { createEmptyValues(ID, it) }
                .forEach{ database.insert(TABLE_NAME, null, it) }
    }
}