package qkh.saber.data_process;

public  class Stringwea {
	
	public String zhuanhuan(String t) {
		String tq;
		if(t.equals("Light Rain"))
			tq=("С��");
		else if(t.equals("Showers"))
			tq=("����");
		else if(t.equals("Few Showers"))
			tq=("��������");
		else if(t.equals("Rain"))
			tq=("����");
		else if(t.equals("AM Showers"))
			tq=("��������");
		else if(t.equals("PM Showers"))
			tq=("��������");
		else if(t.equals("Showers Late"))
			tq=("�������");
		else if(t.equals("Showers Early"))
			tq=("�������");
		else if(t.equals("Scattered Showers"))
			tq=("��������ʱ�з�");
		else if(t.equals("Partly Cloudy"))
			tq=("�ֲ�����");
		else if(t.equals("Cloudy")|t.equals("Cloudy Early")|t.equals("Mostly Cloudy")|t.equals("Cloudy Late"))
			tq=("����");
		else if(t.equals("Sunny")|t.equals("Clear")|t.equals("Fair")|t.equals("PM Sun")|t.equals("AM Sun")
				|t.equals("Clearing Late")|t.equals("Clearing Early"))
			tq=("��");
		else if(t.equals("Mostly Sunny"))
			tq=("��ʱ����");
		else if(t.equals("Clouds")|t.equals("Clouds Early")|t.equals("AM Clouds")|t.equals("PM Clouds")|t.equals("Clouds Late"))
			tq=("��");
		else if(t.equals("Fog"))
			tq=("����");
		else if(t.equals("Mist"))
			tq=("����");
		else if(t.equals("Haze"))
			tq=("����");
		else tq=("null");
		return tq;
		
	}

}
