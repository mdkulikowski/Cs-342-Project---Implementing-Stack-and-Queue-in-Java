import java.util.ArrayList;

abstract class GenericList <T>{
    private Node<T> head;
    private int length;

    public class Node<T>{
        public T data;
        public Node<T> next;

        public Node(T val){
            this.data = val;
            this.next = null;
        }
    }
    public void print(){
        if (this.length == 0){
            System.out.println("Empty List");
        }else{
            Node<T> pointer = this.getHead();
            for (int i = 0; i < this.getLength(); i++){
                System.out.println(pointer.data);
                pointer = pointer.next;
            }
        }
    }
    abstract void add(T data);
    public T delete(){
        if (length == 0){
            return null;
        }else{
            T val = this.head.data;
            this.head = head.next;
            this.length--;
            return val;
        }
    }
    public ArrayList<T> dumpList(){
        ArrayList<T> dump = new ArrayList<T>();
        Node<T> pointer = this.head;
        int size = this.getLength();
        for (int i = 0; i < size; i++){
            dump.add(pointer.data);
            pointer = pointer.next;
            this.delete();
            //this.setLength(this.getLength() - 1);
        }
        return dump;
    }
    public T get(int index){
        if (index > this.length){
            return null;
        }
        Node<T> pointer = this.head;
        for (int i = 0; i < index; i++){
            pointer = pointer.next;
        }
        return pointer.data;
    }
    public T set(int index, T element){
        if (index > this.length){
            return null;
        }
        Node<T> pointer = this.head;
        for (int i = 0; i < index; i++){
            pointer = pointer.next;
        }
        T val = pointer.data;
        pointer.data = element;
        return val;
    }
    public int getLength(){
        return this.length;
    }

    //unsure if I was ment to add a parameter here 
    //but found being able to specify specific length paired very well with being able to call current length (getLength())
    public void setLength(int size){
        this.length = size;
    }
    public Node<T> getHead(){
        return this.head;
    }
    
    //was also unsure if this method needed a paramter but decided to add two because I found it practical in my implementation
    //first parameter is data value of node
    //second parameter is for the desired next value of the node
    //one thing to note is that this method does not change the length variable
    //thus if user calls this function outside of add(), push(), or enqueue() they will have to update the length value themselves
    public void setHead(T data, Node<T> next){
        this.head = new Node<T>(data);
        this.head.next = next;
    }
}