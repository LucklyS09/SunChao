package com.example.ketang;


import com.example.c_chengji.R;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public class NewsFragment extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;
   
	private Button bt;
	private RushBuyCountDownTimerView timerView;
	public static NewsFragment newInstance(int position) {
		NewsFragment f = new NewsFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
		
		
	}

//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//
//		FrameLayout fl = new FrameLayout(getActivity());
//		fl.setLayoutParams(params);
//
//		final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
//				.getDisplayMetrics());
//
//		TextView v = new TextView(getActivity());
//		params.setMargins(margin, margin, margin, margin);
//		v.setLayoutParams(params);
//		v.setLayoutParams(params);
//		v.setGravity(Gravity.CENTER);
//		v.setText("PAGE " + (position + 1));
//
//		fl.addView(v);
//		return fl;
//	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View view = inflater.inflate(R.layout.fragment_usermethed, container, false);  
    	this.timerView=(RushBuyCountDownTimerView)view.findViewById(R.id.timerView);
		// 设置时间(hour,min,sec)
		timerView.setTime(01, 40, 00);
		// 开始倒计时
		timerView.start();	

        bt=(Button) view.findViewById(R.id.buttonsha);
		bt.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
			 new AlertDialog.Builder(NewsFragment.this.getActivity()).setMessage("签退成功").show();			
			}			
		});	
      
        return view;  
    } 
	
	
	
}