import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		// objekti
		KreiranjeRacuna racun1 = new KreiranjeRacuna(21235, "Amina", 100);
		KreiranjeRacuna racun2 = new KreiranjeRacuna(21236, "Belma", 50);
		
		// lista racuna
		ArrayList<KreiranjeRacuna> racuni = new ArrayList<>();
		racuni.add(racun1);
		racuni.add(racun2);
		
		// provjera da li racun ima isti broj
		for(int i=0; i<racuni.size(); i++) {
			for(int j=0; j<racuni.size(); j++) {
				if(racuni.get(i).getBrojRacuna() == racuni.get(j).getBrojRacuna()) {
					throw new ArithmeticException("Broj racuna " + racuni.get(j).getBrojRacuna() + " nije validan!");
				}
			}
		}
		
		//TRANSFER
		TransferNovca transfer = new TransferNovca();
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite source racun: ");
		int source = input.nextInt();
		System.out.println("Unesite target raucn: ");
		int target = input.nextInt();
		System.out.println("Unesite iznos koji zelite prebaciti: ");
		double iznos = input.nextDouble();
		System.out.println();
		

	}

}
