package com.familiagrandi.karaoke

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class MainActivity : AppCompatActivity() {
    private lateinit var player: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        player = ExoPlayer.Builder(this).build()

        findViewById<Button>(R.id.playNow).setOnClickListener {
            val urlTeste = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            player.setMediaItem(MediaItem.fromUri(urlTeste))
            player.prepare()
            player.play()
            Toast.makeText(this, "Tocando vídeo de teste", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::player.isInitialized) player.release()
    }
}
