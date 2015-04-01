//this program is for chat, the command line can send and receive message at the same time
//create two sides, send and receive, they can run at the same time, so need two threads, each thread control one side
//java SE packages used in this program: thread, io, net, exception. UDP protocol 



package Mini_project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;



//thread to send message
class Send implements Runnable{
	private DatagramSocket ds;
	public Send(DatagramSocket ds){
		this.ds=ds;
	}
	public void run(){
		try{
			BufferedReader buffr= new BufferedReader(new InputStreamReader(System.in));
			String line=null;
			while((line=buffr.readLine())!=null){
				if("bye".equals(line))
					break;
				byte[] buff=line.getBytes();
				DatagramPacket dp= new DatagramPacket(buff, buff.length, InetAddress.getByName("127.0.0.1"),8888);
				ds.send(dp);
			}
		}
		catch(Exception e){
			throw new RuntimeException("send failed");
		}
	}
}

//thread to receive message
class Receive implements Runnable{
	private DatagramSocket ds;
	public Receive(DatagramSocket ds){
		this.ds=ds;
	}
	public void run(){
		try{
			while(true){
				byte[] buff= new byte[1024];
				DatagramPacket dp = new DatagramPacket(buff,buff.length);
						ds.receive(dp);
				String ip= dp.getAddress().getHostAddress();
				String data = new String(dp.getData(),0,dp.getLength());
				System.out.println(ip+"----"+data);
			}
		}
		catch(Exception e){
			throw new RuntimeException("receiver failed");
		}
	}
}


public class UdpChat {

	public static void main(String[] args) throws Exception {
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receiveSocket= new DatagramSocket(8888);
		
		new Thread(new Send(sendSocket)).start();
		new Thread(new Receive(receiveSocket)).start();
		
	}

}
