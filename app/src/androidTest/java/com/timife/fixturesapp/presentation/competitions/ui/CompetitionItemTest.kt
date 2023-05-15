package com.timife.fixturesapp.presentation.competitions.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertHasNoClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.timife.fixturesapp.domain.model.Competition
import org.junit.Rule
import org.junit.Test

class CompetitionItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun competitionItemTest() {

        composeTestRule.setContent {
            CompetitionItem(modifier = Modifier, competition = competition)
        }
        composeTestRule.onNodeWithContentDescription("Competition logo").assertExists()
        composeTestRule.onNodeWithContentDescription("Competition logo").assertIsDisplayed()

        composeTestRule.onNodeWithText(competition.code).assertExists()
        composeTestRule.onNodeWithText(competition.code).assertHasNoClickAction()

    }

    companion object {
        val competition = Competition(
            2021,
            "English Premier League",
            "https://crests.football-data.org/PL.png",
            "EPL"
        )
    }
}