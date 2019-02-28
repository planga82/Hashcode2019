package com.hashcode.slideshow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Slide {

    List<Photo> elements = new LinkedList<>();

    private List<String> getTags(){
        List<String> ret = new ArrayList<>();
        for(int x = 0; x < elements.size(); x++){
            ret.addAll(elements.get(0).tags);
        }
        return ret;
    }

}
