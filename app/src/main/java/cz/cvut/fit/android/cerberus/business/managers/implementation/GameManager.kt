package cz.cvut.fit.android.cerberus.business.managers.implementation

import android.content.Context
import cz.cvut.fit.android.cerberus.business.managers.interfaces.IGameManager
import cz.cvut.fit.android.cerberus.data.dao.DAOFactory
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole

object GameManager : IGameManager {

    private var gameScores = HashMap<PlayerRole, Int?>()

    override fun isScored(context: Context, role: PlayerRole): Boolean {
        if (isScoreNotCached(role)) {
            loadScoreToCache(context, role)
        }

        return gameScores[role] != null
    }

    override fun getScore(context: Context, role: PlayerRole): Int? {
        if (isScoreNotCached(role)) {
            loadScoreToCache(context, role)
        }

        return gameScores[role]
    }

    override fun getAllScores(context: Context): HashMap<PlayerRole, Int?> {
        if (areScoresNotCached()) {
            loadScoresToCache(context)
        }

        return gameScores
    }

    override fun setScore(context: Context, role: PlayerRole, points: Int) {
        gameScores[role] = points

        val dao = DAOFactory.getGameDAO(context)
        dao.updatePoints(role, points)
    }

    override fun resetAllScores(context: Context) {
        resetPointsInCache()

        val dao = DAOFactory.getGameDAO(context)
        dao.resetAllPoints()
    }

    private fun isScoreNotCached(role: PlayerRole): Boolean {
        return !gameScores.containsKey(role)
    }

    private fun areScoresNotCached(): Boolean {
        return gameScores.size == PlayerRole.values().size
    }

    private fun loadScoreToCache(context: Context, role: PlayerRole) {
        val dao = DAOFactory.getGameDAO(context)
        val score = dao.getPoints(role)

        if (score != null) {
            gameScores[role] = score
        }
    }

    private fun loadScoresToCache(context: Context) {
        val dao = DAOFactory.getGameDAO(context)
        gameScores = dao.getAllPoints()
    }

    private fun resetPointsInCache() {
        for (role in PlayerRole.values()) {
            gameScores[role] = null
        }
    }
}