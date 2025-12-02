package Graph;
import java.util.LinkedList;

public class LinkedListGraph {
    // FIELDS
    private int                     vertexSize;
    private LinkedList<Integer>[]   edgeList;

    // CONSTRUCTORS
    @SuppressWarnings("unchecked")
    public LinkedListGraph(int _size) {
        if(_size <= 0) throw new RuntimeException("The number of vertices must be greater than 0.");

        this.vertexSize =   _size;
        this.edgeList =     new LinkedList[_size];

        for(int i = 0; i < _size; i++) {
            this.edgeList[i] = new LinkedList<Integer>();
        }
    }

    // METHODS
    public void addEdge(int _vertex, int _linked) {
        if(Math.max(_vertex, _linked) >= vertexSize || Math.max(_vertex, _linked) < 0) throw new RuntimeException("Out of Range");
    
        edgeList[_vertex].add(_linked);
    }

    public boolean isLinked(int _vertex, int _linked) {
        if(Math.max(_vertex, _linked) >= vertexSize || Math.max(_vertex, _linked) < 0) throw new RuntimeException("Out of Range");

        return edgeList[_vertex].contains(_linked);
    }

    public int vertexCount() {
        return vertexSize;
    }

    public int neighborCount(int _vertex) {
        if(_vertex >= vertexSize || _vertex < 0) throw new RuntimeException("Out of Range");

        return edgeList[_vertex].size();
    }

    public int[] neighborToArray(int _vertex) {
        if(_vertex >= vertexSize || _vertex < 0) throw new RuntimeException("Out of Range");

        int neighborCount = neighborCount(_vertex);
        int[] array = new int[neighborCount];
        for(int i = 0; i < neighborCount; i++) {
            array[i] = edgeList[_vertex].get(i);
        }

        return array;
    }

    public String neighborToString(int _vertex) {
        if(_vertex >= vertexSize || _vertex < 0) throw new RuntimeException("Out of Range");

        int neighborCount = neighborCount(_vertex);
        if(neighborCount == 0) return "[]";
        else {
            String result = "[";
            for(int i = 0; i < neighborCount - 1; i++) {
                result += edgeList[_vertex].get(i) +",";
            }
            return result + edgeList[_vertex].get(neighborCount - 1) + "]";
        }
    }

    public String toString() {
        String result = "";
        for(int i = 0; i < vertexSize-1; i++) {
            result += "[" + i + "] : " + neighborToString(i) + "\n";
        }
        result += "[" + (vertexSize - 1) + "] : " + neighborToString(vertexSize - 1);

        return result;
    }
}
