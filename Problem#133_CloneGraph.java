/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        Queue<UndirectedGraphNode> queue = new LinkedList();
        queue.add(node);  
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        while (!queue.isEmpty()){
             UndirectedGraphNode origin = queue.remove();
             UndirectedGraphNode clone = map.get(origin);
             for (int i = 0; i < origin.neighbors.size(); i++)
                if (map.containsKey(origin.neighbors.get(i))){
                    clone.neighbors.add(map.get(origin.neighbors.get(i)));
                } else {
                    UndirectedGraphNode temp = new UndirectedGraphNode(origin.neighbors.get(i).label);
                    map.put(origin.neighbors.get(i), temp);
                    queue.add(origin.neighbors.get(i));
                    clone.neighbors.add(temp);
                }
        }
        
        return newNode;
    }
}
