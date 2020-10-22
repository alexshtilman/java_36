package telran.net.app;
import java.util.Scanner;

public class TcpClientExampleAppl {
public static void main(String[] args) throws Exception{
	TcpExampleClient client = new TcpExampleClient("localhost", 5000);
	Scanner scanner = new Scanner(System.in);
	while(true) {
		try {
			System.out.println("enter request type or quit");
			String lineType = scanner.nextLine();
			if (lineType.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.println("enter any string");
			String line = scanner.nextLine();
			System.out.println(client.send(lineType, line));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	client.close();
	scanner.close();
}
}
