package LearnWithBook.chapter16;

import java.util.TreeSet;

public class TestTreeSet {

    public static void main(String[] args) {
        new TestTreeSet().go();
    }

    public void go() {

        Book b1 = new Book("Как устроены кошки");
        Book b2 = new Book("Постройте заново своё тело");
        Book b3 = new Book("В поисках Эмо");

        TreeSet<Book> tree = new TreeSet<Book>();
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);

    }
}

class Book implements Comparable<Book> {
    String title;

    Book(String t) {
        title = t;
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(((Book)o).title);
    }

    public String toString() {
        return title;
    }
}
