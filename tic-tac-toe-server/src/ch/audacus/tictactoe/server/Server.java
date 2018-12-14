package ch.audacus.tictactoe.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import ch.audacus.tictactoe.commons.Communication;

public class Server implements Runnable {
	
	private ServerSocket listener;
	private List<Client> clients;
	
	public Server() throws IOException {
		listener = new ServerSocket(Communication.PORT);
		clients = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		try {
			new Thread(new Server()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("server started at " + listener);
		try {
			while (true) {
				Client client = new Client(listener.accept());
				System.out.println("new client connected: " + client.getSocket());
				new Thread(client).start();
				clients.add(client);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
