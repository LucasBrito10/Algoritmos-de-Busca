import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;



public final class BreadthFirstSearch {

    private Queue<Integer> queueVertex = new LinkedList<>();


    private BreadthFirstSearch() {

        throw new UnsupportedOperationException("Esta é uma classe utilitária e não pode ser instanciada.");
    }



    public static int BFS(Graph graph, int startVertex, int targetVertex){
        
        
        Queue<Integer> queueVertex = new LinkedList<>();
        boolean[] visitedArray = new boolean[graph.getVertexCount()];
        
        visitedArray[startVertex] = true;
        queueVertex.add(startVertex);


        while(!queueVertex.isEmpty()){

            queueVertex.


        } 



        

        






    }





}
