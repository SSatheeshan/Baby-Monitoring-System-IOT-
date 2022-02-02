package com.satheeshan.ipro

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.videolan.libvlc.LibVLC
import org.videolan.libvlc.Media
import org.videolan.libvlc.MediaPlayer
import org.videolan.libvlc.util.VLCVideoLayout

class MainActivity : AppCompatActivity()
{
    private var url: String = "rtsp://192.168.137.218:8554/"

    private lateinit var libVlc: LibVLC
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var videoLayout: VLCVideoLayout

    override fun onCreate(savedInstanceState: Bundle?)
    {
        title="Baby Live Stream"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        libVlc = LibVLC(this)
        mediaPlayer = MediaPlayer(libVlc)
        videoLayout = findViewById(R.id.videoLayout)
    }

    override fun onStart()
    {
        super.onStart()

        mediaPlayer.attachViews(videoLayout, null, false, false)

        val media = Media(libVlc, Uri.parse(url))
        media.setHWDecoderEnabled(true, false)
        media.addOption(":network-caching=600")

        mediaPlayer.media = media
        media.release()
        mediaPlayer.play()
    }

    override fun onStop()
    {
        super.onStop()

        mediaPlayer.stop()
        mediaPlayer.detachViews()
    }

    override fun onDestroy()
    {
        super.onDestroy()

        mediaPlayer.release()
        libVlc.release()
    }
}