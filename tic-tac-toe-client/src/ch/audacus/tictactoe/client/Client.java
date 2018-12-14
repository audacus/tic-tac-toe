package ch.audacus.tictactoe.client;

import java.io.IOException;
import java.net.Socket;

import ch.audacus.tictactoe.commons.AClient;
import ch.audacus.tictactoe.commons.Communication;

public class Client extends AClient implements Runnable {

	public Client(Socket socket) {
		super(socket);
	}

	public static void main(String[] args) {
		try {
			new Thread(new Client(new Socket(Communication.ADDRESS, Communication.PORT))).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
