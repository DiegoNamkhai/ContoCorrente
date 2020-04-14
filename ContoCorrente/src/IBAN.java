
public class IBAN {
	private String CodicePaese;
	private String CodiceDiSicurezza;
	private char CIN;
	private String ABI ;
	private String CAB;
	private String Conto;
	private String Full;
	
	public IBAN(String CodicePaese, String CodiceDiSicurezza, char CIN, String ABI, 
			String CAB, String Conto)
	{
		this.CodicePaese = CodicePaese;
		this.CodiceDiSicurezza = CodiceDiSicurezza;
		this.CIN = CIN;
		this.ABI = ABI;
		this.CAB = CAB;
		this.Conto = Conto;
		Full = CodicePaese+CodiceDiSicurezza+CIN+ABI+CAB+Conto;
	}
	
	public IBAN(String Full)
	{
		this.Full = Full;
		CodicePaese = Full.substring(0, 1);
		CodiceDiSicurezza = Full.substring(2, 3);
		CIN = Full.charAt(4);
		ABI = Full.substring(5, 9);
		CAB = Full.substring(10, 14);
		Conto = Full.substring(15, 26);
	}	

	public String getCodicePaese() {
		return CodicePaese;
	}

	public void setCodicePaese(String codicePaese) {
		CodicePaese = codicePaese;
	}

	public String getCodiceDiSicurezza() {
		return CodiceDiSicurezza;
	}

	public void setCodiceDiSicurezza(String codiceDiSicurezza) {
		CodiceDiSicurezza = codiceDiSicurezza;
	}

	public char getCIN() {
		return CIN;
	}

	public void setCIN(char cIN) {
		CIN = cIN;
	}

	public String getABI() {
		return ABI;
	}

	public void setABI(String aBI) {
		ABI = aBI;
	}

	public String getCAB() {
		return CAB;
	}

	public void setCAB(String cAB) {
		CAB = cAB;
	}

	public String getConto() {
		return Conto;
	}

	public void setConto(String conto) {
		Conto = conto;
	}

	public String getFull() {
		return Full;
	}

	public void setFull(String full) {
		Full = full;
	}	
}