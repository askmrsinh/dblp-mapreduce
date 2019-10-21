package com.ashessin.cs441.hw2.dblp;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Publication {
    private String key;
    private int mdate;
    private String publtype;
    private String publrecord;
    private ArrayList<String> authors;

    Publication(String key, @Nullable int mdate, @Nullable String publtype, String publrecord, @Nullable ArrayList<String> authors) {
        this.key = key;
        this.mdate = mdate;
        this.publtype = publtype;
        this.publrecord = publrecord;
        this.authors = authors;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getMdate() {
        return mdate;
    }

    public void setMdate(int mdate) {
        this.mdate = mdate;
    }

    public String getPubltype() {
        return publtype;
    }

    public void setPubltype(String publtype) {
        this.publtype = publtype;
    }

    public String getPublrecord() {
        return publrecord;
    }

    public void setPublrecord(String publrecord) {
        this.publrecord = publrecord;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = (ArrayList<String>) authors;
    }

    @Override
    public String toString() {
        return "key=\"" + key + "\", publrecord=\"" + publrecord + "\" mdate=" + mdate + ", publtype=\"" + publtype
                + "\" authors=" + this.authors;
    }
}
