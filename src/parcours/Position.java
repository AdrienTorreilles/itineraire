package parcours;

public class Position {

	
	private int x,y;
	
	private Position precedente;
	
	public Position(int x, int y,Position precedente) {
		this.x=x;
		this.y=y;
		this.precedente=precedente;
	}
	
	public Position getPrecedente() {
		return precedente;
	}

	public void setPrecedente(Position precedente) {
		this.precedente = precedente;
	}

	public Position() {
		
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int hashCode() {
		return 0;
	};
}
