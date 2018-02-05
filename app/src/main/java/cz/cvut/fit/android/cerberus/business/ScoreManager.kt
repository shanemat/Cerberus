package cz.cvut.fit.android.cerberus.business

import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole

object ScoreManager {

    fun isGameScored(role: PlayerRole): Boolean {
        // TODO implement actual check based on DB value
        return false
    }

    fun addStoryPoints(points: Int) {
        // TODO implement actual calculation
    }

    fun subtractStoryPoints(points: Int) {
        // TODO implement actual calculation
    }

    fun resetStoryPoints() {
        // TODO implement points reset
    }
}