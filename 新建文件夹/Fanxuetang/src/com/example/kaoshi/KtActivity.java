package com.example.kaoshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.c_chengji.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class KtActivity extends Activity {
	 private ListView listView;     
	    private KtAdapter myAdapter;   
	    private List<Map<String, Object>> listItems;   

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_kt);
	    
	    listView = (ListView)findViewById(R.id.list);
        listItems = getListItems();   
        myAdapter = new KtAdapter(this, listItems); //创建适配器   
        listView.setAdapter(myAdapter); 
        
        View view1=findViewById(R.id.fanhui);
        view1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(KtActivity.this,com.example.is.MainActivity2.class);
				startActivity(intent);
			}
        	
        });
    }   
		
	private List<Map<String, Object>> getListItems() {
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();     
            Map<String, Object> map1= new HashMap<String, Object>();    
            map1.put("title", "2016-07-20 星期三 第1.2节");
   		    map1.put("info", "回答问题数：3   得分6"); 
            listItems.add(map1); 
            
            Map<String, Object> map2= new HashMap<String, Object>();    
            map2.put("title", "2016-07-21 星期四 第1.2节");
   		    map2.put("info", "回答问题数：3   得分6"); 
            listItems.add(map2);
            
            Map<String, Object> map3= new HashMap<String, Object>();    
            map3.put("title", "2016-07-22 星期五 第1.2节");
   		    map3.put("info", "回答问题数：3   得分6"); 
            listItems.add(map3);
            
            Map<String, Object> map4= new HashMap<String, Object>();    
            map4.put("title", "2016-07-25 星期一 第1.2节");
   		    map4.put("info", "回答问题数：2   得分4"); 
            listItems.add(map4);
            
            Map<String, Object> map5= new HashMap<String, Object>();    
            map5.put("title", "2016-07-26 星期二 第1.2节");
   		    map5.put("info", "回答问题数：3   得分6"); 
            listItems.add(map5);
            
            Map<String, Object> map6= new HashMap<String, Object>();    
            map6.put("title", "2016-07-27 星期三 第1.2节");
   		    map6.put("info", "回答问题数：1   得分2"); 
            listItems.add(map6);
            
            Map<String, Object> map7= new HashMap<String, Object>();    
            map7.put("title", "2016-07-28 星期四 第1.2节");
   		    map7.put("info", "回答问题数：1   得分2"); 
            listItems.add(map7);
              
        return listItems; 
	}
	
}