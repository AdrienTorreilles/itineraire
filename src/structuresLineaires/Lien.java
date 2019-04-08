package structuresLineaires;

public class Lien<T> {
	
	protected Lien<T> suivant;

	
	
	public Lien() {
		suivant=null;
	}
	
	protected Lien<T> suivant(){
		
		return suivant;
	}
	
	protected void suivant(Lien<T> e) {
		
		suivant=e;
	}

}
