package sample;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

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
			outToClient.writeBytes("HTTP/1.0 200 OK");
			outToClient.writeBytes("Connection: close\r\n");
			outToClient.writeBytes("\r\n");
			outToClient.writeBytes("it worked");
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
