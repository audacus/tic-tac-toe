package ch.audacus.tictactoe.commons;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Communication {

	public static String ADDRESS = "127.0.0.1";
	public static int PORT = 1337;

	public static void send(Socket s, Object o) throws IOException {
		ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
		output.writeObject(o);
		output.flush();
	}

	public static Object receive(Socket s) throws IOException, ClassNotFoundException {
		return new ObjectInputStream(s.getInputStream()).readObject();
	}
}
