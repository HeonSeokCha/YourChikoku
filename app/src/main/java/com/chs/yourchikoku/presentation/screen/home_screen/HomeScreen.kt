package com.chs.yourchikoku.presentation.screen.home_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreenRoot(
    viewModel: HomeViewModel,
    navigateDetail: (Int) -> Unit
) {

}

@Composable
fun HomeScreen(
    state: HomeState
) {
    if (state.isLoadIng) {

        return
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