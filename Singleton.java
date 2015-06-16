package interviewProgram;

public class Singleton {
	private int num;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	private Singleton(){
		
	}
	private static Singleton s=new Singleton();
	public static Singleton getInstance(){
		return s;
		//return new Singleton();  this would not work, because every time getInstance() invoked, a new object created.
	}
	
}

class Test{
	public static void main(String[] args){
		Singleton s1=Singleton.getInstance();
		Singleton s2=Singleton.getInstance();
		s1.setNum(5);
		System.out.println(s2.getNum());
	}
}
