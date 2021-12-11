package com.example.recriutingsystem;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class HTTPUtil {
    String path="http://192.168.43.141:8080/test/";

    public HttpURLConnection connect(String url)
    {
        try {
            URL u=new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();//打开连接

            conn.setRequestMethod("GET");//设置请求方式为get
            conn.setConnectTimeout(500);//设置连接超时时间为5秒
            if(conn==null) {
                return null;
            }
            if(conn.getResponseCode()==200)
            {
                return conn;
            }
            return null;
        } catch (MalformedURLException e) {

            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
    public Users Login(String userName,String password)
    {
        try {
            String action="Login?username="+ URLEncoder.encode(userName,"UTF-8")+"&"+"password="+URLEncoder.encode(password,"UTF-8");
            String url=path+action;
            String str=readStream(connect(url));
            if(str==null)return null;
            if(str.equals("Login Failed!")){
                return null;
            }
            else
            return new GsonBuilder().create().fromJson(str,Users.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }

    }
    public int register(String userName,String password,int userType)
    {
        try {
            Log.d("Reg","name="+userName);
            Log.d("Reg","pwd="+password);
            String action="Register?username="+ URLEncoder.encode(userName,"UTF-8")+"&"+"password="+URLEncoder.encode(password,"UTF-8")+
                    "&usertype="+URLEncoder.encode(Integer.toString(userType),"UTF-8");
            String url=path+action;
            String str=readStream(connect(url));
            Log.d("readStr",str);
            if(!str.equals("Failed!")) return Integer.parseInt(str);
            else return 0;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return 0;
    }
    public List<Business> getBusinessList()
    {
        String action="GetBusinessList";
        String url=path+action;
        String str=readStream(connect(url));
        return new GsonBuilder().create().fromJson(str,new TypeToken<List<Business>>(){}.getType());
    }
    public List<JobSeeker> getJobSeekerList()
    {
        String action="GetSeekerList";
        String url=path+action;
        String str=readStream(connect(url));
        return new GsonBuilder().create().fromJson(str,new TypeToken<List<JobSeeker>>(){}.getType());
    }
    public List<Recruit> getRecruitList()
    {
        String action="GetRecruitList";
        String url=path+action;
        String str=readStream(connect(url));
        return new GsonBuilder().create().fromJson(str,new TypeToken<List<Recruit>>(){}.getType());
    }
    public Boolean regBusiness(int uid,String bName,String city,String introduce,String email)
    {
        String action="RegisterBusiness?"+"uid="+uid+"&businessName="+bName+"&city="+city+"&introduce="+introduce+"&email="+email;
        String url=path+action;
        String str=readStream(connect(url));
        return true;
    }
    public Boolean regSeeker(int uid,String name,String sex,String bir,String exp,String degree,String eduBackground,String major,String job,String city,String salary,String email)
    {
        String action="RegisterSeeker?uid="+uid+"&name="+name+"&sex="+sex+"&bir="+bir+"&exp="+exp+"&degree="+degree+"&eduBackground="+eduBackground+"&major="+major+"&job="+job+"&city="+city+"&salary="+salary+"&email="+email;
        String url=path+action;
        String str=readStream(connect(url));
        return true;
    }
    public void sendMessage(int jUid,int bUid,String msg)
    {
        String action="SendMessage?"+"jUid="+jUid+"&bUid="+bUid+"&msg="+msg;
        String url=path+action;
        String str=readStream(connect(url));
    }
    public List<Message> getChat()
    {
        String action="GetChat";
        String url=path+action;
        String str=readStream(connect(url));
        return new GsonBuilder().create().fromJson(str,new TypeToken<List<Message>>(){}.getType());
    }
    public void alterSeeker(int uid,String name,String sex,String birthday,String degree,String eduBackground,String exp,String job,String city,int salary)
    {
        String action="AlterSeeker?uid="+uid+"&name="+name+"&sex="+sex+"&birthday="+birthday+"&degree="+degree+"&eduBackground="+eduBackground+"&exp="+exp+"&job="+job+"&city="+city+"&salary="+salary;
        String url=path+action;
        String str=readStream(connect(url));
    }
    public void alterUser(int uid,String password)
    {
        String action="AlterUser?uid="+uid+"&password="+password;
        String url=path+action;
        String str=readStream(connect(url));
    }
    public void alterBusiness(int uid,String businessName,String city,String introduce,String email)
    {
        String action="AlterBusiness?uid="+uid+"&businessName="+businessName+"&city="+city+"&introduce="+introduce+"&email="+email;
        String url=path+action;
        String str=readStream(connect(url));
    }
    public void alterRecruit(int rid,String jobName,String jobDescription,String workCity,String degree,String expRequire,String salaryOffer,String offerNumber,String email)
    {

        String action="rid="+rid+"&jobName="+jobName+"&jobDescription="+jobDescription+"&workCity="+workCity+"&degree="+degree+"&expRequire="+expRequire+"&salaryOffer="+salaryOffer+"&offerNumber="+"&email="+email;
        String url=path+action;
        String str=readStream(connect(url));
    }
    public void deleteRecruit(int rid)
    {
        String action="DeleteRecruit?rid="+rid;
        String url=path+action;
        String str=readStream(connect(url));
    }
    public void postRecruit(int uid,String jobName,String jobDescription,String workCity,String degree,String expRequire,String salaryOffer,String offerNumber,String email)
    {
        String action="PostRecruit?uid="+uid+"&jobName="+jobName+"&jobDescription="+jobDescription+"&workCity="+workCity+"&degree="+degree+"&expRequire="+expRequire+"&salaryOffer="+salaryOffer+"&offerNumber="+offerNumber+"&email="+email;
        String url=path+action;
        String str=readStream(connect(url));
    }

    private String readStream(HttpURLConnection connection){
        String str="";
        if(connection==null)
        { return null;}
        try {
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
            BufferedReader reader=new BufferedReader(inputStreamReader);
            String line=null;

            while((line = reader.readLine())!=null){
                str+=line;
            }
            connection.disconnect();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }


}
