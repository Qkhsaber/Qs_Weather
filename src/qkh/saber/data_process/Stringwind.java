package qkh.saber.data_process;

public class Stringwind {
	public String fengxiang(String i){
		String f;
		if(i.equals("N"))
			f="����";
		else if(i.equals("NWN"))
			f="����ƫ����";
		else if(i.equals("NW"))
			f="������";
		else if(i.equals("WNW"))
			f="����ƫ����";
		else if(i.equals("W"))
			f="����";
		else if(i.equals("WSW"))
			f="����ƫ����";
		else if(i.equals("SW"))
			f="���Ϸ�";
		else if(i.equals("SSW"))
			f="����ƫ�Ϸ�";
		else if(i.equals("S"))
			f="�Ϸ�";
		else if(i.equals("SSE"))
			f="����ƫ�Ϸ�";
		else if(i.equals("SE"))
			f="���Ϸ�";
		else if(i.equals("ESE"))
			f="����ƫ����";
		else if(i.equals("E"))
			f="����";
		else if(i.equals("ENE"))
			f="����ƫ����";
		else if(i.equals("NE"))
			f="������";
		else if(i.equals("NNE"))
			f="����ƫ����";
		else
			f="null";
		
		return f;
		
	}

}
