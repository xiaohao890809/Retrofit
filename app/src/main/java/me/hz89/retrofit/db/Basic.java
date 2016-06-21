package me.hz89.retrofit.db;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by h.xiao on 2016/6/20.
 */
public class Basic extends RealmObject
{
    private Date time; //快递状态的时间
    private String context;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
