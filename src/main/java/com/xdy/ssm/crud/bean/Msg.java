package com.xdy.ssm.crud.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    //状态码200：表示成功，400：表示失败
    private Integer state;
    //提示信息
    private String msg;

    //返回的数据
    private Map<String,Object> data = new HashMap<>();

    //请求成功后添加要返回的数据
    public Msg add(String key, Object obj){
        this.getData().put(key,obj);
        return this;
    }

    //成功的处理方法
    public static Msg success(){
        Msg msg = new Msg();
        msg.setState(200);
        msg.setMsg("数据请求成功！");
        return msg;
    }

    //请求失败的方法
    public static Msg fail(){
        Msg msg = new Msg();
        msg.setState(400);
        msg.setMsg("数据请求失败！");
        return msg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
