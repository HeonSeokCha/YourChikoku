package com.chs.yourchikoku.presentation.screen.home_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreenRoot(
    viewModel: HomeViewModel,
    navigateDetail: (Int) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.NavigateAlarmDetail -> {
                    navigateDetail(effect.id)
                }
            }
        }
    }

    HomeScreen(
        state = state,
        onIntent = viewModel::handleIntent
    )
}

@Composable
fun HomeScreen(
    state: HomeState,
    onIntent: (HomeIntent) -> Unit
) {
    if (state.isLoadIng) {

    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(state.alarmList) { alarmInfo ->
            ItemAlarmInfo(alarmInfo) {

            }
        }
    }
}