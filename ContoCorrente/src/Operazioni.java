
public class Operazioni {

	public static void main(String[] args) throws InterruptedException {
		
		ContoCorrente c = new ContoCorrente(3000);
		c.accredito(1000);
		c.stampaSaldo();
		c.addebito(2000);
		c.stampaSaldo();
		c.addebito(2100);
	}
}