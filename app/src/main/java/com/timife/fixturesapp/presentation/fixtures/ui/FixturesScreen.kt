package com.timife.fixturesapp.presentation.fixtures.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.timife.fixturesapp.presentation.fixtures.FixturesViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FixturesScreen(
    modifier: Modifier = Modifier,
    viewModel: FixturesViewModel = hiltViewModel(),
    header: String,
    navController: NavController,
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
                    .padding(padding)
                    .height(60.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    IconButton(modifier = Modifier, onClick = {
                        navController.navigateUp()
                    }) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .size(40.dp)
                                .background(Color.LightGray),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Navigate Back",
                                modifier = Modifier.size(20.dp),
                                tint = Color.White
                            )
                        }

                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = header,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                }

            }
            LazyRow(
                modifier = Modifier.padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(state.value.matchDays) { matchday ->
                    FilterChip(
                        filterOption = matchday,
                        selectedFilter = state.value.selectedFilter,
                        onFilterSelected = {
                            viewModel.getFixtures(state.value.competitionId, it)
                        })
                }
            }

            Box(modifier = modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(state.value.fixtures) { fixture ->
                        FixtureItem(
                            modifier = modifier.padding(5.dp),
                            fixture = fixture
                        )
                    }
                }

                if (state.value.fixtures.isEmpty() && !state.value.isLoading) {
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