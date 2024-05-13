package data


data class Round(
    val roundNumber: Int,
    val numberOfCards: Int,
)


data class PlayerBet(
    val playerId: PlayerId,
    val bet: Int,
)


data class PlayerResult(
    val playerId: PlayerId,
    val bet: PlayerBet,
    val numberOfTricks: Int,
    val bonusCards: List<Card> = emptyList()
) {
    val score: Int
        get() {
            var score = numberOfTricks
            score += scoreBetBonus(bet.bet, numberOfTricks)
            bonusCards.forEach { score += it.score }
            return score
        }
}


data class RoundResults(
    val round: Round,
    val playerResults: List<PlayerResult>,
)