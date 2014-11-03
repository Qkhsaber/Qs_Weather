package qkh.saber.connect;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Http_POST {

	public String http_post(HttpClient httpclient_post,String target,String username_local,String passwd_local) {
		String result = "";
		HttpPost httpRequest = new HttpPost(target); 
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("number", username_local));
		params.add(new BasicNameValuePair("passwd", passwd_local));
		params.add(new BasicNameValuePair("select", "cert_no"));

		try {
			httpRequest.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
			HttpResponse httpResponse = httpclient_post.execute(httpRequest); 
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result += EntityUtils.toString(httpResponse.getEntity());
			} else {
				result = "«Î«Û ß∞‹£°";
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace(); 
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
