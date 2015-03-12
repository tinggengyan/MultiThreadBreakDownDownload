package com.steve.player;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.wwj.download.R;

public class PlayerActivity extends Activity {
  private Player player;
  private SeekBar musicProgress;
  private Button playBtn;
  private Button pauseBtn;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.player);
    musicProgress = (SeekBar) findViewById(R.id.music_progress);
    playBtn = (Button) findViewById(R.id.btn_online_play);
    pauseBtn=(Button) findViewById(R.id.btn_online_pause);
    player = new Player(musicProgress);
    musicProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
    playBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        new Thread(new Runnable() {
          @Override
          public void run() {
            player.playUrl("http://abv.cn/music/�������.mp3");
          }
        }).start();
      }
    });
    pauseBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        player.pause();
      }
    });
  }

  class SeekBarChangeEvent implements OnSeekBarChangeListener {
    int progress;

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
      // ԭ����(progress/seekBar.getMax())*player.mediaPlayer.getDuration()
      this.progress = progress * player.mediaPlayer.getDuration() / seekBar.getMax();
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
      // seekTo()�Ĳ����������ӰƬʱ������֣���������seekBar.getMax()��Ե�����
      player.mediaPlayer.seekTo(progress);
    }

  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (player != null) {
      player.stop();
      player = null;
    }
  }
}
