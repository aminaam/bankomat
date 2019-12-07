import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class File {

	public void dodavanjeRacuna(ArrayList<KreiranjeRacuna> racuni) throws IOException {
		// kreiranje fajla sa svim racunima
		Path path = Paths.get("brojevi.txt");

		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		BufferedWriter writer = Files.newBufferedWriter(path);
		String racun;
		for (int i = 0; i < racuni.size(); i++) {
			racun = racuni.get(i).getBrojRacuna() + "";
			writer.write(racun);
			writer.newLine();
		}

		writer.close();
	}
}
