package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources

class ScoutingPaysOff(previousID: Long)
    : StoryNode(StoryLinks(4, previousID, 7, true),
                StoryResources(R.string.scouting_pays_off_text, PlayerRole.POACHER, awardedPoints = 1)) {

    init {
        addAnswer(StoryAnswer(R.string.poacher_call_out, PlayerRole.POACHER, 7))
    }
}