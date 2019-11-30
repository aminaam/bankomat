
public class TransferNovca {
	
	private int sourceAccount; // broj racuna sa koga se prebacuje novac
	private int targetAccount; // broj racuna na koji se prebacuje novac
	private double iznos; // iznos koji se prebacuje
	
	
	// konstruktori
	public TransferNovca() {

	}

	public TransferNovca(int sourceAccount, int targetAccount, double iznos) {
		this.sourceAccount = sourceAccount;
		this.targetAccount = targetAccount;
	}

	// getteri i setteri
	public int getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(int sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public int getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(int targetAccount) {
		this.targetAccount = targetAccount;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
}
