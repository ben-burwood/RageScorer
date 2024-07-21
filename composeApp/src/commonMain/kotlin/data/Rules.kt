package data


const val UnmatchedBetPenalty = -5
const val ExactBetBonus = 10
const val ExactBetZeroBonus = 5


fun scoreBetBonus(bet: Int, numberOfTricks: Int): Int {
    if (bet != numberOfTricks) return UnmatchedBetPenalty

    return if (bet == 0) ExactBetZeroBonus else ExactBetBonus
}
