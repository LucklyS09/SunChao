package com.example.kaoshi;

import java.util.List;
import java.util.Map;

import com.example.c_chengji.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
 
public class KsAdapter extends BaseAdapter {   
   private Context context;                        //����������   
   private List<Map<String, Object>> listItems;    //��Ʒ��Ϣ����   
   private LayoutInflater listContainer;           //��ͼ����   
   public final class ListItemView{                //�Զ���ؼ�����      
   public TextView title;     
   public TextView info;   
   
    }
   public  KsAdapter(Context context, List<Map<String, Object>> listItems) {   
       this.context = context;            
       listContainer = LayoutInflater.from(context);   //������ͼ����������������   
       this.listItems = listItems;   
   }   
 
   public int getCount() {   
       // TODO Auto-generated method stub   
       return listItems.size();   
   }   
 
   public Object getItem(int arg0) {   
       // TODO Auto-generated method stub   
       return null;   
   }   
 
   public long getItemId(int arg0) {   
       // TODO Auto-generated method stub   
       return 0;   
   }            
   /**  
    * ListView Item����  
    */  
   public View getView(int position, View convertView, ViewGroup parent) {   
       // TODO Auto-generated method stub   
       Log.e("method", "getView");   
       //�Զ�����ͼ   
       ListItemView  listItemView = null;   
       if (convertView == null) {   
           listItemView = new ListItemView();    
           //��ȡcj�����ļ�����ͼ   
           convertView = listContainer.inflate(R.layout.ks, null);   
           //��ȡ�ؼ�����   
           listItemView.title = (TextView)convertView.findViewById(R.id.text1);   
           listItemView.info = (TextView)convertView.findViewById(R.id.text2);  
           
           //���ÿؼ�����convertView   
           convertView.setTag(listItemView); 
           
       }else {   
           listItemView = (ListItemView)convertView.getTag();   
       }   
       //�������ֺ�ͼƬ   
       listItemView.title.setText((String) listItems.get(position).get("title"));   
       listItemView.info.setText((String) listItems.get(position).get("info")); 
       return convertView;  
       
       
   }   
}  