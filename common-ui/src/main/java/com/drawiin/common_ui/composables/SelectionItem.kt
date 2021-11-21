package com.drawiin.common_ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.drawiin.common_ui.theme.Border
import com.drawiin.common_ui.theme.FunFitTheme
import com.drawiin.common_ui.theme.OnSurface
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.Values

@Composable
fun SelectionItem(
    modifier: Modifier = Modifier,
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    if (isSelected)
        SelectedItem(title = title, onClick = onClick, modifier = modifier)
    else
        UnselectedItem(title = title, onClick = onClick, modifier = modifier)
}

@Composable
fun SelectedItem(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick, shape = MaterialTheme.shapes.medium, contentPadding = PaddingValues(
            Padding.small
        )
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, style = MaterialTheme.typography.button)
        }
    }
}

@Composable
fun UnselectedItem(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        contentPadding = PaddingValues(Padding.small),
        border = BorderStroke(
            Border.small, OnSurface
        )
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, style = MaterialTheme.typography.button.copy(color = OnSurface))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SelectionItemPreview() {
    FunFitTheme{
        Column {
            SelectionItem(title = "Selected", isSelected = true, modifier = Modifier.fillMaxWidth()) {}
            Spacer(modifier = Modifier.height(Values.x4))
            SelectionItem(title = "Unselected", isSelected = false, modifier = Modifier.fillMaxWidth()) {}
        }
    }
}
