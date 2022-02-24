package com.project;

import java.util.HashSet;
import java.util.Scanner;

class Dedup
{
	public static void main(String args[])
	{
		Scanner f = new Scanner(System.in);
		HashSet<Integer> vals = new HashSet<Integer>();
		while(f.hasNextLine())
		{
			String line = f.nextLine();
			if(line.compareTo("")==0)	
				break;
			vals.add(Integer.parseInt(line));	
		}
		for(int v: vals)
		  System.out.println(v);
	}
}
