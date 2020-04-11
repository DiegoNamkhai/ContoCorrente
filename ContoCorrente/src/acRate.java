
public class acRate extends Transazione{
	
	public acRate(ContoCorrente c, double soldi, int nRate) {
		super(c,soldi,nRate);
	}
	
	public void run() {
		while(nRate>0)
			try {
				
				if (this.time()) {
					conto.accredito(soldi); 
				}
				
			}
				catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			nRate--;
		}
	

}
