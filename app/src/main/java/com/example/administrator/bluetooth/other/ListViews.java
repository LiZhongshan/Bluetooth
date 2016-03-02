package com.example.administrator.bluetooth.other;

/**
 * Created by Administrator on 2016/2/29.
 */
public class ListViews {
    private String aName;
    private String aSpeak;
    private String aTime;
    private int aIcon;

    public ListViews() {
    }

    public ListViews(String aName, String aSpeak, String aTime, int aIcon) {
        this.aName = aName;
        this.aSpeak = aSpeak;
        this.aTime = aTime;
        this.aIcon = aIcon;
    }

    public String getaName() {
        return aName;
    }

    public String getaSpeak() {
        return aSpeak;
    }

    public String getaTime() {
        return aTime;
    }


    public int getaIcon() {
        return aIcon;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public void setaSpeak(String aSpeak) {
        this.aSpeak = aSpeak;
    }

    public void setaTime(String aTime) {
        this.aTime = aTime;
    }
    public void setaIcon(int aIcon) {
        this.aIcon = aIcon;
    }
}