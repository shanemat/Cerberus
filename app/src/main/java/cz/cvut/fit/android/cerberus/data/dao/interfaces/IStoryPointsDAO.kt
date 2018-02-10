package cz.cvut.fit.android.cerberus.data.dao.interfaces

interface IStoryPointsDAO {

    fun get(): Int

    fun add(points: Int)

    fun subtract(points: Int)

    fun reset()
}