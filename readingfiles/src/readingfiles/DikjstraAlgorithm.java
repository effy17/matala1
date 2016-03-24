package readingfiles;



import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DikjstraAlgorithm {
    public static void main(String[] args) {

        Graph graph = new Graph();
        for (int i = 0; i < 8; i++) {
            graph.addVertex(i);
        }
        
        graph.addEdge(4, 5, 0.35);
        graph.addEdge(5, 4, 0.35);
        graph.addEdge(4, 7, 0.37);
        graph.addEdge(5, 7, 0.28);
        graph.addEdge(7, 5, 0.28);
        graph.addEdge(5, 1, 0.32);
        graph.addEdge(0, 4, 0.38);
        graph.addEdge(0, 2, 0.26);
        graph.addEdge(7, 3, 0.39);
        graph.addEdge(1, 3, 0.29);
        graph.addEdge(2, 7, 0.34);
        graph.addEdge(6, 2, 0.40);
        graph.addEdge(3, 6, 0.52);
        graph.addEdge(6, 0, 0.58);
        graph.addEdge(6, 4, 0.93);
        
        /*
        graph.addEdge(4, 5, 35);
        graph.addEdge(5, 4, 35);
        graph.addEdge(4, 7, 37);
        graph.addEdge(5, 7, 28);
        graph.addEdge(7, 5, 28);
        graph.addEdge(5, 1, 32);
        graph.addEdge(0, 4, 38);
        graph.addEdge(0, 2, 26);
        graph.addEdge(7, 3, 39);
        graph.addEdge(1, 3, 29);
        graph.addEdge(2, 7, 34);
        graph.addEdge(6, 2, 40);
        graph.addEdge(3, 6, 52);
        graph.addEdge(6, 0, 58);
        graph.addEdge(6, 4, 93);
        */
        /*graph.addEdge(5, 3, 14);
        graph.addEdge(5, 4, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 0, 8);
        graph.addEdge(7, 1, 11);
        graph.addEdge(7, 6, 1);
        graph.addEdge(7, 8, 7);
        graph.addEdge(8, 2, 2);
        graph.addEdge(8, 6, 6);
        graph.addEdge(8, 7, 7);*/
        //graph.findShortestPaths(7,0);
        graph.findShortestPaths(0,7);
        graph.findShortestPaths(4,7);
        //graph.findShortestPaths(7,0);
        
        Graph h=new Graph();
        
       
      
    }

    
    
    
    
    
    public static class Graph {
        static Vertex[] vertices;
        static double maxSize=10;
        int size;
        static Graph k;

        public Graph() {
            this.maxSize = maxSize;
            vertices = new Vertex[(int)maxSize];
        }

        public void addVertex(int name) {
            vertices[size++] = new Vertex(name);
        }

        public void addEdge(int sourceName, int destinationName, double weight) {
            int srcIndex = sourceName;
            int destiIndex = destinationName;
            vertices[srcIndex].adj = new Neighbour(destiIndex, weight, vertices[srcIndex].adj);
            vertices[destiIndex].indegree++;
        }
        
        public void findShortestPaths(int sourceName,int dest){
            applyDikjstraAlgorith(vertices[sourceName]);
            /*for(int i = 0; i < maxSize; i++){
               System.out.println("Distance of "+vertices[i].name+" from Source: "+ vertices[i].cost);
            }*/
            
            System.out.println("Distance from "+vertices[sourceName].name+" to edge "+vertices[dest].name+" is:"+ vertices[dest].cost);
            /*List<Vertex> path = new ArrayList<Vertex>();
            for (Vertex vertex = vertices[dest]; vertex != null; )
                path.add(vertex);

            Collections.reverse(path);
            
            
            System.out.println(path);*/
        }
        
        /*public static void readgraph(String files){
    		try {
    	           
                //System.out.print("Enter the file name with extention : ");
                File file = new File(files);

                Scanner input = new Scanner(file);
                
                 maxSize = input.nextDouble();
                 //mat=new double[(int) points][(int) points];
                k=new Graph();
                for(int i=0;i<maxSize;i++){
                	k.addVertex(i);
                }
                System.out.println("points "+ maxSize);
                double edges=input.nextDouble();
                System.out.println("edges "+edges);
               while (input.hasNextDouble()) {
            	  
            	  
                  int srcIndex = (int)input.nextDouble();
                  int destiIndex = (int)input.nextDouble();
                  double c=input.nextDouble();
                  k.addEdge(srcIndex, destiIndex, c);
            	  
                    
                   // System.out.println(line);
                   
                }
                
                input.close();

              
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        

    	}
        */
        
        public static void readblacklist(String files){
    		try {
    	           
                //System.out.print("Enter the file name with extention : ");
                File file = new File(files);

                Scanner input = new Scanner(file);
                
                 maxSize = input.nextDouble();
                 //mat=new double[(int) points][(int) points];
                k=new Graph();
                for(int i=0;i<maxSize;i++){
                	k.addVertex(i);
                }
                System.out.println("points "+ maxSize);
                double edges=input.nextDouble();
                System.out.println("edges "+edges);
               while (input.hasNextDouble()) {
            	  
            	  
                  int srcIndex = (int)input.nextDouble();
                  int destiIndex = (int)input.nextDouble();
                  double c=input.nextDouble();
                  k.addEdge(srcIndex, destiIndex, c);
            	  
                    
                   // System.out.println(line);
                   
                }
                
                input.close();

              
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        

    	}
        
        
        public class Vertex {
            double cost;
            int name;
            Neighbour adj;
            int indegree;
            State state;

            public Vertex(int name) {
                this.name = name;
                cost = Integer.MAX_VALUE;
                state = State.NEW;
            }

            public int compareTo(Vertex v) {
                if (this.cost == v.cost) {
                    return 0;
                }
                if (this.cost < v.cost) {
                    return -1;
                }
                return 1;
            }
        }

        public enum State {
            NEW, IN_Q, VISITED
        }

        public class Neighbour {
            int index;
            Neighbour next;
            double weight;

            Neighbour(int index, double weight, Neighbour next) {
                this.index = index;
                this.next = next;
                this.weight = weight;
            }
        }

        public void applyDikjstraAlgorith(Vertex src) {
            Heap heap = new Heap((int)maxSize);
            heap.add(src);
            src.state = State.IN_Q;
            src.cost = 0;
            while (!heap.isEmpty()) {
                Vertex u = heap.remove();
                u.state = State.VISITED;
                Neighbour temp = u.adj;
                while (temp != null) {
                    if (vertices[temp.index].state == State.NEW) {
                        heap.add(vertices[temp.index]);
                        vertices[temp.index].state = State.IN_Q;
                    }
                    if (vertices[temp.index].cost > u.cost + temp.weight) {
                        vertices[temp.index].cost = (u.cost + temp.weight);
                        heap.heapifyUP(vertices[temp.index]);
                    }
                    temp = temp.next;
                }
            }
        }

        public static class Heap {
            private Vertex[] heap;
            private int maxSize;
            private int size;

            public Heap(int maxSize) {
                this.maxSize = maxSize;
                heap = new Vertex[maxSize];
            }

            public void add(Vertex u) {
                heap[size++] = u;
                heapifyUP(size - 1);
            }

            public void heapifyUP(Vertex u) {
                for (int i = 0; i < maxSize; i++) {
                    if (u == heap[i]) {
                        heapifyUP(i);
                        break;
                    }
                }
            }

            public void heapifyUP(int position) {
                int currentIndex = position;
                Vertex currentItem = heap[currentIndex];
                int parentIndex = (currentIndex - 1) / 2;
                Vertex parentItem = heap[parentIndex];
                while (currentItem.compareTo(parentItem) == -1) {
                    swap(currentIndex, parentIndex);
                    currentIndex = parentIndex;
                    if (currentIndex == 0) {
                        break;
                    }
                    currentItem = heap[currentIndex];
                    parentIndex = (currentIndex - 1) / 2;
                    parentItem = heap[parentIndex];
                }
            }

            public Vertex remove() {
                Vertex v = heap[0];
                swap(0, size - 1);
                heap[size - 1] = null;
                size--;
                heapifyDown(0);
                return v;
            }

            public void heapifyDown(int postion) {
                if (size == 1) {
                    return;
                }

                int currentIndex = postion;
                Vertex currentItem = heap[currentIndex];
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;
                int childIndex;
                if (heap[leftChildIndex] == null) {
                    return;
                }
                if (heap[rightChildIndex] == null) {
                    childIndex = leftChildIndex;
                } else if (heap[rightChildIndex].compareTo(heap[leftChildIndex]) == -1) {
                    childIndex = rightChildIndex;
                } else {
                    childIndex = leftChildIndex;
                }
                Vertex childItem = heap[childIndex];
                while (currentItem.compareTo(childItem) == 1) {
                    swap(currentIndex, childIndex);
                    currentIndex = childIndex;
                    currentItem = heap[currentIndex];
                    leftChildIndex = 2 * currentIndex + 1;
                    rightChildIndex = 2 * currentIndex + 2;
                    if (heap[leftChildIndex] == null) {
                        return;
                    }
                    if (heap[rightChildIndex] == null) {
                        childIndex = leftChildIndex;
                    } else if (heap[rightChildIndex].compareTo(heap[leftChildIndex]) == -1) {
                        childIndex = rightChildIndex;
                    } else {
                        childIndex = leftChildIndex;
                    }
                }
            }

            public void swap(int index1, int index2) {
                Vertex temp = heap[index1];
                heap[index1] = heap[index2];
                heap[index2] = temp;
            }

            public boolean isEmpty() {

                return size == 0;
            }
        }
    }
}


