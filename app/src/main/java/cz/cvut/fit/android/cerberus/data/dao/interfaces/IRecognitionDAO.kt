package cz.cvut.fit.android.cerberus.data.dao.interfaces

interface IRecognitionDAO {

    fun getCurrent(): Int?

    fun isAnswered(questionID: Int): Boolean

    fun setCurrent(questionID: Int)

    fun setAnswered(questionID: Int, answered: Boolean)

    fun resetAll()
}