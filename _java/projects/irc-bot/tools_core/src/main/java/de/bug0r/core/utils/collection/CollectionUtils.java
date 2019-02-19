/**
 * 
 */
package de.bug0r.core.utils.collection;

import java.util.Collection;
import java.util.Map;

/**
 * @author bug0r
 *
 */
public class CollectionUtils {

	public static boolean isEmpty(Collection<?> collection) {
		return null == collection || collection.isEmpty();
	}
	
	public static boolean isEmpty(Map<?,?> map) {
		return null == map || map.isEmpty();
	}
	
	public static boolean areAllNotNull(Object...values) {
		boolean result = true;
		for ( Object o: values ) {
			result = result && (o!=null);
			if (!result) break;
		}
		return result;
	}
}
