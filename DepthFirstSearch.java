import java.util.Arrays;
import java.util.Stack;



public class DepthFirstSearch{
    
    private String[] visitedArray;
    Stack<Integer> stackVertex;

    public DepthFirstSearch(Graph graph){

        this.visitedArray = new String[graph.getVertexCount()];
        this.stackVertex = new Stack<>();
        
        Arrays.fill(visitedArray, "VERDE");

    }


    public boolean initiateRecursiveDFS(Graph graph, int startVertex, int targetVertex){

        // Reseta todas as posições para "VERDE" para uma nova busca limpa
        Arrays.fill(this.visitedArray, "VERDE");
        
        return recursiveDFS(graph, startVertex, targetVertex);

    }
    
    public boolean initiateIterativeDFS(Graph graph, int startVertex, int targetVertex){

        // Reseta todas as posições para "VERDE" para uma nova busca limpa
        Arrays.fill(this.visitedArray, "VERDE");
        this.stackVertex.clear();
        return iterativeDFS(graph, startVertex, targetVertex);

    }


    //Busca em profundidade utilizando recursão
    //Importante: este método funciona apenas com vértices com nomenclatura numérica inteira (0 a infinito)
    
    private boolean recursiveDFS(Graph graph, int startVertex, int targetVertex){
        
        if(startVertex == targetVertex) return true;

        boolean find = false;
        this.visitedArray[startVertex] = "AMARELO";
        
    
        for(Integer iterator : graph.getAdjacencyList().get(startVertex)){

            if(this.visitedArray[iterator].equals("VERDE")) find = recursiveDFS(graph, iterator, targetVertex);
            if(find == true) return true;
        
        }

        visitedArray[startVertex] = "VERMELHO";
        
        return false;

    }

    //Busca em profundidade de forma iterativa
    //Importante: este método funciona apenas com vértices com nomenclatura numérica inteira (0 a infinito)
    private boolean iterativeDFS(Graph graph, int startVertex, int targetVertex){

        
        stackVertex.add(startVertex);

        
        while(!stackVertex.isEmpty()){
        
            boolean useBreak = false;
            int processedVertex = stackVertex.peek();

            if(processedVertex == targetVertex) return true;
            
            visitedArray[processedVertex] = "AMARELO";
            
            for(Integer iterator : graph.getAdjacencyList().get(processedVertex)){

                if(visitedArray[iterator].equals("VERDE")) {

                    stackVertex.add(iterator);
                    useBreak = true;
                    break;
               
                }


            }

            if(useBreak == false){
                stackVertex.pop();
                visitedArray[processedVertex] = "VERMELHO";
            }


     }

        return false;
}

}