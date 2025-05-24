package com.bbg.bbgconnect.presentation.ui.sozialMedia

import android.net.Uri
import android.view.ViewGroup
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.Fullscreen
import androidx.compose.material.icons.filled.FullscreenExit
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
/**
 * Created by Enoklit on 21.05.2025.
 */
@Composable
fun VideoPlayer(videoUri: String) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val systemUi = rememberSystemUiController()

    var isPlaying by remember { mutableStateOf(false) }
    var isFullscreen by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(true) }

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(Uri.parse(videoUri)))
            prepare()
            playWhenReady = false
        }
    }
    // Release player when lifecycle ends
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_STOP) {
                exoPlayer.release()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            exoPlayer.release()
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightColors.videoBackground)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
        ) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = {
                    PlayerView(it).apply {
                        player = exoPlayer
                        useController = false
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                    }
                }
            )

            if (isLoading) {
                CircularProgressIndicator(
                    color = LightColors.primary,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(LightColors.card.copy(alpha = 0.9f))
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = "Play/Pause",
                    tint = LightColors.videoControl,
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            if (exoPlayer.isPlaying) {
                                exoPlayer.pause()
                                isPlaying = false
                            } else {
                                exoPlayer.play()
                                isPlaying = true
                            }
                        }
                )

                Icon(
                    imageVector = if (isFullscreen) Icons.Default.FullscreenExit else Icons.Default.Fullscreen,
                    contentDescription = "Fullscreen",
                    tint = LightColors.videoControl,
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            isFullscreen = !isFullscreen
                            systemUi.isSystemBarsVisible = !isFullscreen
                        }
                )
            }
        }
    }

    // Handle back press in fullscreen
    BackHandler(enabled = isFullscreen) {
        isFullscreen = false
        systemUi.isSystemBarsVisible = true
    }
}
