import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.components.PlayerEntryForm


@Composable
@Preview
fun App() {
    val viewModel: AppViewModel = viewModel { AppViewModel() }

    val players by viewModel.players.collectAsState()

    MaterialTheme {

        PlayerEntryForm {
            println(it)
            viewModel.setPlayers(it)
        }

        Text(players.toString())

    }
}