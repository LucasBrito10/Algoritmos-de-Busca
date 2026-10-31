
import java.util.LinkedList;
import java.util.Queue;



public final class BreadthFirstSearch {


    private BreadthFirstSearch() {

        throw new UnsupportedOperationException("Esta é uma classe utilitária e não pode ser instanciada.");
    }



    public static boolean BFS(Graph graph, int startVertex, int targetVertex){
        
        
        Queue<Integer> queueVertex = new LinkedList<>();
        boolean[] visitedArray = new boolean[graph.getVertexCount()];
        
        visitedArray[startVertex] = true;
        queueVertex.add(startVertex);


        while(!queueVertex.isEmpty()){

            int processedVertex = queueVertex.poll();
            visitedArray[processedVertex] = true;

            for(Integer iterator : graph.getAdjacencyList().get(processedVertex)){

                if(iterator.equals(targetVertex)) return true;
                if(visitedArray[iterator] == false) queueVertex.add(iterator);
            
            }

        } 

        return false;
    }

}
