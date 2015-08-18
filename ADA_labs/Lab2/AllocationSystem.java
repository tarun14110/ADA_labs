/* Name=Tarun Kumar
 * Roll no.=2014110
 * 
 * 
 * 
 */



package com.iiitd.ap.lab2;

import java.util.*;
import java.util.ArrayList;

public class AllocationSystem {

	int  num;
	int numofUG;
	int numofPG;
	int numofPHD;
	
	
	
	AllocationSystem(int n)
	{
		num=n;
		
		
		numofPG=n/2;
		numofPHD=n/2;
		numofUG=(int)(0.3*n);
	}
	
	
	
	 ArrayList<Applicant> getshortlist(ArrayList<Applicant> A) throws InvalidInputException
	{

		
		 
		
		try{
			 if(num>A.size())  
			      throw new InvalidInputException();  
		
		}
	catch(Exception m){System.out.println("Exception occured: "+m);}
		
		
		 
		
		Collections.sort(A);
	
		ArrayList<Applicant> B = new ArrayList<Applicant>();
		int k=0;
		
		for(int i=0;i<A.size() && k<numofPHD;++i)
		{ 			
			if(A.get(i).program.equals("PhD"))
			{
				B.add(A.get(i));
				++k;
			}
			}
			
		k=0;
		
		for(int i=0;i<A.size() && k<numofPG ;++i)
			{
			if(A.get(i).program=="PG")
			{
				B.add(A.get(i));
				++k;
			}}
			
		
		k=0;
	
		
			for(int i=0;i<A.size() && k<numofUG;++i){
			if(A.get(i).program=="UG")
			{
				B.add(A.get(i));
				++k;
				
			}}
			
	
			
			
			
			return B;
			
			
			
		
			
			
		
		
		
		
		//catch
		//finally{
		
	//	}
		
	}
	
	
	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}

}



class InvalidInputException extends Exception{  
    InvalidInputException(){  
     super();  
    }  
   }  
