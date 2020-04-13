

import java.util.concurrent.Semaphore;

public class ContoCorrente {

	private IBAN IBAN;
	private double interessi = 5;//siamo molto generosi(serve a vedere la crescita)
	private double saldo;
	private double fido;
	private boolean flagFido;
	Semaphore mutex = new Semaphore(1);
	private static int incConto = 0;
	private String conto;
	private String ABI = "69696";//banca Ivan&Diego
	private String [] CAB = {"11111","22222","33333"};//filiale:
	//via Ugaccione della fagiola 17A||11111
	//via del Bandino 32A||22222
	//Piazza della Repubblica 12B||33333
	
	public ContoCorrente(double f) {//IBAN generato, si fido
		IBAN = this.generazioneIBAN();
		fido = f; 
		flagFido = true;
		Frutto frutto = new Frutto ( this, interessi);
		frutto.start();
	}
	
	public ContoCorrente() {//IBAN generato, no fido
		IBAN = this.generazioneIBAN();
		flagFido = false;
		Frutto frutto = new Frutto ( this, interessi);
		frutto.start();
	}
	
	public ContoCorrente(String CodicePaese, String CodiceDiSicurezza, char CIN, String ABI, 
			String CAB, String Conto, double interessi) {//IBAN dato parte per parte, no fido
		IBAN = new IBAN(CodicePaese, CodiceDiSicurezza, CIN, ABI, CAB, Conto);
		this.interessi = interessi;
		flagFido = false;
		Frutto frutto = new Frutto ( this, interessi);
		frutto.start();
	}
	
	public ContoCorrente(String Full) {//IBAN dato, no fido
		IBAN = new IBAN(Full);
		flagFido = false;
		Frutto frutto = new Frutto ( this, interessi);
		frutto.start();
	}
	
	public ContoCorrente(String CodicePaese, String CodiceDiSicurezza, char CIN, String ABI, 
			String CAB, String Conto, double f, double interessi) {//IBAN dato parte per parte, si fido
		IBAN = new IBAN(CodicePaese, CodiceDiSicurezza, CIN, ABI, CAB, Conto);
		fido = f;
		flagFido = true;
		Frutto frutto = new Frutto ( this, interessi);
		frutto.start();
	}
	
	public ContoCorrente(String Full, double f) {//IBAN dato, si fido
		IBAN = new IBAN(Full);
		fido = f;
		flagFido = true;
		Frutto frutto = new Frutto ( this, interessi);
		frutto.start();
	}

	
	public IBAN generazioneIBAN() {
		IBAN IBAN;
		String paese = "IT";
		String CodiceDiSicurezza = Integer.toString((int)(Math.random() * 9));
		CodiceDiSicurezza += Integer.toString((int)(Math.random() * 9));
		char CIN = (char)(int)(Math.random() * 25 + 65);
		//abi della nostra banca
		String CAB = null;
		switch((int)(Math.random() * 2)) {//si usa questo random per mettere il caso che
		//l'utente vada in una delle filiali,
		//quindi si rendono un po' piú variabili
		case 0:
		CAB = this.CAB[0];
		break;
		case 1:
		CAB = this.CAB[1];
		break;
		case 2:
		CAB = this.CAB[2];
		break;
		}
		String incConto = Integer.toString(this.incConto);
		for (int i=0; i<12-incConto.length(); i++) {
			conto += "0";
		}
		conto += incConto;
		IBAN = new IBAN(paese, CodiceDiSicurezza, CIN, ABI, CAB, conto);
		return IBAN;
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
	
	
	public double getSaldo() {
		
		return saldo;		
	}
	
	public double getFIdo() {
		
		return fido;		
	}
	
	
	public void setSaldo(double s) {
		
		saldo = s;
	}
	
	
	public void setFido(double f) {
		
		fido = f;		
	}

	public IBAN getIBAN() {
		return IBAN;
	}

	public void setIBAN(IBAN iBAN) {
		IBAN = iBAN;
	}
}