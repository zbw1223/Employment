package com.example.recriutingsystem;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

public class UserService {


    private HTTPUtil httpUtil;
    private Users theUser;
    JobSeeker theJobSeeker;
    Business theBusiness;
    List<JobSeeker> jobSeekers;
    List<Recruit> recruits;
    static UserService userService=null;
    UserService(){
        httpUtil=new HTTPUtil();
    }
    public int getType()
    {
        return theUser.getuType();
    }
    public Users Login(String userName,String password){
        theUser=httpUtil.Login(userName,password);
        if(theUser==null)return null;
        if(theUser.getuType()==0){
            List<JobSeeker> list=httpUtil.getJobSeekerList();
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).getUid()==theUser.getUid()){
                    theJobSeeker=list.get(i);
                    break;
                }
            }
        }else {
            List<Business> list=httpUtil.getBusinessList();
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).getUid()==theUser.getUid()){
                    theBusiness=list.get(i);
                    break;
                }
            }
        }

        return theUser;
    }
    public int register(String userName,String password,int uType){
        return httpUtil.register(userName,password,uType);
    }
    public static UserService getUserService()
    {
        if(userService==null){
            userService=new UserService();
        }
        return userService;
    }
    public Boolean regBusiness(int uid,String bName,String city,String introduce,String email)
    {
        return httpUtil.regBusiness(uid,bName,city,introduce,email);
    }
    public Boolean regSeeker(int uid,String name,String sex,String bir,String exp,String degree,String eduBackground,String major,String job,String city,String salary,String email)
    {
        return httpUtil.regSeeker(uid,name,sex,bir,exp,degree,eduBackground,major,job,city,salary,email);
    }
    public List<JobSeeker> getJobSeekerList(){
        jobSeekers =httpUtil.getJobSeekerList();
        return jobSeekers;
    }
    public List<Recruit> getRecruitList(){
        recruits=httpUtil.getRecruitList();
        return httpUtil.getRecruitList();
    }
    public List<Business> getBusinessList(){
        return httpUtil.getBusinessList();
    }
    public void sendMessage(int jUid,int bUid,String msg)
    {
        httpUtil.sendMessage(jUid,bUid,msg);
    }
    public List<Message> getChat(){
        return httpUtil.getChat();
    }

    public void alterSeeker(int uid,String name,String sex,String birthday,String degree,String eduBackground,String exp,String job,String city,int salary)
    {
        theJobSeeker.setName(name);
        theJobSeeker.setSex(sex);
        theJobSeeker.setBirthday(birthday);
        theJobSeeker.setDegree(degree);
        theJobSeeker.setEduBackground(eduBackground);
        theJobSeeker.setExp(exp);
        theJobSeeker.setJob(job);
        theJobSeeker.setCity(city);
        theJobSeeker.setSalary(Integer.toString(salary));
        httpUtil.alterSeeker(uid,name,sex,birthday,degree,eduBackground,exp,job,city,salary);
    }
    public void alterUser(int uid,String password)
    {
        httpUtil.alterUser(uid,password);
        theUser.setPassword(password);
    }
    public void alterBusiness(int uid,String businessName,String city,String introduce,String email)
    {
        theBusiness.setBusinessName(businessName);
        theBusiness.setCity(city);
        theBusiness.setEmail(email);
        theBusiness.setIntroduce(introduce);

        httpUtil.alterBusiness(uid,businessName,city,introduce,email);
    }
    public int getUid()
    {
        return theUser.getUid();
    }
    public String getUserName()
    {
        return theUser.getuName();
    }
    public String getPassword()
    {
        return theUser.getPassword();
    }
    public void setPassword(String password)
    {
        theUser.setPassword(password);
    }
    public void alterRecruit(int rid,String jobName,String jobDescription,String workCity,String degree,String expRequire,String salaryOffer,String offerNumber,String email)
    {
        httpUtil.alterRecruit(rid,jobName,jobDescription,workCity,degree,expRequire,salaryOffer,offerNumber,email);
    }
    public void deleteRecruit(int rid)
    {
        httpUtil.deleteRecruit(rid);
    }
    public void postRecruit(int uid,String jobName,String jobDescription,String workCity,String degree,String expRequire,String salaryOffer,String offerNumber,String email)
    {
        httpUtil.postRecruit(uid,jobName,jobDescription,workCity,degree,expRequire,salaryOffer,offerNumber,email);
    }
    public List<Recruit> search0(String content)
    {
        List<Recruit> results=new ArrayList<Recruit>();
        for(int i=0;i<recruits.size();i++)
        {
            if(recruits.get(i).getJobName().contains(content))results.add(recruits.get(i));
        }
        return results;
    }
    public List<JobSeeker> search1(String content)
    {
        List<JobSeeker> results=new ArrayList<JobSeeker>();
        for(int i=0;i<jobSeekers.size();i++)
        {
            if(jobSeekers.get(i).getJob().contains(content))results.add(jobSeekers.get(i));
        }
        return results;
    }
    public void test()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Users u=Login("name","password");
                if(u==null)
                {
                    Log.d("USER","U null");
                }
                Log.d("USER",u.getuName());
            }
        }).start();
    }
}
