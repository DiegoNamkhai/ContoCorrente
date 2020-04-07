public class Cliente extends Thread{

	private ContoCorrente conto;
	private double addebito;
	
	public Cliente(ContoCorrente c, double addebbito) {
		conto = c;
		this.addebito = addebito;
	}
	
	public void run() {
		conto.addebito(addebito);
	}
	
}