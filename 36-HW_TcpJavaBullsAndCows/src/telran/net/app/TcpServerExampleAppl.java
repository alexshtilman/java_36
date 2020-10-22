package telran.net.app;
import telran.games.bullsAndCows.BullsAndCowsProtocol;
import telran.net.server.ServerJava;

public class TcpServerExampleAppl {

	public static void main(String[] args) {
		ServerJava serverJava = new ServerJava(5000, new BullsAndCowsProtocol());
		serverJava.run();

	}

}
