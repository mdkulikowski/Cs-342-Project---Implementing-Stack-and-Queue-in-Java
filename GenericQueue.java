public class GenericQueue<T> extends GenericList<T>{
    private Node<T> tail;

    public T removeTail(){
        Node<T> removeTail = this.tail;
        this.tail = null;
        this.setLength(this.getLength() - 1);
        return removeTail.data;
    }

    public GenericQueue(T value){
        this.setHead(value, null);
        this.setLength(1);
        this.tail = this.getHead();
    }
    void add(T data){
        if (this.getLength() == 0){
            this.setHead(data, null);
            this.setLength(1);
            this.tail = this.getHead();
        }else{
            Node<T> newTail = new Node<T>(data);
            newTail.next = null;
            this.tail.next = newTail;
            this.tail = newTail;
            this.setLength(this.getLength() + 1);
        }
    }
    public void enqueue(T data){
        this.add(data);
    }
    public T dequeue(){
        return this.delete();
    }
}
