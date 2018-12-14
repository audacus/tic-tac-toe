package ch.audacus.tictactoe.server;

import java.io.IOException;
import java.net.Socket;

import ch.audacus.tictactoe.commons.AClient;

public class Client extends AClient implements Runnable {

	public Client(Socket socket) {
		super(socket);
	}

	@Override
	public void run() {
		try {
			while (true) {
				 System.out.println(this + receive().toString());
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				getSocket().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
