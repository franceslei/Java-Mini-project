package interviewProgram;

public class StringReverse {
	
	public static String reverseString(String str){
		String reverse="";
		if(str.length()==1)
			return str;
		else{
			reverse=reverse+str.charAt(str.length()-1)+reverseString(str.substring(0, str.length()-1));
			return reverse;
		}
	}
	public static void main(String[] args) {
		String str="ancdg";
		String newString=reverseString(str);
		System.out.println(newString);

	}

}
