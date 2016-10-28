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
 * ��ʦ�˵�¼
 */
public class DLActivity extends Activity {
	private EditText userName, password;  
    private CheckBox rem_pw, auto_login;  
    private Button btn_login; 
    private String userNameValue,passwordValue;  
    private SharedPreferences sp;  
  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
          
        //ȥ������  
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.activity_dl);  
          
        //���ʵ������  
        sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);  
        userName = (EditText) findViewById(R.id.username);  
        password = (EditText) findViewById(R.id.password);  
        rem_pw = (CheckBox) findViewById(R.id.checkBox1);  
        auto_login = (CheckBox) findViewById(R.id.checkBox2);  
        btn_login = (Button) findViewById(R.id.loginbtn);  
        //btnQuit = (ImageButton)findViewById(R.id.img_btn);  
          
          
        //�жϼ�ס�����ѡ���״̬  
      if(sp.getBoolean("ISCHECK", false))  
        {  
          //����Ĭ���Ǽ�¼����״̬  
          rem_pw.setChecked(true);  
          userName.setText(sp.getString("USER_NAME", ""));  
          password.setText(sp.getString("PASSWORD", ""));  
          //�ж��Զ���½��ѡ��״̬  
          if(sp.getBoolean("AUTO_ISCHECK", false))  
          {  
                 //����Ĭ�����Զ���¼״̬  
                 auto_login.setChecked(true);  
                //��ת����  
                Intent intent = new Intent(DLActivity.this,LoadingActivity.class);  
                DLActivity.this.startActivity(intent);  
                  
          }  
        }  
          
        // ��¼�����¼�  ����Ĭ��Ϊ�û���Ϊ��liu ���룺123  
        btn_login.setOnClickListener(new OnClickListener() {  
  
            public void onClick(View v) {  
                userNameValue = userName.getText().toString();  
                passwordValue = password.getText().toString();  
                  
                if(userNameValue.equals("123")&&passwordValue.equals("qwe"))  
                {  
                    Toast.makeText(DLActivity.this,"��¼�ɹ�", Toast.LENGTH_SHORT).show();  
                    //��¼�ɹ��ͼ�ס�����Ϊѡ��״̬�ű����û���Ϣ  
                    if(rem_pw.isChecked())  
                    {  
                     //��ס�û��������롢  
                      Editor editor = sp.edit();  
                      editor.putString("USER_NAME", userNameValue);  
                      editor.putString("PASSWORD",passwordValue);  
                      editor.commit();  
                    }  
                    //��ת����  
                    Intent intent = new Intent();
        			intent.setClass(DLActivity.this, LoadingActivity.class);
        			startActivity(intent);
        			DLActivity.this.finish(); 
                      
                }else{  
                      
                    Toast.makeText(DLActivity.this,"�û�����������������µ�¼", Toast.LENGTH_LONG).show();  
                }  
                  
            }  
        });  
  
        //������ס�����ѡ��ť�¼�  
        rem_pw.setOnCheckedChangeListener(new OnCheckedChangeListener() {  
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {  
                if (rem_pw.isChecked()) {  
                      
                    System.out.println("��ס������ѡ��");  
                    sp.edit().putBoolean("ISCHECK", true).commit();  
                      
                }else {  
                      
                    System.out.println("��ס����û��ѡ��");  
                    sp.edit().putBoolean("ISCHECK", false).commit();  
                      
                }  
  
            }  
        });  
          
        //�����Զ���¼��ѡ���¼�  
        auto_login.setOnCheckedChangeListener(new OnCheckedChangeListener() {  
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {  
                if (auto_login.isChecked()) {  
                    System.out.println("�Զ���¼��ѡ��");  
                    sp.edit().putBoolean("AUTO_ISCHECK", true).commit();  
  
                } else {  
                    System.out.println("�Զ���¼û��ѡ��");  
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
	


//	// �û���
//	private TextView userText;
//	// ����
//	private TextView passText;
//	// ��¼��ť
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
//		View v = findViewById(R.id.yjbg);// �ҵ���Ҫ��͸��������layout ��id
//		v.setBackgroundResource(R.drawable.text_view_border);
//		initView();
//
//	}
//
//	// ��ʼ���ؼ�����
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
//			Toast.makeText(getApplicationContext(), "�û����������벻��ȷ", Toast.LENGTH_SHORT).show();
//		}
//
//	}
//
//
//
//}
