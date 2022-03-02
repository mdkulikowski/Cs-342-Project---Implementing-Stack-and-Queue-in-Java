public class GenericStack<T> extends GenericList<T>{
    private Node<T> tail;

    public GenericStack(T value){
        this.setHead(value, null);
        this.setLength(1);
        this.tail = this.getHead();
    }
    
    public T removeTail(){
        Node<T> removeTail = this.tail;
        this.tail = null;
        this.setLength(this.getLength() - 1);
        return removeTail.data;
    }

    void add(T data){
        if (this.getLength() == 0){
            this.setHead(data, null);
            this.setLength(1);
            this.tail = this.getHead();
        }else{
            this.setHead(data, this.getHead());
            this.setLength(this.getLength() + 1);
        }
    }

    public void push(T data){
        this.add(data);
    }
    public T pop(){
        return this.delete();
    }
}
