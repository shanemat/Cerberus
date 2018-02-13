package cz.cvut.fit.android.cerberus.presentation.team

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.business.ManagerFactory
import cz.cvut.fit.android.cerberus.presentation.team.members.TeamMemberAdapter
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.players.Player
import cz.cvut.fit.android.cerberus.structures.questions.QuestionFactory
import cz.cvut.fit.android.cerberus.structures.questions.QuestionFactory.FIRST_QUESTION
import cz.cvut.fit.android.cerberus.structures.questions.QuestionFactory.LAST_QUESTION
import kotlinx.android.synthetic.main.f_main_team.*
import kotlinx.android.synthetic.main.fp_team_photo.*
import kotlinx.android.synthetic.main.fp_team_questions.*

class TeamFragment internal constructor() : Fragment() {

    private lateinit var questions: ArrayList<String>
    private lateinit var memberAdapter: TeamMemberAdapter

    companion object Creator {
        fun newInstance(): TeamFragment {
            return TeamFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_main_team, container, false)
    }

    override fun onStart() {
        super.onStart()

        setUp()
        update()
    }

    private fun setUp() {
        setUpQuestions()
        setUpMembers()
        setUpPhoto()
        setUpButtons()
        setUpCheckBox()
    }

    private fun setUpQuestions() {
        questions = QuestionFactory.getQuestions(resources)
    }

    private fun setUpMembers() {
        val members = obtainTeamMembers()

        memberAdapter = TeamMemberAdapter(activity!!, members)
        teamPlayersListView.adapter = memberAdapter
    }

    private fun obtainTeamMembers(): ArrayList<Player> {
        val manager = ManagerFactory.getPlayerManager()
        val players = manager.getTeam(activity!!)

        val members = ArrayList<Player>()
        PlayerRole.values().mapNotNullTo(members) { players[it] }

        return members
    }

    private fun setUpPhoto() {
        teamPhotoImageView.setOnClickListener {
            // TODO start activity with full view of the photo
        }
    }

    private fun setUpButtons() {
        setUpPhotoButton()
        setUpBackButton()
        setUpForwardButton()
    }

    private fun setUpPhotoButton() {
        teamTakePhotoButton.setOnClickListener {
            // TODO add request to take a photo
        }
    }

    private fun setUpBackButton() {
        teamBackButton.setOnClickListener{
            val manager = ManagerFactory.getRecognitionManager()
            manager.moveBack(activity!!)
            update()
        }
    }

    private fun setUpForwardButton() {
        teamForwardButton.setOnClickListener {
            if (teamAnsweredCheckBox.isChecked) {
                moveForward()
            } else {
                reportNotAnswered(it)
            }
        }
    }

    private fun moveForward() {
        val manager = ManagerFactory.getRecognitionManager()
        manager.moveForward(activity!!)
        update()
    }

    private fun reportNotAnswered(view: View) {
        Snackbar.make(view, R.string.team_question_not_answered, Snackbar.LENGTH_SHORT).show()
    }

    private fun setUpCheckBox() {
        teamAnsweredCheckBox.setOnCheckedChangeListener { _, isChecked ->
            val manager = ManagerFactory.getRecognitionManager()
            manager.setAnswered(activity!!, isChecked)
        }
    }

    private fun update() {
        updateTeamMembers()
        updateQuestion()
        updateButtons()
    }

    private fun updateTeamMembers() {
        val members = obtainTeamMembers()
        memberAdapter.setPlayers(members)
    }

    private fun updateQuestion() {
        val manager = ManagerFactory.getRecognitionManager()
        val currentQuestion = manager.getCurrent(activity!!)
        teamQuestionTextView.text = questions[currentQuestion - 1]

        val isAnswered = manager.isAnswered(activity!!)
        teamAnsweredCheckBox.isChecked = isAnswered

        teamQuestionProgressTextView.text = resources.getString(R.string.team_question_progress, currentQuestion, questions.size)
    }

    private fun updateButtons() {
        val manager = ManagerFactory.getRecognitionManager()
        val currentQuestion = manager.getCurrent(activity!!)

        updateBackButton(currentQuestion)
        updateForwardButton(currentQuestion)
    }

    private fun updateBackButton(currentQuestion: Int) {
        if (currentQuestion == FIRST_QUESTION) {
            teamBackButton.visibility = View.INVISIBLE
        } else {
            teamBackButton.visibility = View.VISIBLE
        }
    }

    private fun updateForwardButton(currentQuestion: Int) {
        if (currentQuestion == LAST_QUESTION) {
            teamForwardButton.visibility = View.INVISIBLE
        } else {
            teamForwardButton.visibility = View.VISIBLE
        }
    }
}