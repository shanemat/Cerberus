package cz.cvut.fit.android.cerberus.data.dao.interfaces

interface IRecognitionDAO {

    fun isAnswered(questionID: Long): Boolean

    fun setAnswered(questionID: Long, answered: Boolean)
}