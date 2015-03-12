package com.steve;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.steve.download.DownloadActivity;
import com.steve.player.PlayerActivity;
import com.wwj.download.R;

public class MainActivity extends Activity implements OnClickListener {
  // Content View Elements
  private Button mButton_download;
  private Button mButton_playonline;

  // End Of Content View Elements
  private void bindViews() {
    mButton_download = (Button) findViewById(R.id.button_download);
    mButton_playonline = (Button) findViewById(R.id.button_playonline);
    mButton_download.setOnClickListener(this);
    mButton_playonline.setOnClickListener(this);
  }



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_choose);
    bindViews();
  }



  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.button_download:
        this.startActivity(new Intent(this, DownloadActivity.class));
        break;
      case R.id.button_playonline:
        this.startActivity(new Intent(this, PlayerActivity.class));
        break;
      default:
        break;
    }
  }
}
