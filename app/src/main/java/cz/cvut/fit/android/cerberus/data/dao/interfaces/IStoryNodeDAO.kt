package cz.cvut.fit.android.cerberus.data.dao.interfaces

interface IStoryNodeDAO {

    fun getPreviousNodeID(currentNodeID: Long): Long?

    fun getChosenAnswerID(currentNodeID: Long): Long?

    fun updatePreviousNodeID(currentNodeID: Long, previousNodeID: Long)

    fun updateChosenAnswerID(currentNodeID: Long, answerID: Long)

    fun resetStory()
}