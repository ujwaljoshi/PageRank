package com.project;

import java.util.Scanner;

class Average
{	
	public static void main(String args[])
	{
		double avg=0;
		int    count=0;
		Scanner f = new Scanner(System.in);
		while(f.hasNextLine())
		{
		    String line = f.nextLine();
		    if(line.compareTo("")==0)
			break;
		    avg+=Integer.parseInt(line);
		    count++;
		}
		System.out.println("Average="+avg/count);
	}
}
