package com.ashessin.cs441.hw2.dblp.utils;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

import javax.annotation.Nullable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * DBLP Publication WritableComparable class to serialize and deserialize publication records.
 */
public class PublicationWritable implements WritableComparable<PublicationWritable> {
    private String key;
    private String publrecord;
    private String publtype;
    private List<String> authors;
    private List<String> editors;
    private int year;
    private String journal;
    private List<String> urls;
    private List<String> ees;
    private List<String> cites;
    private String crossref;
    private List<String> schools;


    PublicationWritable() {
    }

    PublicationWritable(String key, String publrecord, @Nullable String publtype) {
        this.key = key;
        this.publrecord = publrecord;
        this.publtype = publtype;
    }

    public PublicationWritable(String key, String publrecord, @Nullable String publtype, @Nullable List<String> authors,
                               @Nullable List<String> editors, int year, @Nullable String journal,
                               @Nullable List<String> urls, @Nullable List<String> ees, @Nullable List<String> cites,
                               @Nullable String crossref, @Nullable List<String> schools) {
        this.key = key;
        this.publrecord = publrecord;
        this.publtype = publtype;
        this.authors = authors;
        this.editors = editors;
        this.year = year;
        this.journal = journal;
        this.urls = urls;
        this.ees = ees;
        this.cites = cites;
        this.crossref = crossref;
        this.schools = schools;
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

    public List<String> getEditors() {
        return editors;
    }

    public void setEditors(List<String> editors) {
        this.editors = editors;
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

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getEes() {
        return ees;
    }

    public void setEes(List<String> ees) {
        this.ees = ees;
    }

    public List<String> getCites() {
        return cites;
    }

    public void setCites(List<String> cites) {
        this.cites = cites;
    }

    public String getCrossref() {
        return crossref;
    }

    public void setCrossref(String crossref) {
        this.crossref = crossref;
    }

    public List<String> getSchools() {
        return schools;
    }

    public void setSchools(List<String> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        return "key=\"" + key + "\", publrecord=\"" + publrecord + "\", publtype=\"" + publtype
                + "\", authors=" + this.authors + "\", editors=" + this.editors + ", year=" + year
                + ", journal=\"" + this.journal + "\", urls=" + this.urls + ", ees=" + this.ees
                + ", cites=" + this.cites + ", crossref=\"" + this.crossref + "\", schools=" + this.schools;
    }

    @Override
    public int compareTo(PublicationWritable publicationWritable) {
        return key.compareTo(publicationWritable.getKey());
    }

    /**
     * Serialize the fields of this object to <code>out</code>.
     *
     * @param out <code>DataOuput</code> to serialize this object into.
     * @throws IOException in case of input/output errors
     */
    @Override
    public void write(DataOutput out) throws IOException {
        WritableUtils.writeString(out, key);
        WritableUtils.writeString(out, publrecord);
        WritableUtils.writeString(out, publtype);
        WritableUtils.writeStringArray(out, authors.toArray(new String[0]));
        WritableUtils.writeStringArray(out, editors.toArray(new String[0]));
        out.writeInt(year);
        WritableUtils.writeString(out, journal);
        WritableUtils.writeStringArray(out, urls.toArray(new String[0]));
        WritableUtils.writeStringArray(out, ees.toArray(new String[0]));
        WritableUtils.writeStringArray(out, cites.toArray(new String[0]));
        WritableUtils.writeString(out, crossref);
        WritableUtils.writeStringArray(out, schools.toArray(new String[0]));
    }

    /**
     * Deserialize the fields of this object from <code>in</code>.
     *
     * <p>For efficiency, implementations should attempt to re-use storage in the
     * existing object where possible.</p>
     *
     * @param in <code>DataInput</code> to deseriablize this object from.
     * @throws IOException in case of input/output errors
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        key = WritableUtils.readString(in);
        publrecord = WritableUtils.readString(in);
        publtype = WritableUtils.readString(in);
        authors = Arrays.asList(WritableUtils.readStringArray(in));
        editors = Arrays.asList(WritableUtils.readStringArray(in));
        year = in.readInt();
        journal = WritableUtils.readString(in);
        urls = Arrays.asList(WritableUtils.readStringArray(in));
        ees = Arrays.asList(WritableUtils.readStringArray(in));
        cites = Arrays.asList(WritableUtils.readStringArray(in));
        crossref = WritableUtils.readString(in);
        schools = Arrays.asList(WritableUtils.readStringArray(in));
    }
}
