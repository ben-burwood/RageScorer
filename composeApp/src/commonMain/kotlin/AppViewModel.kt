import androidx.lifecycle.ViewModel
import data.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class AppViewModel : ViewModel() {

    private var _players: MutableStateFlow<List<Player>> = MutableStateFlow(emptyList())
    val players: StateFlow<List<Player>> = _players.asStateFlow()

    fun setPlayers(players: List<Player>) {
        _players.value = players
    }
}