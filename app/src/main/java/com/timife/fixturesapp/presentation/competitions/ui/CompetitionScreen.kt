package com.timife.fixturesapp.presentation.competitions.ui

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.timife.fixturesapp.presentation.competitions.CompetitionsViewModel
import com.timife.fixturesapp.ui.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CompetitionScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CompetitionsViewModel = hiltViewModel(),
) {

    val state = viewModel.state

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                HideableTextField(
                    text = state.value.searchText,
                    isSearchActive = state.value.isSearchActive,
                    onTextChange = {},
                    onSearchClick = {},
                    onCloseClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                )
                this@Column.AnimatedVisibility(
                    visible = !state.value.isSearchActive,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Text(
                        text = "Competitions",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                }
            }
            Box(modifier = modifier.fillMaxSize()) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {

                    items(state.value.competitions) { competition ->
                        CompetitionItem(
                            competition = competition,
                            modifier = modifier.padding(5.dp).clickable {
                                navController.navigate(Screen.FixturesScreen.route + "/${competition.id}/${competition.name}")
                            }
                        )
                    }
                }

                if (state.value.error.isNotBlank()) {
                    Text(
                        text = state.value.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(
                                Alignment.Center
                            )
                    )
                }

                if (state.value.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}