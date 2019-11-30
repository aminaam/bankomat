
public class KreiranjeRacuna {
	
	private int brojRacuna;
	private String imeVlasnikaRacuna;
	private double iznosNaRacunu;
	
	
	
	// konstruktori
	public KreiranjeRacuna() {

	}
	
	public KreiranjeRacuna(int brojRacuna, String imeVlasnikaRacuna, double iznosNaRacunu) {
		if(brojRacuna < 0) {
			throw new ArithmeticException("Ne smije biti negativan broj!");
		} else {
			this.brojRacuna = brojRacuna;
		}
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
		if(iznosNaRacunu < 0) {
			throw new ArithmeticException("Ne smije biti negativan iznos na racunu!");
		} else {
			this.iznosNaRacunu = iznosNaRacunu;
		}
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
}
