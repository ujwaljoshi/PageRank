package com.project;

import java.util.Scanner;
import java.util.TreeSet;

class TopN
{
	public static void main(String args[])
	{
		Scanner f = new Scanner(System.in);
		TreeSet<Integer> vals = new TreeSet<Integer>();
		int nval = Integer.parseInt(args[0]);
		int lowOfTopN=0;
		while(f.hasNextLine())
		{
			String line = f.nextLine();
			if(line.compareTo("")==0)	
				break;
			int val = Integer.parseInt(line);
			if(lowOfTopN<val)
			{
				if(vals.size()>nval)
					vals.remove(lowOfTopN);
				vals.add(val);
				lowOfTopN=vals.first();
			}
		}
		for(int val:vals)
		  System.out.println(val);
	}
}
