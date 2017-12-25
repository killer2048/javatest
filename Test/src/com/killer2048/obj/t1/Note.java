package com.killer2048.obj.t1;

public class Note {
	char color;
	int cpu;
	public Note(char color, int cpu) {
		this.color = color;
		this.cpu = cpu;
	}
	public Note() {
	}
	
	public void show() {
		System.out.println(this.color+" "+this.cpu);
	}
	
	
	
	public static void main(String[] args) {
		Note n = new Note('\u9999',56415);
		n.show();
	}
}
