package SS;

public class Wyswietlanie implements Runnable {
	private Thread watek;
	private Swiatlo kolor;
	boolean brakSwiatla = true;
	boolean zmienioneSwiatlo = false;
	
	Wyswietlanie(Swiatlo k){
		kolor = k;		
		watek = new Thread(this);
		watek.start();
	}
	
	Wyswietlanie(){
		kolor = Swiatlo.CZERWONE;
		watek = new Thread(this);
		watek.start();
	}
	
	public void run() {
		while(brakSwiatla) {
			try {
				Thread.sleep(kolor.dajCzas());
			} catch(InterruptedException ie) {
				System.err.println("AWARIA");
			}
			zmianaSwiatla();
			}
	}
	
	synchronized void zmianaSwiatla() {
		switch(kolor) {
			case CZERWONE:
				kolor = Swiatlo.ZIELONE;
				break;
			case ZOLTE:
				kolor = Swiatlo.CZERWONE;
				break;
			case ZIELONE:
				kolor = Swiatlo.ZOLTE;
				break;
			default:
				break;
		}
		zmienioneSwiatlo = true;
		notify();
	}
	
	synchronized void czekaNaZmianeSwiatla() {
		try {
			while(!zmienioneSwiatlo)
				wait();
			zmienioneSwiatlo = false;
		} catch(InterruptedException ie) {
			System.err.println("AWARIA");
		}		
	}
	
	synchronized Swiatlo dajKolor() {
		return kolor;
	}
	
	synchronized void zatrzymaj() {
		brakSwiatla = false;
	}
}
