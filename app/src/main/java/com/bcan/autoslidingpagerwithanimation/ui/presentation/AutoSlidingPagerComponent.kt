package com.bcan.autoslidingpagerwithanimation.ui.presentation

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AutoSlidingPagerComponent() {
    val imagesList = listOf(
        "https://t3.ftcdn.net/jpg/05/68/49/90/240_F_568499083_q9QfafI1PkGJA8QQMIpiTT557xUUJ4Qq.jpg",
        "https://t4.ftcdn.net/jpg/05/64/74/11/240_F_564741194_CjtDvMtO3zKdgd6Lz8Qphnv7UQ7PBKnR.jpg",
        "https://t4.ftcdn.net/jpg/05/64/99/95/360_F_564999540_XdTvqLGDpneB3v4ifz0SZgzxMOFmfoVo.jpg",
        "https://t4.ftcdn.net/jpg/05/90/98/49/240_F_590984956_sfLEosb32bWdY7nYRXlTGCagP7kVgWZD.jpg",
        "https://t4.ftcdn.net/jpg/05/68/49/87/240_F_568498732_dIwNMTR0NOskCtk5MSvwvOs1DOjf14Cr.jpg"

    )

    val pagerState = rememberPagerState { imagesList.size }
    val currentPage by remember { derivedStateOf { pagerState.currentPage } }

    LaunchedEffect(currentPage) {
        delay(5000)
        pagerState.scrollToPage((currentPage + 1) % imagesList.size)
    }

    HorizontalPager(
        state = pagerState
    ) {
        Box {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Crossfade(
                    targetState = currentPage,
                    label = "AnimatedPager",
                    animationSpec = tween(1000)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(imagesList[it])
                            .crossfade(true)
                            .build(),
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds,
                    )
                }
            }
            DotIndicatorItems(
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .align(Alignment.BottomCenter),
                totalDots = imagesList.size,
                selectedIndex = currentPage
            )
        }

    }
}

