
package com.sample;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.entity.ContentType;

import java.io.IOException;

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

    public void post() {

    }

    public void put() {

    }

    public void delete() {

    }

    public static void main(String[] args) {
        try{
            WebClient client = new WebClient();
            String response = client.get("https://bittrex.com/api/v1.1/public/getticker?market=btc-ftc");
            System.out.println("Response: " + response);
        }catch(Exception ie){
            ie.printStackTrace();
        }
    }
}