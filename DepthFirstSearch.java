import java.util.Stack;



public final class DepthFirstSearch{
    


    private DepthFirstSearch(){}


    //Busca em profundidade utilizando recursão
    //Importante: este método funciona apenas com vértices com nomenclatura numérica inteira (0 a infinito)
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

    //Busca em profundidade de forma iterativa
    //Importante: este método funciona apenas com vértices com nomenclatura numérica inteira (0 a infinito)
    public static boolean iterativeDFS(Graph graph, int startVertex, int targetVertex){

        String[] visitedArray = new String[graph.getVertexCount()];
        Stack<Integer> stackVertex = new Stack<>();

        
        stackVertex.add(startVertex);



        while(!stackVertex.isEmpty()){
            int count = 0;
            int processedVertex = stackVertex.getFirst();
            
            visitedArray[processedVertex] = "AMARELO";
            
            for(Integer iterator : graph.getAdjacencyList().get(processedVertex)){

                count++;

                if(visitedArray[iterator].equals("VERDE")) {

                    stackVertex.add(iterator);
                    break;
               
                }

                
            }

            if(count == graph.getVertexCount()){
                stackVertex.pop();
                visitedArray[processedVertex] = "VERMELHO";
            }


        






    }
}

}