package readingfiles;

import java.util.*;
import java.lang.*;
import java.io.*;


public class Graph_algo {

	static // A Java program for Dijkstra's single source shortest path algorithm.
	// The program is for adjacency matrix representation of the graph
	
	 
	class ShortestPath
	{
	    // A utility function to find the vertex with minimum distance value,
	    // from the set of vertices not yet included in shortest path tree
	    //static final int V=9;
	    double minDistance(double dist[], Boolean sptSet[],int V)
	    {
	        // Initialize min value
	        double min = Integer.MAX_VALUE, min_index=-1;
	 
	        for (int v = 0; v < V; v++)
	            if (sptSet[v] == false && dist[v] <= min)
	            {
	                min = dist[v];
	                min_index = v;
	                System.out.println(min_index);
	            }
	 
	        
	        
	        return min_index;
	    }
	 
	    // A utility function to print the constructed distance array
	    void printSolution(double dist[], int n,int x,int y)
	    {
	        System.out.println("Vertex   Distance from Source");
	        //for (int i = 0; i < V; i++)
	           // System.out.println(i+" \t\t "+dist[i]);
	        System.out.println(x+" to "+y+" is ");
	        System.out.println(dist[y]);
	    
	    }
	 
	    // Funtion that implements Dijkstra's single source shortest path
	    // algorithm for a graph represented using adjacency matrix
	    // representation
	    void dijkstra(double graph[][], int src,int dest,int V)
	    {
	        double dist[] = new double[V]; // The output array. dist[i] will hold
	                                 // the shortest distance from src to i
	 
	        // sptSet[i] will true if vertex i is included in shortest
	        // path tree or shortest distance from src to i is finalized
	        Boolean sptSet[] = new Boolean[V];
	 
	        // Initialize all distances as INFINITE and stpSet[] as false
	        for (int i = 0; i < V; i++)
	        {
	            dist[i] = Integer.MAX_VALUE;
	            sptSet[i] = false;
	        }
	 
	        // Distance of source vertex from itself is always 0
	        dist[src] = 0;
	 
	        // Find shortest path for all vertices
	        for (int count = 0; count < V-1; count++)
	        {
	            // Pick the minimum distance vertex from the set of vertices
	            // not yet processed. u is always equal to src in first
	            // iteration.
	            double u = minDistance(dist, sptSet,V);
	 
	            // Mark the picked vertex as processed
	            sptSet[(int)u] = true;
	            //System.out.println("from "+u);
	            // Update dist value of the adjacent vertices of the
	            // picked vertex.
	            for (int v = 0; v < V; v++){
	 
	                // Update dist[v] only if is not in shortestpathtreeSet, there is an
	                // edge from u to v, and total weight of path from src to
	                // v through u is smaller than current value of dist[v]
	                if (!sptSet[v] && graph[(int)u][v]!=0 &&
	                        dist[(int)u] != Integer.MAX_VALUE &&
	                        dist[(int)u]+graph[(int)u][v] < dist[v]){
	               
	                	//System.out.println(u+" to "+v);
	                	//System.out.println(dist[v]);
	                    dist[v] = dist[(int)u] + graph[(int)u][v];}
	                //System.out.println(u);
	                
	            }
	            
	            //System.out.println(u);
	        }
	 
	       // for(int j=0;j<dist.length;j++){
	        //	System.out.println(dist[j]);
	       // }
	        
	        
	        // print the constructed distance array
	        printSolution(dist, V,src,dest);
	    }
	 
	    // Driver method
	    public static void main (String[] args)
	    {
	    	Graph a=new Graph();
	    	a.readgraph("C:\\res\\tinyEWD.txt");
	    	double mat[][]=a.graph();
	        /* Let us create the example graph discussed above */
	       double graph[][] = new double[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
	                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
	                                  {10, 8, 0, 7, 0, 4, 0, 0, 2},
	                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
	                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
	                                  {0, 0, 4, 0, 10, 0, 2, 0, 0},
	                                  {0, 0, 0, 14, 0, 2, 0, 1, 6},
	                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
	                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
	                                 };
	        ShortestPath t = new ShortestPath();
	        
	        t.dijkstra(graph, 0,3,9);

	        
	        
           /* for(int i=0;i<mat.length;i++){
            	for(int j=0;j<mat[0].length;j++){
            		System.out.print(mat[i][j]+" ");
            	}
            	System.out.println("");
            }*/
	        //ShortestPath g = new ShortestPath();
	       //g.dijkstra(mat, 1, 5, a.getpoints());
	       //g.dijkstra(mat, 5, 1, a.getpoints());
	    }
	    
	}
	
}
