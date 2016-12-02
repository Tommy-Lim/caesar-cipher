import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CaesarSipher {

	private static String message;
	private static String alpha;
	private static String ALPHA;
	private static String alphaShift1;
	private static String ALPHAShift1;
	private static int mainKey;
	
	
	public CaesarSipher(int key1, String filename) throws FileNotFoundException {
		mainKey=key1;
		ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		alpha = "abcdefghijklmnopqrstuvwxyz";
		ALPHAShift1= ALPHA.substring(key1)+ALPHA.substring(0, key1);
		alphaShift1= alpha.substring(key1)+alpha.substring(0, key1);
		
		message="";
		File f = new File(filename);
		Scanner sc = new Scanner(f);
		while( sc.hasNextLine()){
			message=message+sc.nextLine()+"\n";
		}
		System.out.println("The original message is: "+message);
	}

	
	public static void main(String[] args) throws IOException {
		CaesarSipher cc = new CaesarSipher(1,"message.txt");
		encrypt(message);
		decrypt(encrypt(message));
		//letterCount(encrypt(message));
	}
	
	
	public static String encrypt(String message) throws IOException{
		String encrypted="";
		for(int k=0; k<message.length();k++){	
				if(ALPHA.indexOf(message.charAt(k))==-1&&alpha.indexOf(message.charAt(k))==-1){
					//System.out.print(" ");
					encrypted=encrypted+message.charAt(k);
				} else if(alpha.indexOf(message.charAt(k))==-1) {
					//System.out.print(alphaShift.charAt(alpha.indexOf(message.charAt(k))));
					encrypted=encrypted+ALPHAShift1.charAt(ALPHA.indexOf(message.charAt(k)));
				} else {
					//System.out.print(alphaShift.charAt(alpha.indexOf(message.charAt(k))));
					encrypted=encrypted+alphaShift1.charAt(alpha.indexOf(message.charAt(k)));
				}				
		}
		System.out.println("The encrypted mesage is: "+encrypted);
		return encrypted;
	}
	
	
	public static String decrypt(String message) throws IOException{
		String decrypted="";
		CaesarSipher cc = new CaesarSipher(26-mainKey,"message.txt");
		for(int k=0; k<message.length();k++){	
				if(ALPHA.indexOf(message.charAt(k))==-1&&alpha.indexOf(message.charAt(k))==-1){
					//System.out.print(" ");
					decrypted=decrypted+message.charAt(k);
				} else if(alpha.indexOf(message.charAt(k))==-1) {
					//System.out.print(alphaShift.charAt(alpha.indexOf(message.charAt(k))));
					decrypted=decrypted+ALPHAShift1.charAt(ALPHA.indexOf(message.charAt(k)));
				} else {
					//System.out.print(alphaShift.charAt(alpha.indexOf(message.charAt(k))));
					decrypted=decrypted+alphaShift1.charAt(alpha.indexOf(message.charAt(k)));
				}				
		}
		System.out.println("The decrypted mesage is: "+decrypted);
		return decrypted;
	}

	
	public static void letterCount(String messageE) throws FileNotFoundException{
		int[] counts1 = new int[26];
		for(int i=0; i<messageE.length(); i++){

				if(alpha.indexOf(messageE.charAt(i))!=-1){
					counts1[alpha.indexOf(messageE.charAt(i))]++;
				}
				if(ALPHA.indexOf(messageE.charAt(i))!=-1){
					counts1[ALPHA.indexOf(messageE.charAt(i))]++;
				}	
		}
		for (int i=0; i<counts1.length; i++){
			//System.out.println(ALPHA.charAt(i)+" at index "+i+" count1 is: "+counts1[i]);
		}
		char maxchar1='\0';
		int maxnumber1=0;
		int index1=0;
		for (int i=0; i<counts1.length; i++){
			//System.out.println(alpha.charAt(i)+" count is: "+counts[i]);
			if(counts1[i]>maxnumber1){
				maxchar1=ALPHA.charAt(i);
				maxnumber1=counts1[i];
				index1=i;
			}
		}
		//System.out.println("Most shown letter in count1 is \""+maxchar1+"\" at "+maxnumber1+" times");
		index1=26-index1+4;
		if(index1>26){
			index1=index1-26;
		}
		System.out.println("Key based on \"E\" being most common is: "+index1);
	}
	
	
}
