
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
		
		public String loadInserts(Element elt, String nombre, String label, String comment){
			String result = new String("INSERT INTO ").concat(nombre.toLowerCase());
			result = result.concat(" VALUES (");
			result = result.concat(label.toLowerCase().concat(" , "));
			result = result.concat(comment).concat(");");
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
			
			for(int i = 0; i <(cuantas*2); i=i+2 ){
				insert = loadInserts(elt, tipo.toLowerCase().concat("_").concat(result[i].trim()), result[i+1].trim(), "");
				lista.add(insert.concat("\n"));
			}
			/*Iterator iter= lista.listIterator();
			while (iter.hasNext())
				System.out.println("insert " + iter.next());*/
			return lista;
		}
		
		public List<Object> getTaggedValue(Element element, Stereotype stereotype, String property) {
			
			List<Object> result = new ArrayList<Object>();
			Object value = element.getValue(stereotype, property);
			result.add(value);
			System.out.println(result);
			return result;
		}
		
		/*aca empiezan los metodos de las reglas*/
		public boolean isGeneral(Element elt, String ruletype){
			if(ruletype.equals("General"))
				return true;
			else
				return false;
		}
		
		public String getSourceType(Element elt, String ocl, String source){
			String cadena = new String();
			int i, j;
			ocl = ocl.trim();
			i = ocl.indexOf(source)+source.length()+1;
			j = ocl.indexOf('=');
			cadena = ocl.substring(i, j);
			cadena = cadena.trim();
			return cadena;
		}
}
