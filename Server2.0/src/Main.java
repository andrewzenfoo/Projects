import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws IOException {
		int i=1;
		ServerSocket server = null;
		boolean running = true;
		
		try {
			server = new ServerSocket(1234);
			while(running) {
				System.out.println(new Date().toString());
				MultiServer m = new MultiServer(server.accept(), i);
				new Thread(m).start();
				i++;
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			server.close();
		}
	}
}