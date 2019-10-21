package com.ashessin.cs441.hw2.dblp;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Publication {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

    private String key;
    private Date mdate;
    private Date cdate;
    private String publtype;
    private String publrecord;
    private List<String> authors;

    Publication(String key, @Nullable String mdate, @Nullable String cdate, @Nullable String publtype, String publrecord, @Nullable List<String> authors, @Nullable String title) throws ParseException {
        this.key = key;
        setMdate(mdate);
        setCdate(cdate);
        setPubltype(publtype);
        this.publrecord = publrecord;
        this.authors = authors;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getMdate() {
        return mdate;
    }

    private void setMdate(String mdate) throws ParseException {
        if (mdate != null && !mdate.equals(""))
            this.mdate = simpleDateFormat.parse(mdate);
        else
            this.mdate = null;
    }

    public Date getCdate() {
        return cdate;
    }

    private void setCdate(String cdate) throws ParseException {
        if (cdate != null && !cdate.equals(""))
            this.cdate = simpleDateFormat.parse(cdate);
        else
            this.cdate = null;
    }

    public String getPubltype() {
        return publtype;
    }

    private void setPubltype(String publtype) {
        if (publtype != null && !publtype.equals(""))
            this.publtype = publtype;
        else
            this.publtype = null;
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
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "key=\"" + key + "\", publrecord=\"" + publrecord + "\" mdate=\"" + mdate + "\", cdate=\"" + cdate + "\", publtype=\"" + publtype
                + "\" authors=" + this.authors;
    }
}
