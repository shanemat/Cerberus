package cz.cvut.fit.android.cerberus.data.dao.implementation

import android.content.Context
import cz.cvut.fit.android.cerberus.data.dao.DAO
import cz.cvut.fit.android.cerberus.data.dao.interfaces.IStoryPointsDAO

class StoryPointsDAO(context: Context) : DAO(context), IStoryPointsDAO {

    override fun get(): Int {
        return getCurrentPoints()
    }

    override fun add(points: Int) {
        val currentPoints = getCurrentPoints()
        setPointsValue(currentPoints + points)
    }

    override fun subtract(points: Int) {
        val currentPoints = getCurrentPoints()
        setPointsValue(currentPoints - points)
    }

    override fun reset() {
        setPointsValue(0)
    }

    private fun getCurrentPoints(): Int {
        val preferences = getPreferences()
        return preferences.getInt(PREFERENCES_STORY_POINTS, 0)
    }

    private fun setPointsValue(points: Int) {
        val preferences = getPreferences()
        preferences.edit()
                .putInt(PREFERENCES_STORY_POINTS, points)
                .apply()
    }
}