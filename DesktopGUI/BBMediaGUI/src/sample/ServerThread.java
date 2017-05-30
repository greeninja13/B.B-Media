package sample;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import uk.co.caprica.vlcj.mrl.FileMrl;
import uk.co.caprica.vlcj.mrl.HttpMrl;

public class ServerThread extends Thread{

	private Socket connection;
	private DataOutputStream outToClient;
	
	public ServerThread(Socket s) {
		connection = s;
	}
	
	public void run(){
		String reciever = "";
		BufferedReader input;
		try {
			input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			outToClient = new DataOutputStream(connection.getOutputStream());
			reciever = input.readLine();

			System.out.println(connection.getInetAddress() + " requests " + reciever);
//			outToClient.writeBytes("HTTP/1.0 200 OK");
//			outToClient.writeBytes("Connection: close\r\n");
//			outToClient.writeBytes("\r\n");
//			outToClient.writeBytes("it worked");
//			connection.close();
			createStream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createStream() throws InterruptedException{
		String mrl = new FileMrl().file("D:/TheFastandtheFurious1954.mp4").value();
//		https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4
//		String mrl = new HttpMrl().host("www.archive.org").port(8080).path("/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4").value();
		VideoStreamer.thingy(mrl);
	}
}
