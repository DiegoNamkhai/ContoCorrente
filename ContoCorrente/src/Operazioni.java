
public class Operazioni {

	public static void main(String[] args) throws InterruptedException {
		
		ContoCorrente c1 = new ContoCorrente();// Conto corrente con IBAN autogenerato senza fido
		ContoCorrente c2 = new ContoCorrente(3000);// Conto corrente con IBAN autogenerato e con fido
		ContoCorrente c3 = new ContoCorrente("IT","39",'A',"95638","04721","000000000654",1);// Conto corrente con IBAN dato parte per parte senza fido e con interessi
		ContoCorrente c4 = new ContoCorrente("IT65B9432190705000000000034");// Conto corrente con IBAN intero senza fido 
		ContoCorrente c5 = new ContoCorrente("IT","99",'D',"16043","67584","000000008076",2500,1);// Conto corrente con IBAN dato parte per parte con fido e con interessi
		ContoCorrente c6 = new ContoCorrente("IT33H6549817054000000015693",1000);// Conto corrente con IBAN intero con fido  
		

		Transazione t1 = new Transazione(c1, 2500, "accredito");
		Transazione t2 = new Transazione(c2, 8000, "accredito");
		Transazione t3 = new Transazione(c3, 250000, "accredito");
		Transazione t4 = new Transazione(c4, 85000, "accredito");
		Transazione t5 = new Transazione(c5, 500, "accredito");
		Transazione t6 = new Transazione(c6, 1500, "accredito");

		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		t6.join();
		
		System.out.println("Conto corrente con IBAN autogenerato senza fido:\nIBAN: "+c1.getIBAN().getFull()+"\nSaldo: "+c1.getSaldo()+"\nFido: "+c1.getFido());
		System.out.println("Conto corrente con IBAN autogenerato e con fido:\nIBAN: "+c2.getIBAN().getFull()+"\nSaldo: "+c2.getSaldo()+"\nFido: "+c2.getFido());	
		System.out.println("Conto corrente con IBAN dato parte per parte senza fido e con interessi:\nIBAN: "+c3.getIBAN().getFull()+"\nSaldo: "+c3.getSaldo()+"\nFido: "+c3.getFido());	
		System.out.println("Conto corrente con IBAN intero senza fido:\nIBAN: "+c4.getIBAN().getFull()+"\nSaldo: "+c4.getSaldo()+"\nFido: "+c4.getFido());	
		System.out.println("Conto corrente con IBAN dato parte per parte con fido e con interessi:\nIBAN: "+c5.getIBAN().getFull()+"\nSaldo: "+c5.getSaldo()+"\nFido: "+c5.getFido());	
		System.out.println("Conto corrente con IBAN intero con fido:\nIBAN: "+c6.getIBAN().getFull()+"\nSaldo: "+c6.getSaldo()+"\nFido: "+c6.getFido());
		
		Transazione t7 = new Transazione(c2, 500, "addebito");
		Transazione t8 = new Transazione(c2, 2500, "accredito",12);
		Transazione t9 = new Transazione(c2, 250, "accredito");
		Transazione t10 = new Transazione(c2, 30, "addebito", 10);
		Transazione t11 = new Transazione(c2, 100, "addebito");
		Transazione t12 = new Transazione(c2, 1500, "accredito");
		
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
		t7.join();
		t8.join();
		t9.join();
		t10.join();
		t11.join();
		t12.join();
		
	}
}