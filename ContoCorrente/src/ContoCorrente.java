import java.util.Date;
import java.util.concurrent.Semaphore;

public class ContoCorrente {

	private String conto;
	private double saldo;
	private double fido;
	Semaphore mutex;//Ivan e Diego
	
	public ContoCorrente(double f) {
		
		fido = f;
		mutex = new Semaphore(1);
	}
	
	public void sos() {
		
	}
	
	public void accredito(double a) throws InterruptedException {
		
		mutex.acquire(1);
		saldo += a;
		mutex.release(1);
	}
	
	public void addebito(double a) throws InterruptedException {
		
		mutex.acquire(1);
		if(a < saldo || (a - saldo) < fido) {
			saldo -= a;
		}
		else {
			System.out.println("L'importo inserito supera il fido bancario di €" + (((saldo + fido) - a) * (-1)));
		}
		mutex.release(1);
	}
	
	public void stampaSaldo() {
		//saaaaassssi
		if(saldo > 0) {
			System.out.println("Saldo attuale: €" + saldo);
		}
		else {			
			System.out.println("Il saldo è in rosso di: €" + (saldo * (-1)));
			System.out.println("Puoi ancora erogare €" + (saldo + fido));
		}
	}
	
	public String getConto() {
		
		return conto;
	}
	
	public double getSaldo() {
		
		return saldo;		
	}
	
	public double getFIdo() {
		
		return fido;		
	}
	
	public void setConto(String c) {
		
		conto = c;		
	}
	
	public void setSaldo(double s) {
		
		saldo = s;
	}
	
	public void setFido(double f) {
		
		fido = f;		
	}
}