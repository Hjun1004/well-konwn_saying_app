package org.example.명언앱_만들기;

import org.example.well_known.Well_Known;

import java.util.*;

public class App {
    private Scanner sc;
    public App(Scanner sc){ // Main으로부터 new Scanner(System.in)이 들어왔다.
        this.sc = sc; // 그걸 App 에 있는 private Scanner sc 로 줬다.
    }
    void run(){
        List<Well_Known> al = new ArrayList<>();

        int count=0;
        int lastid = 0;
        int lastdel_num = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 ==");

        while (true){
            System.out.print("명령) ");
            String 커맨드 = sc.nextLine();



            if(커맨드.trim().equals("등록")){
                System.out.print("명언 : ");
                String known = sc.nextLine().trim();
                System.out.print("작가 : ");
                String name = sc.nextLine().trim();
                al.add(new Well_Known(++lastid, name, known));
                //al.get(count).등록(++lastid);
                count++;
                System.out.println( lastid + "번 명언이 등록되었습니다.");
            }

            if(커맨드.trim().equals("목록")){
                System.out.println("번호 / 작가 / 명언\n------------------------------");

                for(Well_Known sg : al){
                    System.out.printf("%d / %s / %s \n",sg.getId(), sg.getWriter(), sg.getWell());
                }
            }

            if(커맨드.startsWith("삭제"))
            {
                String[] commandBits = 커맨드.split("\\?", 2); // 최대 2개까지 나눈다.
                String actionCode = commandBits[0];
                Map<String, String> params = new HashMap<>();
                String[] ch_id = commandBits[1].split("=",2);

                params.put(ch_id[0], ch_id[1]);

                int delete_num = Integer.parseInt(params.get("id"));

                if(lastdel_num == delete_num){
                    System.out.println(delete_num + "번 명언은 존재하지 않습니다.");
                }

                int check = 0;
                for(int i = 0 ; i < al.size() ; i++){
                    if(al.get(i).getId() == delete_num) {
                        al.remove(i);
                        System.out.println(delete_num + "번 명언이 삭제되었습니다.");
                        lastdel_num = delete_num;
                    }
                }
            }

            /*if(커맨드.substring(0,2).equals("삭제")){
                String intStr = 커맨드.replaceAll("[^0-9]","");

                int delete_num = Integer.parseInt(intStr);
                int a;

                if(lastdel_num == delete_num){
                    System.out.println(delete_num + "번 명언은 존재하지 않습니다.");
                }

                int check = 0;
                for(int i = 0 ; i < al.size() ; i++){
                    if(al.get(i).getId() == delete_num) {
                        al.remove(i);
                        System.out.println(delete_num + "번 명언이 삭제되었습니다.");
                        lastdel_num = delete_num;
                    }
                }
                /*
                for(Well_Known sg : al){
                    if(sg.getId() == delete_num){
                        al.remove(i);
                        System.out.println(delete_num + "번 명언이 삭제되었습니다.");
                        //count--;
                        break;
                    }
                    else if(sg.getId() != delete_num){
                        System.out.println(delete_num + "번 명언은 존재하지 않습니다.");
                    }
                    i++;
                }*/
            //}

            if(커맨드.substring(0,2).equals("수정")) {
                String intStr = 커맨드.replaceAll("[^0-9]", "");
                int Re = Integer.parseInt(intStr);
                for(Well_Known sg : al){
                    if(sg.getId() == Re){
                        System.out.println("명언(기존) : " + sg.getWell());
                        System.out.print("명언 : ");
                        sg.setWell(sc.nextLine());
                        System.out.println("작가(기존) : " + sg.getWriter());
                        System.out.print("작가 : ");
                        sg.setWriter(sc.nextLine());
                    }
                }
            }

            if(커맨드.trim().equals("종료")){
                break;
            }
        }
    }
}
