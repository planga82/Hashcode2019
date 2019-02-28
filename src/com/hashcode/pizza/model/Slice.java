package com.hashcode.pizza.model;

public class Slice {

	int posRowIni;
	int posColIni;
	int rows;
	int cols;
	public Slice(int posRowIni, int posColIni, int rows, int cols) {
		super();
		this.posRowIni = posRowIni;
		this.posColIni = posColIni;
		this.rows = rows;
		this.cols = cols;
	}
	
	
	@Override
	public String toString(){
		return "[" + posRowIni + "," + posColIni + "]" + "["+ rows + "," + cols + "]";

	}
	
	
	
	
}
