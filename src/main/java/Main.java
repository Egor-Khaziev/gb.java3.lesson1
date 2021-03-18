import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Integer[] number = new Integer[] {1, 2, 3, 4, 5, 6, 7} ;
        String[] line = new String[]{"line1", "line2", "line3", "line4", "line5", "line6", "line7"};

        /** task 1*/

        showAll(rearrange(line, 1, 5));
        showAll(rearrange(number, 1, 5));

        /** task 2 */

        transformToArray(line).stream().forEach((System.out::println));
        transformToArray(number).stream().forEach((System.out::println));

        /** task 3 */

        Box<Apple> box = new Box();
        box.addToBox(new Apple());
        box.addToBox(new Apple());
        box.addToBox(new Apple());

        Box<Orange> box1 = new Box();
        box1.addToBox(new Orange());
        box1.addToBox(new Orange());
        box1.addToBox(new Orange());

        Box<Orange> box2 = new Box();
        box2.addToBox(new Orange());
        box2.addToBox(new Orange());
        box2.addToBox(new Orange());
        box2.addToBox(new Orange());

        System.out.println(box.getWeight());
        System.out.println(box1.getWeight());

        box.compare(box1);

        box1.moveFruit(box2);

        System.out.println(box1.getWeight() + " " + box2.getWeight());

        box.moveFruit(box1);

        System.out.println(box.getWeight() + " " + box1.getWeight());


    }




    private static <T> ArrayList<T> transformToArray(T[] array) {

        ArrayList<T> list = new ArrayList();

        for (T t:array) {
            list.add(t);
        }

        return  list;
    }

    private static <T>T[] rearrange(T[] array , int i, int i1) {

        Object temp = array[i-1];
        array[i-1]=array[i1-1];
        array[i1-1]=(T)temp;

        return (T[]) array;
    }

    private static <T> void showAll(T[] array){
        for (T i:array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
