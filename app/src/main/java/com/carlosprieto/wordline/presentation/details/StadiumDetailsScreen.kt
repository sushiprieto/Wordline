package com.carlosprieto.wordline.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.carlosprieto.wordline.R
import com.carlosprieto.wordline.component.StadiumDetailItem

@Suppress("LongMethod")
@Composable
fun StadiumDetailsScreen(
    navController: NavController,
    viewModel: StadiumDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column {
        TopAppBar(
            title =
            {
                state.data?.let {
                    Text(text = it.name)
                }
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.KeyboardArrowLeft, "")
                }
            },
            contentColor = MaterialTheme.colors.onSurface,
            elevation = 12.dp
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            state.data?.let { stadium ->
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(20.dp)
                ) {
                    item {
                        StadiumDetailItem(
                            stringResource(R.string.started_at),
                        )
                        StadiumDetailItem(
                            stringResource(R.string.last_data_at),
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://graphs.coinpaprika.com/currency/chart/${stadium.id}/7d/chart.svg")
                                .decoderFactory(SvgDecoder.Factory())
                                .build(),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(horizontal = 20.dp)
                                .align(Alignment.Center)
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        Card(
                            backgroundColor = MaterialTheme.colors.surface,
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                        ) {
                            Text(
                                text = stadium.description,
                                style = MaterialTheme.typography.body1,
                                color = MaterialTheme.colors.onSurface,
                                modifier = Modifier
                                    .padding(12.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(15.dp))

                    }
                }
            }
            if (state.errorMessage.isNotBlank()) {
                Text(
                    text = state.errorMessage,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val lottieCompositionResult: LottieCompositionResult =
                        rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))

                    val progress by animateLottieCompositionAsState(
                        lottieCompositionResult.value,
                        isPlaying = true,
                        iterations = LottieConstants.IterateForever,
                        speed = 1.0f
                    )

                    LottieAnimation(
                        composition = lottieCompositionResult.value,
                        progress = progress,
                        modifier = Modifier.padding(all = 30.dp)
                    )
                }
            }
        }
    }
}