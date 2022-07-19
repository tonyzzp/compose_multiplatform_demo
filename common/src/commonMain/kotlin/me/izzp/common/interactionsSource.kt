package me.izzp.common

import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter

sealed class FilteredMutableInteractionSource(
    private val base: MutableInteractionSource,
    private val filter: (Interaction) -> Boolean
) : MutableInteractionSource {
    override val interactions: Flow<Interaction>
        get() = base.interactions.filter {
            filter(it)
        }

    override suspend fun emit(interaction: Interaction) {
        if (filter(interaction)) {
            base.emit(interaction)
        }
    }

    override fun tryEmit(interaction: Interaction): Boolean {
        return base.tryEmit(interaction)
    }
}

/**
 * 过滤掉 hover.enter/hover.exit 事件的InteractionSource
 */
class NoHoverExitMutableInteractionSource : FilteredMutableInteractionSource(
    MutableInteractionSource(),
    {
        when (it) {
            is HoverInteraction.Enter -> {
                false
            }
            is HoverInteraction.Exit -> {
                false
            }
            else -> {
                true
            }
        }
    }
)
