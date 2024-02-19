package halozatKezeles1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Kliens {

	public static void main(String[] args) {

		String szerverEleres = "127.0.0.1";
		int szerverPort = 15678; // a szerver oldalon megnyitott portszam

		try {

			Socket socket = new Socket(szerverEleres, szerverPort);

			System.out.println("Letrejott a kapcsolat a szerverrel");

			Scanner sc = new Scanner(socket.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			String kimenoUzenet = "", bejovoUzenet = "";

			while (!kimenoUzenet.equals("stop")) {

				System.out.println("Kerem az uzenetet:");
				kimenoUzenet = br.readLine();

				out.println(kimenoUzenet);

				bejovoUzenet = sc.nextLine();
				System.out.println("Szerver uzenete: " + bejovoUzenet);

			}

			br.close();
			sc.close();
			socket.close();
			
			System.out.println("Kapcsolat bontva");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
