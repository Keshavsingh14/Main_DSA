public class addMiddle {
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

public void middle(int idx, int data){
    if(idx == 0){
        addfirst(data);
        return;
    }
    Node newNode = new Node(data);
    Node temp = head;
    int i = 0;
    while(i < idx - 1){
        temp = temp.next;
        i++;
    }
    newNode.next = temp.next;
    temp.next = newNode;
}

public static void main(String args[]){
    addMiddle ll = new addMiddle();
    ll.addfirst(2);
    ll.addfirst(1);
    ll.addLast(3);
    ll.addLast(4);
    ll.middle(2, 8);
    ll.print();
}
}
