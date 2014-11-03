package qkh.saber.newface;

import qkh.saber.connect.Http_GET;
import qkh.saber.data_process.StringList;
import qkh.saber.data_process.Stringsplit;
import qkh.saber.data_process.Stringwea;
import qkh.saber.http_client.Http_Client;
import saber.qkh.newweather.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ab.activity.AbActivity;
import com.ab.view.slidingmenu.SlidingMenu;
import com.ab.view.titlebar.AbTitleBar;

/**
 * 碎片的容器，主Activity
 *
 *
 */
public class SlidingMenuNestTabActivity extends AbActivity {

	SlidingMenu menu;
	Handler handler;

//	String str_1_temperature = "null";
//	String str_2_temperature = "null";
//	String str_3_temperature = "null";
//	String str_4_temperature = "null";
//	String str_city_name = "null";// 城市名称
//	String str_real_time_temperature = "null";
//	String str_taday_weaher_name = "null";
//	String str_1_weather = "null";
//	String str_2_weather = "null";
//	String str_3_weather = "null";
//	String str_4_weather = "null";
	String str_city_code = "null";// 城市代码
	String str_city_name = "null";// 城市名称

	String str_1_min_temperature = "null";//四天的的最高最低天气
	String str_1_max_temperature = "null";
	String str_2_min_temperature = "null";
	String str_2_max_temperature = "null";
	String str_3_min_temperature = "null";
	String str_3_max_temperature = "null";
	String str_4_min_temperature = "null";
	String str_4_max_temperature = "null";

	String str_1_temperature = "null";//结合的天气
	String str_2_temperature = "null";
	String str_3_temperature = "null";
	String str_4_temperature = "null";

	String str_real_time_temperature = "null";//实时温度

	String str_taday_weather = "null";//当天的天气状况

	String str_1_weather = "null";//后四天的天气状况
	String str_2_weather = "null";
	String str_3_weather = "null";
	String str_4_weather = "null";

	String str_taday_weaher_name = "null";//当天的天气状况（中文）

	String str_visibility = "null";//当天的能见度

	String str_mor_rianprobability = "null";//当天早上的下雨几率
	String str_aft_rianprobability = "null";//当天下午的下雨几率
	String str_mor_humidness = "null";//当天早上的湿度
	String str_aft_humidness = "null";//当天晚上的湿度
	String str_wind_speed = "null";//实时风速
	String str_wind_direction = "null";//实时风向

	String str_sun_up = "null";//当天的日出时间
	String str_sun_set = "null";//当天的日落时间


	static final int SLEEP_TIME = 3 * 1000;

	private static final String PREFS_NAME = "weather_info";

	TextView real_time_temperature;
	TextView taday_weather;
	ImageView img_taday_weather;
	ImageView img_taday_weather1;
	TextView visibility;
	TextView morning;
	TextView afternoon;
	TextView sun_up;
	TextView sun_set;
	TextView direction_speed;
	ImageView img_sun_up;
	ImageView img_sun_set;

	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setAbContentView(R.layout.sliding_menu_content);

		AbTitleBar mAbTitleBar = this.getTitleBar();
		mAbTitleBar.setTitleText("Weather");
		mAbTitleBar.setLogo(R.drawable.button_selector_back);
		mAbTitleBar.setTitleBarBackground(R.drawable.abb);// actionbar样式
		mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
		mAbTitleBar.setLogoLine(R.drawable.line);
		mAbTitleBar.getLogoView().setBackgroundResource(
				R.drawable.button_selector_menu);

		// // 主视图的Fragment添加
		// getSupportFragmentManager().beginTransaction()
		// .replace(R.id.content_frame, new SlidingTabFragment()).commit();

		// SlidingMenu的配�?
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT);

		// slidingmenu的事件模式，如果里面有可以滑动的请用TOUCHMODE_MARGIN
		// 可解决事件冲突问�?
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);

		// menu视图的Fragment添加
		menu.setMenu(R.layout.sliding_menu_menu);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new Fragment1()).commit();
		
		//-----------------------------------------------------------------------------------------------------------
		img_taday_weather=(ImageView)findViewById(R.id.img_taday_weather);
		img_taday_weather1=(ImageView)findViewById(R.id.img_taday_weather1);
		taday_weather =(TextView)findViewById(R.id.taday_weather);
		visibility=(TextView)findViewById(R.id.visibility);
		sun_up=(TextView)findViewById(R.id.sun_up);
		sun_set=(TextView)findViewById(R.id.sun_set);
		direction_speed=(TextView)findViewById(R.id.direction_speed);
		morning=(TextView)findViewById(R.id.morning);
		afternoon=(TextView)findViewById(R.id.afternoon);
		real_time_temperature = (TextView) findViewById(R.id.real_time_temperature);
		img_sun_up=(ImageView)findViewById(R.id.img_sun_up);
		img_sun_set=(ImageView)findViewById(R.id.img_sun_set);

		Typeface fontFace_Thin = Typeface.createFromAsset(getAssets(),//字体的设置
				"fonts/Roboto-Thin.ttf");
		Typeface fontFace_Regular = Typeface.createFromAsset(getAssets(),
				"fonts/Roboto-Regular.ttf");
		Typeface fontFace_Light = Typeface.createFromAsset(getAssets(),
				"fonts/Roboto-Light.ttf");
		real_time_temperature.setTypeface(fontFace_Thin);
		taday_weather.setTypeface(fontFace_Light);
		mAbTitleBar.getLogoView().setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (menu.isMenuShowing()) {
					menu.showContent();
				} else {
					menu.showMenu();
				}
			}
		});
       Button button =(Button)findViewById(R.id.up_data);
       button.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Toast.makeText(SlidingMenuNestTabActivity.this, "还是要点？",Toast.LENGTH_LONG).show();
			real_time_temperature.setText(str_real_time_temperature);

		
			
		}
	});
		
       new Thread() {// 开始联网获取数据
			@Override
			public void run() {
				if (InterneTable()) {
					SharedPreferences sp = getSharedPreferences(PREFS_NAME, 0);// 读取城市信息
					str_city_code = sp.getString("weather_city", "CHXX0116");

					
						String result = new Http_GET()
								.send(Http_Client.gethttpclient(),
										"http://wxdata.weather.com/wxdata/weather/local/"
												+ str_city_code
												+ "?cc=*&unit=m&dayf=8");// 构造地址下载数据
						Log.v("--------------------------------", "获取数据");
						str_city_name = new StringList()
								.zhuanhuan(str_city_code);
						if (str_city_name.equals("null")) {
							str_city_name = new Stringsplit().name(result);
						}// 城市名称处理
						str_1_max_temperature = new Stringsplit().temp1(result)[2];// 后几天的最大最小温度
						str_2_max_temperature = new Stringsplit().temp1(result)[3];
						str_3_max_temperature = new Stringsplit().temp1(result)[4];
						str_4_max_temperature = new Stringsplit().temp1(result)[5];
						str_1_min_temperature = new Stringsplit().temp2(result)[2];// 处理数据进行切割
						str_2_min_temperature = new Stringsplit().temp2(result)[3];
						str_3_min_temperature = new Stringsplit().temp2(result)[4];
						str_4_min_temperature = new Stringsplit().temp2(result)[5];

						str_1_temperature = str_1_max_temperature + "~"// 制作成一整天的温度
								+ str_1_min_temperature + "°C";
						str_2_temperature = str_2_max_temperature + "~"
								+ str_2_min_temperature + "°C";
						str_3_temperature = str_3_max_temperature + "~"
								+ str_3_min_temperature + "°C";
						str_4_temperature = str_4_max_temperature + "~"
								+ str_4_min_temperature + "°C";

						str_real_time_temperature = new Stringsplit()
								.date(result);// 当天的体感温度

						str_visibility = new Stringsplit().see(result)[0];// 能见度
						str_mor_rianprobability = new Stringsplit()
								.rian_1(result)[3];// 一天下雨的概率
						str_aft_rianprobability = new Stringsplit()
								.rian_1(result)[4];

						str_wind_speed = new Stringsplit().wind(result)[4];// 风速
						str_wind_direction = new Stringsplit().win2(result)[9];// 风向
						str_sun_up = new Stringsplit().rich(result)[4];// 日出日落的时间
						str_sun_set = new Stringsplit().ril(result)[4];

						str_mor_humidness = new Stringsplit().rian_2(result)[3];// 一天的空气湿度
						str_aft_humidness = new Stringsplit().rian_2(result)[4];
						str_taday_weather = new Stringsplit().tianqi(result)[0];// 今天的天气
						str_1_weather = new Stringsplit().tianqi(result)[8];
						str_2_weather = new Stringsplit().tianqi(result)[12];
						str_3_weather = new Stringsplit().tianqi(result)[16];
						str_4_weather = new Stringsplit().tianqi(result)[20];

						str_taday_weaher_name = new Stringwea()// 天气转换为中文
								.zhuanhuan(str_taday_weather);

						if (str_taday_weaher_name.equals("null")) {
							str_taday_weaher_name = new Stringsplit()
									.tianqi(result)[0];
						}
					} else {
					
			
					try {
						sleep(SLEEP_TIME);// 如果联网失败会睡眠30s继续联网
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				Message m1 = handler.obtainMessage();
				handler.sendMessage(m1);
			}

		}.start();

		
		 handler = new Handler() {//把数据传输回组件
			@Override
			public void handleMessage(Message msg) {
				if (str_real_time_temperature != "null") {
					real_time_temperature.setText(str_real_time_temperature+"°");
					taday_weather.setText(str_taday_weather);
					visibility.setText("能见度    "+str_visibility+"公里");
					morning.setText("上午  下雨概率"+str_mor_rianprobability+"% "+"空气湿度"+str_mor_humidness+"%");
					afternoon.setText("下午  下雨概率"+str_aft_rianprobability+"% "+"空气湿度"+str_aft_humidness+"%");
					direction_speed.setText(str_wind_direction+"    "+str_wind_speed+"km/s");
					sun_up.setText(str_sun_up);
					sun_set.setText(str_sun_set);
					img_sun_up.setBackgroundResource(R.drawable.wis);
					img_sun_set.setBackgroundResource(R.drawable.wim);
					//开头图片
					if (str_taday_weather.equals("Sunny")|str_taday_weather.equals("Clear")|str_taday_weather.equals("Fair")) {
						img_taday_weather.setImageResource(R.drawable.wi13);
						img_taday_weather1.setImageResource(R.drawable.wi13);
					} else if (str_taday_weather.equals("Partly Cloudy")|str_taday_weather.equals("Mostly Cloudy")) {
						img_taday_weather.setImageResource(R.drawable.wi14);
						img_taday_weather1.setImageResource(R.drawable.wi14);
					} else if (str_taday_weather.equals("Rain")|str_taday_weather.equals("AM Showers")|str_taday_weather.equals("PM Showers")
							|str_taday_weather.equals("Scattered Showers")) {
						img_taday_weather.setImageResource(R.drawable.wi15);
						img_taday_weather1.setImageResource(R.drawable.wi15);
					} else if (str_taday_weather.equals("Cloudy")) {
						img_taday_weather.setImageResource(R.drawable.wi15);
						img_taday_weather1.setImageResource(R.drawable.wi15);
					} else if (str_taday_weather.equals("Showers")|str_taday_weather.equals("Light Rain")) {
						img_taday_weather.setImageResource(R.drawable.wi15);
					img_taday_weather1.setImageResource(R.drawable.wi15);
					}
					else if (str_taday_weather.equals("Fog")|str_taday_weather.equals("Haze")|str_taday_weather.equals("Mist")) {
						img_taday_weather.setImageResource(R.drawable.wi15);
						img_taday_weather1.setImageResource(R.drawable.wi15);
					}
					else if (str_taday_weather.equals("Mostly Sunny")) {
					    img_taday_weather.setImageResource(R.drawable.wi15);
						img_taday_weather1.setImageResource(R.drawable.wi15);
					}
					  else{	
						img_taday_weather.setImageResource(R.drawable.wi12);
						img_taday_weather1.setImageResource(R.drawable.wi12);
		}
					
					
					Toast.makeText(SlidingMenuNestTabActivity.this, "自动出现",Toast.LENGTH_LONG).show();

				}
				else{
					real_time_temperature.setText("死掉了");
				}

			}
		};

	}
	// 判断是否联网
		boolean InterneTable() {
			ConnectivityManager cManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo info = cManager.getActiveNetworkInfo();
			if (info != null && info.isAvailable()) {
				// do something
				// 能联网
				return true;
			} else {
				// do something
				// 不能联网
				return false;
			}
		}

	@Override
	public void onBackPressed() {
		if (menu.isMenuShowing()) {
			menu.showContent();
		} else {
			super.onBackPressed();
		}
	}

}
