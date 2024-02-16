package uk.co.bbc.smpjetpc

import uk.co.bbc.mediaselector.MediaSelectorClientConfiguration
import uk.co.bbc.mediaselector.MediaSet
import uk.co.bbc.mediaselector.request.MediaSelectorRequestParameters

class SMPMediaSelectorConfig : MediaSelectorClientConfiguration {
    override fun getMediaSelectorBaseUrl(): String {
        return "https://open.live.bbc.co.uk/mediaselector/6/select"
    }

    override fun getSecureMediaSelectorBaseUrl(): String {
        return "https://open.live.bbc.co.uk/mediaselector/6/select"
    }

    override fun getDefaultParameters(): MediaSelectorRequestParameters {
        return MediaSelectorRequestParameters()
    }

    override fun getUserAgent(): String {
        return "smp-jetpack"
    }

    override fun getMediaSet(): MediaSet {
        return MediaSet.fromString("mobile-phone-main")
    }
}