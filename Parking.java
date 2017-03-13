import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Scanner;  
class Model
{
int slotNo=1;
boolean status;
int regNo;
long startTime;//in minuits

}
class Parking
{
	public static void main(String []arg)
	{
		Model[] m=new Model[10];
		int ch;
		int rno;
		char c;
		for(int i=0;i<10;i++)
		{
			m[i]=new Model();
			m[i].slotNo=i+1;
			m[i].status=false;
			m[i].regNo=0;
			m[i].startTime=0;
		}

		do
		{

		System.out.println("Enter your Choice...\n\t1.Park Vheical\n\t2.Remove Vheical\n\t3.Get Slot Number\n\t4.Availability");
		Scanner s=new Scanner(System.in);
		ch=s.nextInt();
		switch(ch)
		{
			case 1:
			boolean f=false;
			Scanner s1=new Scanner(System.in);
			System.out.println("Enter Registration ID\t");
			rno=s1.nextInt();
			for(int i=0;i<10;i++)
			{
				if(m[i].status==false)
				{
					f=true;
					m[i].status=true;
					m[i].regNo=rno;
					m[i].startTime=System.currentTimeMillis( );
					System.out.println("Allocated Slot Number.."+ m[i].slotNo);
					break;
				}
				
			}
			if(f==false)
				System.out.println("Sorry..! No Slot available");
			break;
			case 2:
			boolean f1=false;
			long dif=0;
			long st=0;
			long endTime=0;
			Scanner s2=new Scanner(System.in);
			System.out.println("Enter Registration ID\t");
			rno=s2.nextInt();
			for(int i=0;i<10;i++)
			{
				if(m[i].regNo==rno)
				{
					endTime=System.currentTimeMillis();
					f1=true;
					st=m[i].startTime;
					m[i].startTime=0;
					m[i].status=false;
					m[i].regNo=0;
					
				}
			}
			if(f1==true)
			{
				
				dif=endTime-st;
				dif=dif/60000;
				System.out.println("Cost Required.."+dif);
			}
			else
			{
				System.out.println("Sorry..! Vheical is not parked");
			}
			break;
			case 3:
			boolean f3=false;
			Scanner s3=new Scanner(System.in);
			System.out.println("Enter Registration ID\t");
			rno=s3.nextInt();
			for(int i=0;i<10;i++)
			{
				if(m[i].regNo==rno)
				{
				System.out.println("Vheical is at Slot.."+m[i].slotNo);	
					f3=true;x
				}
			}
			if(f3=false)
				System.out.println("Sorry..! Vheical is not parked");
			break;
			case 4:
			boolean f4=false;
			for(int i=0;i<10;i++)
			{
				if(m[i].status==false)
				{
				System.out.println("\t"+m[i].slotNo);	
					f4=true;
				}
			}
			if(f4==false)
				System.out.println("Sorry..! No slot available");
			break;
			
			default: 
			System.out.println("Wrong Choice...!!");
			
		}
		System.out.println("Continue...y");
		Scanner s4=new Scanner(System.in);
			 c=s4.next().charAt(0);

		}while(c=='y'||c=='Y');
	}
	
}