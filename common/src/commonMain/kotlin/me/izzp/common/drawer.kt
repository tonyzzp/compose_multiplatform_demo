package me.izzp.common

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Audiotrack
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColumnScope.AppDrawer() {
    val coroutineScope = rememberCoroutineScope()
    ListItem(
        modifier = Modifier.clickable { },
        icon = {
            Icon(Icons.Default.VideoLibrary, "")
        },
        text = { Text("video") },
    )
    ListItem(
        modifier = Modifier.clickable { },
        icon = {
            Icon(Icons.Default.Audiotrack, "")
        },
        text = { Text("audio") }
    )
    ListItem(
        modifier = Modifier.clickable { },
        icon = {
            Icon(Icons.Default.PhotoLibrary, "")
        },
        text = { Text("photo") }
    )
    val source = remember { NoHoverExitMutableInteractionSource() }
    ListItem(
        modifier = Modifier.clickable(
            enabled = true,
            onClick = {},
            indication = LocalIndication.current,
            interactionSource = source,
        ),
        icon = {
            Icon(Icons.Default.Contacts, "")
        },
        text = { Text("contact") }
    )
}