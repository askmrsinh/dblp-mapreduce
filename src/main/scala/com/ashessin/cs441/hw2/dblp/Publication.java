package com.ashessin.cs441.hw2.dblp;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Publication implements java.io.Serializable {
    private String key;
    private int year;
    private String publtype;
    private String publrecord;
    private ArrayList<String> authors;
    private String journal;

    Publication(String key, @Nullable int year, @Nullable String publtype, String publrecord, @Nullable ArrayList<String> authors, @Nullable String journal) {
        this.key = key;
        this.year = year;
        this.publtype = publtype;
        this.publrecord = publrecord;
        this.authors = authors;
        this.journal = journal;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    @Override
    public String toString() {
        return "key=\"" + key + "\", publrecord=\"" + publrecord + "\" year=" + year + ", publtype=\"" + publtype
                + "\" authors=" + this.authors + ", journal=\"" + this.journal + "\"";
    }
}
