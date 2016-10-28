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

public class NewsFragment extends Fragment {

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
////		v.setLayoutParams(params);
////		v.setLayoutParams(params);
////		v.setGravity(Gravity.CENTER);
////		v.setText("ppp" + (position + 1));
////				v.setGravity(R.layout.wodechengji_page_kgg);
//		v.setTag(R.layout.wodechengji_page_kgg);
//		
//
//		fl.addView(v);
//		
//		
//		
//		return fl;
//	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View view = inflater.inflate(R.layout.wodechengji_page, container, false);  
        view.findViewById(R.id.kaoshi).setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
            Intent intent=new Intent(NewsFragment.this.getActivity(),KsActivity.class);
			startActivity(intent);
            }  
        });  
        
        view.findViewById(R.id.zuoye).setOnClickListener(new OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
            Intent intent=new Intent(NewsFragment.this.getActivity(),ZyActivity.class);
			startActivity(intent);
            }  
        });
        
        view.findViewById(R.id.kaoqin).setOnClickListener(new OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
            Intent intent=new Intent(NewsFragment.this.getActivity(),KqActivity.class);
			startActivity(intent);
            }  
        });
        
        view.findViewById(R.id.ketang).setOnClickListener(new OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
            Intent intent=new Intent(NewsFragment.this.getActivity(),KtActivity.class);
			startActivity(intent);
            }  
        });
        
//        view.findViewById(R.id.wkecheng).setOnClickListener(new OnClickListener() {  
//            
//            @Override  
//            public void onClick(View v) {  
//            Intent intent=new Intent(NewsFragment.this.getActivity(),WkechengActivity.class);
//			startActivity(intent);
//            }  
//        });
//        
//        
//        view.findViewById(R.id.wchengji).setOnClickListener(new OnClickListener() {  
//            
//            @Override  
//            public void onClick(View v) {  
//            Intent intent=new Intent(NewsFragment.this.getActivity(),OtherActivity.class);
//			startActivity(intent);
//            }  
//        });
        return view;  
    } 
	
	public View onCreateView1(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View view = inflater.inflate(R.layout.paihangbang_page, container, false);  
        view.findViewById(R.id.RelativeLayout2).setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
//                Toast.makeText(getActivity(), "这个Fragment2哦，要注意了！！", Toast.LENGTH_SHORT).show();  
            }  
        });  
        return view;  
    } 
	
	
	

}