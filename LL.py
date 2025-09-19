
# define  linked list node  , create a linked list and print it's elements  in python
class Node:
    def __init__(self, data):
        self.data = data      # store data
        self.next = None      # pointer to next node
# Create nodes
node1 = Node(10)
node2 = Node(20)
node3 = Node(30)

# Link them together
node1.next = node2
node2.next = node3

# Head of the list
head = node1
def printLinkedList(head):
    current = head
    while current:
        print(current.data, end=" -> ")
        current = current.next
    print("None")   # end of list
printLinkedList(head)
