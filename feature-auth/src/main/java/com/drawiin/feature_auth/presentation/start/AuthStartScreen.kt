package com.drawiin.feature_auth.presentation.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.drawiin.common_ui.composables.PrimaryButton
import com.drawiin.common_ui.composables.SecondaryButton
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.Values
import com.drawiin.feature_auth.R

@Composable
fun AuthStartScreen(onGoToLogin: () -> Unit, onGoToSignup: () -> Unit) {
    AuthStartBody(onGoToLogin = onGoToLogin, onGoToSignup = onGoToSignup)
}

@Composable
private fun AuthStartBody(onGoToLogin: () -> Unit, onGoToSignup: () -> Unit) {
    Scaffold {
        Column(
            modifier = Modifier
                .padding(vertical = Padding.medium)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                stringResource(id = R.string.auth_start_title),
                modifier = Modifier.padding(horizontal = Padding.small),
                style = MaterialTheme.typography.h4
            )
            Image(
                painter = painterResource(R.drawable.ic_auth_start_banner),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Column(modifier = Modifier.padding(horizontal = Padding.small)) {
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.auth_start_login),
                    onClick = onGoToLogin
                )
                Spacer(modifier = Modifier.height(Values.x1))
                SecondaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.auth_start_singnup),
                    onClick = onGoToSignup
                )
            }
        }
    }
}
