package data


abstract class Card {
    abstract val name: String

    abstract val score: Int
}


data class BonusRage(
    override val name: String = "Bonus Rage",
    override val score: Int = 5
) : Card()


data class MadRage(
    override val name: String = "Mad Rage",
    override val score: Int = -5
) : Card()
