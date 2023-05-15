package com.timife.fixturesapp.presentation.fixtures.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.timife.fixturesapp.data.local.model.*
import com.timife.fixturesapp.data.mappers.toFixture
import org.junit.Rule
import org.junit.Test

class FixtureItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun competitionItemTest() {

        composeTestRule.setContent {
            FixtureItem(modifier = Modifier, fixture = fixture)
        }

        composeTestRule.onNodeWithText(fixture.homeTeam.shortName ?: "Home Team").assertExists()
        composeTestRule.onNodeWithText(fixture.awayTeam.shortName ?: "Away Team").assertExists()
        composeTestRule.onNodeWithText(fixture.matchDate).assertExists()
        composeTestRule.onNodeWithText(fixture.matchTime).assertDoesNotExist()
        composeTestRule.onNodeWithContentDescription("Home Team").assertExists().assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Away Team").assertExists().assertIsDisplayed()

    }

    companion object {
        const val competitionId = 2001

        val fixture = FixtureEntity(
            1,
            2001,
            "Premier League",
            HomeTeamEntity(1, "Manchester United", "United", "", "MUN"),
            AwayTeamEntity(2, "Arsenal", "Arsenal", "", "Ars"),
            ScoreEntity(
                FullTimeEntity(1, 1),
                HalfTimeEntity(1, 1),
                RegularTimeEntity(1, 1),
                ""
            ),
            "August", "", "FINISHED", 3
        ).toFixture()
    }
}
