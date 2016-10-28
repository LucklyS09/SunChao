package com.example.techters;

import com.example.testbase.fragment3.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;


import android.app.Activity;  
import android.content.Intent;  
import android.content.SharedPreferences;  
import android.content.SharedPreferences.Editor;  
import android.opengl.ETC1;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.view.Window;  
import android.view.animation.AlphaAnimation;  
import android.view.animation.Animation;  
import android.view.animation.Animation.AnimationListener;  
import android.widget.Button;  
import android.widget.ImageButton;  
import android.widget.ImageView;  
import android.widget.ProgressBar;  
/*
 * 登录时 的加载圈
 */

public class LoadingActivity extends Activity {

	private ProgressBar progressBar;   
  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        // 去除标题  
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.activity_loading);  
  
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);  
          
  
        Intent intent = new Intent(this, Activity_wdkc.class);  
        LoadingActivity.this.startActivity(intent);  
        finish();
    }  
  
}
