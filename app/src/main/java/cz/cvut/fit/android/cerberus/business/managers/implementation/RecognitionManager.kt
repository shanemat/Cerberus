package cz.cvut.fit.android.cerberus.business.managers.implementation

import android.content.Context
import cz.cvut.fit.android.cerberus.business.managers.interfaces.IRecognitionManager
import cz.cvut.fit.android.cerberus.data.dao.DAOFactory
import cz.cvut.fit.android.cerberus.data.dao.interfaces.IRecognitionDAO
import cz.cvut.fit.android.cerberus.structures.questions.QuestionFactory.FIRST_QUESTION
import cz.cvut.fit.android.cerberus.structures.questions.QuestionFactory.LAST_QUESTION

object RecognitionManager : IRecognitionManager {

    private val questions = HashMap<Int, Boolean>()

    private var currentQuestion: Int = 1
    private var isNotCached = true

    override fun getCurrent(context: Context): Int {
        val dao = obtainDAO(context)
        loadIfNecessary(dao)

        return currentQuestion
    }

    override fun isAnswered(context: Context): Boolean {
        val dao = obtainDAO(context)
        loadIfNecessary(dao)

        return questions[currentQuestion]?: false
    }

    override fun moveBack(context: Context) {
        val dao = obtainDAO(context)
        loadIfNecessary(dao)

        val next = if (currentQuestion - 1 >= FIRST_QUESTION) currentQuestion - 1 else FIRST_QUESTION
        dao.setCurrent(next)
        currentQuestion = next
    }

    override fun moveForward(context: Context) {
        val dao = obtainDAO(context)
        loadIfNecessary(dao)

        val next = if (currentQuestion + 1 <= LAST_QUESTION) currentQuestion + 1 else LAST_QUESTION
        dao.setCurrent(next)
        currentQuestion = next
    }

    override fun setAnswered(context: Context, answered: Boolean) {
        val dao = obtainDAO(context)
        loadIfNecessary(dao)

        dao.setAnswered(currentQuestion, answered)

        questions[currentQuestion] = answered
    }

    override fun resetAll(context: Context) {
        val dao = obtainDAO(context)
        dao.resetAll()

        for (key in questions.keys) {
            questions[key] = false
        }
    }

    private fun obtainDAO(context: Context): IRecognitionDAO {
        return DAOFactory.getRecognitionDAO(context)
    }

    private fun loadIfNecessary(dao: IRecognitionDAO) {
        if (isNotCached) {
            currentQuestion = dao.getCurrent() ?: 1
            isNotCached = false
        }

        if (!questions.containsKey(currentQuestion)) {
            val answered = dao.isAnswered(currentQuestion)
            questions[currentQuestion] = answered
        }
    }
}