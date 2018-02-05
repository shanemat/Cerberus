package cz.cvut.fit.android.cerberus.presentation.story

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.business.StoryFactory
import cz.cvut.fit.android.cerberus.presentation.story.answers.AnswerAdapter
import cz.cvut.fit.android.cerberus.structures.story.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.chapters.first.Beginning
import kotlinx.android.synthetic.main.f_main_story.*

class StoryFragment internal constructor() : Fragment() {

    private lateinit var currentStoryNode: StoryNode
    private lateinit var answerAdapter: AnswerAdapter

    companion object Creator {

        const val MINIMUM_PROGRESS = 0
        const val MAXIMUM_PROGRESS = 100

        fun newInstance(): StoryFragment {
            return StoryFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        currentStoryNode = getCurrentStoryNode()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_main_story, container, false)
    }

    override fun onStart() {
        super.onStart()

        setUp()
        update()
    }

    private fun getCurrentStoryNode(): StoryNode {
        // TODO add extraction of node based on stored ID
        return Beginning()
    }

    private fun setUp() {
        setUpAnswers()
        setUpButtons()
    }

    private fun setUpAnswers() {
        answerAdapter = AnswerAdapter(this.activity!!, currentStoryNode.answers)
        storyAnswersListView.adapter = answerAdapter
    }

    private fun setUpButtons() {
        setUpBackButton()
        setUpForwardButton()
    }

    private fun setUpBackButton() {
        storyBackButton.setOnClickListener {
            changeStoryNode(currentStoryNode.previousID)
        }
    }

    private fun setUpForwardButton() {
        storyForwardButton.setOnClickListener {
            val chosenAnswer = answerAdapter.getChosenAnswer()
            if (chosenAnswer != null) {
                changeStoryNode(chosenAnswer.targetID)
            } else {
                Snackbar.make(it, R.string.error_no_answer, Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun update() {
        updateStoryText()
        updateRoleText()
        updateAnswers()
        updateProgressBer()
        updateButtons()
    }

    private fun updateStoryText() {
        storyTextView.text = currentStoryNode.getText(this.activity!!)
    }

    private fun updateRoleText() {
        val roleName = currentStoryNode.currentRole.getName(this.activity!!)
        val baseName = getBaseName()
        storyRoleTextView.text = resources.getString(R.string.role_text, roleName, baseName)
    }

    private fun updateAnswers() {
        answerAdapter.setAnswers(currentStoryNode.answers)
        answerAdapter.notifyDataSetChanged()
    }

    private fun updateProgressBer() {
        storyProgressBar.progress = currentStoryNode.progress
    }

    private fun updateButtons() {
        handleBackButtonVisibility()
        handleForwardButtonVisibility()
    }

    private fun handleBackButtonVisibility() {
        if (currentStoryNode.progress <= MINIMUM_PROGRESS) {
            storyBackButton.visibility = View.INVISIBLE
        } else {
            storyBackButton.visibility = View.VISIBLE
        }
    }

    private fun handleForwardButtonVisibility() {
        if (currentStoryNode.progress >= MAXIMUM_PROGRESS) {
            storyForwardButton.visibility = View.INVISIBLE
        } else {
            storyForwardButton.visibility = View.VISIBLE
        }
    }

    private fun getBaseName(): String {
        // TODO add base name retrieval
        return "Unknown"
    }

    private fun changeStoryNode(nextNodeID: Long) {
        val currentNodeID = currentStoryNode.ID
        currentStoryNode = StoryFactory.getStoryNode(nextNodeID, currentNodeID)

        update()
    }
}