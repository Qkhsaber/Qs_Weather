package qkh.saber.data_process;

public class StringList {
	String chengshi;
	String 	ci;
	//String city_code;
	
	
	
	
	public String zhuanhuan(String city_code){	//获取city_code并判断
		if (city_code.equals("CHXX0520"))
			ci=("苏州");
		else if (city_code.equals("CHXX0008"))
			ci=("北京");
		else if (city_code.equals("CHXX0116"))
			ci=("上海");
		else if (city_code.equals("CHXX0037"))
			ci=("广州");
		else if (city_code.equals("CHXX0017"))
			ci=("重庆");
		else if (city_code.equals("CHXX0015"))
			ci=("常州");
		else if (city_code.equals("CHXX4822"))
			ci=("无锡");
		else if (city_code.equals("CHXX0101"))
			ci=("南通");
		else if (city_code.equals("CHXX0097"))
			ci=("南京");
		else{
			ci=("null");				
		}
		
		
		
		
		
						
		//super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_setting_weather);
		//City = weather_city.getText().toString();
		//city_code = new Weather_code_city().getcity(City);
		//Weather_code_city WCC = new Weather_code_city();
		//System.out.println(WCC.getcity(city_code));

		//if (city_code.equals("CHXX0520"))
		//	chengshi =String.valueOf("苏州");
		
		
		
		return ci;
		
		
	}



	
	
	
	

}
