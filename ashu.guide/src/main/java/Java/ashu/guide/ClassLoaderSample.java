package Java.ashu.guide;

/**
 * Class loader
 *
 */
public class ClassLoaderSample {
	public static void main(String[] args) {
		// classloader name of current class.
		// Application/System classloader will load this class

		Class c = ClassLoaderSample.class;

		System.out.println(c.getClassLoader());

		// If we print the classloader name of String, it will print null because it is
		// an
		// in-built class which is found in rt.jar, so it is loaded by Bootstrap
		// classlośader
		System.out.println(String.class.getClassLoader());
	}

}
