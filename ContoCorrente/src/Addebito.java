public class Addebito extends Transazione{

	public Addebito(ContoCorrente c, double addebito) {
		super(c, addebito);
		
	}
	
	public void run() {
		try {
			conto.addebito(soldi);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}