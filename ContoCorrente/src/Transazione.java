import java.util.Calendar;
import java.util.GregorianCalendar;

public class Transazione extends Thread{
	
	protected ContoCorrente conto;
	protected double soldi;
	private String tipo;
	protected int nRate;
<<<<<<< HEAD
	//1 Addebito
	//2 Versamento
	//3 Addebito a nRate
	//4 Versamento a nRate
=======
	protected int zeroTime;//giorno di apertura conto
	protected int oneMonth;//un mese dopo
	//i giorni in un anno sono sempre 365, sennó diverebbe troppo complesso
	//1 secondo = 1 giorno
>>>>>>> branch 'master' of https://github.com/DiegoNamkhai/ContoCorrente.git

	public Transazione(ContoCorrente conto, double soldi) {
		// Da usare solo nelle classi figlie
		this.conto = conto;
		this.soldi = soldi;
	}
	
	public Transazione(ContoCorrente conto, double soldi, int nRate) {
		// Da usare solo nelle classi figlie
		this.conto = conto;
		this.soldi = soldi;
		this.nRate = nRate;
	}
	
	public Transazione(ContoCorrente conto, double soldi, String tipo) {
		this.conto = conto;
		this.soldi = soldi;
		if (tipo.compareTo("addebito") == 0){
			tipo = "addebito";
		}
		else {
			tipo = "accredito";
		}
	}
	
	public Transazione(ContoCorrente conto, double soldi, String tipo, int nRate) {
		this.conto = conto;
		this.soldi = soldi;
		if (tipo.compareTo("addebito") == 0){
			tipo = "adRate";
		}
		else {
			tipo = "acRate";
		}
		this.nRate = nRate;
	}
	
	public void run() {
		Calendar calendar = new GregorianCalendar();
		int zeroTime = calendar.get(Calendar.SECOND);
		int oneMonth = zeroTime + 30;
		if (oneMonth>59)
			oneMonth -= 60;
		switch(tipo) {
		case "addebito":
			Addebito addebito = new Addebito (conto, soldi);
			addebito.start();
		break;
		case "accredito":
			Accredito accredito = new Accredito (conto, soldi);
			accredito.start();
		break;
		case "adRate":
			adRate addebitoARate = new adRate (conto, soldi, nRate);
			addebitoARate.start();
		break;
		case "acRate":
			acRate accreditoARate = new acRate (conto, soldi, nRate);
			accreditoARate.start();
		break;
		} 
	}
	
	protected boolean time() {
		
		Calendar calendar = new GregorianCalendar();
		int second = calendar.get(Calendar.SECOND);
		if (second == zeroTime || second == oneMonth ) {
			return true;
		}
		else {
			return false;
		}	
	}
}