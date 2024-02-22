package LearnWithBook.chapter16;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortMountain {

    LinkedList<Mountain> mnt = new LinkedList<Mountain>();

    static class NameCompare implements Comparator <Mountain> {
        public int compare(Mountain one, Mountain two) {
            return one.name.compareTo(two.name);
        }
    }

    static class HeightCompare implements Comparator <Mountain> {
        public int compare(Mountain one, Mountain two) {
            //return (Integer.compare(two.getHeight(), one.getHeight()));
            return (two.height - one.height);
        }
    }

    public static void main(String[] args) {
        new SortMountain().go();
    }

    public void go() {

        mnt.add(new Mountain("Лонг-рейндж", 14255));
        mnt.add(new Mountain("Эльберт", 14433));
        mnt.add(new Mountain("Марун", 14156));
        mnt.add(new Mountain("Касл", 14265));

        System.out.println("В порядке добавления:\n" + mnt );

        NameCompare nc = new NameCompare();
        mnt.sort(nc);
        System.out.println("По названию:\n" + mnt );

        HeightCompare hc = new HeightCompare();
        Collections.sort(mnt, hc);
        System.out.println("По высоте:\n" + mnt );

    }
}

class Mountain {

    String name;
    int height;

    Mountain(String n, int h) {
        name = n;
        height = h;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        return name + ": " + height;
    }

}
