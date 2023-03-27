public class LinkedList{
    public static class Node{
        int data;
        Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public static Node head;
public static Node tail;

public void addfirst(int data){  //O(1)..
    Node newNode = new Node(data);
    if(head == null){
        head = tail = newNode;
        return;
    }
    newNode.next = head;
    head = newNode;
}

public void addLast(int data){  //O(1)..
    Node newNode = new Node(data);
    if(head == null){
        head = tail = newNode;
        return;
    }
    tail.next = newNode;
    tail = newNode;
}

public void print(){  //O(n)..
    if(head == null){
        System.out.println("Linked List is Empty");
        return;
    }
    Node temp = head;
    while(temp != null){
        System.out.print(temp.data+"->");
        temp = temp.next;
    }
    System.out.println("null");
}

public static void main(String args[]){
    LinkedList ll = new LinkedList();
    ll.addfirst(2);
    ll.addfirst(1);
    ll.addLast(3);
    ll.addLast(4);
    ll.print();
}
}