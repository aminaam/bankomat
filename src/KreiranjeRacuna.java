
public class KreiranjeRacuna {
	
	private int brojRacuna;
	private String imeVlasnikaRacuna;
	private double iznosNaRacunu;
	
	
	
	// konstruktori
	public KreiranjeRacuna() {

	}
	
	public KreiranjeRacuna(int brojRacuna, String imeVlasnikaRacuna, double iznosNaRacunu) {
		this.brojRacuna = brojRacuna;
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
		this.iznosNaRacunu = iznosNaRacunu;
	}
	
	// getteri i setteri
		public int getBrojRacuna() {
			return brojRacuna;
		}

		public void setBrojRacuna(int brojRacuna) {
			this.brojRacuna = brojRacuna;
		}

		public String getImeVlasnikaRacuna() {
			return imeVlasnikaRacuna;
		}

		public void setImeVlasnikaRacuna(String imeVlasnikaRacuna) {
			this.imeVlasnikaRacuna = imeVlasnikaRacuna;
		}

		public double getIznosNaRacunu() {
			return iznosNaRacunu;
		}

		public void setIznosNaRacunu(double iznosNaRacunu) {
			this.iznosNaRacunu = iznosNaRacunu;
		}
		
		public void isplata(double iznos) {
			iznosNaRacunu -=iznos;
		}
		
		public void uplata(double iznos) {
			iznosNaRacunu +=iznos;
		}
		
		public void ispisRacuna() {
			System.out.println("Racun: \n");
			System.out.println("Ime vlasnika racuna: " + getImeVlasnikaRacuna());
			System.out.println("Broj racuna je: " + getBrojRacuna());
			System.out.println("Stanje na raèunu: " + getIznosNaRacunu() + " KM");
		}
		
}
