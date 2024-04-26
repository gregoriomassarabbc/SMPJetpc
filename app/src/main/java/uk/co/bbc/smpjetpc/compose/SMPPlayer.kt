package uk.co.bbc.smpjetpc.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ui.PlayerView
import uk.co.bbc.smpjetpc.PlayRequestBuilders

@Suppress("DEPRECATION")
@Composable
fun SMPPlayer(modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Video Simulcast",
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.End)
                .background(Color.Cyan),
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W900,
                fontSize = 18.sp
            )
        )
        AndroidView(
            factory = { context ->
                PlayerView(context).also {
                    val smp = PlayRequestBuilders().createSMP(context)
                    val playRequest = PlayRequestBuilders().playSimulcastRequest(context)
                    val embeddedPlayoutWindow = smp.embeddedPlayoutWindow(playRequest)
                    embeddedPlayoutWindow.attachToViewGroup(it)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )

        Spacer(modifier = Modifier
            .height(8.dp)
            .background(Color.Red))

        Text(
            "VOD",
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.End)
                .background(Color.Yellow),
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W900,
                fontSize = 18.sp
            )
        )

        AndroidView(
            factory = { context ->
                PlayerView(context).also {
                    val smp = PlayRequestBuilders().createSMP(context)
                    val playRequest = PlayRequestBuilders().playVODRequest(context)
                    val embeddedPlayoutWindow = smp.embeddedPlayoutWindow(playRequest)
                    embeddedPlayoutWindow.attachToViewGroup(it)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )

        Text(
            "AOD",
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.End)
                .background(Color.Green),
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W900,
                fontSize = 18.sp
            )
        )

        AndroidView(
            factory = { context ->
                PlayerView(context).also {
                    val smp = PlayRequestBuilders().createSMP(context)
                    val playRequest = PlayRequestBuilders().playAODRequest(context)
                    val embeddedPlayoutWindow = smp.embeddedPlayoutWindow(playRequest)
                    embeddedPlayoutWindow.attachToViewGroup(it)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )

        Text(
            "Audio Simulcast",
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.End)
                .background(Color.Magenta),
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W900,
                fontSize = 18.sp
            )
        )

        AndroidView(
            factory = { context ->
                PlayerView(context).also {
                    val smp = PlayRequestBuilders().createSMP(context)
                    val playRequest = PlayRequestBuilders().playAudioSimulcastRequest(context)
                    val embeddedPlayoutWindow = smp.embeddedPlayoutWindow(playRequest)
                    embeddedPlayoutWindow.attachToViewGroup(it)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )

        IconButton(onClick = { /*TODO*/ }) {

        }

    }

}