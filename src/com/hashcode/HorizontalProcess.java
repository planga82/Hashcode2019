package com.hashcode;

import com.hashcode.slideshow.Slide;
import com.hashcode.slideshow.SlideShow;

import java.util.Iterator;
import java.util.List;

public class HorizontalProcess {

    public SlideShow process(List<Slide> disponibleSlides){
        SlideShow ret = new SlideShow();

        Iterator<Slide> it = disponibleSlides.iterator();

        Slide slide1 = it.next();
        Slide slide2 = it.next();

        ret.slides.add(slide1);
        ret.slides.add(slide2);
        disponibleSlides.remove(slide1);
        disponibleSlides.remove(slide2);

        boolean mejoramos = true;
        while(mejoramos && disponibleSlides.size() > 0){
            mejoramos = false;

            for(int reti = 0; reti < ret.slides.size()-1 ; reti++){

                Iterator<Slide> itDisp = disponibleSlides.iterator();
                while(itDisp.hasNext() && !mejoramos){
                    Slide procesable = itDisp.next();
                    if(insertamosSlide(ret.slides.get(reti),ret.slides.get(reti+1),procesable)){
                        ret.slides.add(reti+1,procesable);
                        disponibleSlides.remove(procesable);
                        mejoramos = true;
                    }
                }
                if(mejoramos){
                    break;
                }
            }

            if(!mejoramos){
                Slide s = disponibleSlides.get(0);
                ret.slides.add(s);
                disponibleSlides.remove(s);
            }
        }
        return ret;

    }

    public boolean insertamosSlide(Slide slide1, Slide slide2, Slide slideObjetivo){
        int coincidenciasActuales = slide1.getCoincidencias(slide2);

        int nuevasConcidencias = slide1.getCoincidencias(slideObjetivo) + slideObjetivo.getCoincidencias(slide2);

        return nuevasConcidencias> coincidenciasActuales;
    }

}
