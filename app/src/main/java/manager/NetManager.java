package manager;

import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import utils.Tools;

/**
 * Created by tom on 2017/3/21.
 */

public class NetManager {



    @Nullable
    public static JSONObject getDicToPost(String path, String post)
    {

        if (!Tools.NETWORK_STATE)
        {
            //本地通知
            Log.e("NetConnt","失去网络链接");

            return null;

        }

        String json = NetManager.getJsonToPost(path,post);

        JSONObject jsonObject = null;

        try {

           jsonObject = jsonObject.getJSONObject(json);

        }catch (JSONException e)
        {
            e.printStackTrace();
        }


        return jsonObject;

    }


    @Nullable
    public static String post(String path, String post)
    {

        String jsonStr = getJsonToPost(path,post);

        return  jsonStr;
//        JSONObject jsonObject = null;
//
//        String result = null;
//
//        try {
//
//            if (jsonStr!=null)
//            {
//                jsonObject =new JSONObject(jsonStr);
//
//                result = jsonObject.getString("result");
//            }
//
//        }catch (JSONException e)
//        {
//            e.printStackTrace();
//        }
//
//
//        if (result=="success")
//        {
//            return  jsonStr;
//
//        }else
//        {
//
//            return  jsonStr;
//        }
    }


    @Nullable
    public static String getJsonToPost(String path, String post)
    {
        URL url = null;
        try {

            path = "http://192.168.88.102:1027/daniubangbang/login";

            url = new URL(path);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // Post不能使用缓存
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            //设定 请求格式 json，也可以设定xml格式的
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //设置编码语言
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            printWriter.write(post);//post的参数 xx=xx&yy=yy
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();

            System.out.println("返回数据："+bos.toString("utf-8"));

            return bos.toString("utf-8");

        } catch (Exception e) {

            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }
    //POST请求 返回 josn String
//    @Nullable
//    public static String getJsonToPost(String path, String post)
//    {
//        URL url = null;
//        try {
//
//            path = "https://hub.expertt.cn"+path;
//
//            url = new URL(path);
//
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestMethod("POST");// 提交模式
//            // 发送POST请求必须设置如下两行
//            httpURLConnection.setDoOutput(true);
//            httpURLConnection.setDoInput(true);
//            // Post不能使用缓存
//            httpURLConnection.setUseCaches(false);
//            httpURLConnection.setInstanceFollowRedirects(true);
//            //设定 请求格式 json，也可以设定xml格式的
//            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            //设置编码语言
//            // 获取URLConnection对象对应的输出流
//            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
//            // 发送请求参数
//            printWriter.write(post);//post的参数 xx=xx&yy=yy
//            // flush输出流的缓冲
//            printWriter.flush();
//            //开始获取数据
//            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            int len;
//            byte[] arr = new byte[1024];
//            while((len=bis.read(arr))!= -1){
//                bos.write(arr,0,len);
//                bos.flush();
//            }
//            bos.close();
//
//            System.out.println("返回数据："+bos.toString("utf-8"));
//
//            return bos.toString("utf-8");
//
//        } catch (Exception e) {
//
//            System.out.println(e);
//            e.printStackTrace();
//        }
//        return null;
//    }

}
