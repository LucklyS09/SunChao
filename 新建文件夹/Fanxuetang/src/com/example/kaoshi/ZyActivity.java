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

public class ZyActivity extends Activity {
	 private ListView listView;     
	    private ZyAdapter myAdapter;   
	    private List<Map<String, Object>> listItems;   

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_zy);
	    
	    listView = (ListView)findViewById(R.id.list);
        listItems = getListItems();   
        myAdapter = new ZyAdapter(this, listItems); //����������   
        listView.setAdapter(myAdapter); 
        
        View view1=findViewById(R.id.fanhui);
        view1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				Intent intent=new Intent(ZyActivity.this,com.example.is.MainActivity2.class);
				startActivity(intent);
			}
        	
        });
    }   
		
	private List<Map<String, Object>> getListItems() {
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();     
            Map<String, Object> map1= new HashMap<String, Object>();    
            map1.put("title", "ʱ�䣺2016-02-03 ����һ");
            map1.put("text", "��ҵ��Ŀ��Android����");
   		    map1.put("info", "�÷֣�80"); 
            listItems.add(map1); 
            
            Map<String, Object> map2= new HashMap<String, Object>();    
            map2.put("title", "ʱ�䣺2016-02-03 ����һ");
            map2.put("text", "��ҵ��Ŀ��Android����");
   		    map2.put("info", "�÷֣�80"); 
            listItems.add(map2);
            
            Map<String, Object> map3= new HashMap<String, Object>();    
            map3.put("title", "ʱ�䣺2016-02-03 ����һ");
            map3.put("text", "��ҵ��Ŀ��Android����");
   		    map3.put("info", "�÷֣�80"); 
            listItems.add(map3);
            
            Map<String, Object> map4= new HashMap<String, Object>();    
            map4.put("title", "ʱ�䣺2016-02-03 ����һ");
            map4.put("text", "��ҵ��Ŀ��Android����");
   		    map4.put("info", "�÷֣�80"); 
            listItems.add(map4);
            
            Map<String, Object> map5= new HashMap<String, Object>();    
            map5.put("title", "ʱ�䣺2016-02-03 ����һ");
            map5.put("text", "��ҵ��Ŀ��Android����");
   		    map5.put("info", "�÷֣�80"); 
            listItems.add(map5);
            
            Map<String, Object> map6= new HashMap<String, Object>();    
            map6.put("title", "ʱ�䣺2016-02-03 ����һ");
            map6.put("text", "��ҵ��Ŀ��Android����");
   		    map6.put("info", "�÷֣�80"); 
            listItems.add(map6);
            
            Map<String, Object> map7= new HashMap<String, Object>();    
            map7.put("title", "ʱ�䣺2016-02-03 ����һ");
            map7.put("text", "��ҵ��Ŀ��Android����");
   		    map7.put("info", "�÷֣�80"); 
            listItems.add(map7);
              
        return listItems; 
	}
	
}