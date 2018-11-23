package projet;

public class triomino {
// Classe convernant les pieces de triominos
	
	//Face du triomino
	face no;
	face ne;
	face south; 
	int Cmax = 5,Cmin = 0; // Constante de limite des valeurs triominos
	
	//Constructeur
	public triomino(int x,int y,int z)
	{
		if ((x < Cmax+1) && (y < Cmax+1) && (z < Cmax+1) && (x >= Cmin) && (y >= Cmin) && (z >= Cmin)) // Il faut que les valeurs soient entre 0 et 5
		{
			no = new face(x,y);
			ne = new face(x,z);
			south = new face(y,z);					
	    } else 
	    {
	    	System.out.print("erreur dans les valeurs saisies");
	    }
	}

	//Methodes
	/*
	public void rotation_gauche()
	// Rotation a gauche [a,b,c] => [b,c,a] => [c,a,b] => [a,b,c]
	{
		int tmp;
		tmp = this.a;
		this.a = this.b;
		this.b = this.c;
		this.c = tmp;
	}
*/
	public face get_face_NE()
	// Methode pour r�cup�rer la face a et b situ� en haut et a droite
	{
		return this.ne;	
	}
	
	// En travaux, besoin de travailler sur une frontiere a implementer dans une classe
	
	/*
	public void placer_triomino(plateau_frontiere A)
	// Prends en parametre un plateau A sur lequel on placera le triomino
	// Le but de cet m�thode est de tester les combinaisons possibles de la frontiere avec le triomino
	{
		int i,j,h; // iterateur pour le tableau du plateau
		face[] B;
	
		
		// Dans le cas ou la frontiere est vide :
		if(A.frontiere[0] == NULL)
		{
			System.out.println("Il n'y a pas de triomino sur ce plateau.");
			A.frontiere[0] = this.ne;
			A.frontiere[1] = this.no;
			A.frontiere[2] = this.south;
		}
		// Dans le cas ou la frontiere n'est pas vide
		for (i = 0; i <= A.length; i++)
		{		
				B[j] = A.frontiere[j]; // On sauvegarde les valeurs pour d�caler si il existe un triomino
							 		   // Qui puisse s'ajouter a la frontiere			
				if (A.frontiere[i] == this.ne)
				// Si deux cases cote a cote sont egaux pour la frontiere et le triomino alors
				// le triomino se rajoutera a la frontiere en rajoutant l'�l�ment qui ne match pas
				// entre les deux valeurs qui match dans le tableau	
				{
					//A finir
					A.frontiere[i] = this.ne;
					for(h = i+1; h <= A.length; h++)
					// D�calage des valeurs de la frontiere pour lib�rer une place
					{
						A.frontiere[h] = B[h]; // A partir de A[i+2] on met les valeurs de i+1 a la fin
					}
				}
		}
	}
	*/	
}