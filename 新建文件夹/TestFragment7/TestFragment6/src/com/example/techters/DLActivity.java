package com.example.techters;



import com.example.testbase.fragment3.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


 
import android.app.backup.SharedPreferencesBackupHelper;  
import android.content.Context;  
import android.content.Intent;  
import android.content.SharedPreferences;  
import android.content.SharedPreferences.Editor; 
import android.text.Spannable;  
import android.view.View.OnClickListener;  
import android.view.Window;  
import android.widget.CheckBox;  
import android.widget.CompoundButton;  
import android.widget.CompoundButton.OnCheckedChangeListener;  
import android.widget.EditText;  
import android.widget.ImageButton;  


/*
 * 教师端登录
 */
public class DLActivity extends Activity {
	private EditText userName, password;  
    private CheckBox rem_pw, auto_login;  
    private Button btn_login; 
    private String userNameValue,passwordValue;  
    private SharedPreferences sp;  
  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
          
        //去除标题  
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.activity_dl);  
          
        //获得实例对象  
        sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);  
        userName = (EditText) findViewById(R.id.username);  
        password = (EditText) findViewById(R.id.password);  
        rem_pw = (CheckBox) findViewById(R.id.checkBox1);  
        auto_login = (CheckBox) findViewById(R.id.checkBox2);  
        btn_login = (Button) findViewById(R.id.loginbtn);  
        //btnQuit = (ImageButton)findViewById(R.id.img_btn);  
          
          
        //判断记住密码多选框的状态  
      if(sp.getBoolean("ISCHECK", false))  
        {  
          //设置默认是记录密码状态  
          rem_pw.setChecked(true);  
          userName.setText(sp.getString("USER_NAME", ""));  
          password.setText(sp.getString("PASSWORD", ""));  
          //判断自动登陆多选框状态  
          if(sp.getBoolean("AUTO_ISCHECK", false))  
          {  
                 //设置默认是自动登录状态  
                 auto_login.setChecked(true);  
                //跳转界面  
                Intent intent = new Intent(DLActivity.this,LoadingActivity.class);  
                DLActivity.this.startActivity(intent);  
                  
          }  
        }  
          
        // 登录监听事件  现在默认为用户名为：liu 密码：123  
        btn_login.setOnClickListener(new OnClickListener() {  
  
            public void onClick(View v) {  
                userNameValue = userName.getText().toString();  
                passwordValue = password.getText().toString();  
                  
                if(userNameValue.equals("123")&&passwordValue.equals("qwe"))  
                {  
                    Toast.makeText(DLActivity.this,"登录成功", Toast.LENGTH_SHORT).show();  
                    //登录成功和记住密码框为选中状态才保存用户信息  
                    if(rem_pw.isChecked())  
                    {  
                     //记住用户名、密码、  
                      Editor editor = sp.edit();  
                      editor.putString("USER_NAME", userNameValue);  
                      editor.putString("PASSWORD",passwordValue);  
                      editor.commit();  
                    }  
                    //跳转界面  
                    Intent intent = new Intent();
        			intent.setClass(DLActivity.this, LoadingActivity.class);
        			startActivity(intent);
        			DLActivity.this.finish(); 
                      
                }else{  
                      
                    Toast.makeText(DLActivity.this,"用户名或密码错误，请重新登录", Toast.LENGTH_LONG).show();  
                }  
                  
            }  
        });  
  
        //监听记住密码多选框按钮事件  
        rem_pw.setOnCheckedChangeListener(new OnCheckedChangeListener() {  
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {  
                if (rem_pw.isChecked()) {  
                      
                    System.out.println("记住密码已选中");  
                    sp.edit().putBoolean("ISCHECK", true).commit();  
                      
                }else {  
                      
                    System.out.println("记住密码没有选中");  
                    sp.edit().putBoolean("ISCHECK", false).commit();  
                      
                }  
  
            }  
        });  
          
        //监听自动登录多选框事件  
        auto_login.setOnCheckedChangeListener(new OnCheckedChangeListener() {  
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {  
                if (auto_login.isChecked()) {  
                    System.out.println("自动登录已选中");  
                    sp.edit().putBoolean("AUTO_ISCHECK", true).commit();  
  
                } else {  
                    System.out.println("自动登录没有选中");  
                    sp.edit().putBoolean("AUTO_ISCHECK", false).commit();  
                }  
            }  
        });  
          
//        btnQuit.setOnClickListener(new OnClickListener() {  
//              
//            @Override  
//            public void onClick(View v) {  
//                finish();  
//            }  
//        });  
  
    }  
}
	


//	// 用户名
//	private TextView userText;
//	// 密码
//	private TextView passText;
//	// 登录按钮
//	private Button loginBtn;
//
//	private static final String MY_USERNAME = "123";
//	private static final String MY_PASSWORD = "qwe";
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_dl);
//
//		View v = findViewById(R.id.yjbg);// 找到你要设透明背景的layout 的id
//		v.setBackgroundResource(R.drawable.text_view_border);
//		initView();
//
//	}
//
//	// 初始化控件对象
//	private void initView() {
//
//		this.userText = (TextView) this.findViewById(R.id.username);
//		this.passText = (TextView) this.findViewById(R.id.password);
//		this.loginBtn = (Button) this.findViewById(R.id.loginbtn);
//
//	}
//
//	public void login_in(View v) {
//		String username = this.userText.getText().toString();
//		String password = this.passText.getText().toString();
//		if (MY_USERNAME.equals(username) && MY_PASSWORD.equals(password)) {
//			Intent intent = new Intent();
//			intent.setClass(DLActivity.this, LoadingActivity.class);
//			startActivity(intent);
//			DLActivity.this.finish();
//
//		} else {
//			Toast.makeText(getApplicationContext(), "用户名或者密码不正确", Toast.LENGTH_SHORT).show();
//		}
//
//	}
//
//
//
//}
