package cz.cvut.fit.android.cerberus.data.database.prototype

class Column(private val name: String,
             private val valueType: ValueType,
             private val keyType: KeyType = KeyType.NO,
             private val incrementation: Incrementation = Incrementation.NO,
             private val nullability: Nullability,
             private val references: String = "") {

    fun getCreationCommand(): String {
        var command = name + valueType.script

        command += when (keyType) {
            KeyType.PRIMARY -> " PRIMARY KEY" + incrementation.script
            KeyType.FOREIGN -> " REFERENCES " + references
            KeyType.NO -> nullability.script
        }

        return command
    }

    enum class ValueType(val script: String) {
        NONE(""),
        TEXT(" TEXT"),
        INTEGER(" INTEGER")
    }

    enum class Incrementation(val script: String) {
        NO(""),
        AUTOINCREMENT(" AUTOINCREMENT")
    }

    enum class Nullability(val script: String) {
        CAN_BE_NULL(""),
        NOT_NULL(" NOT_NULL")
    }

    enum class KeyType {
        NO,
        FOREIGN,
        PRIMARY
    }
}