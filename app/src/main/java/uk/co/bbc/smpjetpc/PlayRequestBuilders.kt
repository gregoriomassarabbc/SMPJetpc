package uk.co.bbc.smpjetpc

import android.content.Context
import uk.co.bbc.smpan.AODDASHPlayRequestBuilder
import uk.co.bbc.smpan.AODProductName
import uk.co.bbc.smpan.AODProductVersion
import uk.co.bbc.smpan.SMP
import uk.co.bbc.smpan.SMPBuilder
import uk.co.bbc.smpan.VODPlayRequestBuilder
import uk.co.bbc.smpan.audiosimulcast.mediation.AudioSimulcastPlayRequestBuilder
import uk.co.bbc.smpan.audiosimulcast.mediation.AudioSimulcastProductName
import uk.co.bbc.smpan.audiosimulcast.mediation.AudioSimulcastProductVersion
import uk.co.bbc.smpan.media.PlayRequest
import uk.co.bbc.smpan.media.model.MediaContentHoldingImage
import uk.co.bbc.smpan.stats.ui.UserInteractionStatisticsProvider
import uk.co.bbc.smpan.videosimulcast.mediation.ProductName
import uk.co.bbc.smpan.videosimulcast.mediation.ProductVersion
import uk.co.bbc.smpan.videosimulcast.mediation.VideoSimulcastPlayRequestBuilder

class PlayRequestBuilders {

    fun playSimulcastRequest(context: Context): PlayRequest? {
        val avStatisticsProvider = SMPAVStatisticsProvider()
        val vpid = "bbc_news24"

        return VideoSimulcastPlayRequestBuilder(
            context,
            ProductName("Video Simulcast"),
            ProductVersion("2.0.1")
        )
            .forVpid(vpid, avStatisticsProvider)
            .with(MediaContentHoldingImage("https://i.pinimg.com/originals/d9/b3/ae/d9b3ae779f3c1b95b2dbac89327924d1.jpg"))
            .withAutoplay(true)
            .build()
    }

    fun playVODRequest(context: Context): PlayRequest? {
        val avStatisticsProvider = SMPAVStatisticsProvider()
        val vpid = "m001vxdm"

        return VODPlayRequestBuilder(
            context,
            uk.co.bbc.smpan.ProductName("VOD PRB"),
            uk.co.bbc.smpan.ProductVersion("4.0.1")
        )
            .forVpid(vpid, avStatisticsProvider)
            .with(MediaContentHoldingImage("https://i.pinimg.com/originals/d9/b3/ae/d9b3ae779f3c1b95b2dbac89327924d1.jpg"))
            .withAutoplay(true)
            .build()
    }

    fun playAODRequest(context: Context): PlayRequest? {
        val avStatisticsProvider = SMPAVStatisticsProvider()
        val vpid = "m001whh8" // Giles Peterson

        return AODDASHPlayRequestBuilder(
            context,
            AODProductName("AOD PRB"),
            AODProductVersion("3.0.1")
        )
            .forVpid(vpid, avStatisticsProvider)
            .with(MediaContentHoldingImage("https://i.pinimg.com/originals/d9/b3/ae/d9b3ae779f3c1b95b2dbac89327924d1.jpg"))
            .withAutoplay(true)
            .build()
    }

    fun playAudioSimulcastRequest(context: Context): PlayRequest? {
        val avStatisticsProvider = SMPAVStatisticsProvider()
        val vpid = "bbc_6music" // Giles Peterson

        return AudioSimulcastPlayRequestBuilder(
            context,
            AudioSimulcastProductName("Audio Simulcast PRB"),
            AudioSimulcastProductVersion("5.0.1")
        )
            .forVpid(vpid, avStatisticsProvider)
            .with(MediaContentHoldingImage("https://i.pinimg.com/originals/d9/b3/ae/d9b3ae779f3c1b95b2dbac89327924d1.jpg"))
            .withAutoplay(true)
            .build()
    }

     fun createSMP(context: Context): SMP {
        return SMPBuilder.create(
            context,
            "My SMP App",
            "0.0.1",
            UserInteractionStatisticsProvider.NULL
        ).with()
            .build()
    }
}