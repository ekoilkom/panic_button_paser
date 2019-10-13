package id.ac.politanisamarinda.panicbutton.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import id.ac.politanisamarinda.panicbutton.Model.Incident;

public class WidgetIncidentAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<Incident> data;

    public WidgetIncidentAdapter(Context mContext,List<Incident> data) {
        this.mContext = mContext;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
