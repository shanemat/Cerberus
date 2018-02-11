package cz.cvut.fit.android.cerberus.business.managers.implementation

import android.content.Context
import cz.cvut.fit.android.cerberus.business.managers.interfaces.IRecognitionManager
import cz.cvut.fit.android.cerberus.data.dao.DAOFactory
import cz.cvut.fit.android.cerberus.data.dao.interfaces.IRecognitionDAO

object RecognitionManager : IRecognitionManager {

    private val questions = HashMap<Long, Boolean>()

    override fun isAnswered(context: Context, questionID: Long): Boolean {
        val dao = obtainDAO(context)
        loadIfNecessary(dao, questionID)

        return questions[questionID]?: false
    }

    override fun setAnswered(context: Context, questionID: Long, answered: Boolean) {
        val dao = obtainDAO(context)
        dao.setAnswered(questionID, answered)

        questions[questionID] = answered
    }

    private fun obtainDAO(context: Context): IRecognitionDAO {
        return DAOFactory.getRecognitionDAO(context)
    }

    private fun loadIfNecessary(dao: IRecognitionDAO, questionID: Long) {
        if (!questions.containsKey(questionID)) {
            val answered = dao.isAnswered(questionID)
            questions[questionID] = answered
        }
    }
}