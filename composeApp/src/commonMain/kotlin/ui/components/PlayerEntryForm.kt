package ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import data.Player
import ui.components.generic.SwipeToDeleteContainer


@Composable
fun PlayerField(index: Int, player: Player, onNameChange: (String) -> Unit = {}) {
    val changeName = {
        if (player.name.isNotBlank()) onNameChange(player.name)
    }

    OutlinedTextField(
        value = player.name,
        onValueChange = { player.name = it },
        label = { Text("Player ${index + 1}") },
        modifier = Modifier.onFocusChanged {
            if (!it.isFocused) changeName()
        },
        singleLine = true
    )
}


@Composable
fun PlayerEntryForm(minPlayers: Int = 3, maxPlayers: Int = 8, onSubmit: (List<Player>) -> Unit) {

    // TODO:ENHANCEMENT - Implement Reordering of players in the List

    val initialPlayers = List(minPlayers) { Player(it) }
    val players = remember { mutableStateListOf<Player>().apply { addAll(initialPlayers) } }

    val submit = {
        players.forEachIndexed { index, player ->
            player.playerNumber = index
        }
        onSubmit(players.toList())
    }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        players.forEachIndexed { index, player ->
            // TODO:BUG - Fix Deleting Player from List
            SwipeToDeleteContainer(
                item = player,
                onDelete = { players.remove(player) }
            ) { item ->
                PlayerField(index, item) { newName ->
                    players[index].name = newName
                }
            }
        }

        Button(
            onClick = { players.add(Player(players.size)) },
            enabled = players.size < maxPlayers
        ) {
            Text("+ Player")
        }

        Button(
            onClick = { submit() },
            enabled = players.size in minPlayers..maxPlayers
        ) {
            Text("Start Game")
        }
    }
}