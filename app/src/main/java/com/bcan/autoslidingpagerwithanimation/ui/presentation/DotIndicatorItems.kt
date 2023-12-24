package com.bcan.autoslidingpagerwithanimation.ui.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DotIndicatorItems(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
) {
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(totalDots) { index ->
            if (index == selectedIndex) {
                SelectedDot()
            } else {
                UnSelectedDot()
            }
            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 3.dp))
            }
        }
    }
}

@Composable
private fun UnSelectedDot() {
    Surface(
        modifier = Modifier.size(15.dp),
        shape = CircleShape,
        color = Color(0xFF95a5a6),
        border = BorderStroke(2.dp, Color(0xFF333333))
    ) {}
}

@Composable
private fun SelectedDot() {
    Surface(
        modifier = Modifier.size(18.dp),
        shape = CircleShape,
        color = Color(0xFF2ecc71),
        border = BorderStroke(2.dp, Color(0xFF333333))
    ) {}
}