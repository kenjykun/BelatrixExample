package extras;

public class SortArrayPrices {

	public producto[] compare(producto[] a)
	{
		int i = 1;
		producto aux = new producto();
		int i3 = a.length -1;
		while (i == 1)

		{i = 0;
			for (int i2 = 1; i2 < i3; i2++) 
			{
				
				//int  r = a[i2].getPrecio().compareTo((a[i2+1].getPrecio()))	;
				
			/* System.out.println("vuelta" + i2);
			  System.out.println(a[i2].getPrecio());
			  System.out.println(a[i2+1].getPrecio());
							*/	
				if (a[i2].getPrecio() < a[i2+1].getPrecio()  ) //si es menor que el parametro que pasamos
				{
					aux = a[i2];
					a[i2]=a[i2+1];
					a[i2+1] = aux;
					i = 1;
				}
			//&& i2+1<i3
			}

			
		}
		return a;
	}
}
