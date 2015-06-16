package interviewProgram;

//two or more threads a blocked forever. it occurs because the synchronized keyword causes the thread hold the lock while waiting for
//other threads release the lock associated with other objects. The threads would each be waiting for others to release the lock, and 
//they will end up waiting forever. it happens when threads access objects in different order.

public class DeadLock {
	String str1="Object---1";
	String str2="Object---2";
	
	Thread th1= new Thread("thread--1"){
		public void run(){
			int i=0;
			while(true){
			synchronized(str1){
				synchronized(str2){
					System.out.println(i+":::"+str1+str2);
					i++;
				}
			}}
		}
	};

	
	Thread th2=new Thread("thread--2"){
		public void run(){
			int i=0;
			while(true){
			synchronized(str2){
				synchronized(str1){
					System.out.println(i+":::"+str2+str1);
					i++;
				}
			}}
		}
	};

	public static void main(String[] args) {
		DeadLock dl=new DeadLock();
		dl.th2.start();
		dl.th1.start();

	}
}
