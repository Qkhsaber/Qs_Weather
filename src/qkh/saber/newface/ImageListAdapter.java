package qkh.saber.newface;

import java.util.List;
import java.util.Map;

import saber.qkh.newweather.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ab.bitmap.AbImageDownloader;
import com.ab.global.AbConstant;
/**
 * 碎片中的图片列表适配�?
 * 
 *			
 *		
 */
public class ImageListAdapter extends BaseAdapter{
	
  
	private Context mContext;
	//xml转View对象
    private LayoutInflater mInflater;
    //单行的布�?
    private int mResource;
    //列表展现的数�?
    private List mData;
    //Map中的key
    private String[] mFrom;
    //view的id
    private int[] mTo;
    //图片下载�?
    private AbImageDownloader mAbImageDownloader = null;
    
   /**
    * 构�?�方�?
    * @param context
    * @param data 列表展现的数�?
    * @param resource 单行的布�?
    * @param from Map中的key
    * @param to view的id
    */
    public ImageListAdapter(Context context, List data,
            int resource, String[] from, int[] to){
    	this.mContext = context;
    	this.mData = data;
    	//this.mResource = resource;
    	this.mFrom = from;
    	this.mTo = to;
        //用于将xml转为View
        this.mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //图片下载�?
        mAbImageDownloader = new AbImageDownloader(mContext);
        mAbImageDownloader.setWidth(100);
        mAbImageDownloader.setHeight(100);
        mAbImageDownloader.setType(AbConstant.SCALEIMG);
        mAbImageDownloader.setLoadingImage(R.drawable.image_loading);
        mAbImageDownloader.setErrorImage(R.drawable.image_error);
        mAbImageDownloader.setNoImage(R.drawable.image_no);
        //mAbImageDownloader.setAnimation(true);
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
    public View getView(int position, View convertView, ViewGroup parent){
    	  final ViewHolder holder;
          if(convertView == null){
	           //使用自定义的list_items作为Layout
	           convertView = mInflater.inflate(mResource, parent, false);
	           //减少findView的次�?
			   holder = new ViewHolder();
	           //初始化布�?中的元素
//			   holder.itemsIcon = ((ImageView) convertView.findViewById(mTo[0]));
			   holder.itemsTitle = ((TextView) convertView.findViewById(mTo[1]));
			   holder.itemsText = ((TextView) convertView.findViewById(mTo[2]));
			   convertView.setTag(holder);
          }else{
        	   holder = (ViewHolder) convertView.getTag();
          }
          
		  //获取该行的数�?
          final Map<String, Object>  obj = (Map<String, Object>)mData.get(position);
          String imageUrl = (String)obj.get("itemsIcon");
          holder.itemsTitle.setText((String)obj.get("itemsTitle"));
          holder.itemsText.setText((String)obj.get("itemsText"));
          //设置加载中的View
          mAbImageDownloader.setLoadingView(convertView.findViewById(R.id.progressBar));
          //图片的下�?
          mAbImageDownloader.display(holder.itemsIcon,imageUrl);
          
          return convertView;
    }
    
    /**
	 * View元素
	 */
	static class ViewHolder {
		ImageView itemsIcon;
		TextView itemsTitle;
		TextView itemsText;
		ImageButton itemsBtn;
	}
    
}
