package com.ly.commons.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResponseData
 * @Author alan.wang   QQ:3103484396
 * @Description 返回结果
 */
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T>
{
    public ResponseData(T t)
    {
        this.setData(t);
    }

    public interface ResultCode{
        int SUCCESS = 0;
        int FAIL = 1;
    }

    /* 响应的结果码 */
    private Integer code = ResultCode.SUCCESS;
    private String msg = "成功!";
    private T data;




    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
