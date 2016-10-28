package com.example.ketang;

import com.example.c_chengji.R;

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
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class NewsFragment2 extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;

	private TextView  te;
	
	public static NewsFragment2 newInstance2(int position) {
		NewsFragment2 f = new NewsFragment2();
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
        View view = inflater.inflate(R.layout.fragment_b, container, false);  
        view.findViewById(R.id.wenti).setOnClickListener(new OnClickListener() {                
            @Override  
            public void onClick(View v) {  
////                Toast.makeText(getActivity(), "这个Fragment2，要注意了！！", Toast.LENGTH_SHORT).show();  
//            	Intent intent=new Intent(NewsFragment2.this.getActivity(),KaoshiActivity.class);
//    			startActivity(intent);
            	  String s="qwqwqwqwqwqwqwqwqwqwqwqwq";
                  te =(TextView)NewsFragment2.this.getActivity().findViewById(R.id.textView31);
                  te.setText(s);
            }  
        });  
      
      
        return view;  
    }

	

	
	
	

}