package cz.cvut.fit.android.cerberus.presentation.minigames

import android.content.Context
import android.content.Intent
import cz.cvut.fit.android.cerberus.presentation.minigames.archaeologist.ArchaeologistGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.armedescort.ArmedEscortGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.bombexpert.BombExpertGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.chief.ChiefGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.driver.DriverGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.paramedic.ParamedicGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.poacher.PoacherGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.porter.PorterGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.quartermaster.QuartermasterGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.translator.TranslatorGameActivity
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole.*

object GamesFactory {

    fun getGameIntent(context: Context, role: PlayerRole): Intent {
        return when (role) {
            POACHER -> PoacherGameActivity.newIntent(context)
            PORTER -> PorterGameActivity.newIntent(context)
            DRIVER -> DriverGameActivity.newIntent(context)
            ARMED_ESCORT -> ArmedEscortGameActivity.newIntent(context)
            TRANSLATOR -> TranslatorGameActivity.newIntent(context)
            PARAMEDIC -> ParamedicGameActivity.newIntent(context)
            ARCHAEOLOGIST -> ArchaeologistGameActivity.newIntent(context)
            CHIEF -> ChiefGameActivity.newIntent(context)
            QUARTERMASTER -> QuartermasterGameActivity.newIntent(context)
            BOMB_EXPERT -> BombExpertGameActivity.newIntent(context)
        }
    }
}