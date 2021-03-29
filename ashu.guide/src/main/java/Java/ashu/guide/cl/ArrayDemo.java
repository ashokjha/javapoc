/**
 * 
 */
package Java.ashu.guide.cl;

/**
 * <b>Array collection of same data type:  </b> <BR>
 * 
 * <strong>The length of an array is established when the array is created. After creation, its length is fixed. </strong>
 * @author Ashok Kumar Jha
 *
 */
public interface ArrayDemo {
	public static void cpOfRange() {
		char[] copyFrom = { 'h', 't', 't', 'p', 's', ':', '/', '/', 'g', 'i', 't', 'h', 'u', 'b', '.', 'c', 'o', 'm' };

		char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 8, 14);

		System.out.println(new String(copyTo));
		System.out.println(copyTo);
	}

	public static void cp() {
		char[] copyFrom = { 'h', 't', 't', 'p', 's', ':', '/', '/', 'g', 'i', 't', 'h', 'u', 'b', '.', 'c', 'o', 'm' };
		char[] copyTo = new char[7];
		System.arraycopy(copyFrom, 11, copyTo, 0, 7);
		System.out.println(new String(copyTo));
	}
}