package org.eclipse.acceleo.module.sample.services;
import java.util.*;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.*;
import java.lang.String;

public class UML2Services {
public boolean hasStereotype(Class clazz, String stereotypeName) {
  List<Stereotype> stereotypes = clazz.getAppliedStereotypes();
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

public static boolean hasStereotype2(Element element, String stereotypeName) { 
	Stereotype stereotype = getStereotype(element, stereotypeName); 
	return (stereotype!=null); 
} 

public Object getValue(Element element, String stereotypeName, String propertyName) { 
	Stereotype stereotype = getStereotype(element, stereotypeName); 
	return element.getValue(stereotype, propertyName); 
} 

}
