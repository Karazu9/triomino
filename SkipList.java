package projet;

import java.util.Random;

public class SkipList {

	// Parametres 
	
	public SkipListEntry head; // First element of the top level
	public SkipListEntry tail; // Last element of the top
	
	public int n; // number of entries in the Skiplist
	
	public int h; // Height
	Random r ; // Coin toss

	// Constructeur
	
	public SkipList() 
	{
		SkipListEntry p1,p2;
		
		// On instancie +oo et -oo
		p1 = new SkipListEntry(SkipListEntry.negInf, (face) null);
		p2 = new SkipListEntry(SkipListEntry.posInf, (face) null);
	
		// On initialise la tête et la queue
		// tel que :
		// [-oo]----------------->[+oo] 
		
		
		head = p1;
		tail = p2;
		
		// On lie +oo et -oo pour initialiser la skip-list
		p1.right = p2;
		p2.left = p1;
		
		n = 0;
		h = 0;
		r = new Random();
	
	}
	
	// Methodes
	
	//________________Retirer________________//
	
	  public face Retirer(String key) 
	  {
	     return(null);
	  }
	
	//________________ Recherche_______________//
	
	 public SkipListEntry Recherche(String k)
	  {
	     SkipListEntry p;

	     p = head;

	     while (true)
	     {
	        while (p.right.key != SkipListEntry.posInf && p.right.key.compareTo(k) <= 0)
	        {
	           p = p.right;
	        }
	        // Si on peut descendre alors on execute la suite :
		
	        if ( p.down != null )
	        {  
	           p = p.down;
	        }
	        else
		   break;	// Une fois que l'on arrive tout en bas, on force la sortie
	     }

	     return(p); // p.key <= k
	  }
		
	//__________________Get________________//
		
		public face get(String k)
		{
			SkipListEntry p;
			
			p = Recherche(k);
			
			if (k.equals(p.key))
			{
				return(p.value);
			}
			else
			{
				return(null);
			}
		}
		
	//____________________Put__________________//
		
		public face put (String k, face v)
		{
			SkipListEntry p,q;
			int i;
			face temp;
			
			
			p = Recherche(k);
			
			if(k.equals(p.key))
			{
				temp = p.value; // On sauvegarde la face
				p.value = v; // On le met a jour
				return (temp);
			}
			
			// Si on ne met pas a jour, on met une nouvelle valeur
			
			q = new SkipListEntry(k,v); // On créé une nouvelle entrée
			
			q.left = p;
			q.right = p.right;
			p.right.left = q;
			p.right = q;
			
			i = 0;  // On initialise la hauteur
			
			// A partir de la, on décide avec un lancé de piece si on monte de niveau dans cet insertion
			
			while(r.nextDouble() < 0.5)
			{
				// Si le lancé donne "face" alors on créé un nouvel étage :
				if(i >= h)
				{
					
					// Création du nouvel étage
					SkipListEntry p1, p2;
					
					// La hauteur augemente....
					h = h + 1;

					p1 = new SkipListEntry(SkipListEntry.negInf,null);
					p2 = new SkipListEntry(SkipListEntry.posInf,null);
					
					// Initialisation de ce nouvel étage
					p1.right = p2;
					p1.down  = head;

					p2.left = p1;
					p2.down = tail;

					head.up = p1;
					tail.up = p2;

					head = p1;
					tail = p2;
				}
				
				while(p.up == null)
				{
					p = p.left;
				}
				
				// On pointe a l'élément du dessus
				p = p.up;

				// On ajoute une nouvelle valeur et sa clef dans la colonne
			   	SkipListEntry e;
			   		 
			   	e = new SkipListEntry(k, null);
			   		 
			   	// On initialise e
			   	e.left = p;
			   	e.right = p.right;
			   	e.down = q;
			   	
			   	// On change les pointeurs avoisinant p et q
			   	p.right.left = e;
			   	p.right = e;
			   	q.up = e;

			    q = e;		// Set q up for the next iteration

			    i = i + 1;	// Current level increased by 1

			   }
		
		n = n + 1;
		return(null);   
	}
}
