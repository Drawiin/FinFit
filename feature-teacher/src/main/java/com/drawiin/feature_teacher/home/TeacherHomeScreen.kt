package com.drawiin.feature_teacher.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.drawiin.common_ui.composables.DrawerLayout
import com.drawiin.common_ui.composables.DrawerOption
import com.drawiin.common_ui.composables.NavigationAppBar
import com.drawiin.common_ui.composables.TrainingItem
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.PrimaryColor
import com.drawiin.common_ui.theme.SurfaceColor
import com.drawiin.common_ui.theme.Values
import com.drawiin.feature_teacher.R
import com.drawiin.utils.trainings
import kotlinx.coroutines.launch
import com.drawiin.core.R as CoreR

@ExperimentalMaterialApi
@Composable
fun TeacherHomeScreen(
     onGoToCreateTraining: () -> Unit,
     onGoToTrainingDetail: (uid: String) -> Unit
) {
     val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
     val scope = rememberCoroutineScope()
     val toggleDrawer: () -> Unit = {
          scope.launch {
               if (drawerState.isOpen)
                    drawerState.close()
               else
                    drawerState.open()
          }
     }
     val drawerOptions = listOf(
          DrawerOption(
               title = stringResource(id = CoreR.string.drawer_option_licence),
               icon = Icons.Default.List
          ) {},
          DrawerOption(
               title = stringResource(id = CoreR.string.drawer_option_terms),
               icon = Icons.Default.Info
          ) {},
          DrawerOption(
               title = stringResource(id = CoreR.string.drawer_option_log_out),
               icon = Icons.Default.ExitToApp
          ) {}
     )

     TeacherHomeBody(
          drawerOptions,
          drawerState,
          toggleDrawer,
          onGoToTrainingDetail,
          onGoToCreateTraining
     )
}

@ExperimentalMaterialApi
@Composable
private fun TeacherHomeBody(
     drawerOptions: List<DrawerOption>,
     drawerState: DrawerState,
     toggleDrawer: () -> Unit,
     onGoToTrainingDetail: (uid: String) -> Unit,
     onGoToCreateTraining: () -> Unit
) {
     DrawerLayout(
          title = stringResource(id = R.string.teacher_drawer_title) + " Vinicius",
          options = drawerOptions,
          drawerState = drawerState
     ) {
          Scaffold(
               topBar = {
                    NavigationAppBar(
                         leadingIcon = Icons.Outlined.Menu,
                         onLeadingClicked = { toggleDrawer() })
               },
               floatingActionButton = {
                    AddFab(onGoToCreateTraining)
               }
          ) {
               Column(Modifier.padding(horizontal = Padding.small)) {
                    Text(
                         stringResource(id = R.string.teacher_home_title),
                         style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(Values.x8))
                    LazyColumn {
                         items(trainings) { t ->
                              TrainingItem(
                                   title = t.title,
                                   quantity = t.exercises.size,
                                   onClick = { onGoToTrainingDetail(t.uid) }
                              )
                              Spacer(modifier = Modifier.height(Values.x2))
                         }
                    }
               }
          }
     }
}

@Composable
private fun AddFab(onClick: () -> Unit) {
     FloatingActionButton(
          onClick = { onClick() },
          backgroundColor = PrimaryColor
     ) {
          Icon(
               imageVector = Icons.Default.Add,
               contentDescription = null,
               tint = SurfaceColor
          )
     }
}
