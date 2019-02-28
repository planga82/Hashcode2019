package com.hashcode.slideshow;

import java.util.LinkedList;
import java.util.List;

public class Photo {

    List<String> tags = new LinkedList<>();
    public int id;

	boolean vertival;
    
	public Photo(int i) {
		id = i;
	}
    
   
    public int getCoincidencias(Photo p) {
    	int num=0;
    	for(String s: tags) {

    		for(String str: p.tags){
    			int cmp = s.compareTo(str);
    			if(cmp == 0){
    				num++;
				}else if(cmp>1){
    				break;
				}
			}

    	}
    	
    	return num;
    }

}
