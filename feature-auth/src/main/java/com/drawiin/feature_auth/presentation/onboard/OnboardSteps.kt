package com.drawiin.feature_auth.presentation.onboard

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.drawiin.feature_auth.R

data class OnBoardStep(
    @DrawableRes val img: Int,
    @StringRes val description: Int
) {
    companion object {
        val steps = arrayOf(
            OnBoardStep(R.drawable.ic_onboarding_01, R.string.onboard_step_01),
            OnBoardStep(R.drawable.ic_onboarding_02, R.string.onboard_step_02),
            OnBoardStep(R.drawable.ic_onboarding_03, R.string.onboard_step_03)
        )
    }
}
