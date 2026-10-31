import java.util.Stack;

public final class DepthFirstSearch{


    private Stack<Integer> stack;
    


    private DepthFirstSearch(){}



    public static boolean recursiveDFS(Graph graph, String[] visitedArray, int startVertex, int targetVertex){
        
        if(startVertex == targetVertex) return true;

        boolean find = false;
        visitedArray[startVertex] = "AMARELO";
        
    
        for(Integer iterator : graph.getAdjacencyList().get(startVertex)){

            if(visitedArray[iterator].equals("VERDE")) find = recursiveDFS(graph, visitedArray, iterator, targetVertex);
            if(find == true) return true;
        
        }

        visitedArray[startVertex] = "VERMELHO";
        
        return false;

    }

}