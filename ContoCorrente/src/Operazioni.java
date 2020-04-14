
public class Operazioni {

	public static void main(String[] args) throws InterruptedException {
		
		ContoCorrente c1 = new ContoCorrente();// Conto corrente con IBAN autogenerato senza fido
		ContoCorrente c2 = new ContoCorrente(3000);// Conto corrente con IBAN autogenerato e con fido
		ContoCorrente c3 = new ContoCorrente("IT","39",'A',"95638","04721","000000000654",1);// Conto corrente con IBAN dato parte per parte senza fido e con interessi
		ContoCorrente c4 = new ContoCorrente("IT65B9432190705000000000034");// Conto corrente con IBAN intero senza fido 
		ContoCorrente c5 = new ContoCorrente("IT","99",'D',"16043","67584","000000008076",2500,1);// Conto corrente con IBAN dato parte per parte con fido e con interessi
		ContoCorrente c6 = new ContoCorrente("IT33H6549817054000000015693",1000);// Conto corrente con IBAN intero con fido  
		
		Transazione ac = new Transazione(c1, 3000, "accredito");
		ac.start();
		
		
		
		System.out.println("Conto corrente con IBAN autogenerato senza fido:\nIBAN: "+c1.getIBAN().getFull()+"\nSaldo: "+c1.getSaldo()+"\nFido: "+c1.getFido());
		System.out.println("Conto corrente con IBAN autogenerato e con fido:\nIBAN: "+c2.getIBAN().getFull()+"\nSaldo: "+c2.getSaldo()+"\nFido: "+c2.getFido());	
		System.out.println("Conto corrente con IBAN dato parte per parte senza fido e con interessi:\nIBAN: "+c3.getIBAN().getFull()+"\nSaldo: "+c3.getSaldo()+"\nFido: "+c3.getFido());	
		System.out.println("Conto corrente con IBAN intero senza fido:\nIBAN: "+c4.getIBAN().getFull()+"\nSaldo: "+c4.getSaldo()+"\nFido: "+c4.getFido());	
		System.out.println("Conto corrente con IBAN dato parte per parte con fido e con interessi:\nIBAN: "+c5.getIBAN().getFull()+"\nSaldo: "+c5.getSaldo()+"\nFido: "+c5.getFido());	
		System.out.println("Conto corrente con IBAN intero con fido:\nIBAN: "+c6.getIBAN().getFull()+"\nSaldo: "+c6.getSaldo()+"\nFido: "+c6.getFido());	
	}
}