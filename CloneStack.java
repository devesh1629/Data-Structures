class StackNode {
    int data;
    StackNode next;

    public StackNode(int val) {
        data = val;
        next = null;
    }
}
class Stack {
    public StackNode top;
    public Stack() {
        top = null;
    }
    public void push(int val) {
        StackNode temp = new StackNode(val);
        if(top == null)
            top = temp;
        else {
            temp.next = top;
            top = temp;
        }
    }
    public int pop() {
        int val = top.data;
        top = top.next;
        return val;
    }
    public void display() {
        StackNode current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }
    public void reverse() {
        StackNode current = top;
        StackNode temp = null;
        StackNode prev = null;
        while(current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        top = prev;
    }
    public boolean isEmpty() {
        return top == null;
    }
}

public class CloneStack {
    public static void main(String args[]) {
        Stack source = new Stack();
        Stack dest = new Stack();

        source.push(1);
        source.push(2);
        source.push(3);
 
        System.out.println("Source Stack:");
        source.display();
        source.reverse();
        while (source.isEmpty() != true) {
            dest.push(source.pop());
        }
        System.out.println("Destination Stack:");
        dest.display();
    }
}
