package com.example.challenge_app.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.challenge_app.R

data class ChallengeCard(
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val desc: Int
)

val challengeCards = listOf(
    ChallengeCard(R.string.day1T, R.drawable.day1, R.string.day1B),
    ChallengeCard(R.string.day2T, R.drawable.day2, R.string.day2B),
    ChallengeCard(R.string.day3T, R.drawable.day3, R.string.day3B),
    ChallengeCard(R.string.day4T, R.drawable.day4, R.string.day4B),
    ChallengeCard(R.string.day5T, R.drawable.day5, R.string.day5B),
    ChallengeCard(R.string.day6T, R.drawable.day6, R.string.day6B),
    ChallengeCard(R.string.day7T, R.drawable.day7, R.string.day7B),
    ChallengeCard(R.string.day8T, R.drawable.day8, R.string.day8B),
    ChallengeCard(R.string.day9T, R.drawable.day9, R.string.day9B),
    ChallengeCard(R.string.day10T, R.drawable.day10, R.string.day10B),
    ChallengeCard(R.string.day11T, R.drawable.day11, R.string.day11B),
    ChallengeCard(R.string.day12T, R.drawable.day12, R.string.day12B),
    ChallengeCard(R.string.day13T, R.drawable.day13, R.string.day13B),
    ChallengeCard(R.string.day14T, R.drawable.day14, R.string.day14B),
    ChallengeCard(R.string.day15T, R.drawable.day15, R.string.day15B)
)
