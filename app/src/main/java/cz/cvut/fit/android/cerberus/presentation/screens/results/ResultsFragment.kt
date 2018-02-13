package cz.cvut.fit.android.cerberus.presentation.screens.results

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.business.ManagerFactory
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import kotlinx.android.synthetic.main.fp_results_games.*
import kotlinx.android.synthetic.main.fp_results_story.*
import kotlinx.android.synthetic.main.fp_results_sum.*

class ResultsFragment internal constructor() : Fragment() {

    private lateinit var gameScoreMap: HashMap<PlayerRole, TextView>

    private var gamePoints = 0
    private var storyPoints = 0

    companion object Creator {
        fun newInstance(): ResultsFragment {
            return ResultsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_main_results, container, false)
    }

    override fun onStart() {
        super.onStart()

        prepareGameScoreMap()
        update()
    }

    private fun prepareGameScoreMap() {
        gameScoreMap = HashMap<PlayerRole, TextView>()

        gameScoreMap[PlayerRole.POACHER] = resultsPoacherPoints
        gameScoreMap[PlayerRole.PORTER] = resultsPorterPoints
        gameScoreMap[PlayerRole.DRIVER] = resultsDriverPoints
        gameScoreMap[PlayerRole.ARMED_ESCORT] = resultsArmedEscortPoints
        gameScoreMap[PlayerRole.TRANSLATOR] = resultsTranslatorPoints
        gameScoreMap[PlayerRole.PARAMEDIC] = resultsParamedicPoints
        gameScoreMap[PlayerRole.ARCHAEOLOGIST] = resultsArchaeologistPoints
        gameScoreMap[PlayerRole.CHIEF] = resultsChiefPoints
        gameScoreMap[PlayerRole.QUARTERMASTER] = resultsQuarterMasterPoints
        gameScoreMap[PlayerRole.BOMB_EXPERT] = resultsBombExpertPoints
    }

    private fun update() {
        updateGamePoints()
        updateStoryPoints()
        updatePointsTotal()
    }

    private fun updateGamePoints() {
        val manager = ManagerFactory.getGameManager()
        val scores = manager.getAllScores(this.activity!!)

        gamePoints = 0
        for (role in PlayerRole.values()) {
            val roleTextView = gameScoreMap[role]
            val points = scores[role]

            roleTextView?.text = getScoreText(points)
            if (points != null) {
                gamePoints += points
            }
        }
    }

    private fun updateStoryPoints() {
        val manager = ManagerFactory.getStoryPointsManager()
        storyPoints = manager.get(this.activity!!)

        resultsStoryPoints.text = storyPoints.toString()
    }

    private fun updatePointsTotal() {
        val totalPoints = gamePoints + storyPoints
        resultsTotalPoints.text = totalPoints.toString()
    }

    private fun getScoreText(points: Int?): String {
        return if (points != null) {
            points.toString()
        } else {
            "-"
        }
    }
}