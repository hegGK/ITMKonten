
public class Konto {
	static int zaehler = 0;		// --> Klassenvariable
	public int kontonummer;	// --> Instanzvariablen
	protected double saldo;
	
	public Konto(int nummer){
		zaehler = zaehler + 1;
		kontonummer = nummer;
		saldo = 0.00;
	}
	
	public int getKontonummer(){
		return kontonummer;
	}
	
	public double getSaldo(){
		return saldo;
	}
	
	public void einzahlen(double betrag){
		saldo = saldo + betrag;
	}
	
	public void auszahlen(double betrag){
		saldo = saldo - betrag;
	}
	
	public void auszug(){
		System.out.println("Kontonummer: "+kontonummer+" Saldo: "+saldo+" Euro");
	}
	
	public boolean equals(Konto o)
	{
		return this.kontonummer == o.kontonummer;
	}
	
}
