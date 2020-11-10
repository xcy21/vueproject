package com.liujx.testfront.common.lang;

import lombok.Data;
import org.apache.logging.log4j.message.ReusableMessage;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private int code;
    private String msg;
//    private Object data;

    public static Result succ() {
        return succ(200, "登錄成功！");
    }
    public static Result succ(int code,String msg){
        Result t = new Result();
        t.setCode(code);
        t.setMsg(msg);
//        t.setData(data);
        return t;
    }

    public static Result fail() {
        return succ(400, "登錄失敗！");
    }
    public static Result fail(int code,String msg){
        Result t = new Result();
        t.setCode(code);
        t.setMsg(msg);
//        t.setData(data);
        return t;
    }
}
