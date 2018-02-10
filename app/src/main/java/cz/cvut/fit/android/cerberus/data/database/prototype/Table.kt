package cz.cvut.fit.android.cerberus.data.database.prototype

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

abstract class Table(private val name: String) {

    private val columns: ArrayList<Column> = ArrayList()

    protected fun addColumn(column: Column) {
        columns.add(column)
    }

    protected fun createEmptyValues(IDColumnName: String, IDValue: Int): ContentValues {
        val values = ContentValues()

        values.put(IDColumnName, IDValue)

        return values
    }

    protected open fun initializeValues(database: SQLiteDatabase) {
        // intentionally left blank for subclasses to override
    }

    fun initialize(database: SQLiteDatabase?) {
        if (database != null) {
            createTable(database)
            initializeValues(database)
        }
    }

    private fun createTable(database: SQLiteDatabase) {
        var command = "CREATE TABLE $name ("
        val columnsCount = columns.size

        for (i in 0 until columnsCount) {
            val column = columns[i]
            command += column.getCreationCommand()
            command += if (!isLast(i)) {
                ", "
            } else {
                ");"
            }
        }

        database.execSQL(command)
    }

    private fun isLast(index: Int): Boolean {
        return index == columns.size - 1
    }
}