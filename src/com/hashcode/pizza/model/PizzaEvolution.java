package com.hashcode.pizza.model;

import com.hashcode.generic.Node;
import java.util.*;

public class PizzaEvolution implements Node, Cloneable {

	//Base pizza
	Pizza pizza;

	//Evolution
	Cell[][] base;
	Stack<Slice> selectedSlices;
    Stack<Iterator<Slice>> totalSlices;

    private PizzaEvolution(){};

	public PizzaEvolution(Pizza pizza) {
		this.pizza = pizza;
		initializeBaseState(pizza);

		this.selectedSlices = new Stack<>();

		this.totalSlices = new Stack<>();
		this.totalSlices.push(GeneradorSlice.getInstance(pizza).getSlices());

	}

	private void initializeBaseState(Pizza pizza){
		base = new Cell[pizza.rows][pizza.cols];
		for (int i = 0; i < pizza.rows; i++) {
			for (int j = 0; j < pizza.cols; j++) {
				base[i][j] = new Cell(pizza.base[i][j],false);
			}
		}
	}


	@Override
	public int getWeigth() {
        int puntos = 0;
        for (int i = 0; i < pizza.rows; i++) {
            for (int j = 0; j < pizza.cols; j++) {
                if(this.base[i][j].withSlice){
                    puntos++;
                }
            }
        }
        return puntos;
	}



	@Override
	public boolean updateStateNextChild() {
		//System.out.println("Init updateStateNextChild:" + System.currentTimeMillis());
		while (totalSlices.peek().hasNext()) {
			Slice nextSlice = totalSlices.peek().next();
			if (!CompruebaRestricciones.pisaOtroSlice(this, nextSlice)) {
				this.updateState(nextSlice);
				return true;
			}
		}
		//System.out.println("End updateStateNextChild:" + System.currentTimeMillis());
		return false;

	}

    private void updateState(Slice s){
		//System.out.println("Init update:" + System.currentTimeMillis());
        this.selectedSlices.push(s);
        this.totalSlices.push(GeneradorSlice.getInstance(pizza).getSlices());
        for (int i = s.posRowIni; i < s.posRowIni + s.rows; i++) {
            for (int j = s.posColIni; j < s.posColIni + s.cols; j++) {
                this.base[i][j].withSlice = true;
            }
        }
		//System.out.println("End update:" + System.currentTimeMillis());
    }

	@Override
	public void rollBackState() {
		//System.out.println("Init rollback:" + System.currentTimeMillis());
		Slice s = this.selectedSlices.pop();
        this.totalSlices.pop();
		for (int i = s.posRowIni; i < s.posRowIni + s.rows; i++) {
			for (int j = s.posColIni; j < s.posColIni + s.cols; j++) {
				this.base[i][j].withSlice = false;
			}
		}
		//System.out.println("End rollback:" + System.currentTimeMillis());
	}


	@Override
	public void printSolution(String fileName) {
		try {
			Utils.writeFile("/data/tmp/" + fileName + "Output-" + getWeigth() + "-Max-" + pizza.cols * pizza.rows, this.toFileNames());
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}


	public List<String> toFileNames(){
        ArrayList<String> ret = new ArrayList<>();
        ret.add(String.valueOf(selectedSlices.size()));
        for (Slice slice : selectedSlices) {
            String linea = String.valueOf(slice.posRowIni) + " " + String.valueOf(slice.posColIni) + " " +
                    String.valueOf(slice.posRowIni + slice.rows -1) + " " + String.valueOf(slice.posColIni + slice.cols-1);
            ret.add(linea);
        }
        System.out.println("toFileNames - " + ret.size() + " Time:" +  System.currentTimeMillis());
        return ret;
    }

    @Override
	public int numChilds(){
		return GeneradorSlice.getInstance(pizza).listTotalSilces.size() / 2;
	}


}
