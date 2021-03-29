/**
 * 
 */
package Java.ashu.guide.dt;

/**
 * <h1>Primitive Type!</h1>
 * <table>
 * <tr>
 * <th>Data Type</th>
 * <th>Default Value (for fields)</th>
 * </tr>
 * <tr>
 * <td>byte</td>
 * <td>0</td>
 * </tr>
 * <tr>
 * <td>short</td>
 * <td>0</td>
 * </tr>
 * <tr>
 * <td>int</td>
 * <td>0</td>
 * </tr>
 * <tr>
 * <td>long</td>
 * <td>0L</td>
 * </tr>
 * <tr>
 * <td>float</td>
 * <td>0.0f</td>
 * </tr>
 * <tr>
 * <td>double</td>
 * <td>0.0d</td>
 * </tr>
 * <tr>
 * <td>char</td>
 * <td>'\u0000'</td>
 * </tr>
 * <tr>
 * <td>String (or any object)</td>
 * <td>null</td>
 * </tr>
 * <tr>
 * <td>boolean</td>
 * <td>false</td>
 * </tr>
 * </table>
 * 
 * 
 * <p>
 * Local variables are slightly different; the compiler never assigns a default
 * value to an uninitialized local variable. If you cannot initialize your local
 * variable where it is declared, make sure to assign it a value before you
 * attempt to use it. Accessing an uninitialized local variable will result in a
 * compile-time error.
 * 
 * Literals
 * </p>
 * 
 * @author Ashok Kumar Jha
 *
 */
public interface PrimitiveDataType {

	byte bt_max = Byte.MAX_VALUE;
	byte bt_min = Byte.MIN_VALUE;
	short st_max = Short.MAX_VALUE;
	short st_min = Short.MIN_VALUE;
	int int_max = Integer.MAX_VALUE;
	int int_min = Integer.MIN_VALUE;
	long lng_max = Long.MAX_VALUE;
	long lng_min = Long.MIN_VALUE;
	float flt_max = Float.MAX_VALUE;
	float flt_min = Float.MIN_VALUE;
	double dbl_max = Double.MAX_VALUE;
	double dbl_min = Double.MIN_VALUE;
	boolean bln_max = Boolean.TRUE;
	boolean bln_min = Boolean.FALSE;
	char chr_max = Character.MAX_VALUE;
	char chr_min = Character.MIN_VALUE;

	/**
	 * Describe every primitive
	 */
	static void describe() {
		System.out.printf("byte Minimum : %d  , byte Max = %d  \n", bt_min, bt_max);
		System.out.printf("short Minimum : %d , short Max = %d \n", st_min, st_max);
		System.out.printf("int Minimum : %d   , int Max = %d \n", int_min, int_max);
		System.out.printf("long Minimum : %d ,  long Max = %d \n", lng_min, lng_max);
		System.out.printf("Float Minimum : %f ,Float Max = %f  \n", flt_min, flt_max);
		System.out.printf("Double Minimum : %f ,Double Max = %f \n", dbl_min, dbl_max);
		System.out.printf("Boolean Minimum : %b ,Boolean Max = %b \n", bln_min, bln_max);
		System.out.println("Char Minimum : " + chr_min + " , Char Max : " + chr_max);
	}

	static void literals() {
		// Literals
		boolean result = true;
		char capitalC = 'C';
		byte b = 100;
		short s = 10000;
		int i = 100000;
		System.out.println(result);
		System.out.println(capitalC);
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		// Integer Literals
		// The number 26, in decimal
		int decVal = 26;
		// The number 26, in hexadecimal
		int hexVal = 0x1a;
		// The number 26, in binary
		int binVal = 0b11010;
		/// Floating-Point Literals
		System.out.println(decVal);
		System.out.println(hexVal);
		System.out.println(binVal);
		double d1 = 123.4;
		// same value as d1, but in scientific notation
		double d2 = 1.234e2;
		float f1 = 123.4f;
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(f1);
		// Character and String Literals
		long creditCardNumber = 1234_5678_9012_3456L;
		long socialSecurityNumber = 999_99_9999L;
		System.out.println(creditCardNumber);
		System.out.println(socialSecurityNumber);
		
		float pi = 3.14_15F;
		long hexBytes = 0xFF_EC_DE_5E;
		long hexWords = 0xCAFE_BABE;
		long maxLong = 0x7fff_ffff_ffff_ffffL;
		byte nybbles = 0b0010_0101;
		long bytes = 0b11010010_01101001_10010100_10010010;
		System.out.println(pi);
		System.out.println(hexBytes);
		System.out.println(hexWords);
		System.out.println(maxLong);
		System.out.println(nybbles);
		System.out.println(bytes);	
		// Invalid: cannot put underscores
		// adjacent to a decimal point
		// float pi1 = 3_.1415F;

		// Invalid: cannot put underscores
		// adjacent to a decimal point
		// float pi2 = 3._1415F;

		// Invalid: cannot put underscores
		// prior to an L suffix
		// long socialSecurityNumber1 = 999_99_9999_L;

		// OK (decimal literal)
		int x1 = 5_2;
		// Invalid: cannot put underscores
		// At the end of a literal
		// int x2 = 52_;
		// OK (decimal literal)
		int x3 = 5_______2;

		// Invalid: cannot put underscores
		// in the 0x radix prefix
		// int x4 = 0_x52;
		// Invalid: cannot put underscores
		// at the beginning of a number
		// int x5 = 0x_52;
		// OK (hexadecimal literal)
		int x6 = 0x5_2;
		// Invalid: cannot put underscores
		// at the end of a number
		// int x7 = 0x52_;
		System.out.println(x1);
		System.out.println(x3);
		System.out.println(x6);
	}
}
