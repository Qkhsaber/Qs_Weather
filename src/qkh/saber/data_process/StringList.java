package qkh.saber.data_process;

public class StringList {
	String chengshi;
	String 	ci;
	//String city_code;
	
	
	
	
	public String zhuanhuan(String city_code){	//��ȡcity_code���ж�
		if (city_code.equals("CHXX0520"))
			ci=("����");
		else if (city_code.equals("CHXX0008"))
			ci=("����");
		else if (city_code.equals("CHXX0116"))
			ci=("�Ϻ�");
		else if (city_code.equals("CHXX0037"))
			ci=("����");
		else if (city_code.equals("CHXX0017"))
			ci=("����");
		else if (city_code.equals("CHXX0015"))
			ci=("����");
		else if (city_code.equals("CHXX4822"))
			ci=("����");
		else if (city_code.equals("CHXX0101"))
			ci=("��ͨ");
		else if (city_code.equals("CHXX0097"))
			ci=("�Ͼ�");
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
		//	chengshi =String.valueOf("����");
		
		
		
		return ci;
		
		
	}



	
	
	
	

}
