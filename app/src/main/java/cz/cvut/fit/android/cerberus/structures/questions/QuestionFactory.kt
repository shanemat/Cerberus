package cz.cvut.fit.android.cerberus.structures.questions

import android.content.res.Resources
import cz.cvut.fit.android.cerberus.R

object QuestionFactory {

    const val FIRST_QUESTION = 1
    const val LAST_QUESTION = 22

    fun getQuestions(resources: Resources): ArrayList<String> {
        val questions = ArrayList<String>()

        questions.add(resources.getString(R.string.team_question_name_member, 7))
        questions.add(resources.getString(R.string.team_question_show_member, 5))
        questions.add(resources.getString(R.string.team_question_name_member, 6))
        questions.add(resources.getString(R.string.team_question_name_special_part, 9))
        questions.add(resources.getString(R.string.team_question_name_member, 3))
        questions.add(resources.getString(R.string.team_question_show_member, 2))
        questions.add(resources.getString(R.string.team_question_name_member, 8))
        questions.add(resources.getString(R.string.team_question_name_member, 3))
        questions.add(resources.getString(R.string.team_question_name_special_part, 8))
        questions.add(resources.getString(R.string.team_question_show_member, 4))
        questions.add(resources.getString(R.string.team_question_name_member, 8))
        questions.add(resources.getString(R.string.team_question_show_member, 5))
        questions.add(resources.getString(R.string.team_question_show_member, 6))
        questions.add(resources.getString(R.string.team_question_name_member, 8))
        questions.add(resources.getString(R.string.team_question_name_special_part, 6))
        questions.add(resources.getString(R.string.team_question_name_member, 5))
        questions.add(resources.getString(R.string.team_question_name_member, 7))
        questions.add(resources.getString(R.string.team_question_show_member, 8))
        questions.add(resources.getString(R.string.team_question_name_member, 6))
        questions.add(resources.getString(R.string.team_question_name_special_part, 7))
        questions.add(resources.getString(R.string.team_question_name_member, 6))
        questions.add(resources.getString(R.string.team_question_show_member, 9))

        return questions
    }
}