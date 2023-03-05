package org.example.well_known.controller;

import org.example.Container;
import org.example.Rq;
import org.example.well_known.entity.Well_Known;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Well_KnownController {
    private List<Well_Known> al = new ArrayList<>();
    //Rq rq = new Rq();
    private int count;
    private int lastid = 0;
    int id = -1;

    public void write(){
        System.out.print("명언 : ");
        String known = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String name = Container.getScanner().nextLine().trim();
        al.add(new Well_Known(++lastid, name, known));
        //al.get(count).등록(++lastid);
        count++;
        System.out.println( lastid + "번 명언이 등록되었습니다.");
    }

    public void list(){
        System.out.println("번호 / 작가 / 명언\n------------------------------");

        for(Well_Known sg : al){
            System.out.printf("%d / %s / %s \n",sg.getId(), sg.getWriter(), sg.getWell());
        }
    }

    public void remove(Rq rq){
        id = rq.getIntParam("id", -1);
        if(id == -1){
            System.out.println("id를 입력해");
            return;
        }

        Well_Known wellKnown = findById(id);
        if(wellKnown == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        al.remove(wellKnown);
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    public void modify(Rq rq){
        int mo_id = rq.getIntParam("id",-1);
        if(mo_id == -1) System.out.println("id 입력해");

        for(Well_Known ss : al){
            if(ss.getId() == mo_id){
                System.out.println("명언(기존) : " + ss.getWell());
                System.out.print("명언 : ");
                ss.setWell(Container.getScanner().nextLine());
                System.out.println("작가(기존) : " + ss.getWriter());
                System.out.print("작가 : ");
                ss.setWriter(Container.getScanner().nextLine());
            }
        }
    }

    private Well_Known findById(int id){
        for(Well_Known sg : al){
            if(sg.getId() == id){
                return sg;
            }
        }
        return null;
    }
}
