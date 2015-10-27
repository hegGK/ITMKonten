
public class Sparkonto  extends Konto {
	private double zinssatz; // zusaetzliches Attribut

	// Konstuktor der Klasse Sparkonto
	public Sparkonto(int nummer, double zins){
		super(nummer); // Konstruktor der Superklasse Konto wird aufgerufen
		zinssatz = zins;
	}
	
	// neue Methoden fuer Zugri auf Attribut zinssatz
	public double getZinssatz(){
		return zinssatz;
	}
	
	public void setZinssatz(double zins){
		zinssatz = zins;
	
	}
	
	// neue Methode
	public void verzinsen(){
		saldo = saldo + (zinssatz * saldo)/100;
	
	}
}
