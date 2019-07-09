package com.hudipo.retrofitandroid.adapters;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hudipo.retrofitandroid.R;
import com.hudipo.retrofitandroid.model.Department;

import java.util.List;


public class CustomGridAdapter extends BaseAdapter {
	
	private Context context;
	List<Department> listDepartment;

	//Constructor to initialize values
	public CustomGridAdapter(Context context,List<Department> listDepartment ) {
		this.context = context;
		this.listDepartment = listDepartment;
	}
	
	@Override
	public int getCount() {
		
		// Number of times getView method call depends upon gridValues.length
		return listDepartment.size();
	}

	@Override
	public Object getItem(int position) {
		
		return null;
	}

	@Override
	public long getItemId(int position) {
		
		return 0;
	}
	
	
    // Number of times getView method call depends upon gridValues.length
	
	public View getView(int position, View convertView, ViewGroup parent) {

		//LayoutInflator to call external list_user.xml file
		
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from list_user.xml
			gridView = inflater.inflate(R.layout.recyclerview_department, null);

			// set value into textview
			TextView tv_dept_name = (TextView) gridView
					.findViewById(R.id.tv_dept_name);


			tv_dept_name.setText(listDepartment.get(position).getNAME());

		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}
}
