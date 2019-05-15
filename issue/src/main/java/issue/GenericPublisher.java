package issue;

public interface GenericPublisher<E> {
    
    void publish(E event);
    
}
