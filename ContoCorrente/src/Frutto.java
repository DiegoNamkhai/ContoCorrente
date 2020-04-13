import java.util.Calendar;
import java.util.GregorianCalendar;

public class Frutto extends Thread{
	//interessi attici senza vincoli con capitalizzazione trimestrale
	private double interessi;
	private ContoCorrente conto;
	private int mesi3 = -1;// mesi tre perché é trimestrale
	
	public Frutto(ContoCorrente conto, double interessi) {
		this.interessi = interessi;
		this.conto = conto;
	}
	
	
	
	private boolean time() {
		
		Calendar calendar = new GregorianCalendar();
		int second = calendar.get(Calendar.SECOND);
		if (second == 0 || second == 30 ) {
			mesi3++;
			if (mesi3 == 3) {
				mesi3 = 0;
				return true;
			}
		}
		return false;
	}

}
