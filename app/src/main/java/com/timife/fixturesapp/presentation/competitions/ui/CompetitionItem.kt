package com.timife.fixturesapp.presentation.competitions.ui

import androidx.compose.foundation.background
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
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.timife.fixturesapp.domain.model.Competition

@Composable
fun CompetitionItem(
    modifier: Modifier,
    competition: Competition,
) {
    Column(
        modifier = modifier.background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .shadow(10.dp)
                .fillMaxWidth()
                .height(130.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(competition.emblem)
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = "Competition logo",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Inside
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = competition.code,
            color = Color.Gray,
            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}