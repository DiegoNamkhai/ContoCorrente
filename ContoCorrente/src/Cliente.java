public class Cliente extends Thread{

	protected ContoCorrente conto;
	protected double addebito;
	
	public Cliente(ContoCorrente c, double addebbito) {
		conto = c;
		this.addebito = addebito;
	}
	
	public void run() {
		try {
			conto.addebito(addebito);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}