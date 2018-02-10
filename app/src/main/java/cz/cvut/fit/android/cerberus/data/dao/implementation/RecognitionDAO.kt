package cz.cvut.fit.android.cerberus.data.dao.implementation

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import cz.cvut.fit.android.cerberus.data.dao.DAO
import cz.cvut.fit.android.cerberus.data.dao.interfaces.IRecognitionDAO
import cz.cvut.fit.android.cerberus.data.database.tables.RecognitionTable

class RecognitionDAO(context: Context) : DAO(context), IRecognitionDAO {

    override fun isAnswered(questionID: Long): Boolean {
        val database = getDatabase()

        val whereClause = prepareWhereClause(RecognitionTable.ID)
        val whereArgs = arrayOf(questionID.toString())

        val cursor = database.query(RecognitionTable.TABLE_NAME, null,
                whereClause, whereArgs, null, null, null)

        cursor.use { it ->
            if (it.moveToFirst()) {
                return getAnsweredFrom(it)
            }
        }

        return false
    }

    override fun setAnswered(questionID: Long, answered: Boolean) {
        val database = getDatabase()

        val whereClause = prepareWhereClause(RecognitionTable.ID)
        val whereArgs = arrayOf(questionID.toString())

        val values = getValuesFrom(answered)

        database.update(RecognitionTable.TABLE_NAME, values, whereClause, whereArgs)
    }

    private fun getValuesFrom(answered: Boolean): ContentValues {
        val values = ContentValues()

        val value = if (answered) 1 else 0
        values.put(RecognitionTable.IS_ANSWERED, value)

        return values
    }

    private fun getAnsweredFrom(cursor: Cursor): Boolean {
        val value = cursor.getInt(cursor.getColumnIndex(RecognitionTable.IS_ANSWERED))
        return (value == 1)
    }
}