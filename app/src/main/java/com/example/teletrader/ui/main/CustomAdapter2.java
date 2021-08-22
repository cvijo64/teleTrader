package com.example.teletrader.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.teletrader.R;

import java.util.List;

public class CustomAdapter2 extends ArrayAdapter<Symbol> implements View.OnClickListener{

    private List<Symbol> dataSet;
    Context mContext;

    @Override
    public void onClick(View view) {

    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtBid;
        TextView txtAsk;
        TextView txtHigh;
        TextView txtLow;
    }

    public CustomAdapter2(List<Symbol> data, Context context) {
        super(context, R.layout.mylist1, data);
        this.dataSet = data;
        this.mContext = context;

    }

    private int lastPosition = -1;

    @SuppressLint("SetTextI18n")
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
            convertView = inflater.inflate(R.layout.mylist1, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtBid = (TextView) convertView.findViewById(R.id.bid);
            viewHolder.txtAsk = (TextView) convertView.findViewById(R.id.ask);
            viewHolder.txtHigh = (TextView) convertView.findViewById(R.id.high);
            viewHolder.txtLow = (TextView) convertView.findViewById(R.id.low);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtHigh.setText(String.valueOf(dataModel.getHigh()));
        viewHolder.txtLow.setText(String.valueOf(dataModel.getLow()));
        if(dataModel.getBid() == -1)
            viewHolder.txtBid.setText("-");
        else
            viewHolder.txtBid.setText(String.valueOf(dataModel.getBid()));
        if(dataModel.getAsk() == -1)
            viewHolder.txtAsk.setText("-");
        else
            viewHolder.txtAsk.setText(String.valueOf(dataModel.getAsk()));
        // Return the completed view to render on screen
        return convertView;
    }
}
