/*
 *@ author Tarun Kumar Yadav
 *	Roll no:- 2014110
 */

package com.iiitd.ap.lab1;




public class InsertionSorting {
public static  int swaps = 0;

public static <T extends Comparable> T[] Sort(T[] data){
		InsertionSorting tem=new InsertionSorting(); 
		tem.swaps=0;
		
		   int j;
		   T toto;
		   
		   for (int i = 0; i < data.length; i++)
		   {
		       toto = data[i];
		       j = i-1;
		       while (j >= 0 && data[j].compareTo(toto)>0)
		       {
		           data[j+1] = data[j];
		           j = j-1;
		           ++tem.swaps;
		       }
		       data[j+1] = toto;
		   }
		   System.out.println("hii"+tem.swaps);
		   return data;
		}


	

	
	

}