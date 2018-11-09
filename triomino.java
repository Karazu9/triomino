package projet;

public class triomino {
// Classe convernant les pieces de triominos
	
	//Face du triomino
	int a;
	int b;
	int c;
	
	//Constructeur
	public triomino(int x,int y,int z)
	{
		if ((x < 6) && (y < 6) && (z < 6) && (x >= 0) && (y >= 0) && (z >= 0)) // Il faut que les valeurs soient entre 0 et 5
		{
			a = x;
			b = y;
			c = z;
	    } else {
	    	System.out.print("erreur dans les valeurs saisies");
	    }
	}

	//Methodes
	
	public void rotation_gauche()
	// Rotation a gauche [a,b,c] => [b,c,a] => [c,a,b] => [a,b,c]
	{
		int tmp;
		tmp = this.a;
		this.a = this.b;
		this.b = this.c;
		this.c = tmp;
	}

	public int[] get_face_NE()
	// Methode pour récupérer la face a et b situé en haut et a droite
	{
		int face[] = {this.a, this.b};
		return face;	
	}
	
	
	
	// En travaux, besoin de travailler sur une frontiere a implementer dans une classe
	
	
	public void placer_triomino(plateau_frontiere A)
	// Prends en parametre un plateau A sur lequel on placera le triomino
	// Le but de cet méthode est de tester les combinaisons possibles de la frontiere
	// avec le triomino
	{
		int i,j,h; // iterateur pour le tableau du plateau
		int faces[] = {this.a, this.b,this.c,this.a}; // Stock les faces de tel : [a,b,c,a]
		int[] B;
	
		// Dans le cas ou la frontiere est vide :
		if(A.frontiere[0] == NULL)
		{
			A.frontiere[0] = this.a;
			A.frontiere[1] = this.b;
			A.frontiere[2] = this.c;
		}
		// Dans le cas ou la frontiere n'est pas vide
		for (i = 0; i <= A.length; i++)
		{
			for(j = 0; j <= faces.length; j++)
			{
				
				B[j] = A.frontiere[j]; // On sauvegarde les valeurs pour décaler si il existe un triomino
							 		   // Qui puisse s'ajouter a la frontiere	
				
				if ((A.frontiere[i] == faces[j]) && (A.frontiere[i+1] == faces[j+1]))
				// Si deux cases cote a cote sont egaux pour la frontiere et le triomino alors
				// le triomino se rajoutera a la frontiere en rajoutant l'élément qui ne match pas
				// entre les deux valeurs qui match dans le tableau	
				{
					A.frontiere[i] = faces[j];
					for(h = i+2; h <= faces.length; h++)
					// Décalage des valeurs de la frontiere pour libérer une place
					{
						A.frontiere[h] = B[h-1]; // A partir de A[i+2] on met les valeurs de i+1 a la fin
					}
					
					A.frontiere[i+1]=faces[j+2];
				}
			}
		}
		
	}
	
	
}
