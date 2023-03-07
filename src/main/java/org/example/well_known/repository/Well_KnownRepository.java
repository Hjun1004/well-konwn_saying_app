package org.example.well_known.repository;

import org.example.well_known.entity.Well_Known;

import java.util.ArrayList;
import java.util.List;

public class Well_KnownRepository {
    private List<Well_Known> al;
    private int lastid = 0;

    public Well_KnownRepository() {
        al = new ArrayList<>();
        lastid = 0;
    }


    public List<Well_Known> findAll(){
        return al;
    }

    public Well_Known findById(int id){
        for(Well_Known sg : al){
            if(sg.getId() == id){
                return sg;
            }
        }
        return null;
    }

    public int write(String content, String authorName) {
        int id = lastid+1;
        al.add(new Well_Known(id, content, authorName));
        //al.get(count).등록(++lastid);
        lastid = id; // 방금 새 명언이 생성되었으니

        return id;
    }

    public void remove(Well_Known wellKnown) {
        al.remove(wellKnown);
    }
    public void modify(Well_Known wellKnown ,String content, String authorName) {
        wellKnown.setWell(content);
        wellKnown.setWriter(authorName);
    }

}
