package uk.co.bbc.smpjetpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.co.bbc.smpjetpc.compose.SMPPlayer
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
                    SMPPlayer(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SMPPlayerPreview() {
    SMPJetpcTheme {
        SMPPlayer()
    }
}