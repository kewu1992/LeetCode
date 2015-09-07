public class Solution {
    class Node{
        int val;
        Node next;
        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        if (n == 0)
            return true;
        int[] degree = new int[numCourses];
        Node[] graph = new Node[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new Node(0, null);
        for (int i = 0; i < n; i++){
            Node temp = new Node(prerequisites[i][0], graph[prerequisites[i][1]].next);
            graph[prerequisites[i][1]].next = temp;
            degree[prerequisites[i][0]]++;
        }
        
        boolean[] visited = new boolean[numCourses];
        int visitedCourse = 0;
        for (int i = 0; i < numCourses; i++)
            if (degree[i] == 0 && !visited[i])
                visitedCourse += search(i, graph, degree, visited);
        return visitedCourse == numCourses;
    }
    
    private int search(int index, Node[] graph, int[] degree, boolean[] visited){
        int ans = 0;
        LinkedList<Integer> queue = new LinkedList();
        queue.addLast(index);
        while (!queue.isEmpty()){
            ans++;
            visited[queue.getFirst()] = true;
            Node temp = graph[queue.removeFirst()].next;
            while (temp != null){
                if (--degree[temp.val] == 0)
                    queue.addLast(temp.val);
                temp = temp.next;
            }
        }
        return ans;
    }
}
