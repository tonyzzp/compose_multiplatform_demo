package me.izzp.common

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Toolbar(
    snackbarHostState: SnackbarHostState,
    onNavIconClick: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    TopAppBar(title = {
        Text("Demo")
    }, navigationIcon = {
        IconButton(onClick = onNavIconClick) {
            Icon(Icons.Default.Menu, "")
        }
    }, actions = {
        IconButton(
            onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(
                        "refresh clicked",
                        duration = SnackbarDuration.Short,
                    )
                }
            },
        ) {
            Icon(Icons.Default.Refresh, "refresh")
        }
    })
}