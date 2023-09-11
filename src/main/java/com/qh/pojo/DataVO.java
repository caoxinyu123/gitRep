package com.qh.pojo;

import java.util.List;

/**
 * @项目名: demo2
 * @描述:
 * @作者: 胖虎
 * @日期: 2023-06-17 20:56
 **/

public class DataVO<T> {
    private Integer code;
    private String msgg;
    private Long count;
    private List<T> data;

    public DataVO(Integer code, String msg, Long count, List<T> data) {
        this.code = code;
        this.msgg = msg;
        this.count = count;
        this.data = data;
    }

    public DataVO() {
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msgg;
    }

    public Long getCount() {
        return count;
    }

    public List<T> getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msgg = msg;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataVO{" +
                "code=" + code +
                ", msg='" + msgg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
