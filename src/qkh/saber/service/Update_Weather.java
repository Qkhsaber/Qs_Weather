package qkh.saber.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Update_Weather extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {

			Intent send = new Intent(context, Download_Weather_Date.class);
			send.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // 注意，必须添加这个标记，否则启动会失败

			Bundle bd = new Bundle();
			bd.putString("city", "CHXX0116");
			send.putExtra("city", bd);
			context.startService(send);
			Log.v("----------------------", "手机开机啦~");
			Toast.makeText(context, "Open The Phone", Toast.LENGTH_SHORT)
					.show();

			//

		}

	}

}
