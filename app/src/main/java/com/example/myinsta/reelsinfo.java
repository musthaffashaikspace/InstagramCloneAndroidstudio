package com.example.myinsta;

public class reelsinfo {
    String accountname;
    String videopath;

    public reelsinfo(String accountname, String videopath) {
        this.accountname = accountname;
        this.videopath = videopath;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getVideopath() {
        return videopath;
    }

    public void setVideopath(String videopath) {
        this.videopath = videopath;
    }
}
