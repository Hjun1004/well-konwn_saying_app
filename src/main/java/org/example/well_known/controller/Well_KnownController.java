package org.example.well_known.controller;

import org.example.Container;
import org.example.Rq;
import org.example.service.Well_KnownService;
import org.example.well_known.entity.Well_Known;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Well_KnownController {

    private final Well_KnownService wellKnownService;

    private int count;

    int id = -1;

    public Well_KnownController(){
        wellKnownService = new Well_KnownService();
    }


    public void write(){
        System.out.print("명언 : ");
        String known = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String name = Container.getScanner().nextLine().trim();

        int id = wellKnownService.write(known, name);
        System.out.println( id + "번 명언이 등록되었습니다.");
    }

    public void list(){

        List<Well_Known> al = wellKnownService.findAll();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));

        for(Well_Known sg : al){
            System.out.printf("%d / %s / %s \n",sg.getId(), sg.getWriter(), sg.getWell());
        }
        //wellKnownService.list();
    }

    public void remove(Rq rq){
        id = rq.getIntParam("id", -1);
        if(id == -1){
            System.out.println("id를 입력해");
            return;
        }

        Well_Known wellKnown = wellKnownService.findById(id);

        if(wellKnown == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        wellKnownService.remove(wellKnown);
        //al.remove(wellKnown);
        System.out.println(id + "번 명언이 삭제되었습니다.");
        //wellKnownService.remove(rq);
    }

    public void modify(Rq rq){
        id = rq.getIntParam("id",-1);
        if(id == -1) System.out.println("id 입력해");

        Well_Known wellKnown = wellKnownService.findById(id);

        if(wellKnown == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + wellKnown.getWell());
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        //ss.setWell(Container.getScanner().nextLine());
        System.out.println("작가(기존) : " + wellKnown.getWriter());
        System.out.print("작가 : ");
        String authorName = Container.getScanner().nextLine().trim();
        //ss.setWriter(Container.getScanner().nextLine());

        wellKnownService.modify(wellKnown, content, authorName);
    }


}
