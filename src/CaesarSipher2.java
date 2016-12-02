import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CaesarSipher2 {
	
	private static String message;
	private String alpha;
	private String ALPHA;
	private String alphaShift1;
	private String ALPHAShift1;
	private String alphaShift2;
	private String ALPHAShift2;
	
	public CaesarSipher2(int key1, int key2, String filename) throws FileNotFoundException {
		ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		alpha = "abcdefghijklmnopqrstuvwxyz";
		ALPHAShift1= ALPHA.substring(key1)+ALPHA.substring(0, key1);
		alphaShift1= alpha.substring(key1)+alpha.substring(0, key1);
		ALPHAShift2= ALPHA.substring(key2)+ALPHA.substring(0, key2);
		alphaShift2= alpha.substring(key2)+alpha.substring(0, key2);
		
		message="";
		File f = new File(filename);
		Scanner sc = new Scanner(f);
		while( sc.hasNextLine()){
			message=message+sc.nextLine()+"\n";
		}
		
	}

	
	/*	
	public static void main(String[] args) {
		//CaesarSipher2 cc = new CaesarSipher2(4,7,"message.txt");
		//System.out.println(message);

	}*/

}
