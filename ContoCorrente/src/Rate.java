
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
				
				if (time) {
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
		
	
	}

