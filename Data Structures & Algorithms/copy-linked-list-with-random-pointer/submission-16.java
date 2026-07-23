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
        return map.get(head);
        
    }
}
