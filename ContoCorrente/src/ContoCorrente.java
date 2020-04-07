import java.util.Date;
import java.util.concurrent.Semaphore;

public class ContoCorrente {

	private String conto;
	private double saldo;
	private double fido;
	private boolean flagFido;
	Semaphore mutex = new Semaphore(1);
	
	public ContoCorrente(double f) {
		
		fido = f; 
		flagFido = true;
	}
	
	public ContoCorrente() {
		flagFido = false;
	}

	
	public void accredito(double a) throws InterruptedException {
		
		mutex.acquire(1);
		saldo += a;
		mutex.release(1);
	}
	
	
	public boolean addebito(double addebito) throws InterruptedException {
		
		mutex.acquire(1);
		if(flagFido){
		 	if(addebito<saldo){
		 		saldo -= addebito;
		 		mutex.release(1);
		 		return true;
		 	}
		 	else {
		 		mutex.release(1);
		 		System.out.println("Transazione annullata, saldo insufficente");
		 		return false;
		 	}
		 }
		else {
		 	if ((addebito - saldo) < fido){
		 		saldo -= addebito;
		 		mutex.release(1);
		 		return true;
		 	}
		 	else {
		 		mutex.release(1);
		 		System.out.println("Transazione annullata, fido terminato");
		 		return false;
		 	}
		 
		 }
		
		
	}
	
	public void stampaSaldo() {
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