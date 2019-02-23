package com.hashcode.imp.model;

public class Cell {

	char ingrediente;
	boolean withSlice;
	
	
	
	public Cell(char ingrediente, boolean withSlice) {
		super();
		this.ingrediente = ingrediente;
		this.withSlice = withSlice;
	}
	public char getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(char ingrediente) {
		this.ingrediente = ingrediente;
	}
	public boolean isWithSlice() {
		return withSlice;
	}
	public void setWithSlice(boolean withSlice) {
		this.withSlice = withSlice;
	}
	
	
}
