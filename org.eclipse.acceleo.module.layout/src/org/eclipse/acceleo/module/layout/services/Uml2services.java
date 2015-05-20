package org.eclipse.acceleo.module.layout.services;

import java.util.*;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Element;
import java.lang.String;

public class UML2Services {
	public boolean hasStereotype(Element element, String stereotypeName) {
		  List<Stereotype> stereotypes = element.getAppliedStereotypes();
		    for (Stereotype stereotype : stereotypes) {
		      if (stereotype.getName().equals(stereotypeName)) {
		        return true;
		      }
		    }
		    return false;
		  }
		public List<Object> getTaggedValue(Element element, Stereotype stereotype, String property) {
			
			List<Object> result = new ArrayList<Object>();
			Object value = element.getValue(stereotype, property);
			result.add(value);
			System.out.println(result);
			return result;
		}

		public static Stereotype getStereotype(Element element, String stereotypeName) { 
			List<Stereotype> stereotypes = element.getAppliedStereotypes(); 
			for (Stereotype stereotype : stereotypes) {
				if( stereotype.getName().equals(stereotypeName) ) 
				{ 
					return stereotype; 
				}	 
			} 
			return null; 
		} 

		public Object getValue(Element element, String stereotypeName, String propertyName) { 
			Stereotype stereotype = getStereotype(element, stereotypeName); 
			return element.getValue(stereotype, propertyName); 
		} 
} 