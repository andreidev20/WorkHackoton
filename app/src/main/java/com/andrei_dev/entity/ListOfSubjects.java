package com.andrei_dev.entity;

import java.util.ArrayList;

/**
 * Created by annap on 04.12.2017.
 */

public class ListOfSubjects {
    private ArrayList<Subject> sublist = new ArrayList();

    public ListOfSubjects() {
    }
    public void add(Subject subject){
        sublist.add(subject);
    }

    public ArrayList<Subject> getSublist() {
        return sublist;
    }
}
