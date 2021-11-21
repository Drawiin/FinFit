package com.drawiin.common_ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.drawiin.common_ui.theme.FunFitTheme
import com.drawiin.common_ui.theme.OnSurface
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.Shapes
import com.drawiin.common_ui.theme.Values

@Composable
fun DrawerLayout(
    title: String,
    options: List<DrawerOption>,
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerBody(title = title, options = options) },
        content = content,
        drawerShape = RectangleShape
    )
}

@Composable
fun DrawerBody(
    title: String,
    options: List<DrawerOption>
) {
    Column(Modifier.padding(Padding.small)) {
        Text(title, style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(Values.x8))
        Column {
            options.forEach {
                DrawerOptionItem(item = it)
                Spacer(modifier = Modifier.height(Values.x2))
            }
        }
    }
}

@Composable
fun DrawerOptionItem(item: DrawerOption) {
    val (title, icon, onItemClicked) = item
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onItemClicked() }) {
        Icon(imageVector = icon, contentDescription = title, tint = OnSurface)
        Spacer(modifier = Modifier.width(Values.x3))
        Text(title, style = MaterialTheme.typography.h5)
    }
}

data class DrawerOption(
    val title: String,
    val icon: ImageVector,
    val onItemClicked: () -> Unit
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DrawerLayoutPreview() {
    FunFitTheme {
        DrawerLayout(title = "Ola, Pessoa", options = listOf(
            DrawerOption(
                "Licenças",
                Icons.Default.List
            ) {},
            DrawerOption(
                "Licenças",
                Icons.Default.List
            ) {},
            DrawerOption(
                "Licenças",
                Icons.Default.List
            ) {}
        ), drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
        ) {
            Text(text = "Hey there my friend")
        }
    }
}
