package qkh.saber.newface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qkh.saber.weather_setting.Setting_weather;
import saber.qkh.newweather.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.ab.task.AbTaskItem;
import com.ab.task.AbTaskListener;
import com.ab.task.AbTaskQueue;
import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;

/**
 * Activity中嵌入的碎片
 * 
 * 
 * 
 */
public class Fragment1 extends Fragment {
	String str_city_code = "null";// 城市代码
	String str_city_name = "null";// 城市名称

	String str_1_min_temperature = "null";// 四天的的最高最低天气
	String str_1_max_temperature = "null";
	String str_2_min_temperature = "null";
	String str_2_max_temperature = "null";
	String str_3_min_temperature = "null";
	String str_3_max_temperature = "null";
	String str_4_min_temperature = "null";
	String str_4_max_temperature = "null";

	String str_1_temperature = "null";// 结合的天气
	String str_2_temperature = "null";
	String str_3_temperature = "null";
	String str_4_temperature = "null";

	String str_real_time_temperature = "null";// 实时温度

	String str_taday_weather = "null";// 当天的天气状况

	String str_1_weather = "null";// 后四天的天气状况
	String str_2_weather = "null";
	String str_3_weather = "null";
	String str_4_weather = "null";

	String str_taday_weather_name = "null";// 当天的天气状况（中文）

	String str_visibility = "null";// 当天的能见度

	String str_mor_rianprobability = "null";// 当天早上的下雨几率
	String str_aft_rianprobability = "null";// 当天下午的下雨几率
	String str_mor_humidness = "null";// 当天早上的湿度
	String str_aft_humidness = "null";// 当天晚上的湿度
	String str_wind_speed = "null";// 实时风速
	String str_wind_direction = "null";// 实时风向

	String str_sun_up = "null";// 当天的日出时间
	String str_sun_set = "null";// 当天的日落时间
	String str_uptada_time = "null";// 更新天氣時間

	static final int SLEEP_TIME = 3 * 1000;

	private static final String PREFS_NAME = "weather_info";

	private Activity mActivity = null;
	private List<Map<String, Object>> list = null;
	private List<Map<String, Object>> newList = null;
	private AbPullListView mAbPullListView = null;
	private int currentPage = 1;
	private AbTaskQueue mAbTaskQueue = null;
	private ArrayList<String> mPhotoList = new ArrayList<String>();
	private New_adapter myListViewAdapter = null;
	private int total = 50;
	private int pageSize = 6;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mActivity = this.getActivity();

		View view = inflater.inflate(R.layout.pull_list, null);// 增加侧滑�?
		mAbTaskQueue = AbTaskQueue.getInstance();
		// 获取ListView对象
		mAbPullListView = (AbPullListView) view.findViewById(R.id.mListView);
		// 设置进度条的样式
		mAbPullListView.getHeaderView().setHeaderProgressBarDrawable(
				this.getResources().getDrawable(R.drawable.progress_circular));
		// ListView数据
		list = new ArrayList<Map<String, Object>>();

		// 使用自定义的Adapter
		// 注释掉会导致崩溃
		myListViewAdapter = new New_adapter(mActivity, list,
				R.layout.list_items, new String[] { "itemsIcon","itemsButton" },
				new int[] {R.id.itemsIcon, R.id.itemsButton });
		mAbPullListView.setAdapter(myListViewAdapter);
		// item被点击事�?
		mAbPullListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// 增加天气选择
				if(id==0){
				Intent intent = new Intent(mActivity,Setting_weather.class);
				startActivity(intent);
				}else{
					
				}

			}
		});

		return view;
	}

	
	
	@Override
	public void onStart() {
		super.onStart();
		
		// 定义两种查询的事�?
		final AbTaskItem item1 = new AbTaskItem();
		item1.listener = new AbTaskListener() {

			@Override
			public void update() {
				list.clear();// 清空列表
				if (newList != null && newList.size() > 0) {
					list.addAll(newList);
					myListViewAdapter.notifyDataSetChanged();
					newList.clear();
				}
				mAbPullListView.stopRefresh();
			}

			// 增加列表
			@Override
			public void get() {
				try {
					Thread.sleep(1000);
					currentPage = 1;
					newList = new ArrayList<Map<String, Object>>();
					Map<String, Object> map = null;

					
						map = new HashMap<String, Object>();
						map.put("itemsIcon", R.drawable.ic_launcher);
						map.put("itemsButton", "增加天气" );
						newList.add(map);
					
				} catch (Exception e) {
				}
			};
		};

		final AbTaskItem item2 = new AbTaskItem();
		item2.listener = new AbTaskListener() {

			@Override
			public void update() {
				if (newList != null && newList.size() > 0) {
					list.addAll(newList);
					myListViewAdapter.notifyDataSetChanged();
					newList.clear();
				}
				mAbPullListView.stopLoadMore();
				//list.clear();// 清空列表
			}

			//
			@Override
			public void get() {
				try {
					currentPage++;
					Thread.sleep(1000);
					newList = new ArrayList<Map<String, Object>>();
					Map<String, Object> map = null;

					for (int i = 0; i < pageSize; i++) {
						map = new HashMap<String, Object>();
						map.put("itemsIcon", R.drawable.ic_launcher);
						map.put("itemsButton", "苏州" + (i + 1));
						if ((list.size() + newList.size()) < total) {
							newList.add(map);
						}
					}
				} catch (Exception e) {
					currentPage--;
					newList.clear();
				}
			};
		};

		mAbPullListView.setAbOnListViewListener(new AbOnListViewListener() {

			@Override
			public void onRefresh() {
				mAbTaskQueue.execute(item1);
			}

			@Override
			public void onLoadMore() {
				mAbTaskQueue.execute(item2);
			}

		});

		// 第一次下载数�?
		mAbTaskQueue.execute(item1);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

}
