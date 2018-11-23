package projet;
import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main(String[] args) {
		
		//www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Map/skip-list-impl.html
		
		// Premiere etape : Creer la liste de triomino
		
		List<triomino> pioche = new ArrayList<triomino>();
		int x,y,z;
		
		for (x = 0; x <= 5; x++)
		{
			for (y = 0; y <= 5; y++)
			{
				for (z = 0; z <= 5; z++)
				{
					triomino trio = new triomino(x,y,z);
					pioche.add(trio);
				}
			}
		}
		
		System.out.println(pioche.get(1));
	}
}