package qkh.saber.newface;

import java.util.List;
import java.util.Map;

import saber.qkh.newweather.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class New_adapter extends BaseAdapter {

	private Context mContext;
	//xml转View对象
    private LayoutInflater mInflater;
    //单行的布�?
    private int mResource;
    //列表展现的数�?
    private List<Map<String, Object>> mData;
    //Map中的key
    private String[] mFrom;
    
    public New_adapter(Context context, List data,
            int resource, String[] from, int[] to){
    	this.mContext = context;
    	this.mData = data;
    	this.mResource = resource;
    	this.mFrom = from;
        //用于将xml转为View
        this.mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	
    }
    
    @Override
    public int getCount() {
        return mData.size();
    }
    
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position){
      return position;
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
        if(convertView == null){
	           //使用自定义的list_items作为Layout
	           convertView = mInflater.inflate(mResource, parent, false);
	           //减少findView的次�?
			   holder = new ViewHolder();
	           //初始化布�?中的元素
			   holder.itemsIcon = ((ImageView) convertView.findViewById(R.id.itemsIcon));
			   holder.itemsButton = ((TextView) convertView.findViewById(R.id.itemsButton));
			   convertView.setTag(holder);
        }else{
      	   holder = (ViewHolder) convertView.getTag();
        }
      //获取该行的数�?
        holder.itemsIcon.setBackgroundResource((Integer)mData.get(position).get("itemsIcon"));
        holder.itemsButton.setText((String)mData.get(position).get("itemsButton"));
        
        return convertView;
	}
	 /**
		 * View元素
		 */
		static class ViewHolder {
			ImageView itemsIcon;
			TextView itemsButton;
		}

}
