package eg.edu.alexu.csd.datastructure.stack.cs22;
import java.awt.*;
import java.util.*;
import java.lang.*;

public interface IStack {
    public Object pop();
    public Object peek();
    public void push(Object element);
    public boolean isEmpty();
    public int size();
}
class Stack implements IStack{
    /**
     *class that implements the stack using a linked list
     */
    int size=0;
    class singly {
        Object value;
        singly next;
        singly(Object data) { value = data; }
    }
    singly head;
    public Object pop(){
        /**
         * Removes the last inserted element from the stack and returns its value
         * @return the stack's top element
         */
        if(head==null)
            throw new RuntimeException ("The stack is empty");
        Object i=head.value;
        head=head.next;
        size--;
        return i;
    }
    public Object peek(){
        /**
         * Returns the value of the last inserted element
         * @return the stack's top element
         */
        if(head==null)
            throw new RuntimeException ("The stack is empty");
        Object i=head.value;
        return i;
    }
    public void push(Object element){
        /**
         * Add the element to the top of the stack
         * @param element
         */
        size++;
        if(head==null){
            head=new singly(element);
            return;
        }
        singly list=head;
        head=new singly(element);
        head.next=list;
    }
    public boolean isEmpty(){
        /**
         * @return true if the stack is empty
         */
        return (size==0);
    }
    public int size(){
        /**
         * @return the size of the stack
         */
      return size;
    }
}