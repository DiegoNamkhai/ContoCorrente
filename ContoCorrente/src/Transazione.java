import java.util.Calendar;
import java.util.GregorianCalendar;

public class Transazione extends Thread{
	
	protected ContoCorrente conto;
	protected double soldi;
	private String tipo;
	protected int nRate;
	//1 addebito
	//2 versamento
	//3 addebito a nRate
	//4 versamento a nRate

	public Transazione(ContoCorrente conto, double soldi) {
		//da usare solo nelle classi figlie
		this.conto = conto;
		this.soldi = soldi;
	}
	
	public Transazione(ContoCorrente conto, double soldi, int nRate) {
		//da usare solo nelle classi figlie
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
		switch(tipo) {
		case "addebito":
			Addebito addebito = new Addebito (conto, soldi);
			addebito.start();

		break;
		case "accredito":
		
		break;
		case "adRate":
		break;
		
		case "acRate":
		break;
		
		} 
	}
	
	protected boolean time() {
		
		Calendar calendar = new GregorianCalendar();
		int second = calendar.get(Calendar.SECOND);
		if (second == 0 || second == 30 ) {
			return true;
		}
		else {
			return false;
		}	
	}

}
