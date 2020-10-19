package edu.pitt.cmpinf401.lab9;

public class Rectangle {
	int width, height, id;
	String color; 
	
	public Rectangle(int rid, int w, int h, String c) {
		id=rid;
		width=w;
		height=h;
		color=c;		
	}
	
	public String toString() {
		return color+ " "+width+" x "+height +" rectangle.";
	}
}
