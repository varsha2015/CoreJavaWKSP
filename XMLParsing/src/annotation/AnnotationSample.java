package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationSample {
	public static void main(String...args) {
		TestClass o = new TestClass();
		boolean annotationFound;
		for(Method m : o.getClass().getMethods()) {
			annotationFound = false;
			//System.out.println(m.toString());
			for(Annotation a : m.getAnnotations()) {
				if(a instanceof Test) {
					annotationFound = true;
					break;
				}
			}
			if(annotationFound)
				try {
					m.invoke(o);
				} catch (IllegalArgumentException ex) {
					ex.printStackTrace();
				} catch (IllegalAccessException ex) {
					ex.printStackTrace();
				} catch (InvocationTargetException ex) {
					ex.printStackTrace();
				}
		}
	}
}
