package org.example.명언앱_만들기;

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
    /*void 등록(int id){
        Scanner sc = new Scanner(System.in);
        System.out.print("명언 : ");
        String known = sc.nextLine().trim();
        System.out.print("작가 : ");
        String name = sc.nextLine().trim();
        this.well = known;
        this.writer = name;
        this.id = id;
    }*/
}
