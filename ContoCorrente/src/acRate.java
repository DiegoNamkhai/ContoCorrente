
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
				catch (InterruptedException e) {e.printStackTrace();}
			nRate--;
			try {
				Thread.sleep(500);//per non incepparle il pc
				//se vuole usare il processore al 100 fisso, tolga lo sleep
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}