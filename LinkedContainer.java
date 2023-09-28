import java.util.Iterator;

// Незамкнутый связный список
public class LinkedContainer<E> implements Linked<E>, Iterable<E>, DescendingIterator<E>{

    private Node<E> firstNode; //  Первая  нода

    private Node<E> lastNode; //  Последняя нода
    private int size = 0;

    // null<-prevElement[firstNode(e = null)] nextElement-> <-prevElement[firstNode(e = value)] nextElement-> <-prevElement[firstNode(e = null)] nextElement-> null

    public  LinkedContainer(){
        lastNode = new Node<E>(null, firstNode, null);
        firstNode = new Node<E>(null, null, lastNode);
    }

    @Override
    public void addLast(E e) {
        Node<E>  prev = lastNode; // Создали указатель на объект, созданный в конструкторе
        prev.setCurrentElement(e); // Задали указателю текущий элемент
        lastNode = new Node<E>(null, prev, null);
        prev.setNextElement(lastNode);
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E>  next = firstNode; // Создали указатель на объект, созданный в конструкторе
        next.setCurrentElement(e); // Задали указателю текущий элемент
        firstNode = new Node<E>(null, null, next);
        next.setPrevElement(firstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    // Вся идея связного списка в этом методе.
    @Override
    public E getElementByIndex(int counter) {
        Node<E> target = firstNode.getNextElement(); // Хранит наш результат. Идем от начала связного списка. Берем следующий элемент у первой ноды.
        for(int i = 0; i < counter; i++){
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<E> getNextElement(Node<E> current){
        return current.getNextElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getElementByIndex(counter++);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0 ;
            }

            @Override
            public E next() {
                return getElementByIndex(counter--);
            }
        };
    }

    private class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        private Node(E currentElement, Node<E> prevElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }

}
