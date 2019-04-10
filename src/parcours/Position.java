package parcours;



public class Position {

	
	private int x,y;
	
	
	

		public Position(int x,int y) {
		this.x=x;
		this.y=y;
		
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


	/**
	 *  recuperer l'id du marquage
	 */
	@Override
	public int hashCode() {
		
	    return x * 31 + y;	
	    };
	
	    /**
	     * pour verifier l'egalité entre des positions
	     */
	    @Override
	public boolean equals(Object o) {
		if(!(o instanceof Position)) return false;
		Position o2= (Position) o;
		if(this.getX()==o2.getX()&&this.getY()==o2.getY()) return true;
		else return false;
	}
}
