package cz.cvut.fit.android.cerberus.presentation.story

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.business.ScoreManager
import cz.cvut.fit.android.cerberus.business.StoryFactory
import cz.cvut.fit.android.cerberus.presentation.minigames.GamesFactory
import cz.cvut.fit.android.cerberus.presentation.story.answers.AnswerAdapter
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.chapters.first.Beginning
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
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
            subtractPoints(currentStoryNode.awardedPoints)
        }
    }

    private fun setUpForwardButton() {
        storyForwardButton.setOnClickListener {
            val chosenAnswer = answerAdapter.getChosenAnswer()
            if (chosenAnswer != null) {
                moveForward(chosenAnswer)
            } else {
                reportNoAnswerSelected(it)
            }
        }
    }

    private fun moveForward(chosenAnswer: StoryAnswer) {
        val role = currentStoryNode.gameRole
        if (shouldStartGame(role)) {
            startGame(role)
        } else {
            continueInStory(chosenAnswer)
        }
    }

    private fun shouldStartGame(role: PlayerRole): Boolean {
        return currentStoryNode.leadsToGame && !ScoreManager.isGameScored(role)
    }

    private fun continueInStory(chosenAnswer: StoryAnswer) {
        val nextNodeID = pickNextNodeID(chosenAnswer)
        changeStoryNode(nextNodeID)
        addPoints(currentStoryNode.awardedPoints)
    }

    private fun reportNoAnswerSelected(view: View) {
        Snackbar.make(view, R.string.error_no_answer, Snackbar.LENGTH_SHORT).show()
    }

    private fun changeStoryNode(nextNodeID: Long) {
        val currentNodeID = currentStoryNode.ID
        currentStoryNode = StoryFactory.getStoryNode(nextNodeID, currentNodeID)
        update()
    }

    private fun pickNextNodeID(chosenAnswer: StoryAnswer): Long {
        return if (shouldTakeAlternativePath()) {
            chosenAnswer.alternativeID
        } else {
            chosenAnswer.targetID
        }
    }

    private fun shouldTakeAlternativePath(): Boolean {
        // TODO add check for earned points
        return currentStoryNode.leadsToGame && false
    }

    private fun addPoints(points: Int) {
        ScoreManager.addStoryPoints(points)
    }

    private fun subtractPoints(points: Int) {
        ScoreManager.subtractStoryPoints(points)
    }

    private fun startGame(role: PlayerRole) {
        val gameIntent = GamesFactory.getGameIntent(this.activity!!, role)
        startActivity(gameIntent)
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
        val roleName = currentStoryNode.answeringRole.getName(this.activity!!)
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
}