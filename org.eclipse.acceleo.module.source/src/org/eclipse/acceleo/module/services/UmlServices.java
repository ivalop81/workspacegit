package org.eclipse.acceleo.module.services;
import org.eclipse.uml2.uml.*;
import java.util.*;
import java.lang.String;

public class UmlServices {	
	
	public boolean hasStereotype(Element elt, String stereotype){
		  for (Stereotype st : elt.getAppliedStereotypes()) {
	            if (st.getName().equals(stereotype)) {
	               return true;
	            }
	        }
	        return false;	        
	}
		
	int id=0;
	String last= new String();
	public String loadInserts(Element elt, String nombre, String label, String comment){
		if (nombre != last && id ==0)
			id++;
		else
			if (nombre != last)
				id =1;
		last = nombre;
		String result = new String("INSERT INTO ").concat(nombre.toLowerCase());
		result = result.concat(" VALUES (" + id + ", \'");
		result = result.concat(label.toLowerCase().concat("\' , \'"));
		result = result.concat(comment).concat("\');");
		id++;
		return result;
	}
	
	public List<Object> getSources(Element elt, String cadena, String tipo){
		String result[];
		String insert = new String();
		List<Object> lista = new ArrayList<Object>();
		String cad[];
			int cuantas = 1;
		cad= cadena.split("");
		for(int j=0; j<cad.length; j++){
			if(cad[j].contains(","))
				cuantas++;
		}
		cadena = cadena.trim();
		cadena = cadena.replaceAll(" ", "");
		cadena = cadena.replace("{", " ").replace("}", " ").replace(",", " ").replace("=", " ");
		cadena = cadena.trim();
		result = cadena.split(" ");
		lista.add(tipo);			
		/*for(int i = 0; i <(cuantas*2); i=i+2 ){
		/*	insert = loadInserts(elt, tipo.toLowerCase().concat("_").concat(result[i].trim()), result[i+1].trim(), "");
			lista.add(insert.concat("\n"));*/
		for(int i = 0; i < cuantas*2; i++ ){
			lista.add(result[i].trim());
		}
		Iterator iter= lista.listIterator();
		while (iter.hasNext())
			System.out.println(iter.next());
		return lista;
	}
	
	public String createLoadScript(Element elt, List<Object> lista){
		String cadena = new String();
		System.out.println("entra a create load ");
		return cadena;
	}
	
	public List<Object> getTaggedValue(Element element, Stereotype stereotype, String property) {
		System.out.println("entra a getTagged value");
		List<Object> result = new ArrayList<Object>();
		Object value = element.getValue(stereotype, property);
		if (value instanceof Collection) 
			result.addAll((Collection)value);
		else
			result.add(value);
			
		return result;
		}
}

