package com.futing.myjetpack.roomdemo02.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.futing.myjetpack.R;
import com.futing.myjetpack.roomdemo02.Student;

import java.util.List;


public class GoodsAdapter extends BaseAdapter {
	
	private LayoutInflater inflater;
	private List<Student> students;

	public GoodsAdapter(Context context, List<Student> students) {
		inflater = LayoutInflater.from(context);
		this.students = students;
	}

	@Override
	public int getCount() {
		return students.size();
	}

	@Override
	public Object getItem(int position) {
		return students.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View view = inflater.inflate(R.layout.item_room2, null);
		Student student = students.get(position);

		TextView tv_like = (TextView) view.findViewById(R.id.tv_id);
		tv_like.setText("number:"+student.getUid());
		
		TextView tv_style = (TextView) view.findViewById(R.id.tv_name);
		tv_style.setText("name:"+student.getName());
		
		return view;
	}

}
