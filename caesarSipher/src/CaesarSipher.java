import java.io.*;
import java.util.*;


public class CaesarSipher {
	
	public static void main(String[] args) throws IOException{
		
		//practiceProblems();
		
		
		//used for a full iteration of keys
		/*for(int i=0; i<=25; i++){
			for(int k=0; k<=25; k++){
				System.out.println(i+","+k+" "+SipherEncrypt(i,k, ""));  //use 26-key to decrypt
			}
		}*/
		
		//SipherEncrypt(9,22,"");
		//SipherDecrypt(19,"");
		//letterCount();
		//SipherEncrypt(9,22,"");
		//countWordLengths();
	}
	
	
	public static void countWordLengths() throws FileNotFoundException{
		//Assignment 1: Word lengths
		File f = new File("manywords.txt");
		Scanner sc = new Scanner(f);
		ArrayList<String> words = new ArrayList<String>();
		String word="";
		while(sc.hasNext()){
			word=sc.next();
			word=word.replace(",", "");
			word=word.replace(".", "");
			word=word.replace("?", "");
			word=word.replace(":", "");
			word=word.replace(";", "");
			word=word.replace("!", "");
			word=word.replace("\"", "");
			words.add(word);
		}
		int[] counts = new int[31];
		for(String object:words){
			if(object.length()>=30){
				counts[31]++;
			} else{
				counts[object.length()]++;
			}			
		}
		for(int i=0; i<counts.length; i++){
			//System.out.println(i+" letters long shown "+counts[i]+" number of times");
		}
		int maxcount=0;
		int maxlength=0;
		for(int i=0; i<counts.length; i++){
			if(counts[i]>maxcount){
				maxcount=counts[i];
				maxlength=i;
			}
		}
		System.out.println("Max length: "+maxlength+" and max count: "+maxcount);
		
		
		
		
	}
	
	
	public static void letterCount() throws FileNotFoundException{
		File f = new File("mysteryTwoKeysQuiz.txt");
		Scanner sc = new Scanner(f);
		String message = "";
		String alpha="abcdefghijklmnopqrstuvwxyz";
		String ALPHA="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		while( sc.hasNextLine()){
			message=message+sc.nextLine()+"\n";
		}
		int[] counts1 = new int[26];
		int[] counts2 = new int[26];
		for(int i=0; i<message.length(); i++){
			if(i%2==0){
				if(alpha.indexOf(message.charAt(i))!=-1){
					counts1[alpha.indexOf(message.charAt(i))]++;
				}
				if(ALPHA.indexOf(message.charAt(i))!=-1){
					counts1[ALPHA.indexOf(message.charAt(i))]++;
				}
			}else{
				if(alpha.indexOf(message.charAt(i))!=-1){
					counts2[alpha.indexOf(message.charAt(i))]++;
				}
				if(ALPHA.indexOf(message.charAt(i))!=-1){
					counts2[ALPHA.indexOf(message.charAt(i))]++;
				}
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
		for (int i=0; i<counts2.length; i++){
			//System.out.println(ALPHA.charAt(i)+" at index "+i+" count2 is: "+counts2[i]);
		}
		char maxchar2='\0';
		int maxnumber2=0;
		int index2=0;
		for (int i=0; i<counts2.length; i++){
			//System.out.println(alpha.charAt(i)+" count is: "+counts[i]);
			if(counts2[i]>maxnumber2){
				maxchar2=ALPHA.charAt(i);
				maxnumber2=counts2[i];
				index2=i;
			}
		}
		//System.out.println("Most shown letter in count2 is \""+maxchar2+"\" at "+maxnumber2+" times");
		index1=26-index1+4;
		index2=26-index2+4;
		if(index1>26){
			index1=index1-26;
		}
		if(index2>26){
			index2=index2-26;
		}
		System.out.println("Keys based on \"E\" being most common are: "+index1+" and "+index2+". Original keys to encrypt were therefor 26-key,i");
				
	}
	
	
	public static String SipherEncrypt(int key1, int key2, String message) throws IOException{
		
		//this method will take in a key and message to input a shifted replication of the message
		
		//key=19;
		//message= "A BAT";
		
		//take in the message from the call or take it from a scanner
		
		
		message="";
		
		File f = new File("mysteryTwoKeysQuiz.txt");
		Scanner sc = new Scanner(f);
		
		
		while( sc.hasNextLine()){
			message=message+sc.nextLine()+"\n";
		}
		
		//System.out.println("Message is:\n"+message);
		
		
		String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alpha = "abcdefghijklmnopqrstuvwxyz";		
		String encrypted="";
		//message = message.toUpperCase();
		
		
		String ALPHAShift1= ALPHA.substring(key1)+ALPHA.substring(0, key1);
		String alphaShift1= alpha.substring(key1)+alpha.substring(0, key1);
		String ALPHAShift2= ALPHA.substring(key2)+ALPHA.substring(0, key2);
		String alphaShift2= alpha.substring(key2)+alpha.substring(0, key2);
		
		//System.out.println(alphaShift);
		for(int k=0; k<message.length();k++){	
			if(k%2==0){	
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
			} else{	
				if(ALPHA.indexOf(message.charAt(k))==-1&&alpha.indexOf(message.charAt(k))==-1){
					//System.out.print(" ");
					encrypted=encrypted+message.charAt(k);
				} else if(alpha.indexOf(message.charAt(k))==-1) {
					//System.out.print(alphaShift.charAt(alpha.indexOf(message.charAt(k))));
					encrypted=encrypted+ALPHAShift2.charAt(ALPHA.indexOf(message.charAt(k)));
				} else {
					//System.out.print(alphaShift.charAt(alpha.indexOf(message.charAt(k))));
					encrypted=encrypted+alphaShift2.charAt(alpha.indexOf(message.charAt(k)));
				}
			}	
		}
		//System.out.println();
		//System.out.println("Message encrypted is:\n"+encrypted);
		System.out.println(encrypted);
		return encrypted;
	}
	
	
	public static String SipherDecrypt(int key, String message){
		
		//this method will take in a key and message to input a shifted replication of the message
		
		//key=19;
		//message= "A BAT";
				
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String decrypted="";
		message = message.toUpperCase();
		
		
		String alphaShift= alpha.substring(key)+alpha.substring(0, key);
		//System.out.println(alphaShift);
		for(int k=0; k<message.length();k++){	
			if(alphaShift.indexOf(message.charAt(k))==-1){
				//System.out.print(" ");
				decrypted=decrypted+" ";
			} else {
			//System.out.print(alphaShift.charAt(alpha.indexOf(message.charAt(k))));
			decrypted=decrypted+alpha.charAt(alphaShift.indexOf(message.charAt(k)));
			}
		}
		//System.out.println();
		System.out.println(decrypted);
		return decrypted;
	}
	
			
	public static void practiceProblems(){
		//the ceasers sipher shift 3 encryption
		
		String cab="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String cab2=cab.substring(23)+cab.substring(0,23);
		//System.out.println(cab2);
		
		String cab3="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String cab4=cab3.substring(0,5);   //a single index will be the end, if both it is begin index then end index. the begin index will 
		//System.out.println(cab4);
		cab3=cab3+cab4;
		//System.out.println(cab3);
		
		StringBuilder sb = new StringBuilder("Hello");
		sb.append("World");
		sb.insert(5,  " Around The ");
		//System.out.println(sb);
		
		String dna = "cgatga";
		//System.out.println(dna.indexOf("atg"));
		//System.out.println(dna.substring(1,4));
		
		String s = "abcd";
		String ret = "";
		
		//for loop same as while loop
		for(int k=0;k<s.length();k++){
			ret=s.charAt(k)+ret;
			//System.out.println(ret);
		}
		
		//while loop same as for loop
		String w = "abcd";
		String retw = "";
		int a =0;
		while(a < w.length()){
			retw = w.charAt(a)+retw;
			a=a+1;
			//System.out.println(retw);
		}
		
		//running the for loop negatively
		String y="abcdef";
		String rety="";
		
		//System.out.println(y.charAt(1));
		
		for(int b=y.length()-1;b>-1;b--){
			rety=y.charAt(b)+rety;
			//System.out.println(rety);
		}
	}
	
}
