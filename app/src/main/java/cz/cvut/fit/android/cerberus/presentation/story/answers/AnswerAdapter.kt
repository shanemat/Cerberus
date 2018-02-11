package cz.cvut.fit.android.cerberus.presentation.story.answers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.business.ManagerFactory
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer

class AnswerAdapter(context: Context, private var answers: ArrayList<StoryAnswer>)
    : ArrayAdapter<StoryAnswer>(context, 0) {

    init {
        obtainSelectedAnswer()
        answers.shuffle()
    }

    override fun getCount(): Int {
        return answers.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var currentView = convertView

        val answer = answers[position]
        val holder: AnswerItemHolder

        if (currentView == null) {
            val inflater = LayoutInflater.from(context)
            currentView = inflater.inflate(R.layout.i_answer, null)

            holder = AnswerItemHolder(currentView)
            currentView.tag = holder

        } else {
            holder = currentView.tag as AnswerItemHolder
        }

        populateHolder(context, holder, answer)
        return currentView!!
    }

    fun setAnswers(answers: ArrayList<StoryAnswer>) {
        this.answers = answers
        obtainSelectedAnswer()
        answers.shuffle()
    }

    fun getChosenAnswer(): StoryAnswer? {
        return answers.firstOrNull { it.isSelected }
    }

    private fun obtainSelectedAnswer() {
        val manager = ManagerFactory.getStoryNodeManager()
        val chosenAnswerID = manager.getAnswerID(context)

        if (chosenAnswerID != null) {
            answers
                    .filter { it.ID == chosenAnswerID }
                    .forEach { it.isSelected = true }
        }
    }

    private fun populateHolder(context: Context, holder: AnswerItemHolder, answer: StoryAnswer) {
        holder.textView.text = answer.getText(context)

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                deselectAllAnswers()
                selectAnswer(answer)
            } else {
                deselectAnswer(answer)
            }

            notifyDataSetChanged()
        }
        holder.checkBox.isChecked = answer.isSelected
    }

    private fun deselectAllAnswers() {
        for (answer in answers) {
            answer.isSelected = false
        }
    }

    private fun selectAnswer(answer: StoryAnswer) {
        val manager = ManagerFactory.getStoryNodeManager()
        manager.setAnswerID(context, answer.ID)

        answer.isSelected = true
    }

    private fun deselectAnswer(answer: StoryAnswer) {
        answer.isSelected = false
    }
}