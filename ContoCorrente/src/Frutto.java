import java.util.Calendar;
import java.util.GregorianCalendar;

public class Frutto extends Thread{
	// Interessi attici senza vincoli con capitalizzazione trimestrale
	private double interessi;
	private ContoCorrente conto;
<<<<<<< HEAD
	private int mesi3 = -1;// Mesi tre perché é trimestrale
=======
	private int mesi3 = 0;// mesi tre perché é trimestrale
	private int zeroTime;//giorno di apertura conto
	private int oneMonth;//un mese dopo
	//i giorni in un anno sono sempre 365, sennó diverebbe troppo complesso
	//1 secondo = 1 giorno
>>>>>>> branch 'master' of https://github.com/DiegoNamkhai/ContoCorrente.git
	
	public Frutto(ContoCorrente conto, double interessi) {
		this.interessi = interessi;
		this.conto = conto;
	}
	
<<<<<<< HEAD
=======
	public void run() {
		
		Calendar calendar = new GregorianCalendar();
		int zeroTime = calendar.get(Calendar.SECOND);
		int oneMonth = zeroTime + 30;
		if (oneMonth>59)
			oneMonth -= 60;
		while(true) {
			if(this.time()) { 
				try {
					conto.accredito(conto.getSaldo()*interessi);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
>>>>>>> branch 'master' of https://github.com/DiegoNamkhai/ContoCorrente.git
	private boolean time() {
		
		Calendar calendar = new GregorianCalendar();
		int second = calendar.get(Calendar.SECOND);
		if (second == zeroTime || second == oneMonth ) {
			mesi3++;
			if (mesi3 == 2) {//arriva a due perché parte da 0
				mesi3 = 0;
				return true;
			}
		}
		return false;
	}
}