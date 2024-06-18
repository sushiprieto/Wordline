package com.carlosprieto.wordline.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest

@Composable
fun StadiumDetailItem(
    title: String?,
    image: String?
) {
    Card(
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.button,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colors.onSurface
                )
            }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image)
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .padding(horizontal = 5.dp)
            )

        }
    }
}
