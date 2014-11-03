package qkh.saber.data_process;

public class Stringwind {
	public String fengxiang(String i){
		String f;
		if(i.equals("N"))
			f="北风";
		else if(i.equals("NWN"))
			f="西北偏北风";
		else if(i.equals("NW"))
			f="西北风";
		else if(i.equals("WNW"))
			f="西北偏西风";
		else if(i.equals("W"))
			f="西风";
		else if(i.equals("WSW"))
			f="西南偏西风";
		else if(i.equals("SW"))
			f="西南风";
		else if(i.equals("SSW"))
			f="西南偏南风";
		else if(i.equals("S"))
			f="南风";
		else if(i.equals("SSE"))
			f="东南偏南风";
		else if(i.equals("SE"))
			f="东南风";
		else if(i.equals("ESE"))
			f="东南偏东风";
		else if(i.equals("E"))
			f="东风";
		else if(i.equals("ENE"))
			f="东北偏东风";
		else if(i.equals("NE"))
			f="东北风";
		else if(i.equals("NNE"))
			f="东北偏北风";
		else
			f="null";
		
		return f;
		
	}

}
