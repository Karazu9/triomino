package projet;

public class plateau {
// Classe concernant le plateau de jeu
	
	triomino[][] plat; // Tableau de triomino en deux dimensions.
	int ligne;         // Peut contenir jusqu'a 30 pieces
	int colonne;  
	
	
	// Constructeur
	public plateau() {
		triomino[][] plat = new triomino[28][28];
	}
	
	// Accesseur
	public int getLigne()
	{
		return this.ligne;	
	}
	
	public int getColonne()
	{
		return this.colonne;
	}
	
	// Méthodes
	
}
