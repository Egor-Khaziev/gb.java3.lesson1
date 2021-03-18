import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Comparator;

public class Box<T extends Fruit> {

    boolean orange = false;
    boolean apple = false;

    public boolean isOrange() {
        return orange;
    }

    public boolean isApple() {
        return apple;
    }

    public ArrayList<T> box = new ArrayList<>();

//    public ArrayList<Fruit> getBox() {
//        return box;
//    }

    public void addToBox(T one) {

        if (box.size() == 0) {

            if ((one instanceof Apple && isApple()) || (one instanceof Orange && isOrange()) || (!isOrange() && !isApple())) {
                box.add(one);
                if (one instanceof Apple) {
                    apple = true;
                } else {
                    orange = true;
                }
                return;
            } else {
                System.out.println("Sorry, your fruit is wrong, this box for another fruits");
            }
        }

        if (box.get(0) instanceof Apple && one instanceof Apple) {
            box.add(one);
        } else if (box.get(0) instanceof Orange && one instanceof Orange) {
            box.add(one);
        } else {
            System.out.println("Sorry, your fruit is wrong, this box for another fruits");
        }
    }

    public float getWeight() {
        if (box.size() == 0) {
            return 0.0f;
        }
        if (box.get(0) instanceof Apple) {
            return box.size() * 1.0f;
        }
        if (box.get(0) instanceof Orange) {
            return box.size() * 1.5f;
        }
        return 0.0f;
    }

    public boolean compare(Box anotherBox) {
        if (anotherBox.getWeight() == this.getWeight()) {
            return true;
        }
        return false;
    }

    public void moveFruit(Box box2) {
        if (this.box.size() == 0){
            System.out.println("no fruits in box");
            return;
        }
        if (box2.box.size() == 0) {
            if ((box2.isApple() && isApple()) || (box2.isOrange() && isOrange())) {
                box2.box.addAll(this.box);
                this.box.clear();
                return;
            } else {
                System.out.println("Sorry, your fruit is wrong, this box for another fruits");
            }

        } else {
            if (this.box.get(0).getClass().equals(box2.box.get(0).getClass())) {
                box2.box.addAll(this.box);
                this.box.clear();

            } else {
                System.out.println("Sorry, different fruits");
            }
        }
    }
}
