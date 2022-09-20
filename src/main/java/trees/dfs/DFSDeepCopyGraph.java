package trees.dfs;

import trees.GraphNode;

import java.util.*;

public class DFSDeepCopyGraph {

    /*

    1 ------ 2
    |        |
    3 ------ 4

    1, 2,3
    2, 1,4
    3, 1,4
    4, 2,3

     */

    public static void main (String[] args) {
        GraphNode node = new GraphNode(1);
    }

    public GraphNode cloneGraph(GraphNode node) {
        if(node == null)return  null;
        Map<Integer, GraphNode> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    private GraphNode cloneGraph(GraphNode node, Map<Integer, GraphNode> map) {
        if(map.containsKey(node.val)) return map.get(node.val);
        GraphNode copy = new GraphNode(node.val);
        map.put(node.val, copy);
        for(GraphNode neighbor : node.neighbors){
            copy.neighbors.add(cloneGraph(neighbor, map));
        }
        return copy;
    }
}

