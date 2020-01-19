package com.example.mongo.entity;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class PatBinli {
    @Id
    private Integer id;
    private String patname;
    private String binli;
    private List<String> keyset = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatname() {
        return patname;
    }

    public void setPatname(String patname) {
        this.patname = patname;
    }

    public String getBinli() {
        return binli;
    }

    public void setBinli(String binli) {
        this.binli = binli;
    }

    public List<String> getKeyset() {
        return keyset;
    }

    public void setKeyset(List<String> keyset) {
        this.keyset = keyset;
    }

    public PatBinli() {
    }

    public PatBinli(Integer id, String patname, String binli) {
        this.id = id;
        this.patname = patname;
        this.binli = binli;
    }

    public PatBinli(Integer id, String patname, String binli, List<String> keyset) {
        this.id = id;
        this.patname = patname;
        this.binli = binli;
        this.keyset = keyset;
    }

    @Override
    public String toString() {
        return "PatBinli{" +
                "id=" + id +
                ", patname='" + patname + '\'' +
                ", binli='" + binli + '\'' +
                ", keyset=" + keyset +
                '}';
    }
}
