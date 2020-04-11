
public class adRate extends Transazione{

	protected int nRate;
	
	public adRate(ContoCorrente c, double soldi, int nRate) {
		super(c, soldi, nRate);
	}

	
	
	public void run() {
		while(nRate>0)
			try {
				
				if (this.time()) {
					if(!conto.addebito(soldi)) {
						//se non avviene l'addebito si posticipa
						//di un mese la rata
						nRate++;
					}
				} 
				
			}
				catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			nRate--;
		}
		
	
}

