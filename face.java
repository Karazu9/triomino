package projet;

public class face {

	int face[];
	
	// Constructeur 
	
	face(int x, int y)
	{
		face[0]=x;
		face[1]=y;
	}

public int getX() {
	return this.face[0];
}

public int getY() {
	return this.face[1];
}

}


