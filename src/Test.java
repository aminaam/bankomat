import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {

		// objekti
		KreiranjeRacuna racun1 = new KreiranjeRacuna(12345, "Amina", 100);
		KreiranjeRacuna racun2 = new KreiranjeRacuna(12346, "Belma", 50);

		// lista racuna
		ArrayList<KreiranjeRacuna> racuni = new ArrayList<>();
		racuni.add(racun1);
		racuni.add(racun2);

		// provjera da li racun ima isti broj
		for (int i = 0; i < racuni.size(); i++) {
			for (int j = i + 1; j < racuni.size(); j++) {
				if (racuni.get(i).getBrojRacuna() == racuni.get(j).getBrojRacuna()) {
					throw new ArithmeticException("Broj racuna " + racuni.get(j).getBrojRacuna() + " nije validan!");
				}
			}
		}

		// kreiranje fajla sa svim racunima
		Path path = Paths.get("brojevi.txt");

		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		// TRANSFER
		TransferNovca transfer = new TransferNovca();
		Scanner input = new Scanner(System.in);
		System.out.print("Unesite racun sa kojeg prebacujete novac: ");
		int source = input.nextInt();
		System.out.print("Unesite racun na koji prebacujete novac: ");
		int target = input.nextInt();
		System.out.print("Unesite iznos koji zelite prebaciti: ");
		double iznos = input.nextDouble();
		System.out.println();
		input.close();
		boolean transf = false;

		for (int i = 0; i < racuni.size(); i++) {
			for (int j = 0; j < racuni.size(); j++) {
				if (racuni.get(j).getBrojRacuna() == target && racuni.get(i).getBrojRacuna() == source) { // da li postoje u sistemu
					transfer.setTargetAccount(target);
					transfer.setSourceAccount(source);
					if (racuni.get(i).getIznosNaRacunu() > iznos) { // da li je iznos dovoljan
						racuni.get(i).isplata(iznos);
						racuni.get(j).uplata(iznos);
						System.out.println("-----USPJESAN TRANSFER-----\n");
						racuni.get(i).ispisRacuna();
						System.out.println("_________________________\n");
						racuni.get(j).ispisRacuna();
						transf = true;
						break;
					} else {
						System.out.println("Ne moze se izvrsiti transfer! Na source racunu nema dovoljno novca.");
					}
				}
			}
		}

		if (!transf) {
			System.out.println("-----NEUSPJESAN TRASNFER-----");
		}
	}
}
