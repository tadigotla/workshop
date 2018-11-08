
package com.sample;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import java.io.IOException;
import org.json.JSONObject;

import java.util.*; 

public class WebClient {
    public String get(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);

        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            String contentMimeType = ContentType.getOrDefault(entity1).getMimeType();
            System.out.println(contentMimeType);

            String response = EntityUtils.toString(entity1, "UTF-8");
            return response;
        } catch(IOException e){
            e.printStackTrace(System.out);
        }finally {
            response1.close();
        }
        return "NOT_FOUND";
    }


    public String post(String url, Map<String, String> payload) throws IOException {
        JSONObject json = new JSONObject();
        for (Map.Entry<String, String> entry : payload.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
	    }
        
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    
        try {
            HttpPost httpPost = new HttpPost(url);    
            StringEntity params = new StringEntity(json.toString());
            httpPost.addHeader("content-type", "application/json");
            httpPost.setEntity(params);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity2 = response.getEntity();

            String responseForLogin = EntityUtils.toString(entity2, "UTF-8");
            return responseForLogin;
            
        } catch(IOException e){
            e.printStackTrace(System.out);
        }finally {
            httpClient.close();
        }
        
        return "NOT_FOUND";
    }

    public void put() {

    }

    public void delete() {

    }

    public static void main(String[] args) {
        try{
            WebClient web = new WebClient();
            String responseForGet = web.get("https://bittrex.com/api/v1.1/public/getticker?market=btc-ftc");
            System.out.println("Response: " + responseForGet);
            Map<String, String> postInput = new HashMap<String, String>();
            postInput.put("username", "admin");
            postInput.put("password", "admin");
            String loginResponse = web.post("http://dev.vivasa.in:32228/mesaforte/api/login", postInput);
            System.out.println("Response for Login: " + loginResponse);
        }catch(Exception ie){
            ie.printStackTrace();
        }
    }
}