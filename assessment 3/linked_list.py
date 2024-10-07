class Node:
    def __init__(self,data):
        self.data=data
        self.next=None

class LinkedList:
    def  __init__  (self):
        self.head=None

    def append(self,data):
        new_node=Node(data)
        if not self.head:
            self.head=new_node
            return
        current=self.head
        while current.next:
            current=current.next
        current.next=new_node

    def remove_at_index(self, index):
        if self.head is None:
            return "List is empty"

        if index==0:
            self.head=self.head.next
            return

        current=self.head
        for _ in range(index-1):
            if current is None or current.next is None:
                return "Index out of bounds"
            current=current.next

        if current.next is None:
            return"Index out of bounds"

        current.next=current.next.next

    def print_list(self):
        current=self.head
        while current:
            print(current.data, end="->")
            current=current.next
        print("None") 

    def create_list():
        linked_list=LinkedList()
        user_input= input("Enter the Linked List elements")
        elements=user_input.split()
        for element in elements:
            linked_list.append(int(element))
        return linked_list 

    if __name__=="__main__":
        linked_list=create_list()
        print("Original Linked List:")
        linked_list.print_list()

    index_to_remove=int(input("Enter the index to be removed:"))
    linked_list.remove_at_index(index_to_remove)

    print("Linked list after removing the element at the index",index_to_remove,":")
    linked_list.print_list()                                                   