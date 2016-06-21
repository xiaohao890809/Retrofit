package me.hz89.retrofit.db;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by h.xiao on 2016/6/20.
 */
public class Data extends RealmObject
{
    @PrimaryKey
    private String nu; // 快递单号
    private String com; //快递公司名称
    private String status; //查询结果状态
    private String state; // 当前状态

    //    @SerializedName("data")
    private RealmList<Basic> data;

    public RealmList<Basic> getData() {
        return data;
    }

    public void setData(RealmList<Basic> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }


}
