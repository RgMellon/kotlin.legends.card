package com.example.card_legends.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.card_legends.model.Stage
import com.example.card_legends.ui.theme.Purple100
import com.example.card_legends.ui.theme.Purple200
import com.example.card_legends.ui.theme.Yellow
import kotlin.reflect.KSuspendFunction1

@Composable
fun DropDownStage(
        stages: List<Stage>,
        getBestPlayersOfTheWeek: (stageId: String) -> Unit,
        getAllPlayers: (stageId: String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var lastWeekSlug by remember {
        mutableStateOf(stages[stages.size - 1].slug)
    }

     fun onSelectStage(stageId: String, stageSlug: String) {
        getBestPlayersOfTheWeek(stageId)
         getAllPlayers(stageId)
         expanded = false
         lastWeekSlug = stageSlug

    }

    Button(
        onClick = { expanded = true },
        modifier = Modifier
            .fillMaxWidth(0.5f),

        colors = ButtonDefaults.buttonColors(Purple100),
        border = BorderStroke(1.dp, Yellow)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(lastWeekSlug)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Outlined.ArrowDropDown,
                contentDescription = null,
                tint = Color.White
            )
        }
    }

    DropdownMenu(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .background(Purple200),
        expanded = expanded,

        onDismissRequest = { expanded = false }
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {
            stages.forEach { stage ->
                DropdownMenuItem(
                    text = { Text(stage.slug, color = Color.White) },
                    onClick = {onSelectStage(stage.id, stage.slug)},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowRight,
                            contentDescription = null,
                            tint = Color.White
                        )
                    })
            }


        }

    }
}
