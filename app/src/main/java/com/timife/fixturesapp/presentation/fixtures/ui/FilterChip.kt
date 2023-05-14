package com.timife.fixturesapp.presentation.fixtures.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterChip(filterOption: Int, selectedFilter: Int, onFilterSelected: (Int) -> Unit) {
    val isSelected = remember { mutableStateOf(filterOption == selectedFilter) }

    Chip(
        onClick = {
            if (!isSelected.value) {
                isSelected.value = !isSelected.value
            }
            if (isSelected.value) {
                onFilterSelected(filterOption)
            }
        },
        colors = if (filterOption == selectedFilter) ChipDefaults.chipColors(
            backgroundColor = Color.Red,
            contentColor = Color.White
        ) else ChipDefaults.chipColors(
            backgroundColor = Color.White,
            contentColor = Color.LightGray
        )
    ) {
        Text(text = "Matchday $filterOption")
    }
}


