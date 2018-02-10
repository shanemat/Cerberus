package cz.cvut.fit.android.cerberus.data.database.tables

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import cz.cvut.fit.android.cerberus.data.database.prototype.Column
import cz.cvut.fit.android.cerberus.data.database.prototype.Column.*
import cz.cvut.fit.android.cerberus.data.database.prototype.Table

class RecognitionTable
    : Table(TABLE_NAME) {

    companion object {
        const val TABLE_NAME = "recognition"

        const val ID = "id"
        const val IS_ANSWERED = "is_answered"
    }

    init {
        addColumn(Column(ID, ValueType.INTEGER, KeyType.PRIMARY, Incrementation.NO, Nullability.NOT_NULL))

        addColumn(Column(IS_ANSWERED, ValueType.INTEGER, nullability = Nullability.NOT_NULL))
    }

    override fun initializeValues(database: SQLiteDatabase) {
        (0 until 22)
                .map { createInitialValues(it) }
                .forEach{ database.insert(TABLE_NAME, null, it) }
    }

    private fun createInitialValues(IDValue: Int): ContentValues {
        val values = ContentValues()

        values.put(ID, IDValue)
        values.put(IS_ANSWERED, false)

        return values
    }
}