package cz.cvut.fit.android.cerberus.structures.players

data class Player(var ID: Long = 0,
                  var teamID: Long,
                  var roleID: Long,
                  var name: String,
                  var surname: String)