package extras;

import java.util.Comparator;

public class sortByTitle implements Comparator<producto> {


	public int compare(producto a, producto b)
	{
		int result = a.getTitulo().compareToIgnoreCase(b.getTitulo()) ;
		 
					
		 return result;
		
	}

}

