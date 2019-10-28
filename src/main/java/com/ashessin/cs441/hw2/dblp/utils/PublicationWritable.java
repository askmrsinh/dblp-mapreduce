package com.ashessin.cs441.hw2.dblp.utils;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

import javax.annotation.Nullable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PublicationWritable implements WritableComparable<PublicationWritable> {
    private String key;
    private String publrecord;
    private String publtype;
    private List<String> authors;
    private int year;
    private String journal;

    PublicationWritable() {
    }

    PublicationWritable(String key, String publrecord, @Nullable String publtype, @Nullable ArrayList<String> authors, int year, @Nullable String journal) {
        this.key = key;
        this.publrecord = publrecord;
        this.publtype = publtype;
        this.authors = authors;
        this.year = year;
        this.journal = journal;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPublrecord() {
        return publrecord;
    }

    public void setPublrecord(String publrecord) {
        this.publrecord = publrecord;
    }

    public String getPubltype() {
        return publtype;
    }

    public void setPubltype(String publtype) {
        this.publtype = publtype;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    @Override
    public String toString() {
        return "key=\"" + key + "\", publrecord=\"" + publrecord + "\", publtype=\"" + publtype
                + "\" authors=" + this.authors + ", year=" + year + ", journal=\"" + this.journal + "\"";
    }

    @Override
    public int compareTo(PublicationWritable publicationWritable) {
        return key.compareTo(publicationWritable.getKey());
    }

    /**
     * Serialize the fields of this object to <code>out</code>.
     *
     * @param out <code>DataOuput</code> to serialize this object into.
     * @throws IOException
     */
    @Override
    public void write(DataOutput out) throws IOException {
        WritableUtils.writeString(out, key);
        WritableUtils.writeString(out, publrecord);
        WritableUtils.writeString(out, publtype);
        WritableUtils.writeStringArray(out, authors.toArray(new String[0]));
        out.writeInt(year);
        WritableUtils.writeString(out, journal);
    }

    /**
     * Deserialize the fields of this object from <code>in</code>.
     *
     * <p>For efficiency, implementations should attempt to re-use storage in the
     * existing object where possible.</p>
     *
     * @param in <code>DataInput</code> to deseriablize this object from.
     * @throws IOException
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        key = WritableUtils.readString(in);
        publrecord = WritableUtils.readString(in);
        publtype = WritableUtils.readString(in);
        authors = Arrays.asList(WritableUtils.readStringArray(in));
        year = in.readInt();
        journal = WritableUtils.readString(in);
    }
}
