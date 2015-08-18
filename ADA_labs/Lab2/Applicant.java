/*Name=Tarun Kuamr Yadav
 * Roll No.=2014110
 * 
 * 
 */




package com.iiitd.ap.lab2;


public class Applicant implements Comparable<Applicant> {
	
	String name=new String();
	String id=new String();
	public String program=new String();
	Double CGPA=new Double(0.0); 
	
	
	Applicant(String nm,String i,String pro,Double cg)
	{
		name=nm;
		id=i;
	    program=pro;
	    CGPA=cg;
		
	}
	
	
	//double
	public double getStudentCGPA()
	{
		return CGPA;
	}
	
	@Override
    public int compareTo(Applicant comparestu) {
        //double compareCGPA=((Applicant)comparestu).getStudentCGPA();
      double compareCGPA=this.CGPA-comparestu.CGPA;
        //compareCGPA=compareCGPA-this.CGPA;
        if(compareCGPA >0)
        {
        	return -1;
        }
        else if(compareCGPA <0)
        {
        	return 1;
        }
        else{
        	return 0;
        }
        
        
      //  return (this.CGPA-compareCGPA);

    }


	public String getid() {
		// TODO Auto-generated method stub
		return id;
	}
	

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}



}
