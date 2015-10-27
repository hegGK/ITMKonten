
public class KontoTest {

	static void ueberweisen(double betrag, Konto kontoA, Konto kontoZ){
		kontoA.auszug();
		kontoZ.auszug();
		kontoA.auszahlen(betrag);
		kontoZ.einzahlen(betrag);
		System.out.print("Von Konto " + kontoA.getKontonummer());
		System.out.print(" wurden " + betrag + " Euro ");
		System.out.println("auf Konto " + kontoZ.getKontonummer() + " ueberwiesen.");
		kontoA.auszug();
		kontoZ.auszug();
	}
	
	static void testGleichheit()
	{
		System.out.println("Anzahl Konten: "+Konto.zaehler);
		Konto meinKonto = new Konto(4531088);
		System.out.println("Anzahl Konten: "+Konto.zaehler);
		Konto deinKonto = new Konto(4531088);
		System.out.println("Anzahl Konten: " + Konto.zaehler);
		System.out.println("Kontonummer von \"deinKonto\": " + deinKonto.kontonummer);

		meinKonto.einzahlen(300.00);
		deinKonto.einzahlen(400.00);

		Konto unserKonto;
		// Zuweisung
		unserKonto=deinKonto;

		// Vergleich
		if (meinKonto == deinKonto)
			System.out.println("Mein Konto und dein Konto sind identisch.");
		else 
			System.out.println("Mein Konto und dein Konto sind verschieden.");

		if (meinKonto.equals(deinKonto))
			System.out.println("Mein Konto und dein Konto sind equal.");
		else 
			System.out.println("Mein Konto und dein Konto sind nicht equal.");
		
		if (unserKonto == deinKonto)
			System.out.println("Unser Konto und dein Konto sind identisch.");
		else 
			System.out.println("Unser Konto und dein Konto sind verschieden.");

		// Parameter
		ueberweisen(30.00, meinKonto, deinKonto);
		
	}
	
	static void testMethoden()
	{
		Sparkonto meinSparkonto = new Sparkonto(5613990,3.4);

		// jede Instanz der Klasse Sparkonto hat 3 Attribute
		System.out.print("Kontonummer: "+meinSparkonto.getKontonummer()); 	// geerbtes Attribut
		System.out.print(" Saldo: "+meinSparkonto.getSaldo()+" Euro"); 		//geerbtes Attribut
		System.out.println(" Zinssatz: "+meinSparkonto.getZinssatz()); 		// neu deklariertes Attribut
		
		// Methoden einzahlen(betrag), auszahlen(betrag) und auszug() koennen verwendet werden
		meinSparkonto.einzahlen(250.00); 	// geerbte Methoden
		meinSparkonto.auszug();
		meinSparkonto.auszahlen(10.00);
		meinSparkonto.auszug();
		
		// ausserdem gibt es fuer Instanzen der Klasse Sparkonto die Methode verzinsen()
		meinSparkonto.verzinsen(); 			// neu implementierte Methode
		meinSparkonto.auszug();
	}
	
	static void testReimplementierung()
	{
		Konto meinKonto = new Konto(4531088);
		meinKonto.einzahlen(400.00);
		meinKonto.auszug();
		System.out.println("Versuche 100 Euro abzuheben.");
		meinKonto.auszahlen(100.00); // Methode auszahlen(betrag) der Klasse Konto
		meinKonto.auszug();
		System.out.println("Versuche 500 Euro abzuheben.");
		meinKonto.auszahlen(500.00); // Methode auszahlen(betrag) der Klasse Konto
		meinKonto.auszug();
		System.out.println();
		
		Girokonto meinGirokonto = new Girokonto(1733065,100);
		meinGirokonto.einzahlen(400.00);
		meinGirokonto.auszug();
		System.out.println("Versuche 100 Euro abzuheben.");
		meinGirokonto.auszahlen(100.00); // Methode auszahlen(betrag) der Klasse Girokonto
		meinGirokonto.auszug();
		System.out.println("Versuche 500 Euro abzuheben.");
		meinGirokonto.auszahlen(500.00); // Methode auszahlen(betrag) der Klasse Girokonto
		meinGirokonto.auszug();
	}
	
	static void testPolymorphismus()
	{
		Konto meinKonto ; // Variable vom Typ Konto
		meinKonto = new Konto(4531088); // meinKonto zeigt auf ein Objekt vom Typ Konto
		machMal(meinKonto);
		meinKonto.auszug();
		System.out.println();
		
		meinKonto = new Sparkonto(5613990,100); // meinKonto zeigt jetzt auf ein Objekt vom Typ Girokonto
  // Methode auszahlen(betrag) der Klasse Girokonto wird aufgerufen
		((Sparkonto)meinKonto).verzinsen();
		
		// --> Polymorphismus & dynamische Bindung
		meinKonto.auszug();
		System.out.println();
		meinKonto = new Sparkonto(1733065,1.25); // meinKonto zeigt jetzt auf ein Objekt vom Typ Sparkonto
		meinKonto.einzahlen(400.00);
		meinKonto.auszug();
		meinKonto.auszahlen(100.00); // Methode auszahlen(betrag) der Klasse Sparkonto wird aufgerufen
		meinKonto.auszug();
		
//		meinKonto.verzinsen(); // Fehler: die Klasse Konto kennt die Methode verzinsen() nicht */
		((Sparkonto)meinKonto).verzinsen();
		meinKonto.auszug();
	}

	private static void machMal(Konto meinKonto) {
		meinKonto.einzahlen(300.00);
		meinKonto.auszug();
		meinKonto.auszahlen(500.00);
	}
	
	private static void tuWas( Sparkonto k){
		System.out.println("Sparkonto tut was.");
	}
	
	private static void tuWas( Konto k){
		System.out.println("Konto tut was.");
	}
	
	static void testMulti()
	{
		int i = 7;
		System.out.println(i);
		Integer I = i;
		System.out.println(I.toString());
//		i.toString();
		System.out.println(((Integer)i).toString());
		
		Konto k = new Sparkonto(12345,1.0);
		tuWas(k);
		
	}

	static void testZuweis()
	{

		Girokonto gkonto = new Girokonto(1733065,100);
		Konto konto1 = gkonto;
		Object obj1 = konto1;
				
		Sparkonto skonto = new Sparkonto(12345,1.0);
		Konto konto2 = skonto;
		Object obj2 = konto2;
				
//		System.out.println(konto1.limit);
		System.out.println(konto1.kontonummer);
//		System.out.println(obj1.limit);
//		System.out.println(obj1.kontonummer);
		
//		Girokonto giro1 = konto1;
		Girokonto giro2 = (Girokonto)konto1;
		System.out.println(giro2.limit);
		
//		Girokonto giro3 = (Girokonto)konto2;
//		System.out.println(giro3.limit);
		
		System.out.println("Toll" instanceof String );
		System.out.println("Toll" instanceof Object );
		System.out.println(new Girokonto(12345,100.0) instanceof Object );
		
		Girokonto go1 = new Girokonto(1234567, 200.0);
		System.out.println("go1 instanceof Girokonto:" + (go1 instanceof Girokonto ));
		System.out.println("go1 instanceof Konto:" + (go1 instanceof Konto ));
//		System.out.println("go1 instanceof Girokonto:" + (go1 instanceof Sparkonto ));
		System.out.println("go1 instanceof Object:" + (go1 instanceof Object ));
		
		Konto go2 = new Girokonto(1234567, 200.0);
		System.out.println("go2 instanceof Girokonto:" + (go2 instanceof Girokonto ));
		System.out.println("go2 instanceof Konto:" + (go2 instanceof Konto ));
		System.out.println("go2 instanceof Sparkonto:" + (go2 instanceof Sparkonto ));
		System.out.println("go2 instanceof Object:" + (go2 instanceof Object ));
		
		Object go3 = new Girokonto(1234567, 200.0);
		System.out.println("go3 instanceof Girokonto:" + (go3 instanceof Girokonto ));
		System.out.println("go3 instanceof String:" + (go3 instanceof String ));
		System.out.println("go3 instanceof Konto:" + (go3 instanceof Konto ));
		System.out.println("go3 instanceof Sparkonto:" + (go3 instanceof Sparkonto ));
		System.out.println("go3 instanceof Object:" + (go3 instanceof Object ));
		
	}

	public static void main(String[] args) 
	{
/*		System.out.println("--------------- Gleichheit ------------------");
		testGleichheit();
		System.out.println();

		System.out.println("--------------- Methoden ------------------");
		testMethoden();
		System.out.println();

		System.out.println("--------------- Reimplementierung ------------------");
		testReimplementierung();
		System.out.println();

		System.out.println("--------------- Polymorphismus ------------------");
		testPolymorphismus();
		System.out.println();

		System.out.println("--------------- Multi ------------------");
		testMulti();
*/		
		System.out.println("--------------- Zuweis ------------------");
		testZuweis();
	}

}
