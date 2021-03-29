package Java.ashu.guide;

import Java.ashu.guide.cl.ArrayDemo;
import Java.ashu.guide.cl.ClassLoaderDemo;
import Java.ashu.guide.dt.PrimitiveDataType;

/**
 * Class loader
 * @author Ashok Kumar Jha
 * 
 */
public class Driver {

	public static void main(String[] args) {
		int key = 1;
		switch (key) {
		case 1:
			ArrayDemo.cpOfRange();
			ArrayDemo.cp();
			break;
		case 14:
			PrimitiveDataType.describe();
			PrimitiveDataType.literals();
			break;
		case 15:
			Driver.pocClassLoader();
			break;
		default:
			System.out.println("Here to help you ; Dial required number!");
			break;
		}

	}

	/**
	 * Class loader POC
	 */
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
