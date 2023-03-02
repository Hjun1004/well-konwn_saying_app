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
            String 커맨드 = sc.nextLine();



            if(커맨드.trim().equals("등록")){
                al.add(new Well_Known());
                al.get(count).등록(count+1);
                count++;
                System.out.println(count + "번 명언이 등록되었습니다.");
            }

            //System.out.println(al.get(0).getWell());

            if(커맨드.trim().equals("목록")){
                System.out.println("번호 / 작가 / 명언\n------------------------------");
                for(int i = count-1 ; i>=0 ; i--){
                    if(al.get(i).getId() != 0)
                        System.out.printf("%d / %s / %s \n",al.get(i).getId(),al.get(i).getWriter(), al.get(i).getWell());
                }
            }

            if(커맨드.substring(0,2).equals("삭제")){
                String intStr = 커맨드.replaceAll("[^0-9]","");
                int delete_num = Integer.parseInt(intStr);
                if(al.get(delete_num-1).getId() != delete_num){
                    System.out.println(delete_num + "번 명언은 존재하지 않습니다.");
                }
                else {
                    for(Well_Known sg : al){
                        if(sg.getId() == delete_num){
                            sg.setId(0);
                            sg.setWell(null);
                            sg.setWriter(null);
                        }
                    }
                    //al.remove(delete_num-1);
                    System.out.println(delete_num + "번 명언이 삭제되었습니다.");
                    //count;
                }

            }

            if(커맨드.substring(0,2).equals("수정")) {
                String intStr = 커맨드.replaceAll("[^0-9]", "");
                int Re = Integer.parseInt(intStr);
                System.out.println("명언(기존) : " + al.get(Re-1).getWell());
                System.out.print("명언 : ");
                al.get(Re-1).setWell(sc.nextLine());
                System.out.println("작가(기존) : " + al.get(Re-1).getWriter());
                System.out.print("작가 : ");
                al.get(Re-1).setWriter(sc.nextLine());
            }


            /*for(Well_Known sg : al){
                if(sg.getId() != 0)
                {
                    System.out.printf("%d / %s / %s \n",sg.getId(),sg.getWriter(), sg.getWell());
                }

            }*/

            if(커맨드.trim().equals("종료")){
                break;
            }
        }



    }
}

class Well_Known{
    private int id;
    private String writer;
    private String well;

    //private int count = 0;

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

    void 등록(int count){
        Scanner sc = new Scanner(System.in);
        System.out.print("명언 : ");
        String known = sc.nextLine().trim();
        System.out.print("작가 : ");
        String name = sc.nextLine().trim();
        this.well = known;
        this.writer = name;
        this.id = count;

    }

}