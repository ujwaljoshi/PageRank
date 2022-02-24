package com.project;

import java.util.Scanner;

class GraphUtils {
	public static int[] getNeighbours(int[][] adjMatrix, int index)
	{
		int countNeighbours=0;
		for(int i=0;i<adjMatrix[0].length;i++)
		{
			if(adjMatrix[index][i]==1)
			    countNeighbours++;
		}
		int[] neighbours = new int[countNeighbours];
		int nIndex=0;
		for(int i=0;i<adjMatrix[0].length;i++)
		{
			if(adjMatrix[index][i]==1)
			{
				neighbours[nIndex] = i;
				nIndex++;
			}
		}
		return neighbours;
	}
	public static int[][] listToMatrix(int[][] adjList)
	{
		int[][] adjMatrix = new int[adjList.length][adjList.length];
		for(int i=0;i<adjList.length;i++)
		{
			for(int j=0;j<adjList[i].length;j++)
			{
				adjMatrix[i][adjList[i][j]]=1;
			}
		}
		return adjMatrix;
	}
	
	public static int[][] readGraph(Scanner f, int numVerts)
	{
		int[][] result= new int[numVerts][];
		for(int i=0;i<numVerts;i++)
		{
			if(f.hasNextLine())
			{
				String line = f.nextLine();
				String strInts[] = line.split(" ");
				result[i] = new int[strInts.length];
				for(int j=0;j<strInts.length;j++)
				{
					result[i][j]=Integer.parseInt(strInts[j]);
				}
			}
		}
		return result;
	}
	public static void main(String args[])
	{
		int numVerts = Integer.parseInt(args[0]);
		Scanner s = new Scanner(System.in);
		int[][] graph = readGraph(s, numVerts);
		int[][] adjMatrix = listToMatrix(graph);
		for(int i=0;i<numVerts;i++)
		{
		   System.out.println("");
		   for(int j=0; j<numVerts;j++)
			System.out.print(" "+adjMatrix[i][j]);
		}
	}
 }
