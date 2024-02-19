package halozatKezeles1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UzenetFogadas {

	public static void main(String[] args) {

		// djxmmx.net --> veletlen uzeneteket kuld a 17-es porton

		for (int i = 0; i < 5; i++) {
			try {

				Socket socket = new Socket("djxmmx.net", 17);
				Scanner sc = new Scanner(socket.getInputStream());

				while (sc.hasNextLine()) {

					System.out.println(sc.nextLine());

				}

				socket.close();

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
