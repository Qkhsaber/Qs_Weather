package qkh.saber.service;

import qkh.saber.connect.Http_GET;
import qkh.saber.http_client.Http_Client;
import qkh.saber.data_process.StringList;
import qkh.saber.data_process.Stringsplit;
import qkh.saber.data_process.Stringwea;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class Download_Weather_Date extends Service {
	String str_city_code = "null";// ���д���
	String str_city_name = "null";// ��������

	String str_1_min_temperature = "null";
	String str_1_max_temperature = "null";
	String str_2_min_temperature = "null";
	String str_2_max_temperature = "null";
	String str_3_min_temperature = "null";
	String str_3_max_temperature = "null";
	String str_4_min_temperature = "null";
	String str_4_max_temperature = "null";

	String str_1_temperature = "null";
	String str_2_temperature = "null";
	String str_3_temperature = "null";
	String str_4_temperature = "null";

	String str_real_time_temperature = "null";

	String str_taday_weather = "null";

	String str_1_weather = "null";
	String str_2_weather = "null";
	String str_3_weather = "null";
	String str_4_weather = "null";

	String str_taday_weaher_name = "null";

	String str_visibility = "null";

	String str_mor_rianprobability = "null";
	String str_aft_rianprobability = "null";
	String str_mor_humidness = "null";
	String str_aft_humidness = "null";
	String str_wind_speed = "null";
	String str_wind_direction = "null";

	String str_sun_up = "null";
	String str_sun_set = "null";

	int CLOSE_NUM = 0;

	static final int SLEEP_TIME = 3 * 1000;

	private static final String PREFS_NAME = "weather_info";



	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		new Thread() {// ��ʼ������ȡ����
			@Override
			public void run() {
				if (InterneTable()) {
					SharedPreferences sp = getSharedPreferences(PREFS_NAME, 0);// ��ȡ������Ϣ
					str_city_code = sp.getString("weather_city", "CHXX0116");

					if (str_real_time_temperature == "null") {
						String result = new Http_GET()
								.send(Http_Client.gethttpclient(),
										"http://wxdata.weather.com/wxdata/weather/local/"
												+ str_city_code
												+ "?cc=*&unit=m&dayf=8");// �����ַ��������
						Log.v("--------------------------------", "��ȡ����");
						str_city_name = new StringList()
								.zhuanhuan(str_city_code);
						if (str_city_name.equals("null")) {
							str_city_name = new Stringsplit().name(result);
						}// �������ƴ���
						str_1_max_temperature = new Stringsplit().temp1(result)[2];// ����������С�¶�
						str_2_max_temperature = new Stringsplit().temp1(result)[3];
						str_3_max_temperature = new Stringsplit().temp1(result)[4];
						str_4_max_temperature = new Stringsplit().temp1(result)[5];
						str_1_min_temperature = new Stringsplit().temp2(result)[2];// �������ݽ����и�
						str_2_min_temperature = new Stringsplit().temp2(result)[3];
						str_3_min_temperature = new Stringsplit().temp2(result)[4];
						str_4_min_temperature = new Stringsplit().temp2(result)[5];

						str_1_temperature = str_1_max_temperature + "~"// ������һ������¶�
								+ str_1_min_temperature + "��C";
						str_2_temperature = str_2_max_temperature + "~"
								+ str_2_min_temperature + "��C";
						str_3_temperature = str_3_max_temperature + "~"
								+ str_3_min_temperature + "��C";
						str_4_temperature = str_4_max_temperature + "~"
								+ str_4_min_temperature + "��C";

						str_real_time_temperature = new Stringsplit()
								.date(result);// ���������¶�

						str_visibility = new Stringsplit().see(result)[0];// �ܼ���
						str_mor_rianprobability = new Stringsplit()
								.rian_1(result)[3];// һ������ĸ���
						str_aft_rianprobability = new Stringsplit()
								.rian_1(result)[4];

						str_wind_speed = new Stringsplit().wind(result)[4];// ����
						str_wind_direction = new Stringsplit().win2(result)[9];// ����
						str_sun_up = new Stringsplit().rich(result)[4];// �ճ������ʱ��
						str_sun_set = new Stringsplit().ril(result)[4];

						str_mor_humidness = new Stringsplit().rian_2(result)[3];// һ��Ŀ���ʪ��
						str_aft_humidness = new Stringsplit().rian_2(result)[4];
						str_taday_weather = new Stringsplit().tianqi(result)[0];// ���������
						str_1_weather = new Stringsplit().tianqi(result)[8];
						str_2_weather = new Stringsplit().tianqi(result)[12];
						str_3_weather = new Stringsplit().tianqi(result)[16];
						str_4_weather = new Stringsplit().tianqi(result)[20];

						str_taday_weaher_name = new Stringwea()// ����ת��Ϊ����
								.zhuanhuan(str_taday_weather);

						if (str_taday_weaher_name.equals("null")) {
							str_taday_weaher_name = new Stringsplit()
									.tianqi(result)[0];
						}

						// ------------------------------------------------------------if

						Intent intent = new Intent();
						Bundle bd = new Bundle();

						bd.putString("city_name", str_city_name);// �����Ƿ��b����
						bd.putString("temperature1", str_1_temperature);
						bd.putString("temperature2", str_2_temperature);
						bd.putString("temperature3", str_3_temperature);
						bd.putString("temperature4", str_4_temperature);
						bd.putString("real_time_temperature",
								str_real_time_temperature);
						bd.putString("taday_weather", str_taday_weaher_name);
						bd.putString("weather1", str_1_weather);
						bd.putString("weather2", str_2_weather);
						bd.putString("weather3", str_3_weather);
						bd.putString("weather4", str_4_weather);
						// bd.putString("visibility", str_visibility);
						// bd.putString("wind_speed",str_wind_speed );
						// bd.putString("wind_direction",str_wind_direction );
						// bd.putString("sun_up",str_sun_up );
						// bd.putString("sun_set", str_sun_set);
						// bd.putString("mor_humidness",str_mor_humidness );
						// bd.putString("aft_humidness",str_aft_humidness );
						// bd.putString("mor_rianprobability",
						// str_mor_rianprobability);
						// bd.putString("aft_rianprobability",
						// str_aft_rianprobability);
						intent.putExtra("weather", bd);
						//intent.setAction("CAN_YOU");
						sendBroadcast(intent);
						

						Log.v("--------------------------------",
								str_real_time_temperature);
					} else {

						Intent intent = new Intent();
						Bundle bd = new Bundle();

						bd.putString("city_name", str_city_name);// �����Ƿ��b����
						bd.putString("temperature1", str_1_temperature);
						bd.putString("temperature2", str_2_temperature);
						bd.putString("temperature3", str_3_temperature);
						bd.putString("temperature4", str_4_temperature);
						bd.putString("real_time_temperature",
								str_real_time_temperature);
						bd.putString("taday_weather", str_taday_weaher_name);
						bd.putString("weather1", str_1_weather);
						bd.putString("weather2", str_2_weather);
						bd.putString("weather3", str_3_weather);
						bd.putString("weather4", str_4_weather);
						// bd.putString("visibility", str_visibility);
						// bd.putString("wind_speed",str_wind_speed );
						// bd.putString("wind_direction",str_wind_direction );
						// bd.putString("sun_up",str_sun_up );
						// bd.putString("sun_set", str_sun_set);
						// bd.putString("mor_humidness",str_mor_humidness );
						// bd.putString("aft_humidness",str_aft_humidness );
						// bd.putString("mor_rianprobability",
						// str_mor_rianprobability);
						// bd.putString("aft_rianprobability",
						// str_aft_rianprobability);
						intent.putExtra("i", bd);

						Log.v("--------------------------------",
								str_real_time_temperature);

					}
				} else {
					try {
						sleep(SLEEP_TIME);// �������ʧ�ܻ�˯��30s��������
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}

		}.start();

		// stopSelf();
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		// if (CLOSE_NUM == 1) {//����Ѿ�������ݷ�װ��kill��
		super.onDestroy();
		// this.stopSelfResult(CLOSE_NUM);
		// }
	}

	// �ж��Ƿ�����
	boolean InterneTable() {
		ConnectivityManager cManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cManager.getActiveNetworkInfo();
		if (info != null && info.isAvailable()) {
			// do something
			// ������
			return true;
		} else {
			// do something
			// ��������
			return false;
		}
	}

}
