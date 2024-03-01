package uk.co.bbc.smpjetpc

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ui.PlayerView
import uk.co.bbc.smpan.SMP
import uk.co.bbc.smpan.SMPBuilder
import uk.co.bbc.smpan.media.PlayRequest
import uk.co.bbc.smpan.media.model.MediaContentHoldingImage
import uk.co.bbc.smpan.stats.ui.UserInteractionStatisticsProvider
import uk.co.bbc.smpan.videosimulcast.mediation.ProductName
import uk.co.bbc.smpan.videosimulcast.mediation.ProductVersion
import uk.co.bbc.smpan.videosimulcast.mediation.VideoSimulcastPlayRequestBuilder
import uk.co.bbc.smpjetpc.ui.theme.SMPJetpcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMPJetpcTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SMPPlayer()
                }
            }
        }
    }


}

@Composable
fun SMPPlayer(modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
        Text(
            "SMP Video Simulcast",
            modifier = Modifier
                .padding(30.dp)
                .align(Alignment.CenterHorizontally),
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W900,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        )
        AndroidView(
            factory = { context ->
                PlayerView(context).also {
                    val smp = createSMP(context)
                    val playRequest = playRequest(context)
                    val embeddedPlayoutWindow = smp.embeddedPlayoutWindow(playRequest)
                    embeddedPlayoutWindow.attachToViewGroup(it)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )

        Spacer(modifier = Modifier.height(8.dp))

        IconButton(onClick = { /*TODO*/ }) {
            
        }

    }

}

private fun playRequest(context: Context): PlayRequest? {
    val avStatisticsProvider = SMPAVStatisticsProvider()
    val vpid = "bbc_news24"

    return VideoSimulcastPlayRequestBuilder(
        context,
        ProductName("My SMP App"),
        ProductVersion("0.0.1")
    )
        .forVpid(vpid, avStatisticsProvider)
        .with(MediaContentHoldingImage("https://i.pinimg.com/originals/d9/b3/ae/d9b3ae779f3c1b95b2dbac89327924d1.jpg"))
        .withAutoplay(true)
        .build()
}

private fun createSMP(context: Context): SMP {
    return SMPBuilder.create(
        context,
        "My SMP App",
        "0.0.1",
        UserInteractionStatisticsProvider.NULL
    ).build()
}


@Preview(showBackground = true)
@Composable
fun SMPPlayerPreview() {
    SMPJetpcTheme {
        SMPPlayer()
    }
}