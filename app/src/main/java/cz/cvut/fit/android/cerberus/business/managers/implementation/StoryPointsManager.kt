package cz.cvut.fit.android.cerberus.business.managers.implementation

import android.content.Context
import cz.cvut.fit.android.cerberus.business.managers.interfaces.IStoryPointsManager
import cz.cvut.fit.android.cerberus.data.dao.DAOFactory
import cz.cvut.fit.android.cerberus.data.dao.interfaces.IStoryPointsDAO

object StoryPointsManager : IStoryPointsManager {

    private var storyPoints: Int = 0
    private var isNotCached = true

    override fun get(context: Context): Int {
        val dao = obtainDAO(context)
        loadIfNecessary(dao)

        return storyPoints
    }

    override fun add(context: Context, points: Int) {
        val dao = obtainDAO(context)
        loadIfNecessary(dao)

        storyPoints += points
        dao.add(points)
    }

    override fun subtract(context: Context, points: Int) {
        val dao = obtainDAO(context)
        loadIfNecessary(dao)

        storyPoints -= points
        dao.subtract(points)
    }

    override fun reset(context: Context) {
        val dao = obtainDAO(context)

        storyPoints = 0
        dao.reset()
    }

    private fun obtainDAO(context: Context): IStoryPointsDAO {
        return DAOFactory.getStoryPointsDAO(context)
    }

    private fun loadIfNecessary(dao: IStoryPointsDAO) {
        if (isNotCached) {
            storyPoints = dao.get()
            isNotCached = false
        }
    }
}