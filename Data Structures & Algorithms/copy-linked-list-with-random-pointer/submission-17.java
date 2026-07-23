/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //You need to use a hashmap with two passes beacause some nodes arent created 
        //when you try to link random nodes
        Node node = head;
        Map<Node, Node> map = new HashMap<>();
        while(node != null){
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while(node != null){
            Node copy = map.get(node);
            copy.next = map.get(node.next);
            copy.random = map.get(node.random);
            node = node.next;
        }
        //the while loop wires up the nodes in the hashmap, returning the value 
        //of head in the map gives the first copied node becasue head is the beginning of the map
        return map.get(head);
        
    }
}
