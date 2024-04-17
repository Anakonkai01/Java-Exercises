import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack <T>{
    private final ArrayList<T> elements;
    public Stack(){
        elements = new ArrayList<T>();
    }

    public void push(T element){
        elements.add(element);
    }

    public T pop(){
        if (elements.isEmpty()){
            throw new EmptyStackException();
        }
        return elements.removeLast();
    }

    public T peek(){
        if (elements.isEmpty()){
            throw new EmptyStackException();
        }
        return elements.getLast();
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }


}

