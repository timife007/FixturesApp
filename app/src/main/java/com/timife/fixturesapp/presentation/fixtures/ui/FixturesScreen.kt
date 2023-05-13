package com.timife.fixturesapp.presentation.fixtures.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.timife.fixturesapp.presentation.fixtures.FixturesViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FixturesScreen(
    modifier: Modifier = Modifier,
    viewModel: FixturesViewModel = hiltViewModel(),
    header:String
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
                Text(
                    text = header,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Box(modifier = modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
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