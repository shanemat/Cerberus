package cz.cvut.fit.android.cerberus.presentation.screens.settings.team

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.enums.Team

class TeamAdapter(context: Context)
    : ArrayAdapter<Team>(context, 0) {

    private val teams = Team.values()

    override fun getCount(): Int {
        return teams.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return prepareView(position, convertView)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return prepareView(position, convertView)
    }

    private fun prepareView(position: Int, convertView: View?): View {
        var currentView = convertView

        val team = teams[position]
        val holder: TeamItemHolder

        if (currentView == null) {
            val inflater = LayoutInflater.from(context)
            currentView = inflater.inflate(R.layout.i_team, null)

            holder = TeamItemHolder(currentView)
            currentView.tag = holder

        } else {
            holder = currentView.tag as TeamItemHolder
        }

        populateHolder(holder, team)
        return currentView!!
    }

    private fun populateHolder(holder: TeamItemHolder, team: Team) {
        holder.textView.text = team.codeName
    }
}