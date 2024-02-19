package halozatKezeles1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class URLParszolas {

	public static void main(String[] args) {

		try {

			URL ruanderURL = new URL("https://www.ruander.hu");

			BufferedReader br = new BufferedReader(new InputStreamReader(ruanderURL.openStream()));

			Map<String, Integer> tanfolyamok = new HashMap<String, Integer>();

			while (br.ready()) {

				String sor = br.readLine();
				if (sor.contains("span class=\"course-name\"")) {

					int elsoElofordulas = sor.indexOf("span class=\"course-name\"");
					String reszString = sor.substring(elsoElofordulas);

					elsoElofordulas = reszString.indexOf(">");
					int elsoElofordulas2 = reszString.indexOf("<");
					String tanfolyamMegnevezes = reszString.substring(elsoElofordulas + 1, elsoElofordulas2);
					// System.out.println(tanfolyamMegnevezes);

					elsoElofordulas = reszString.indexOf("span class=\"currency\"");
					if (elsoElofordulas > -1) {

						reszString = reszString.substring(0, elsoElofordulas);
						elsoElofordulas = reszString.lastIndexOf(">");
						elsoElofordulas2 = reszString.lastIndexOf("<");
						reszString = reszString.substring(elsoElofordulas + 1, elsoElofordulas2).trim();
						reszString = reszString.replace(".", "");

						tanfolyamok.put(tanfolyamMegnevezes, Integer.parseInt(reszString));

					}

				}

			}
			
			String fajlnev = "RuanderKepzesek_" + LocalDate.now() + ".txt";
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev), "UTF-8");

			for (Map.Entry<String, Integer> elem : tanfolyamok.entrySet()) {
				System.out.println(elem.getKey() + " - a kepzes dija: " + elem.getValue() + " Ft");
				out.write(elem.getKey()+";"+String.valueOf(elem.getValue())+"\n");
			}
			out.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
