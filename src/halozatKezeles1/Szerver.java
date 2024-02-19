package halozatKezeles1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Szerver {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int portszam = 15678; // Tetszoleges port hozzarendelese a szerverhez. Ezen a porton fogja figyelni a
								// kliens kereseit.

		try {

			ServerSocket serverSocket = new ServerSocket(portszam);

			System.out.printf("A szerver fut es figyel a %s porton %n", String.valueOf(portszam));

			Socket socket = serverSocket.accept();
			System.out.println("Letrejott a kapcsolat a klienssel. Kliens adatai: " + socket);

			Scanner sc = new Scanner(socket.getInputStream());

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String kimenoUzenet = "", bejovoUzenet = "";

			while (sc.hasNextLine()) {

				bejovoUzenet = sc.nextLine();
				System.out.println("Kliens uzenete: " + bejovoUzenet);

				System.out.println("Adja meg a valaszt: ");
				kimenoUzenet = br.readLine();
				out.println(kimenoUzenet);
				

			}
			
			System.out.println("Kliens bontotta a kapcsolatot");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
