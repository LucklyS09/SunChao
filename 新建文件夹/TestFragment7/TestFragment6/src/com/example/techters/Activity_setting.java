package com.example.techters;



import java.io.File;
import java.io.FileOutputStream;

import com.example.testbase.fragment3.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/*��ʦ������
 * 
 */

public class Activity_setting extends Activity implements OnClickListener {
	/* ��� */
	private LinearLayout switchAvatar,switchAvatar1;
	private ImageView faceImage,back;
	private TextView resultText;
	private Button btnClose;
	private String[] items = new String[] { "ѡ�񱾵�ͼƬ", "����" };
	/* ͷ������ */
	private static final String IMAGE_FILE_NAME = "faceImage.jpg";

	/* ������ */
	private static final int IMAGE_REQUEST_CODE = 0;
	private static final int CAMERA_REQUEST_CODE = 1;
	private static final int RESULT_REQUEST_CODE = 2;
	
	LinearLayout linearLayout=null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // ȥ������
		setContentView(R.layout.activity_setting);
		switchAvatar = (LinearLayout) findViewById(R.id.LinearLayout2);
		switchAvatar1 = (LinearLayout) findViewById(R.id.LinearLayout5);
		faceImage = (ImageView) findViewById(R.id.face);
		back = (ImageView) findViewById(R.id.back);
		//��ť
		btnClose=(Button) findViewById(R.id.button1);
		btnClose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				SharedPreferences sp= getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE); 
				sp.edit().putBoolean("AUTO_ISCHECK", false).commit(); 
				Intent intent = new Intent(Activity_setting.this,DLActivity.class);  
				Activity_setting.this.startActivity(intent);
				Activity_setting.this.finish();
			}
		});
		// �����¼�����
		back.setOnClickListener(backlistener);
		switchAvatar.setOnClickListener(listener);
		switchAvatar1.setOnClickListener(listener1);
		final TextView  resultText1 = (TextView) findViewById(R.id.textView13);
		LinearLayout showDialogBtn = (LinearLayout) findViewById(R.id.LinearLayout3);
		showDialogBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				MyCustomDialog dialog = new MyCustomDialog(Activity_setting.this, "�������ַ",
						new MyCustomDialog.OnCustomDialogListener() {

							@Override
							public void back(String name) {
								resultText1.setText(name);

							}
						});
				dialog.show();
			}
		});
		
		final TextView resultText2 = (TextView) findViewById(R.id.textView14);
		LinearLayout showDialogB = (LinearLayout) findViewById(R.id.LinearLayout4);
		showDialogB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				MyCustomDialog dialog = new MyCustomDialog(Activity_setting.this, "��	����绰",
						new MyCustomDialog.OnCustomDialogListener() {

							@Override
							public void back(String name) {
								resultText2.setText(name);

							}
						});
				dialog.show();
			}
		});
		
	}

	private View.OnClickListener listener1 = new View.OnClickListener() {

		public void onClick(View v) {
			Intent intent = new Intent(Activity_setting.this, MimaActivity.class); 
            startActivity(intent);
			
		}
	};
	private View.OnClickListener listener = new View.OnClickListener() {

		public void onClick(View v) {
			
			showDialog();
			
		}
	};
	private View.OnClickListener backlistener = new View.OnClickListener() {

		public void onClick(View v) {
			
			Activity_setting.this.finish();
			
		}
	};
	


	
	/**
	 * ��ʾѡ��Ի���
	 */
	private void showDialog() {
		
		

		new AlertDialog.Builder(this)
				.setTitle("����ͷ��")
				.setItems(items, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
						case 0:
							Intent intentFromGallery = new Intent();
							intentFromGallery.setType("image/*"); // �����ļ�����
							intentFromGallery
									.setAction(Intent.ACTION_GET_CONTENT);
							startActivityForResult(intentFromGallery,
									IMAGE_REQUEST_CODE);
							break;
						case 1:

							Intent intentFromCapture = new Intent(
									MediaStore.ACTION_IMAGE_CAPTURE);
							// �жϴ洢���Ƿ�����ã����ý��д洢
							if (Tools.hasSdcard()) {

								intentFromCapture.putExtra(
										MediaStore.EXTRA_OUTPUT,
										Uri.fromFile(new File(Environment
												.getExternalStorageDirectory(),
												IMAGE_FILE_NAME)));
							}

							startActivityForResult(intentFromCapture,
									CAMERA_REQUEST_CODE);
							break;
						}
					}
				})
				.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				}).show();
		  

	}


		

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// ����벻����ȡ��ʱ��
		if (resultCode != RESULT_CANCELED) {

			switch (requestCode) {
			case IMAGE_REQUEST_CODE:
				startPhotoZoom(data.getData());
				break;
			case CAMERA_REQUEST_CODE:
				if (Tools.hasSdcard()) {
					File tempFile = new File(
							Environment.getExternalStorageDirectory()
									+ IMAGE_FILE_NAME);
					startPhotoZoom(Uri.fromFile(tempFile));
				} else {
					Toast.makeText(Activity_setting.this, "δ�ҵ��洢�����޷��洢��Ƭ��",
							Toast.LENGTH_LONG).show();
				}

				break;
			case RESULT_REQUEST_CODE:
				if (data != null) {
					getImageToView(data);
				}
				break;
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * �ü�ͼƬ����ʵ��
	 * 
	 * @param uri
	 */
	public void startPhotoZoom(Uri uri) {

		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// ���òü�
		intent.putExtra("crop", "true");
		// aspectX aspectY �ǿ�ߵı���
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX outputY �ǲü�ͼƬ���
		intent.putExtra("outputX", 320);
		intent.putExtra("outputY", 320);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, 2);
	}

	/**
	 * ����ü�֮���ͼƬ����
	 * 
	 * @param picdata
	 */
	private void getImageToView(Intent data) {
		Bundle extras = data.getExtras();
		if (extras != null) {
			Bitmap photo = extras.getParcelable("data");
			Drawable drawable = new BitmapDrawable(photo);
			faceImage.setImageDrawable(drawable);
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		
	}

	
	

}
