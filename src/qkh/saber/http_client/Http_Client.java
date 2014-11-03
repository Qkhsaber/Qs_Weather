package qkh.saber.http_client;

import org.apache.http.impl.client.DefaultHttpClient;

public class Http_Client {
	
	public static DefaultHttpClient httpclient = new DefaultHttpClient();
	
	public static DefaultHttpClient gethttpclient()
	{
		return httpclient;
		
	}

}
