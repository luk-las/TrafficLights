package SS;

public enum Swiatlo {
	CZERWONE(5000), ZOLTE(1000), ZIELONE(4000);
	
	private int czas;
	
	Swiatlo(int czas){
		this.czas = czas;
	}
	
	int dajCzas() {
		return czas;
	}
}
