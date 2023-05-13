package com.timife.fixturesapp.presentation.fixtures.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.timife.fixturesapp.domain.model.Fixture

@Composable
fun FixtureItem(
    modifier: Modifier = Modifier,
    fixture: Fixture,
) {

    Card(
        modifier = Modifier
            .shadow(10.dp)
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = fixture.homeTeam.shortName ?: "Home Team",
                style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.SemiBold),
                modifier = Modifier.padding(5.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.offset(0.dp, 0.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(fixture.homeTeam.crest)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = "Home Team",
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .size(50.dp)
                        .padding(5.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "19:00",
                        style = MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Red
                        ),
                        modifier = Modifier.padding(5.dp)
                    )
                    Text(
                        text = "15 OCT.",
                        style = MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.LightGray
                        ),
                        modifier = Modifier.padding(5.dp)
                    )
                }
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(fixture.awayTeam.crest)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = "Away Team",
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .size(50.dp)
                        .padding(5.dp)
                )
            }

            Text(
                text = fixture.awayTeam.shortName ?: "Away Team",
                style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.SemiBold),
                modifier = Modifier.padding(5.dp)
            )
        }

    }
}