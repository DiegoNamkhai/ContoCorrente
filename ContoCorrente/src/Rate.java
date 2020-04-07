

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
		long tempoFinale;
		long tempoTrascorso = 0;
		while(nRate != 0) {
			while(tempoTrascorso == 30) {	
				tempoFinale = System.currentTimeMillis();
				tempoTrascorso = tempoTrascorso + (tempoFinale - tempoIniziale);
			}
			nRate--;
		}
		return true;
	}
}