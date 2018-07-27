package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer implements Server{

	private ServerSocket _serverSocket;
	private int _port;
	private boolean _stop;
	
	//bug - not valid ports
	public MyServer(int port) {
	
		this._port=port;
		_stop=false;
	}

	private void serverStart(ClientHandler ch) throws IOException {
		//open socket
		_serverSocket=new ServerSocket(_port);
		_serverSocket.setSoTimeout(1000);
		System.out.println("server connected - waiting for client");
		
		while(!_stop) {
			
			try {
				Socket aClientSock= _serverSocket.accept();
				
				ch.handleClient(aClientSock.getInputStream(),aClientSock.getOutputStream() );
				
				aClientSock.close();
			} catch (SocketTimeoutException e) {
				
				//System.err.println("client didnt connect");
			}
			
		}
		
		
	}
	@Override
	public void start(ClientHandler ch) {
		new Thread(()->{
					try {
						serverStart(ch);
					} catch (IOException e) {
						System.err.println("error with opening socket");
					}
				}).start();
		
	}

	@Override
	public void stop() {
		_stop=true;
		
	}
		
}
