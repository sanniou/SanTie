package com.saniou.santieba.component.thread

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.media2.common.MediaMetadata
import androidx.media2.common.UriMediaItem
import androidx.media2.player.MediaPlayer
import androidx.media2.widget.VideoView
import com.blankj.utilcode.util.ThreadUtils

class VideoPlayerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return VideoView(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getString("video")?.run {
            view as VideoView
            val mediaMetaData = MediaMetadata.Builder()
                .putString(MediaMetadata.METADATA_KEY_TITLE, "media title")
                .build()

            val mediaItem = UriMediaItem.Builder(this.toUri())
                .setMetadata(mediaMetaData) // optional
                .build()

            MediaPlayer(requireContext()).run {
                view.setPlayer(this)
                setMediaItem(mediaItem)
                // play when ready
                prepare().addListener(
                    Runnable { play() }, ThreadUtils.getIoPool()
                )
            }
        }
    }
}