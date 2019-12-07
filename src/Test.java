import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	public static void izbor() {
		System.out.println("------BANKOMAT------\n");
		System.out.println("1. Kreiranje racuna ");
		System.out.println("2. Transfer novca ");
	}

	public static boolean validanRacun(int brojRacuna, double iznosNaRacunu) {

		if (brojRacuna < 0) {
			throw new ArithmeticException("Broj racuna ne smije biti negativan broj!");
		} else if (iznosNaRacunu < 0) {
			throw new ArithmeticException("Ne smije biti negativan iznos na racunu!");
		}
		return true;
	}

	public static boolean istiRacun(ArrayList<KreiranjeRacuna> racuni, int broj) {
		for (int i = 0; i < racuni.size(); i++) {
				if (racuni.get(i).getBrojRacuna() == broj) {
					throw new ArithmeticException("Broj racuna " + broj + " nije validan!");
				}
			}
		return false;
	}
	
	public static boolean kreiranjeRacuna(ArrayList<KreiranjeRacuna> racuni, Scanner input) {
		System.out.print("Unesite broj racuna: ");
		int broj = input.nextInt();
		System.out.print("Unesite ime vlasnika racuna: ");
		String ime = input.next();
		System.out.print("Unesite iznos na racunu: ");
		double iznosRacuna = input.nextDouble();
		
		if (validanRacun(broj, iznosRacuna)) {
			if(!istiRacun(racuni, broj)) {
			KreiranjeRacuna racun = new KreiranjeRacuna(broj, ime, iznosRacuna);
			racuni.add(racun);
			return true;
			}
		}
		return false;
	}

	public static boolean transferNovca(ArrayList<KreiranjeRacuna> racuni, Scanner input) {
		TransferNovca transfer = new TransferNovca();
		System.out.print("Unesite racun sa kojeg prebacujete novac: ");
		int source = input.nextInt();
		System.out.print("Unesite racun na koji prebacujete novac: ");
		int target = input.nextInt();
		System.out.print("Unesite iznos koji zelite prebaciti: ");
		double iznos = input.nextDouble();
		System.out.println();
		input.close();

		for (int i = 0; i < racuni.size(); i++) {
			for (int j = 0; j < racuni.size(); j++) {
				if (racuni.get(j).getBrojRacuna() == target && racuni.get(i).getBrojRacuna() == source) { //da li postoje u sistemu
					transfer.setTargetAccount(target);
					transfer.setSourceAccount(source);
					if (racuni.get(i).getIznosNaRacunu() > iznos) { // da li je iznos dovoljan
						racuni.get(i).isplata(iznos);
						racuni.get(j).uplata(iznos);
						System.out.println("-----USPJESAN TRANSFER-----\n");
						racuni.get(i).ispisRacuna();
						System.out.println("_________________________\n");
						racuni.get(j).ispisRacuna();
						return true;
					} else {
						System.out.println("Ne moze se izvrsiti transfer! Na source racunu nema dovoljno novca.");
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {

		// objekti
		KreiranjeRacuna racun1 = new KreiranjeRacuna(12345, "Amina", 100);
		KreiranjeRacuna racun2 = new KreiranjeRacuna(12346, "Belma", 50);

		// lista racuna
		ArrayList<KreiranjeRacuna> racuni = new ArrayList<>();
		racuni.add(racun1);
		racuni.add(racun2);

		Scanner input = new Scanner(System.in);
		izbor();
		System.out.print("\nUnesite zeljenu opciju: ");
		int izbor = input.nextInt();
		System.out.println();

		File file = new File();
		switch (izbor) {
		case 1:
			if(kreiranjeRacuna(racuni, input)) {
				System.out.println("\nUspjesno ste kreirali novi racun!");
				file.dodavanjeRacuna(racuni);
				break;
			}
		case 2:
			if(!transferNovca(racuni, input)) {
				System.out.println("-----NEUSPJESAN TRASNFER-----");
				break;
			} break;
		default:
			System.out.println("Pogresan unos!");
		}
	}
}
