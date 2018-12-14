package ch.audacus.tictactoe.commons;

import java.io.IOException;
import java.net.Socket;

public abstract class AClient {

	private int id;
	private Socket socket;

	public AClient(Socket socket) {
		id = hashCode();
		this.socket = socket;
		System.out.println("new " + this.getClass() + " started at " + socket);
	}

	public int getId() {
		return id;
	}

	public Socket getSocket() {
		return socket;
	}

	protected void send(Object o) throws IOException {
		Communication.send(socket, o);
	}

	protected Object receive() throws ClassNotFoundException, IOException {
		return Communication.receive(socket);
	}
}
