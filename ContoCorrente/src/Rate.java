

public class Rate extends Cliente{

	private int nRate;
	
	public Rate(ContoCorrente c, double addebbito, double nrate, int nRate) {
		super(c, addebbito);
		this.nRate = nRate;
	}

	
	private boolean fine = false;
	
	
	public void run() {
		while(nRate>0)
			try {
				
				if (this.time()) {
					if(!conto.addebito(addebito)) {
						nRate++;
					}
				} 
				
			}
				catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			nRate--;
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

