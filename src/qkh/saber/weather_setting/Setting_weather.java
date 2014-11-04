package qkh.saber.weather_setting;


import qkh.saber.data_process.Weather_code_city;
import saber.qkh.newweather.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Setting_weather extends Activity {
	EditText weather_city;
	Button search_city;
	private static final String PREFS_NAME = "weather_info";
	String city;
	String city_code;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding_weather_setting1);

		search_city = (Button) findViewById(R.id.search_button_city);
		weather_city = (EditText) findViewById(R.id.search_edittext_city);

		search_city.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				city = weather_city.getText().toString();
				city_code = new Weather_code_city().getcity(city);
				if (city_code.equals("null")) {
					Toast.makeText(Setting_weather.this, "系统暂时未收录此坐标，建议输入城市名称",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(Setting_weather.this, "城市设置成功",
							Toast.LENGTH_SHORT).show();
					SaveUserDate();
				}

			}
		});
	}

	private void SaveUserDate() {
		// 载入配置文件
		SharedPreferences sp = getSharedPreferences(PREFS_NAME, 0);
		// 写入配置文件
		Editor spEd = sp.edit();
		spEd.putBoolean("isSave", true);
		spEd.putString("weather_city", city_code);

		spEd.commit();
	}

}
