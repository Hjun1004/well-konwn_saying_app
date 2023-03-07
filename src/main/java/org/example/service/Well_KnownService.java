package org.example.service;

import org.example.Container;
import org.example.Rq;
import org.example.well_known.entity.Well_Known;
import org.example.well_known.repository.Well_KnownRepository;

import java.util.ArrayList;
import java.util.List;

public class Well_KnownService {
    private final Well_KnownRepository wellKnownRepository;

    public Well_KnownService() {
        wellKnownRepository = new Well_KnownRepository();
    }


    public int write(String known, String name) {
        return wellKnownRepository.write(known, name);

    }

    public void remove(Well_Known wellKnown) {
        wellKnownRepository.remove(wellKnown);
    }

    public void modify(Well_Known wellKnown ,String content, String authorName) {
        wellKnownRepository.modify(wellKnown , content,  authorName);
    }

    public List<Well_Known> findAll() {
        return wellKnownRepository.findAll();
    }

    public Well_Known findById(int id) {
        return wellKnownRepository.findById(id);
    }
}
