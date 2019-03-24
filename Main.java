package SS;

public class Main {

	public static void main(String[] args) {
		Wyswietlanie w = new Wyswietlanie(Swiatlo.ZIELONE);
		
		int liczbaCykli = 5;
		for(int i=0; i<liczbaCykli*3; i++) {
			System.out.println(w.dajKolor());
			w.czekaNaZmianeSwiatla();
		}
		
		w.zatrzymaj();
	}
}
