import java.io.*;
import java.net.Socket;
import java.util.*;

public class MultiServer implements Runnable {

	private int id;
	private Socket connection;
	
	public MultiServer(Socket s, int i) {
		connection = s;
		id = i;
	}
	
	@Override
	public void run() {
		boolean done = false;
		try(
				BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				PrintWriter out = new PrintWriter(connection.getOutputStream(),true);
				PrintWriter log = new PrintWriter(new FileWriter("log" + id + ".txt"), true);
		) {
			while(!done) {
				String line = input.readLine();
				log.println(new Date().toString() + ": " + line);
				out.println("MESSAGE FROM CLIENT #" + id +" : " + line.toUpperCase());
				System.out.println("CLIENT #" + id +" : " + line.toUpperCase());
				if("QUIT".equals(line)) 
					done = true;
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
