
/*
 *@ author Tarun Kumar Yadav
 *	Roll no:- 2014110
 */

package com.iiitd.ap.lab1;


public class SelectionSorting {
	public static int swaps=0;
	public static <T extends Comparable> T[] Sort (T[] data)
	{ swaps=0;
	    Integer value;
	 
	    for (int i = 0; i < data.length; i++)
	    {
	        
	        value = i;
	        for (int j = i+1; j < data.length; j++)
	          if (data[j].compareTo(data[value]) < 0)
	            value = j;

	        if(data[i].compareTo(data[value])==0)
	        {}
	        else
	        {
	        ++swaps;
	        }
	        T tem;
	        tem=data[value];
	        data[value]=data[i];
	        data[i]=tem;
	        
	    }
	    System.out.println("hii"+swaps);
	    return data;
	}
	

}
	
