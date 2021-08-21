package com.example.teletrader.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.teletrader.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Symbol> implements View.OnClickListener{

    private List<Symbol> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtChPer;
        TextView txtLast;
    }

    public CustomAdapter(List<Symbol> data, Context context) {
        super(context, R.layout.mylist2, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

/*        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Data dataModel=(Data)object;

        switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +data.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }*/
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Symbol dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.mylist2, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtChPer = (TextView) convertView.findViewById(R.id.chPer);
            viewHolder.txtLast = (TextView) convertView.findViewById(R.id.last);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtChPer.setText(dataModel.getChangePercent());
        viewHolder.txtLast.setText(dataModel.getLast());
        // Return the completed view to render on screen
        return convertView;
    }
}
