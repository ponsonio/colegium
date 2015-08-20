package org.domain.colegium.session.bean;

import java.io.Serializable;
import java.util.ArrayList;

import org.jboss.seam.annotations.Name;

@Name("item")
public class Item implements Serializable{

	String nombre;

	ArrayList<String> valores ;

	public Item(String nombre, ArrayList<String> valores) {
		super();
		this.nombre = nombre;
		this.valores = valores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getValores() {
		return valores;
	}

	public void setValores(ArrayList<String> valores) {
		this.valores = valores;
	}
	
	
	
}
