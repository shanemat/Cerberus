package cz.cvut.fit.android.cerberus.presentation.screens.minigames

import android.content.Context
import android.content.Intent
import cz.cvut.fit.android.cerberus.presentation.screens.minigames.archaeologist.ArchaeologistGameActivity
import cz.cvut.fit.android.cerberus.presentation.screens.minigames.armedescort.ArmedEscortGameActivity
import cz.cvut.fit.android.cerberus.presentation.screens.minigames.bombexpert.BombExpertGameActivity
import cz.cvut.fit.android.cerberus.presentation.screens.minigames.chief.ChiefGameActivity
import cz.cvut.fit.android.cerberus.presentation.screens.minigames.driver.DriverGameActivity
import cz.cvut.fit.android.cerberus.presentation.screens.minigames.paramedic.ParamedicGameActivity
import cz.cvut.fit.android.cerberus.presentation.screens.minigames.poacher.PoacherGameActivity
import cz.cvut.fit.android.cerberus.presentation.screens.minigames.porter.PorterGameActivity
import cz.cvut.fit.android.cerberus.presentation.screens.minigames.quartermaster.QuartermasterGameActivity
import cz.cvut.fit.android.cerberus.presentation.screens.minigames.translator.TranslatorGameActivity
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