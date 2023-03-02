package org.example.명언앱_만들기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Well_Known> al = new ArrayList<>();
        int count=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 ==");
        while (true){
            System.out.print("명령) ");
            String sd = sc.nextLine();
            if("등록".equals(sd)){
                al.add(new Well_Known());
                al.get(0).등록();
                count++;
                System.out.println(count + "번 명언이 등록되었습니다.");

            }
            else if("종료".equals(sd)){
                break;
            }
        }



    }
}

class Well_Known{
    private int id;
    private String writer;
    private String well;

    private int count = 0;

    public void setId(int id) {
        this.id = id;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setWell(String well) {
        this.well = well;
    }

    public int getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getWell() {
        return well;
    }

    public int getCount(){
        return count;
    }

    void 등록(){
        Scanner sc = new Scanner(System.in);
        System.out.print("명언 : ");
        String known = sc.nextLine();
        System.out.print("작가 : ");
        String name = sc.nextLine();
        this.well = known;
        this.writer = name;


    }

}