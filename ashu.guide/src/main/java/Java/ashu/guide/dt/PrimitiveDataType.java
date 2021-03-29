/**
 * 
 */
package Java.ashu.guide.dt;

/**
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
	boolean bln_min = Boolean.FALSE ;
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
		System.out.println("Char Minimum : "+chr_min+ " , Char Max : "+ chr_max);
		
	}
}
