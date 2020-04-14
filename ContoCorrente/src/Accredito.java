
public class Accredito extends Transazione{
	
	public Accredito(ContoCorrente c, double soldi) {
		super(c, soldi);
	}
		
	public void run() {
		try {
			conto.accredito(soldi);
		} catch (InterruptedException e) {e.printStackTrace();}
	}		
}