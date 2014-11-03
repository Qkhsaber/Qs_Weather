package qkh.saber.newface;

import saber.qkh.newweather.R;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

public class Login extends Activity {
	private static final long SPLASH_DELAY_MILLIS = 1*1000;
    String str_real_time_temperature="null";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo);
        Typeface fontFace = Typeface.createFromAsset(getAssets(),
				"fonts/STHUPO.TTF");
		TextView text = (TextView) findViewById(R.id.asd);
		text.setTypeface(fontFace);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
			//goService();
		}
	}, 10);

		new Handler().postDelayed(new Runnable() {
			

			@Override
			public void run() {
				
					goHome();
				
				
				
			}
		}, SPLASH_DELAY_MILLIS);
    }

    private void goHome() {
    	
		
		Intent intent = new Intent(Login.this, SlidingMenuNestTabActivity.class);
		Login.this.startActivity(intent);
		Login.this.finish();
	}
    private void goService() {
    	Intent intent1 = new Intent("START_DATA_SERVICE");
		startService(intent1);//运行服务
		Log.v("--------------------------------", "启动服务");
    	
    }
}
