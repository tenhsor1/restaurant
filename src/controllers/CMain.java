package controllers;

import views.VMain;

public class CMain {
	static VMain vista;
	public static void main(String[] args) {
		vista = new VMain();	
		vista.iniciarVista();
	}
}
