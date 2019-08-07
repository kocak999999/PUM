package com.hudipo.pum_indomaret.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.model.Department;

public class DepartmentAdapter extends BaseAdapter {

    private Context context;
    private Department[] departments;


    public DepartmentAdapter(Context context, Department[] departments) {
        this.context = context;
        this.departments = departments;
    }


    @Override
    public int getCount() {
        return departments.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        /********** Inflate spinner_rows.xml file for each row ( Defined below ) ************/
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.cell_spinner_dep, parent, false);


        TextView tv_dep_spinner = (TextView) row.findViewById(R.id.tv_dep_spinner);
        TextView tv_dep_detail_spinner = (TextView) row.findViewById(R.id.tv_dep_detail_spinner);

        if (position == 0) {

            // Default selected Spinner item
            tv_dep_spinner.setText("");
            tv_dep_detail_spinner.setText("--Select Your Department--");

        } else {
            // Set values for spinner each row
            tv_dep_spinner.setText(departments[position].getName());
            tv_dep_detail_spinner.setText(departments[position].getDescription());

        }

        return row;
    }
}
