package qkh.saber.connect;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class Http_GET{
	
	public String send(HttpClient httpclient_get,String target) {
		String result = "";
		HttpGet httpRequest = new HttpGet(target);
		HttpResponse httpResponse;
		try {
			httpResponse = httpclient_get.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				result = EntityUtils.toString(httpResponse.getEntity());
			}else{
				result="«Î«Û ß∞‹£°";
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}