package interviewProgram;

import java.util.*;



public class GetDuplicate {
	
	public static int getDuplicate(List<Integer> list){
		Set<Integer> set = new HashSet<Integer>();
		int duplicate=-1;
		for(int x=0; x<list.size(); x++){
			if(!set.add(list.get(x)))
				duplicate=list.get(x);
		}
		return duplicate;
	}

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		int n=26;
		int m=3;
		for(int x=0;x<=n;x++){
			list.add(x);
		}
		list.add(m);
		System.out.println(list);
		int duplicate=getDuplicate(list);
		System.out.println(duplicate);
		

	}

}
