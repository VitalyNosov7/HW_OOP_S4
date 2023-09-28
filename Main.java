import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        LinkedContainer<String> stringLinked = new LinkedContainer<>();
        stringLinked.addLast("a");
        stringLinked.addLast("b");
        stringLinked.addLast("c");
        stringLinked.addLast("d");
        stringLinked.addLast("e");

        System.out.println("==============");
        System.out.println("Количество элементов связного списка");
        System.out.println(stringLinked.size());

        System.out.println("==============");
        System.out.println("Элемент, выбранный по индексу");
        System.out.println(stringLinked.getElementByIndex(0));

        System.out.println("==============");
        System.out.println("С начала связного списка");
        for (String s : stringLinked){
            System.out.println(s);
        }

        System.out.println("==============");

        System.out.println("С конца связного списка");
        Iterator iterator = stringLinked.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
