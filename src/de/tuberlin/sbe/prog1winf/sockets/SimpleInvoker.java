package de.tuberlin.sbe.prog1winf.sockets;

import java.net.Socket;

/**
 * @author Ingo Weber
 * This is an invoker class, that starts a server thread and sends it some input.
 */
public class SimpleInvoker {
	
	public static void main(String[] args) throws Exception{
		SimpleServer serverConnection = new SimpleServer();
		serverConnection.setName("Server0");
		serverConnection.start();
//		SimpleServer serverConnection1 = new SimpleServer();
//		serverConnection1.setName("Server1");
//		serverConnection1.start();

		Thread.sleep(50);
		Socket s = new Socket("127.0.0.1", 8082);

		for (int j = 0; j < 10; j++) {
			int k = (int) (Math.random() * 10 * j);
			System.out.println(Thread.currentThread().getName() + " : " + k);
			s.getOutputStream().write(k);
			Thread.sleep(500);
		}
		s.close();
		serverConnection.join();
		System.out.println("Server thread is stopped");
	}

}
