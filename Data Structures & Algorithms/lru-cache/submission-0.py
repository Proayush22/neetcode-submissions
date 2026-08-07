class Node:
    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
        self.prev = self.next = None


class LRUCache:

    def __init__(self, capacity: int):
        self.cache = {}  # Maps key -> Node
        self.cap = capacity

        # Dummy nodes to track Least Recently Used (left) and Most Recently Used (right)
        self.left, self.right = Node(0, 0), Node(0, 0)
        self.left.next, self.right.prev = self.right, self.left

    # Helper: Unlink a node from the doubly linked list
    def remove(self, node: Node) -> None:
        prv, nxt = node.prev, node.next
        prv.next, nxt.prev = nxt, prv

    # Helper: Insert a node right before the MRU dummy node (self.right)
    def insert(self, node: Node) -> None:
        prv, nxt = self.right.prev, self.right
        prv.next = nxt.prev = node
        node.prev, node.next = prv, nxt

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            # Move accessed node to MRU position
            self.remove(node)
            self.insert(node)
            return node.val
        return -1

    def put(self, key: int, value: int) -> None:
        # If key already exists, remove the old node
        if key in self.cache:
            self.remove(self.cache[key])

        # Insert new node as MRU
        new_node = Node(key, value)
        self.cache[key] = new_node
        self.insert(new_node)

        # Evict LRU node if capacity is exceeded
        if len(self.cache) > self.cap:
            lru = self.left.next
            self.remove(lru)
            del self.cache[lru.key]
