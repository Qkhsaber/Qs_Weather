package qkh.saber.data_process;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Stringsplit
{   
	public String strin(String target,int num)
    {
        String a[] = target.split(" ");
		return a[num];
    }
	public String stringsplit(String target,int num)
    {
        String a[] = target.split(",");
		return a[num];
    }
	public String stringsplit_w(String title,int num)
    {
        String a[] = title.split("N");
		return a[num];
    }
	public String stringsplit_q(String target,int num)
    {
        String a[] = target.split("A");
		return a[num];
    }
    public String stringsplit_cn(String target,int num)
    {
        String a[] = target.split("/");
		return a[num];
    }
    public String cut_updatetime(String target){
    	for (int i = 0; i < target.length(); i++) {
			if(target.charAt(i)=='M'){
				target=target.substring(9,
						i+1);
			}

		}
    	return target;
    }
   
    public String name(String result) {
		String title = "";
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("dnam");
		for (Element link : links) {
			title += link.text();
			title = stringsplit(title, 0);
		}
		return title;
	}
   
    public String date(String result) {
		String title = "";
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("flik");
		for (Element link : links) {
			title += link.text();
			title = stringsplit(title, 0);
		}
		return title;
	}
    public String[] temp1(String result) {
		String title[] = new String[20];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("low");
		int i= 0;
		for (Element link : links) {
			
			title[i] = link.text();
			i++;
		}
		return title;
	}
    public String[] temp2(String result) {
		String title[] = new String[20];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("hi");
		int i= 0;
		for (Element link : links) {
			
			title[i] = link.text();
			i++;
		}
		return title;
	}
   public String[] tianqi(String result) {
		String title[] = new String[200];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("t");
		int i= 0;
		for (Element link : links) {
		
			title[i] = link.text();
			title[i] = stringsplit_cn(title[i],0);
			i++;
		}
		return title;
   }
   public String[] rich(String result) {
		String title[] = new String[200];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("sunr");
		int i= 0;
		for (Element link : links) {
		
			title[i] = link.text();
			i++;
		}
		return title;
  }
   public String[] ril(String result) {
		String title[] = new String[200];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("suns");
		int i= 0;
		for (Element link : links) {
		
			title[i] = link.text();
			i++;
		}
		return title;
 }
   public String[] wind(String result) {
		String title[] = new String[200];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("wind");
		int i= 0;
		for (Element link : links) {
		
			title[i] = link.text();
			title[i] = stringsplit_w(title[i],0);
			i++;
		}
		return title;
}
   public String[] wind1(String result) {
		String title[] = new String[200];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("wind");
		int i= 0;
		for (Element link : links) {
		
			title[i] = link.text();
			title[i] = stringsplit_q(title[i],1);
			i++;
		}
		return title;
}
   public String[] rian_1(String result) {
		String title[] = new String[200];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("ppcp");
		int i= 0;
		for (Element link : links) {
		
			title[i] = link.text();
			i++;
		}
		return title;
}
   public String[] rian_2(String result) {
	String title[] = new String[200];
	Document doc = Jsoup.parse(result);
	Elements links = doc.select("hmid");
	int i= 0;
	for (Element link : links) {
	
		title[i] = link.text();
		i++;
	}
	return title;
}
   public String[] see(String result) {
		String title[] = new String[200];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("vis");
		int i= 0;
		for (Element link : links) {
		
			title[i] = link.text();
			i++;
		}
		return title;
	}
   public String[] win1(String result) {
		String title[] = new String[200];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("s");
		int i= 0;
		for (Element link : links) {
		
			title[i] = link.text();
			i++;
		}
		return title;
	}
   public String[] win2(String result) {
		String title[] = new String[200];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("t");
		int i= 0;
		for (Element link : links) {
		    
			title[i] = link.text();
			i++;
		}
		return title;
	}
   public String[] up_data_time(String result) {
		String title[] = new String[200];
		Document doc = Jsoup.parse(result);
		Elements links = doc.select("lsup");
		int i= 0;
		for (Element link : links) {
			 
			title[i] = link.text();
			i++;
		}
		
		return title;
	}
   
    
}