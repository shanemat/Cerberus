package cz.cvut.fit.android.cerberus.presentation.prototype.players

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.players.Player

class PlayerAdapter(context: Context, private var players: ArrayList<Player>)
    : ArrayAdapter<Player>(context, 0) {

    override fun getCount(): Int {
        return players.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return prepareView(position, convertView)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return prepareView(position, convertView)
    }

    private fun prepareView(position: Int, convertView: View?): View {
        var currentView = convertView

        val teamMember = players[position]
        val holder: PlayerItemHolder

        if (currentView == null) {
            val inflater = LayoutInflater.from(context)
            currentView = inflater.inflate(R.layout.i_player, null)

            holder = PlayerItemHolder(currentView)
            currentView.tag = holder

        } else {
            holder = currentView.tag as PlayerItemHolder
        }

        populateHolder(holder, teamMember)
        return currentView!!
    }

    fun setPlayers(players: ArrayList<Player>) {
        this.players = players
        notifyDataSetChanged()
    }

    private fun populateHolder(holder: PlayerItemHolder, teamMember: Player) {
        val name = teamMember.name
        val surname = teamMember.surname

        holder.textView.text = "$name $surname"
    }
}