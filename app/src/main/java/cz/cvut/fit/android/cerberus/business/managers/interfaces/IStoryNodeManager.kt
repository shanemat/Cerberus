package cz.cvut.fit.android.cerberus.business.managers.interfaces

import android.content.Context
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode

interface IStoryNodeManager {

    fun getCurrent(context: Context): StoryNode

    fun getAnswerID(context: Context): Long?

    fun setAnswerID(context: Context, answerID: Long)

    fun moveForward(context: Context, nextID: Long)

    fun moveBackward(context: Context)

    fun resetStory(context: Context)
}