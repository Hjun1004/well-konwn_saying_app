package org.example.well_known.entity;

import java.util.Scanner;

public class Well_Known {
    private int id ;
    private String writer;
    private String content;

    //private int count = 0;

    public void setId(int id) {
        this.id = id;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setWell(String well) {
        this.content = well;
    }

    public int getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getWell() {
        return content;
    }

    public Well_Known(int id, String writer, String well) {
        this.id = id;
        this.writer = writer;
        this.content = well;
    }
}
