package Java.ashu.guide;

import Java.ashu.guide.cl.ClassLoaderDemo;

/**
 * Class loader
 *
 */
public class Driver {
	
	public static void main(String[] args) {
		Driver.pocClassLoader();
	}
	
	
	
	
	public static void pocClassLoader() {
		
		// classloader name of current class.
		// Application/System classloader will load this class

		Class<ClassLoaderDemo> c = ClassLoaderDemo.class;

		System.out.println(c.getClassLoader());
		try {
			ClassLoaderDemo obj = c.newInstance();
			obj.hello();
			
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		}

		// If we print the classloader name of String, it will print null because it is
		// an
		// in-built class which is found in rt.jar, so it is loaded by Bootstrap
		// classlośader
		System.out.println(String.class.getClassLoader());
	}

}
