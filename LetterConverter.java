package Mini_project;

//Construct two classes, one Client, the other Server on the net. when Client send text message to Server, Server received the 
//message and convert the letters to Uppercase and send them back to client, the client receive Uppercase text.
//keywords: io,net,socket, serversocket, TCP
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


class Client{
	public static void main(String[] args) throws Exception, IOException {
		Socket s= new Socket("127.0.0.1", 8888);
		
		BufferedReader buffr = new BufferedReader(new InputStreamReader(System.in));
		
		//this line can be replaced with: PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		BufferedWriter buffOut= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		BufferedReader buffIn= new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String line=null;
		while((line=buffr.readLine())!=null){
			if("over".equals(line))
				break;
			buffOut.write(line);    //The following 3 lines can be replaced with: out.println(line);
			buffOut.newLine();
			buffOut.flush();
			
			String converted=buffIn.readLine();
			System.out.println(converted);
		}
		buffr.close();
		s.close();
	}
	
}

class Server{
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+" connected");
		
		BufferedReader buffIn= new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedWriter buffOut= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		//The above line can be repalced with: PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		String line = null;
		while((line=buffIn.readLine())!=null){
			System.out.println(line);
			buffOut.write(line.toUpperCase());  //The following 3 lines can be replaced with out.println(line.toUpperCase());
			buffOut.newLine();
			buffOut.flush();
		}
		s.close();
		ss.close();
		
	}
	
}

public class LetterConverter {

	public static void main(String[] args) {
	
	}

}
