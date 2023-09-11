package com.qh.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 带有参数的Post请求 -- 带参数的
 * NameValuePair
 */
public class DoPOSTTaken {
    public static String doPost() throws Exception {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost("http://172.16.6.164:10021/oauth/token?grant_type=client_credentials&client_id=qianheesb&client_secret=qhesb2020");
        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("grant_type", "client_credentials"));
        parameters.add(new BasicNameValuePair("client_id", "qianheesb"));
        parameters.add(new BasicNameValuePair("client_secret", "qhesb2020"));
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);
        //伪装浏览器
        httpPost.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        CloseableHttpResponse response = null;

        String str = null;

        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");


                String[]  R = content.split(",");
                 String str2 = R[0];
                String[] split = str2.split(":");
                String str3 = split[1];

                String stringWithoutQuotes = str3.substring(1, str3.length() - 1);
                str = stringWithoutQuotes;

            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
        return str;
    }
}