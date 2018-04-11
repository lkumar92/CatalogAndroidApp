package lkum.com.catalogapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by lalkumar1 on 06-Mar-18.
 */

public class CategoryListAdapter extends BaseAdapter {

    Context context;
    List<Category> categoryList;

    public CategoryListAdapter(Context context, List<Category> categoryList){
        //super(context, R.layout.single_category, categoryList);
        this.context = context;
        this.categoryList = categoryList;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.single_category, viewGroup,false);
        TextView textView = (TextView)  rowView.findViewById(R.id.label);
        //ImageView icon = (ImageView) view.findViewById(R.id.icon);
        textView.setText(categoryList.get(position).getName());
        //icon.setImageResource(flags[i]);
        return rowView;
    }

    @Override
    public int getCount() {

        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {

        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }


}
