package qkh.saber.data_process;

public  class Stringwea {
	
	public String zhuanhuan(String t) {
		String tq;
		if(t.equals("Light Rain"))
			tq=("小雨");
		else if(t.equals("Showers"))
			tq=("阵雨");
		else if(t.equals("Few Showers"))
			tq=("短暂阵雨");
		else if(t.equals("Rain"))
			tq=("有雨");
		else if(t.equals("AM Showers"))
			tq=("上午有雨");
		else if(t.equals("PM Showers"))
			tq=("下午有雨");
		else if(t.equals("Showers Late"))
			tq=("晚间有雨");
		else if(t.equals("Showers Early"))
			tq=("早间有雨");
		else if(t.equals("Scattered Showers"))
			tq=("零星阵雨时有风");
		else if(t.equals("Partly Cloudy"))
			tq=("局部多云");
		else if(t.equals("Cloudy")|t.equals("Cloudy Early")|t.equals("Mostly Cloudy")|t.equals("Cloudy Late"))
			tq=("多云");
		else if(t.equals("Sunny")|t.equals("Clear")|t.equals("Fair")|t.equals("PM Sun")|t.equals("AM Sun")
				|t.equals("Clearing Late")|t.equals("Clearing Early"))
			tq=("晴");
		else if(t.equals("Mostly Sunny"))
			tq=("晴时多云");
		else if(t.equals("Clouds")|t.equals("Clouds Early")|t.equals("AM Clouds")|t.equals("PM Clouds")|t.equals("Clouds Late"))
			tq=("阴");
		else if(t.equals("Fog"))
			tq=("雾霾");
		else if(t.equals("Mist"))
			tq=("有雾");
		else if(t.equals("Haze"))
			tq=("薄雾");
		else tq=("null");
		return tq;
		
	}

}
