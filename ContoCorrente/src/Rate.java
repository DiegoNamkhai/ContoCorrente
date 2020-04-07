

public class Rate extends Cliente{

	private int nRate;
	private boolean fine = false;
	
	public Rate(ContoCorrente c, int nRate) {
		super(c);
		this.nRate = nRate;
	}
	
	public void run() {
		while(!fine) {
			
		}
		
	}
	
	public boolean time() {
		
		long tempoIniziale = System.currentTimeMillis();
		tempoIniziale = tempoIniziale / 1000; //Da millisecondi a secondi
		long tempoFinale;
		long tempoTrascorso = 0;
		while(tempoTrascorso == 30) {	
				tempoFinale = System.currentTimeMillis();
				tempoFinale = tempoFinale / 1000; //Da millisecondi a secondi
				tempoTrascorso = tempoTrascorso + (tempoFinale - tempoIniziale);
		}
			return true;		
	}
}