package sample;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerThreadDriver extends Thread {
	
	ServerSocket ss;
	
	public void run(){
		try {
			ss = new ServerSocket(7777);
			
			while(true){
				ServerThread st = new ServerThread(ss.accept());
				st.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void StopServer() throws IOException {
		ss.close();
		this.interrupt();
	}

}
