package com.example.is;

import com.example.c_chengji.R;
import com.example.c_chengji.R.layout;
import com.example.kaoshi.KqActivity;
import com.example.kaoshi.KsActivity;
import com.example.kaoshi.KtActivity;
import com.example.kaoshi.ZyActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class ZuoyeFanhui extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;

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

	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View view = inflater.inflate(R.layout.activity_zy, container, false);  
        view.findViewById(R.id.fanhui).setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
            Intent intent=new Intent(ZuoyeFanhui.this.getActivity(),FanhuiActivity.class);
			startActivity(intent);
            }  
        });  

        return view;  
    } 
	
	
	

}