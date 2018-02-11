package cz.cvut.fit.android.cerberus.business.managers.implementation

import android.content.Context
import cz.cvut.fit.android.cerberus.business.managers.interfaces.IStoryNodeManager
import cz.cvut.fit.android.cerberus.data.dao.DAOFactory
import cz.cvut.fit.android.cerberus.data.dao.interfaces.IStoryNodeDAO
import cz.cvut.fit.android.cerberus.structures.story.StoryFactory
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode

object StoryNodeManager : IStoryNodeManager {

    private val storyNodes = HashMap<Long, StoryNodeInfo>()

    private var currentNodeID: Long = 0
    private var isNotCached = true

    override fun getCurrent(context: Context): StoryNode {
        val dao = obtainDAO(context)
        loadCurrentIfNecessary(dao)

        val previousNodeID = storyNodes[currentNodeID]?.previousID ?: 0
        return StoryFactory.getStoryNode(currentNodeID, previousNodeID)
    }

    override fun getAnswerID(context: Context): Long? {
        val dao = obtainDAO(context)
        loadCurrentIfNecessary(dao)

        return storyNodes[currentNodeID]?.answerID
    }

    override fun setAnswerID(context: Context, answerID: Long) {
        val dao = obtainDAO(context)
        loadCurrentIfNecessary(dao)

        val currentNodeInfo = storyNodes[currentNodeID]
        if (currentNodeInfo != null) {
            currentNodeInfo.answerID = answerID
        }

        dao.updateChosenAnswerID(currentNodeID, answerID)
    }

    override fun moveForward(context: Context, nextID: Long) {
        val dao = obtainDAO(context)
        loadCurrentIfNecessary(dao)

        dao.updateCurrentNodeID(nextID)
        dao.updatePreviousNodeID(nextID, currentNodeID)

        currentNodeID = nextID
    }

    override fun moveBackward(context: Context) {
        val dao = obtainDAO(context)
        loadCurrentIfNecessary(dao)

        val currentNodeInfo = storyNodes[currentNodeID]
        if (currentNodeInfo != null) {
            dao.updateCurrentNodeID(currentNodeInfo.previousID)
            currentNodeID = currentNodeInfo.previousID
        }
    }

    override fun resetStory(context: Context) {
        val dao = obtainDAO(context)
        dao.resetStory()
    }

    private fun obtainDAO(context: Context): IStoryNodeDAO {
        return DAOFactory.getStoryNodeDAO(context)
    }

    private fun loadCurrentIfNecessary(dao: IStoryNodeDAO) {
        if (isNotCached) {
            currentNodeID = dao.getCurrentNodeID() ?: 0
            isNotCached = false
        }

        if (!storyNodes.containsKey(currentNodeID)) {
            val previousID = dao.getPreviousNodeID(currentNodeID) ?: 0
            val answerID = dao.getChosenAnswerID(currentNodeID)

            storyNodes[currentNodeID] = StoryNodeInfo(previousID, answerID)
        }
    }

    data class StoryNodeInfo (var previousID: Long,
                              var answerID: Long?)
}