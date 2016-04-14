package com.example.linkman;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by lenovo on 2015/10/26.
 */
public class Adapter extends BaseAdapter  {
    DatabaseLinkman linkman;
    ArrayList<Man> arrayList;
    Context context;
   

    public Adapter(Context context) {
        this.context = context;
        linkman = new DatabaseLinkman(this.context, "linkman", null, 1);
        arrayList = linkman.View(linkman.getWritableDatabase());
    }
    public  Adapter(Context context,String sql){
    	 this.context = context;
         linkman = new DatabaseLinkman(this.context, "linkman", null, 1);
         arrayList = linkman.funView(linkman.getWritableDatabase(),sql);
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        
        ViewHolder holder = null;
        Man man = arrayList.get(position);
        holder = new ViewHolder();
        convertView = LayoutInflater.from(context).inflate(
                R.layout.linkman_listview_item, null);
        holder.name = (TextView) convertView.findViewById(R.id.name);
        holder.name.setText(man.getName());
        holder.number = (TextView) convertView
                .findViewById(R.id.telephone);
        holder.number.setText(man.getNumber());
        holder.photo = (ImageView) convertView
                .findViewById(R.id.header);
        holder.photo.setImageResource(R.drawable.ic_launcher);
        convertView.setTag(holder);
        return convertView;

    }
    
    
    
    
    
    /*@Override
    public Filter getFilter() {
        if(filters==null)
        filters=new Filters();
        return filters;
    }
    class Filters extends Filter {


    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        ArrayList<Man> newValues = new ArrayList<Man>();
        String filterString = constraint.toString().trim()
                .toLowerCase();

        // 濡傛灉鎼滅储妗嗗唴瀹逛负绌猴紝灏辨仮澶嶅師濮嬫暟鎹�
        if (TextUtils.isEmpty(filterString)) {
            newValues = arrayList;
        } else {
            // 杩囨护鍑烘柊鏁版嵁
            for (Man str : arrayList) {
                if (str != null) {
                    newValues.add(str);
                }
            }
        }

        results.values = newValues;
        results.count = newValues.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        arrayList = (ArrayList<Man>) results.values;

        if (results.count > 0) {
            notifyDataSetChanged();  // 閫氱煡鏁版嵁鍙戠敓浜嗘敼鍙�
        } else {
            notifyDataSetInvalidated(); // 閫氱煡鏁版嵁澶辨晥
        }
    }

}*/

}
