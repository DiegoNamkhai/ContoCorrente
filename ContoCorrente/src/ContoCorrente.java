
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
		//ritorna true se é possibile effettuare la'addebito, altrimenti false
		
		mutex.acquire(1);
		if(!flagFido){//controllo se con conto con fido o meno
		 	if(addebito<saldo){ //no conto fido
		 		saldo -= addebito;
		 		mutex.release(1);
		 		return true;//effettua transazione
		 	}
		 	else {
		 		mutex.release(1);
		 		System.out.println("Transazione annullata, saldo insufficente");
		 		return false;//non effettua transazione
		 	}
		 }
		else {//con conto fido
		 	if ((addebito - saldo) < fido){
		 		saldo -= addebito;
		 		mutex.release(1);
		 		return true;//effettua transazione
		 	}
		 	else {
		 		mutex.release(1);
		 		System.out.println("Transazione annullata, fido terminato");
		 		return false;//non effettua transazione
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