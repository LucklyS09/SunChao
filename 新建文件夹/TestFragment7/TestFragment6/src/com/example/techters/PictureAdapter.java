package com.example.techters;

import java.util.ArrayList;
import java.util.List;

import com.example.testbase.fragment3.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * 学生出勤 加载头像的adapter
 * 
 */

public class PictureAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private List<Picture_stu> pictures;

	public PictureAdapter(String[] titles, int[] images, Context context) {
		super();
		pictures = new ArrayList<Picture_stu>();
		inflater = LayoutInflater.from(context);
		for (int i = 0; i < images.length; i++) {
			Picture_stu picture = new Picture_stu(titles[i], images[i]);
			pictures.add(picture);
		}
	}

	@Override
	public int getCount() {
		if (null != pictures) {
			return pictures.size();
		} else {
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		return pictures.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder_stu viewHolder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.picture_item, null);
			viewHolder = new ViewHolder_stu();
			viewHolder.title = (TextView) convertView.findViewById(R.id.title);
			viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder_stu) convertView.getTag();
		}
		viewHolder.title.setText(pictures.get(position).getTitle());
		viewHolder.image.setImageResource(pictures.get(position).getImageId());
		return convertView;
	}

}
