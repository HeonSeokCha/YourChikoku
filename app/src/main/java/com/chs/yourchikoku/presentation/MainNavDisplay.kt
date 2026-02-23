package com.chs.yourchikoku.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.chs.yourchikoku.presentation.screen.home_screen.HomeScreenRoot
import com.chs.yourchikoku.presentation.screen.home_screen.HomeViewModel
import org.koin.androidx.compose.koinViewModel

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

            entry<YourChikokuScreens.AlarmDetailScreen> {

            }
        }
    )
}