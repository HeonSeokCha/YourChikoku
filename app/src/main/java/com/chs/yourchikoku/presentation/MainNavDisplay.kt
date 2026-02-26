package com.chs.yourchikoku.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.chs.yourchikoku.presentation.screen.alarm_detail.AlarmDetailScreenRoot
import com.chs.yourchikoku.presentation.screen.alarm_detail.AlarmDetailViewModel
import com.chs.yourchikoku.presentation.screen.home_screen.HomeScreenRoot
import com.chs.yourchikoku.presentation.screen.home_screen.HomeViewModel
import com.chs.yourchikoku.presentation.screen.step_alarm.StepAlarmScreenRoot
import com.chs.yourchikoku.presentation.screen.step_alarm.StepAlarmViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainNavDisplay(
    backStack: NavBackStack<NavKey>,
    modifier: Modifier = Modifier
) {
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<YourChikokuScreens.HomeScreen> {
                val viewModel: HomeViewModel = koinViewModel()

                HomeScreenRoot(
                    viewModel = viewModel,
                    navigateDetail = {
                        backStack.add(YourChikokuScreens.AlarmDetailScreen(it))
                    }
                )
            }

            entry<YourChikokuScreens.AlarmDetailScreen> { key ->
                val viewModel = koinViewModel<AlarmDetailViewModel> {
                    parametersOf(key.alarmId)
                }
                AlarmDetailScreenRoot(viewModel)
            }

            entry<YourChikokuScreens.StepAlarmScreen> {
                val viewModel: StepAlarmViewModel = koinViewModel()

                StepAlarmScreenRoot()
            }
        }
    )
}