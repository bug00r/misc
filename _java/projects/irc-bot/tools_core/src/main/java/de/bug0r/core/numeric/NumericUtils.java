package de.bug0r.core.numeric;

import java.util.ArrayList;
import java.util.List;

public class NumericUtils {

	private static List<Class> numericType;
	static {
		numericType = new ArrayList<Class>();
		numericType.add(Integer.class);
		numericType.add(Long.class);
		numericType.add(Float.class);
		numericType.add(Double.class);
	}
	
	public static boolean isNumeric(Object value) {
		boolean result = false;
		if ( numericType.contains(value.getClass()) ) {
			result = true;
		}
		return result;
	}
	
	public static boolean sameNumericRepresentation(Object...values) {
		boolean result = true;
		Class representation = null;
		for ( Object value: values ) {
			if ( isNumeric(value) ) {
				if ( null == representation ) {
					representation = value.getClass();
				} else {
					result = result && ( representation == value.getClass() );
					if ( !result ) break;
				}
			} else {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public static boolean isLower(Object lValue, Object rValue) {
		boolean result = false;
		if ( sameNumericRepresentation(lValue,rValue)) {
			if ( lValue.getClass() == Short.class ) return (Short)lValue < (Short)rValue;
			else if ( lValue.getClass() == Integer.class ) return (Integer)lValue < (Integer)rValue;
			else if ( lValue.getClass() == Long.class ) return (Long)lValue < (Long)rValue;
			else if ( lValue.getClass() == Float.class ) return (Float)lValue < (Float)rValue;
			else if ( lValue.getClass() == Double.class ) return (Double)lValue < (Double)rValue;
		}
		return result;
	}
	
}
