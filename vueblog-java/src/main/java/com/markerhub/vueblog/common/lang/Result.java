package com.markerhub.vueblog.common.lang;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private int code;//是否成功，例如200、400
    private String msg;//结果消息
    private Object data;//结果数据


    //操作成功类型
    public static Result succ(Object data) {
       return commo(200,"操作成功",data);
    }

    //操作失败类型
    public static Result fail(String msg) {
        return commo(400,msg, null);
    }

    //操作失败类型
    public static Result fail(String msg,Object data) {
        return commo(400, msg, data);
    }

    //操作失败类型
    public static Result fail(int code,String msg,Object data) {
        return commo(code, msg, data);
    }

    //操作类型通用
    public static Result commo(int code,String mess,Object data){
        Result m=new Result();
        m.setCode(code);
        m.setMsg(mess);
        m.setData(data);
        return m;
    }
}
