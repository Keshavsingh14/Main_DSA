public class zigZag {
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


// THIS IS ALSO KNOWN AS FLYOD CYCLE DETECTION ALGORITHM.
public static boolean iscycle(){
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null){
        slow = slow.next; //+1.
        fast = fast.next.next; //+2.
        if(slow == fast){
            return true; // cycle exists.
        }
    }
    return false; // cycle does not exists.
}

public void zigZagg(){  // finding MID..
    Node slow = head;
    Node fast = head.next;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    Node mid = slow;

    // reverse 2nd half..
    Node curr = mid.next;
    mid.next = null;
    Node prev = null;
    Node next;
    while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    Node left = head;
    Node right = prev;
    Node nextL, nextR;

    //alternate merge - zigzag merge
    while(left != null && right != null){
        nextL = left.next;
        left.next = right;
        nextR = right.next;
        right.next = nextL;

        left = nextL;
        right = nextR;

    }
}

public static void main(String args[]){
    zigZag ll = new zigZag();
   ll.addLast(1);
   ll.addLast(2);
   ll.addLast(3);
   ll.addLast(4);
   ll.addLast(5);
   ll.print();
   ll.zigZagg();
   ll.print();


}
}
