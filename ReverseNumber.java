package interviewProgram;

public class ReverseNumber {
	
	public static long reverseNumber(int num){
		String str=""+num;
		StringBuilder sb= new StringBuilder();
		for(int x=0; x<str.length();x++){
			sb.append(str.charAt(x));
		}
		sb.reverse();
		return Integer.valueOf(sb.toString());
		
	}

	public static void main(String[] args) {
		System.out.println(reverseNumber(15789));

	}

}
