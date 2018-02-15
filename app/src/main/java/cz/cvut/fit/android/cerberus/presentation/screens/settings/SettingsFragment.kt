package cz.cvut.fit.android.cerberus.presentation.screens.settings

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.business.ManagerFactory
import cz.cvut.fit.android.cerberus.presentation.prototype.players.PlayerAdapter
import cz.cvut.fit.android.cerberus.presentation.screens.settings.team.TeamAdapter
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.players.Player
import kotlinx.android.synthetic.main.f_main_settings.*
import kotlinx.android.synthetic.main.fp_settings_control.*
import java.text.SimpleDateFormat
import java.util.*

class SettingsFragment internal constructor() : Fragment() {

    private lateinit var teamAdapter: TeamAdapter
    private lateinit var playerAdapter: PlayerAdapter

    companion object Creator {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_main_settings, container, false)
    }

    override fun onStart() {
        super.onStart()

        setUp()
        update()
    }

    private fun setUp() {
        setUpTeamSpinner()
        setUpButtons()
        setUpTeamListView()
    }

    private fun setUpTeamSpinner() {
        teamAdapter = TeamAdapter(activity!!)

        settingsTeamSpinner.adapter = teamAdapter
        settingsTeamSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // intentionally left blank
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, ID: Long) {
                val manager = ManagerFactory.getPlayerManager()
                manager.setCurrentTeam(activity!!, position.toLong() + 1)
                update()
            }
        }
    }

    private fun setUpButtons() {
        setUpResetQuestionsButton()
        setUpResetStoryButton()
        setUpFetchPlayersButton()
    }

    private fun setUpResetQuestionsButton() {
        settingsResetQuestionsButton.setOnClickListener {
            // TODO add confirmation dialog

            val manager = ManagerFactory.getRecognitionManager()
            manager.resetAll(activity!!)

            showSnackBar(it, R.string.settings_questions_been_reset)
        }
    }

    private fun setUpResetStoryButton() {
        settingsResetStoryButton.setOnClickListener {
            // TODO add confirmation dialog

            val nodeManager = ManagerFactory.getStoryNodeManager()
            nodeManager.resetStory(activity!!)

            val pointsManager = ManagerFactory.getStoryPointsManager()
            pointsManager.reset(activity!!)

            showSnackBar(it, R.string.settings_story_been_reset)
        }
    }

    private fun setUpFetchPlayersButton() {
        settingsFetchPlayersButton.setOnClickListener {
            // TODO add UI Thread handling

            val manager = ManagerFactory.getPlayerManager()
            manager.fetchPlayers(activity!!)

            showSnackBar(it, R.string.settings_players_been_fetched)
        }
    }

    private fun setUpTeamListView() {
        val members = obtainTeamMembers()

        playerAdapter = PlayerAdapter(activity!!, members)
        settingsPlayerListView.adapter = playerAdapter
    }

    private fun obtainTeamMembers(): ArrayList<Player> {
        val manager = ManagerFactory.getPlayerManager()
        val players = manager.getTeam(activity!!)

        val members = ArrayList<Player>()
        PlayerRole.values().mapNotNullTo(members) { players[it] }

        return members
    }

    private fun update() {
        updateTeamSpinner()
        updatePlayersList()
        updateActualizationText()
    }

    private fun updateTeamSpinner() {
        val manager = ManagerFactory.getPlayerManager()
        val teamID = manager.getTeamID(activity!!)

        settingsTeamSpinner.setSelection(teamID.toInt() - 1)
    }

    private fun updatePlayersList() {
        val players = obtainTeamMembers()
        playerAdapter.setPlayers(players)
    }

    private fun updateActualizationText() {
        val manager = ManagerFactory.getActualizationManager()
        val actualizationDate = manager.getDate(activity!!)

        val formattedDate = getFormattedDate(actualizationDate)
        settingsActualizationTextView.text = getString(R.string.settings_actualization_text, formattedDate)
    }

    private fun getFormattedDate(date: Date): String {
        val format = SimpleDateFormat("dd / MM / yyyy", Locale.ENGLISH)
        return format.format(date)
    }

    private fun showSnackBar(view: View, textResourceID: Int) {
        Snackbar.make(view, textResourceID, Snackbar.LENGTH_SHORT).show()
    }
}