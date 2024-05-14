package data


typealias PlayerId = Int


data class Player(
    val id: PlayerId,
    var name: String = "Player ${id + 1}",
) {
    // Defines the Order of Play
    var playerNumber = id
}