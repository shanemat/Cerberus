package cz.cvut.fit.android.cerberus.data.dao.implementation

import android.content.ContentValues
import android.content.Context
import cz.cvut.fit.android.cerberus.data.dao.DAO
import cz.cvut.fit.android.cerberus.data.dao.interfaces.IStoryNodeDAO
import cz.cvut.fit.android.cerberus.data.database.tables.StoryNodeTable

class StoryNodeDAO(context: Context) : DAO(context), IStoryNodeDAO {

    override fun getCurrentNodeID(): Long? {
        val preferences = getPreferences()
        return preferences.getLong(PREFERENCES_STORY_NODE_ID, 0)
    }

    override fun getPreviousNodeID(currentNodeID: Long): Long? {
        return getLong(currentNodeID, StoryNodeTable.PREVIOUS_ID)
    }

    override fun getChosenAnswerID(currentNodeID: Long): Long? {
        return getLong(currentNodeID, StoryNodeTable.ANSWER_ID)
    }

    override fun updateCurrentNodeID(currentNodeID: Long) {
        val preferences = getPreferences()
        preferences.edit()
                .putLong(PREFERENCES_STORY_NODE_ID, currentNodeID)
                .apply()
    }

    override fun updatePreviousNodeID(currentNodeID: Long, previousNodeID: Long) {
        updateLong(currentNodeID, previousNodeID, StoryNodeTable.PREVIOUS_ID)
    }

    override fun updateChosenAnswerID(currentNodeID: Long, answerID: Long) {
        updateLong(currentNodeID, answerID, StoryNodeTable.ANSWER_ID)
    }

    override fun resetStory() {
        val database = getDatabase()

        val values = ContentValues()
        values.putNull(StoryNodeTable.PREVIOUS_ID)
        values.putNull(StoryNodeTable.ANSWER_ID)

        database.update(StoryNodeTable.TABLE_NAME, values, null, null)

        val preferences = getPreferences()
        preferences.edit()
                .putLong(PREFERENCES_STORY_NODE_ID, 0)
                .apply()
    }

    private fun getLong(currentNodeID: Long, columnName: String): Long? {
        val database = getDatabase()

        val whereClause = prepareWhereClause(StoryNodeTable.ID)
        val whereArgs = arrayOf(currentNodeID.toString())

        val cursor = database.query(StoryNodeTable.TABLE_NAME, null,
                whereClause, whereArgs, null, null, null)

        cursor.use { it ->
            if (cursor.moveToFirst()) {
                return extractNullableLong(it, columnName)
            }
        }

        return null
    }

    private fun updateLong(currentNodeID: Long, newValue: Long, columnName: String) {
        val database = getDatabase()

        val whereClause = prepareWhereClause(StoryNodeTable.ID)
        val whereArgs = arrayOf(currentNodeID.toString())

        val values = ContentValues()
        values.put(columnName, newValue)

        database.update(StoryNodeTable.TABLE_NAME, values, whereClause, whereArgs)
    }
}