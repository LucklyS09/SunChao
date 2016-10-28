package com.example.kechengbiao;

import java.util.ArrayList;
import java.util.List;

import com.example.c_chengji.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter{
	private LayoutInflater inflater; 
    private List<Picture> pictures; 

    public Adapter(List<String[]> titles, Context context) 
    { 
        super(); 
        pictures = new ArrayList<Picture>(); 
        inflater = LayoutInflater.from(context); 
        for(String[] strs:titles)
        {
        	pictures.add(new Picture(strs[0],strs[1],strs[2],strs[3]));
        }

}
    @Override
    public int getCount() 
    { 
        if (null != pictures) 
        { 
            return pictures.size(); 
        } else
        { 
            return 0; 
        } 
    } 
 
    @Override
    public Object getItem(int position) 
    { 
        return pictures.get(position); 
    } 
 
    @Override
    public long getItemId(int position) 
    { 
        return position; 
    } 
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) 
    { 
        ViewHolder viewHolder; 
        if (convertView == null) 
        { 
            convertView = inflater.inflate(R.layout.aaaaaaaa, null); 
            viewHolder = new ViewHolder(); 
            viewHolder.title = (TextView) convertView.findViewById(R.id.textView2); 
            viewHolder.title2=(TextView)convertView.findViewById(R.id.textView3);
            viewHolder.title3=(TextView)convertView.findViewById(R.id.textView4);
            viewHolder.title4=(TextView)convertView.findViewById(R.id.textView5);
            convertView.setTag(viewHolder); 
        } else
        { 
            viewHolder = (ViewHolder) convertView.getTag(); 
        } 
        viewHolder.title.setText(pictures.get(position).getTitle1()); 
        viewHolder.title2.setText(pictures.get(position).getTitle2()); 
        viewHolder.title3.setText(pictures.get(position).getTitle3()); 
        viewHolder.title4.setText(pictures.get(position).getTitle4()); 
        //viewHolder.image.setImageResource(pictures.get(position).getImageId()); 
        return convertView; 
    } 
 
} 
 
class ViewHolder 
{ 
    public TextView title; 
    public TextView title2;
    public TextView title3;
    public TextView title4;
} 
 
class Picture 
{ 
    private String title1; 
   
    
    private String title2; 
    
    
    private String title3; 
   
    
    private String title4; 
   
    
    
 
   
	public Picture(String title1, String title2, String title3, String title4) {
		super();
		this.title1 = title1;
		this.title2 = title2;
		this.title3 = title3;
		this.title4 = title4;
	}

	public Picture() 
    { 
        super(); 
    }

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	

	public String getTitle3() {
		return title3;
	}

	public void setTitle3(String title3) {
		this.title3 = title3;
	}

	

	public String getTitle4() {
		return title4;
	}

	public void setTitle4(String title4) {
		this.title4 = title4;
	}

	
 
    
}
