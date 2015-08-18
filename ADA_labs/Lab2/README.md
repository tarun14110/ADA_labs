Lab2 Question

Concepts Covered: 
● OOP 
● ArrayList 
● Implement Interface 
 
You have to design a simplified version of TA allocation system. Given a set of Applicant objects 
you are required to return a list of shortlisted Applicant objects as per the required number for 
the course. Let’s assume that the allocation needs to be done for only one course. The 
shortlisting is done based on the following rules: 
1. Preference order: PhD student>PG student>UG student 
2. Among two candidates with same program, the one with higher CGPA is preferred. 
Incase of equal CGPA, select either 
3. Of a requirement of n number of TAs, the division should be as follows 
a. Atmost 50% are Phd students(take floor function if value not integer) 
b. Atmost 50% are PG students(take floor function if value not integer) 
c. Atmost 30% are UG students(take floor function if value not integer) 
 
Note that based on these rules, it is likely that the number of shortlisted TAs are lesser than n. 
That is acceptable. For instance, if the list of applicants are only 10 PG students, and the course 
requirement is of 6 TAs, you can have atmost 3 PG TAs (Rule 3). Since, no Phd or UG applicant 
is available, your shortlist contains top 3 PG applicants only against the requirement of 6 TAs. 
 
You must maintain a class called Applicant. This class must maintain the following fields ●
●
●
●
name: String 
id: String to record the Roll number 
program(UG,PG,PhD else all are invalid): String 
CGPA: Double 
 
You are free to define other methods as per the requirement. 
As you may have guessed, your Applicant class is required to define its own compareTo 
method, i.e it implements Comparable interface. 
 
You are also required to maintain a class called AllocationSystem for each course(let’s assume 
just a single course). The class should take the number of TAs required as a constructor 
argument. 
Define a method getshortlist that takes the Arraylist of Applicant objects as argument and 
returns an Arraylist of shortlisted Applicants as per the defined rules and requirement. 
 
Example: 
 
Applicants(Name, Roll no., Program, CGPA): 
 "Madhur","MT1254","PG",7.8 
 "Megha","MT1354","PG",8.2 
"Rani","1254","PhD",7.8 
"Jay","2013054","UG",9.3 
"Shabad","MT1554","PG",9.0 
"Seema","MT1504","PG",8.5 
 
Requirement: 4 TAs(atmost 2 PhDs, atmost, 2 PGs, atmost 1 UG such that total <=4) 
 
Shortlist(Name, Roll no., Program, CGPA): 
"Rani","1254","PhD",7.8 
"Shabad","MT1554","PG",9.0 
"Seema","MT1504","PG",8.5 
"Jay","2013054","UG",9.3 
 
 
The Test file provides a set of test cases to evaluate your design