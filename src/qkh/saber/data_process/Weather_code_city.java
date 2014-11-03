package qkh.saber.data_process;

public class Weather_code_city {
	public String getcity(String where) {
		
		String code_city = "null";
		if (where.equals("北京"))
			code_city = "CHXX0008";
		if (where.equals("上海"))
			code_city = "CHXX0116";
		if (where.equals("广州"))
			code_city = "CHXX0037";
		if (where.equals("安顺"))
			code_city = "CHXX0005";
		if (where.equals("苏州")|where.equals("suzhou"))
			code_city = "CHXX0520";
		if (where.equals("重庆"))
			code_city = "CHXX0017";
		if (where.equals("大连"))
			code_city = "CHXX0019";
		if (where.equals("佛山"))
			code_city = "CHXX0028";
		if (where.equals("福州"))
			code_city = "CHXX0031";
		if (where.equals("桂林"))
			code_city = "CHXX0434";
		if (where.equals("哈尔滨"))
			code_city = "CHXX0046";
		if (where.equals("海口"))
			code_city = "CHXX0502";
		if (where.equals("杭州"))
			code_city = "CHXX0044";
		if (where.equals("惠州"))
			code_city = "CHXX0053";
		if (where.equals("合肥"))
			code_city = "CHXX0448";
		if (where.equals("吉林"))
			code_city = "CHXX0063";
		if (where.equals("济南"))
			code_city = "CHXX0064";
		if (where.equals("九江"))
			code_city = "CHXX0068";
		if (where.equals("开封"))
			code_city = "CHXX0072";
		if (where.equals("昆明"))
			code_city = "CHXX0076";
		if (where.equals("拉萨"))
			code_city = "CHXX0080";
		if (where.equals("兰州"))
			code_city = "CHXX0079";
		if (where.equals("洛阳"))
			code_city = "CHXX0086";
		if (where.equals("柳州"))
			code_city = "CHXX0479";
		if (where.equals("南昌"))
			code_city = "CHXX0097";
		if (where.equals("南京"))
			code_city = "CHXX0099";
		if (where.equals("南宁"))
			code_city = "CHXX0100";
		if (where.equals("绵阳"))
			code_city = "CHXX0351";
		if (where.equals("青岛"))
			code_city = "CHXX0110";
		if (where.equals("泉州"))
			code_city = "CHXX0114";
		if (where.equals("绍兴"))
			code_city = "CHXX0117";
		if (where.equals("汕头"))
			code_city = "CHXX0493";
		if (where.equals("沈阳"))
			code_city = "CHXX0119";
		if (where.equals("深圳"))
			code_city = "CHXX0120";
		if (where.equals("石家庄"))
			code_city = "CHXX0122";
		if (where.equals("太原"))
			code_city = "CHXX0129";
		if (where.equals("台北"))
			code_city = "TWXX0021";
		if (where.equals("天津"))
			code_city = "CHXX0133";
		if (where.equals("温州"))
			code_city = "CHXX0462";
		if (where.equals("乌鲁木齐"))
			code_city = "CHXX0135";
		if (where.equals("西安"))
			code_city = "CHXX0141";
		if (where.equals("西宁"))
			code_city = "CHXX0236";
		if (where.equals("厦门"))
			code_city = "CHXX0140";
		if (where.equals("香港"))
			code_city = "CHXX0049";
		if (where.equals("咸阳"))
			code_city = "CHXX0143";
		if (where.equals("新乡"))
			code_city = "CHXX0148";
		if (where.equals("徐州"))
			code_city = "CHXX0437";
		if (where.equals("武汉"))
			code_city = "CHXX0138";
		if (where.equals("宜昌"))
			code_city = "CHXX0407";
		if (where.equals("岳阳"))
			code_city = "CHXX0411";
		if (where.equals("郑州"))
			code_city = "CHXX0165";
		if (where.equals("鄂多斯"))
			code_city = "101080701";
		if (where.equals("通"))
			code_city = "101080501";
		if (where.equals("南"))
			code_city = "101120101";
		if (where.equals("岛"))
			code_city = "101120201";
		if (where.equals("博"))
			code_city = "101120301";
		if (where.equals("海"))
			code_city = "101121301";
		if (where.equals("曲阜"))
			code_city = "101120710";
		if (where.equals("沂"))
			code_city = "101120901";
		if (where.equals("台"))
			code_city = "101120501";
		if (where.equals("庄"))
			code_city = "101121401";
		if (where.equals("城"))
			code_city = "101121701";
		if (where.equals("宁"))
			code_city = "101120701";
		if (where.equals("泽"))
			code_city = "101121001";
		if (where.equals("安"))
			code_city = "101120801";
		if (where.equals("照"))
			code_city = "101121501";
		if (where.equals("营"))
			code_city = "101121201";
		if (where.equals("州"))
			code_city = "101120401";
		if (where.equals("州"))
			code_city = "101121101";
		if (where.equals("芜"))
			code_city = "101121601";
		if (where.equals("坊"))
			code_city = "101120601";
		if (where.equals("京"))
			code_city = "101190101";
		if (where.equals("山"))
			code_city = "101190404";
		if (where.equals("通"))
			code_city = "101190501";
		if (where.equals("仓"))
			code_city = "101190408";
		if (where.equals("县"))
			code_city = "101190406";
		if (where.equals("州"))
			code_city = "101190801";
		if (where.equals("兴"))
			code_city = "101190203";
		if (where.equals("江"))
			code_city = "101190301";
		if (where.equals("安"))
			code_city = "101190901";
		if (where.equals("熟"))
			code_city = "101190402";
		if (where.equals("城"))
			code_city = "101190701";
		if (where.equals("州"))
			code_city = "101191201";
		if (where.equals("无锡"))
			code_city = "CHXX4822";
		if (where.equals("云港"))
			code_city = "101191001";
		if (where.equals("州"))
			code_city = "101190601";
		if (where.equals("常州"))
			code_city = "CHXX0015";
		if (where.equals("南通"))
			code_city = "CHXX0101";
		return code_city;
	}

}
