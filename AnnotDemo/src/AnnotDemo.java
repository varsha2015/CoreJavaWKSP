
import java.lang.annotation.*;
import java.lang.reflect.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface test{
	String author();
	String fileName();
}
class AnnotationUser{
	@test(author="varsha" ,fileName="abc.txt")
	public void show(){
		System.out.println(" Show is invoked....");
	}
}
class AnnotationProcessor{
	public void parseAnnotation(){
		Class cla=AnnotationUser.class;
		
		try {
			Method m[]=AnnotationUser.class.getMethods();
			for(Method met:m){
			if(met.isAnnotationPresent(test.class))
			{
				met.invoke(new AnnotationUser());
			}
			 
			}
			
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


public class AnnotDemo {

	public static void main(String[] args) {
		
		AnnotationUser annot=new AnnotationUser();
		
		AnnotationProcessor process=new AnnotationProcessor();
		
		process.parseAnnotation();

	}

}
