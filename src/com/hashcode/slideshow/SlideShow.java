package com.hashcode.slideshow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SlideShow {

    public List<Slide> slides = new LinkedList<>();
    
    public void write(String file) throws IOException {
   
    	FileWriter fw = new FileWriter(new File(file));
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(slides.size());
		bw.newLine();
		for(Slide s: slides) {
			for(Photo p : s.elements) {
				bw.write(p.id);
				bw.write(' ');
			}
			bw.newLine();
		}
		bw.close();
		fw.close();
		
    }
}
