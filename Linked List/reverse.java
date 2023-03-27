public class reverse {
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
public static int size;

public void addfirst(int data){  //O(1)..
    Node newNode = new Node(data);
    size++;
    if(head == null){
        head = tail = newNode;
        return;
    }
    newNode.next = head;
    head = newNode;
}

public void addLast(int data){  //O(1)..
    Node newNode = new Node(data);
    size++;
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
    size++;
    Node temp = head;
    int i = 0;
    while(i < idx - 1){
        temp = temp.next;
        i++;
    }
    newNode.next = temp.next;
    temp.next = newNode;
}

public int delete(){
    if(size == 0){
        System.out.println("Linked List is empty");
        return Integer.MIN_VALUE;
    }
    else if(size == 1){
        int val = head.data;
        head = tail = null;
        return val;
    }
    int val = head.data;
    head = head.next;
    return val;
}

public int removeLast(){
    if(size == 0){
        System.out.println("Linked List is empty");
        return Integer.MIN_VALUE;
    }
    else if(size == 1){
        int val = head.data;
        head = tail = null;
        return val;
    }
    Node prev = head;
    for(int i=0; i<size-2; i++){
        prev = prev.next;
    }
    int val = prev.next.data;
    prev.next = null;
    tail = prev;
    return val;
}

public static int searchItr(int key){  //O(n)... because ye linear search use kar raha hai isme...
    Node temp = head;
    int i =0;

    while(temp!=null){
        if(temp.data == key){   //key found here...
            return i;
        }
        temp = temp.next;
        i++;
    }
    return -1;
}

public void reverseItr(){
    Node prev = null;
    Node curr = tail = head;
    Node next;

    while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    head = prev;
}

public static void main(String args[]){
    reverse ll = new reverse();
    ll.addfirst(2);
    ll.addfirst(1);
    ll.addLast(4);
    ll.addLast(5);
    ll.middle(2, 3);
   // ll.delete();
    ll.print();
    //System.out.println(size);

   // ll.removeLast();
    //ll.print();

   // System.out.println(searchItr(8));
    //System.out.println(searchItr(4));

    ll.reverseItr();
    ll.print();
}
}
