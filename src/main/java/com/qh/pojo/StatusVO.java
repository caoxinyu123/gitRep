package com.qh.pojo;

public class StatusVO {
    private int statusNum;

    public StatusVO(int statusNum) {
        this.statusNum = statusNum;
    }

    public int getStatusNum() {
        return statusNum;
    }

    public void setStatusNum(int statusNum) {
        this.statusNum = statusNum;
    }

    @Override
    public String toString() {
        return "StatusVO{" +
                "statusNum=" + statusNum +
                '}';
    }
}
