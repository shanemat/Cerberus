package cz.cvut.fit.android.cerberus.structures.enums

import android.content.Context
import cz.cvut.fit.android.cerberus.R

enum class PlayerRole(private val ID: Long, private val textResourceID: Int) {

    POACHER(0, R.string.role_poacher),
    PORTER(1, R.string.role_porter),
    DRIVER(2, R.string.role_driver),
    ARMED_ESCORT(3, R.string.role_armed_escort),
    TRANSLATOR(4, R.string.role_translator),
    PARAMEDIC(5, R.string.role_paramedic),
    ARCHAEOLOGIST(6, R.string.role_archaeologist),
    CHIEF(7, R.string.role_chief),
    QUARTERMASTER(8, R.string.role_quartermaster),
    BOMB_EXPERT(9, R.string.role_bomb_expert);

    fun getName(context: Context): String {
        return context.resources.getString(textResourceID)
    }
}