package com.ashessin.cs441.hw2.dblp;

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
    private int year;
    private String publtype;
    private String publrecord;
    private List<String> authors;
    private String journal;

    PublicationWritable() {
    }

    PublicationWritable(String key, @Nullable int year, @Nullable String publtype, String publrecord, @Nullable ArrayList<String> authors, @Nullable String journal) {
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
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "key=\"" + key + "\", publrecord=\"" + publrecord + "\" year=" + year + ", publtype=\"" + publtype
                + "\" authors=" + this.authors + "\" journal=\"" + this.journal + "\"";
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
        out.writeInt(year);
        WritableUtils.writeString(out, publtype);
        WritableUtils.writeString(out, publrecord);
        WritableUtils.writeStringArray(out, authors.toArray(new String[0]));
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
        year = in.readInt();
        publtype = WritableUtils.readString(in);
        publrecord = WritableUtils.readString(in);
        authors = Arrays.asList(WritableUtils.readStringArray(in));
        journal = WritableUtils.readString(in);
    }
}
