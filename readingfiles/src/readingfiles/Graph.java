package readingfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Graph {

	private static double mat[][];
	private static int points;
	private static String mainfile;
	
	public Graph(){
		this.mat=new double[0][0];
		points=0;
		mainfile="";
	}
	
	public double[][] graph(){
		return mat;
	}
	
	public void setgraph(double g[][]){
		mat=g;
	}
	
	public int getpoints(){
		return points;
	}
	
	public void setpoints(int point){
		points=point;
	}
	
	public String getfile(){
		return mainfile;
	}
	
	public void setfile(String f){
		mainfile=f;
	}
	
	public static void readgraph(String files){
		try {
	           
            //System.out.print("Enter the file name with extention : ");
            File file = new File(files);

            Scanner input = new Scanner(file);
            
             points = (int)input.nextDouble();
             mat=new double[(int) points][(int) points];
            
            System.out.println("points "+ points);
            double edges=input.nextDouble();
            System.out.println("edges "+edges);
           while (input.hasNextDouble()) {
        	  double a = input.nextDouble();
        	  double b=input.nextDouble();
        	  double c=input.nextDouble();
        	  if(c<=0){
        		  System.out.println("no negative input allowed");
        	  	  return;}
        	  
        	  mat[(int)a][(int)b]=c;
                
               // System.out.println(line);
               
            }
            
            input.close();

           /* for(int i=0;i<points;i++){
            	for(int j=0;j<points;j++){
            		System.out.print(mat[i][j]+" ");
            	}
            	System.out.println("");
            }*/
            
            
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    

	}
	//try
	private int index(int i,int j) {
		return i*(points+1) + j;
	}
	
	public String getPath(int x, int y) {
		x=points;
		return "(0,0)" + mat[index(0,0)][index(x,y)];
	}
	//
		public static void isdirected(double a[][]){
			for(int i=0;i<mat.length;i++){
            	for(int j=0;j<mat[0].length;j++){
            		if(mat[i][j]!=mat[j][i]){
            			System.out.println("directed graph");
            			return;
            		}
            	}
            }
			System.out.println("not a directed graph");
		}
		
		
		public static void blacklist(String files){
			try {
		           
	            //System.out.print("Enter the file name with extention : ");
	            File file = new File(files);

	            Scanner input = new Scanner(file);
	            
	            double checks = input.nextDouble();
	             
	            
	            System.out.println("checks "+ checks);
	            
	           
	           while (input.hasNextDouble()) {
	        	  
	        	  
	        	while(checks>0){
	        		readgraph(mainfile);
	        	  double a = input.nextDouble();
	        	  double b=input.nextDouble();
	        	  double c=input.nextDouble();
	        	  if(c>0){
	        		  double temp[]=new double[(int)c];
	        		  System.out.println(c);
	        		  for(int i=0;i<temp.length;i++){
	        			  temp[i]=input.nextDouble();
	        			  System.out.println(temp[i]);
	        		  }
	        		  for(int i=0;i<temp.length;i++){
	        			  for(int j=0;j<mat.length;j++){
	        				  mat[i][j]=Double.POSITIVE_INFINITY;
	        				  mat[j][i]=Double.POSITIVE_INFINITY;
	        			  }
	        		  }
	        	  }
	        	   //mat[(int)a][(int)b]=c;
	        	   checks--;
	        	}
	               // System.out.println(line);
	               
	            }
	            
	            input.close();

	           /* for(int i=0;i<points;i++){
	            	for(int j=0;j<points;j++){
	            		System.out.print(mat[i][j]+" ");
	            	}
	            	System.out.println("");
	            }*/
	            
	            
	            
	            
	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 readgraph("C:\\res\\tinyEWD.txt");  
	 isdirected(mat);
	 blacklist("C:\\res\\test1.txt");
	 for(int i=0;i<mat.length;i++){
     	for(int j=0;j<mat[0].length;j++){
     		System.out.print(mat[i][j]+" ");
     	}
     	System.out.println("");
     }
	 readgraph("C:\\res\\tinyEWG.txt"); 
	 isdirected(mat);
	 //readgraph("C:\\res\\mediumEWD.txt");
	 //isdirected(mat);
	 //readgraph("C:\\res\\mediumEWG.txt");
	 //isdirected(mat);
	}
}

