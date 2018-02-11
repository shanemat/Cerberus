package cz.cvut.fit.android.cerberus.presentation.story

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.business.ManagerFactory
import cz.cvut.fit.android.cerberus.presentation.minigames.GamesFactory
import cz.cvut.fit.android.cerberus.presentation.story.answers.AnswerAdapter
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import kotlinx.android.synthetic.main.f_main_story.*

class StoryFragment internal constructor() : Fragment() {

    private lateinit var currentStoryNode: StoryNode
    private lateinit var answerAdapter: AnswerAdapter

    companion object Creator {

        const val MINIMUM_PROGRESS = 0
        const val MAXIMUM_PROGRESS = 100

        const val ALTERNATIVE_PATH_THRESHOLD = 1

        fun newInstance(): StoryFragment {
            return StoryFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        updateStoryNode()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_main_story, container, false)
    }

    override fun onStart() {
        super.onStart()

        setUp()
        update()
    }

    private fun updateStoryNode() {
        val manager = ManagerFactory.getStoryNodeManager()
        currentStoryNode = manager.getCurrent(this.activity!!)
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
            val manager = ManagerFactory.getStoryNodeManager()

            manager.moveBackward(this.activity!!)
            subtractPoints(currentStoryNode.awardedPoints)

            updateStoryNode()
            update()
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
        val manager = ManagerFactory.getGameManager()
        return currentStoryNode.leadsToGame && !manager.isScored(this.activity!!, role)
    }

    private fun continueInStory(chosenAnswer: StoryAnswer) {
        val nextNodeID = pickNextNodeID(chosenAnswer)
        val manager = ManagerFactory.getStoryNodeManager()

        manager.moveForward(this.activity!!, nextNodeID)
        addPoints(currentStoryNode.awardedPoints)

        updateStoryNode()
        update()
    }

    private fun reportNoAnswerSelected(view: View) {
        Snackbar.make(view, R.string.error_no_answer, Snackbar.LENGTH_SHORT).show()
    }

    private fun pickNextNodeID(chosenAnswer: StoryAnswer): Long {
        return if (shouldTakeAlternativePath()) {
            chosenAnswer.alternativeID
        } else {
            chosenAnswer.targetID
        }
    }

    private fun shouldTakeAlternativePath(): Boolean {
        val manager = ManagerFactory.getGameManager()
        val score = manager.getScore(this.activity!!, currentStoryNode.gameRole)

        return if (score != null) {
            currentStoryNode.leadsToGame && (score >= ALTERNATIVE_PATH_THRESHOLD)
        } else {
            false
        }
    }

    private fun addPoints(points: Int) {
        val manager = ManagerFactory.getStoryPointsManager()
        manager.add(this.activity!!, points)
    }

    private fun subtractPoints(points: Int) {
        val manager = ManagerFactory.getStoryPointsManager()
        manager.subtract(this.activity!!, points)
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
        val manager = ManagerFactory.getPlayerManager()
        val player = manager.getPlayer(this.activity!!, currentStoryNode.answeringRole)

        return player?.name ?: "---"
    }
}