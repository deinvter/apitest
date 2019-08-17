package com.mine.api.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class RequestUtils {
    /**
     * get请求（无请求头）
     * @param url 将请求数据拼接到url中
     * @return
     * @throws IOException
     */
    public static CloseableHttpResponse get(String url)  {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * get请求（有请求头）
     * @param url 将请求数据拼接到url中
     * @param header
     * @return
     * @throws IOException
     */
    public static CloseableHttpResponse get(String url, HashMap<String,String> header)  {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        for (Map.Entry<String,String> entry: header.entrySet()) {
            httpGet.addHeader(entry.getKey(),entry.getValue());
        }
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * post请求
     * @param url
     * @param entity
     * @return
     * @throws IOException
     */
    public static CloseableHttpResponse post(String url,String entity)  {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost =new HttpPost(url);
        httpPost.setHeader("content-type","application/json");
        CloseableHttpResponse response = null;
        try {
            httpPost.setEntity(new StringEntity(entity));
            response = client.execute(httpPost);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * post请求
     * @param url
     * @param entity
     * @param header
     * @return
     * @throws IOException
     */
    public static CloseableHttpResponse post(String url,String entity,HashMap<String,String> header)  {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost =new HttpPost(url);
        CloseableHttpResponse response = null;
        for (Map.Entry<String,String> entry: header.entrySet()) {
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
        try {
            httpPost.setEntity(new StringEntity(entity));
            response = client.execute(httpPost);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
    public static void delete(){
    }
    public static void put(){

    }
}
