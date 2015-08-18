package com.iiitd.ap.lab2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class Test_AllocationSystem {

		AllocationSystem system;
		int num;
		private Applicant[] appln_list;
		private String[] expected_result;
	    
		public Test_AllocationSystem(Integer num,Applicant[] appln_list,String[] expected_result) {
	    	system=new AllocationSystem(num);
	    	this.num=num;
	    	this.appln_list=appln_list;
	    	this.expected_result=expected_result;
	    	
	    }
		
		@Parameterized.Parameters
		   public static Collection<Object[]> test1() {
			  //[Number of Test Cases][Number of Parameters]
		      Object[][] o = new Object[5][3];
		      //Set #Parameter 1
		      o[0][0]=4;
		      
		      //Set #Parameter 2
		      Applicant[] a = new Applicant[5];
		      a[0]=new Applicant("Madhur","MT1254","PG",7.8);
		      a[1]=new Applicant("Megha","MT1354","PG",8.2);
		      a[2]=new Applicant("Rani","1254","PhD",7.8);
		      a[3]=new Applicant("Jay","2013054","UG",9.3);
		      a[4]=new Applicant("Shabad","MT1554","PG",9.0);
		      o[0][1]=a;
		      
		      //Set #Parameter 3
		      String[] s = new String[4];
		      s[0]="1254";
		      s[1]="MT1554";
		      s[2]="MT1354";
		      s[3]="2013054";
		      o[0][2]=s;
		      
		      
		      
		      //Set #Parameter 1
		      o[1][0]=4;
		      
		      //Set #Parameter 2
		      Applicant[] a2 = new Applicant[5];
		      a2[0]=new Applicant("Madhur","20131254","UG",7.8);
		      a2[1]=new Applicant("Megha","20131354","UG",9.0);
		      a2[2]=new Applicant("Rani","20131258","UG",9.0);
		      a2[3]=new Applicant("Jay","2013054","UG",7.8);
		      a2[4]=new Applicant("Shabad","20131554","UG",9.3);
		      o[1][1]=a2;
		      
		      //Set #Parameter 3
		      String[] s2 = new String[1];
		      s2[0]="20131554";
		      o[1][2]=s2;
		      
		      
		    //Set #Parameter 1
		      o[2][0]=1;
		      
		      //Set #Parameter 2
		      Applicant[] a3 = new Applicant[5];
		      a3[0]=new Applicant("Madhur","MT1254","UG",7.8);
		      a3[1]=new Applicant("Megha","MT1354","UG",8.2);
		      a3[2]=new Applicant("Rani","1254","PhD",7.8);
		      a3[3]=new Applicant("Jay","2013054","UG",9.3);
		      a3[4]=new Applicant("Shabad","MT1554","PG",9.0);
		      o[2][1]=a3;
		      
		      //Set #Parameter 3
		      String[] s3=new String[0];
		      o[2][2]=s3;
		    
		      
		      
		    //Set #Parameter 1
		      o[3][0]=13;
		      
		      //Set #Parameter 2
		      Applicant[] a4 = new Applicant[5];
		      a4[0]=new Applicant("Madhur","20131254","UG",7.8);
		      a4[1]=new Applicant("Megha","20131354","UG",9.0);
		      a4[2]=new Applicant("Rani","20131258","UG",9.0);
		      a4[3]=new Applicant("Jay","2013054","UG",7.8);
		      a4[4]=new Applicant("Shabad","20131554","UG",9.3);
		      o[3][1]=a4;
		      
		      //Set #Parameter 3
		      String[] s4 = new String[1];
		      s4[0]="";
		      o[3][2]=s4;
		      
		      
		      
		    //Set #Parameter 1
		      o[4][0]=3;
		      
		      //Set #Parameter 2
		      Applicant[] a5 = new Applicant[10];
		      a5[0]=new Applicant("Madhur","MT1254","UG",7.8);
		      a5[1]=new Applicant("Megha","MT1354","UG",8.2);
		      a5[2]=new Applicant("Rani","1254","PhD",7.8);
		      a5[3]=new Applicant("Jay","2013054","UG",9.3);
		      a5[4]=new Applicant("Shabad","MT1554","PG",9.0);
		      a5[5]=new Applicant("Siddharth","1407","PhD",9.7);
		      a5[6]=new Applicant("Divya","MT1425","PG",8.9);
		      a5[7]=new Applicant("Anamika","1241","PhD",6.5);
		      a5[8]=new Applicant("Adarsh","2011054","UG",9.3);
		      a5[9]=new Applicant("Amit","MT1245","PG",9.5);
		      o[4][1]=a5;
		      
		      //Set #Parameter 3
		      String[] s5 = new String[2];
		      s5[0]="1407";
		      s5[1]="MT1245";
		      o[4][2]=s5;
		    
		      //Return
		      return Arrays.asList(o);
		   }
				
		@Test
		public void check_result()
		{
			System.out.println("Parameterized Number of TA's is : " + num);
			AllocationSystem system=new AllocationSystem(num);
			ArrayList<Applicant>  result=null;
			try{
			
				result=system.getshortlist(new ArrayList<Applicant>(Arrays.asList(appln_list)));
				if(num>appln_list.length)
					fail("The method didn't throw InvalidInputException  when I expected it to do");
			}catch(InvalidInputException e)
			{
				System.out.println("Exception well caught");
				return;
			}
			catch(IndexOutOfBoundsException e)
			{
				fail("The method didn't throw InvalidInputException  when I expected it to do");
				return;
			}
			ArrayList<String> expectedresult=new ArrayList<String>(Arrays.asList(expected_result));
			ArrayList<String> actualresult=new ArrayList<String>();
			System.out.println("ID's of shortlisted TA's:");
			for(Applicant r:result)
			{
				System.out.println(r.getid());
				actualresult.add(r.getid());
			}
			
			assertArrayEquals(actualresult.toArray(),expectedresult.toArray());
					
		}
				
		
		
	}
	


