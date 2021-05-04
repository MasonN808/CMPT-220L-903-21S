package base;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListItem {
    int value;
    ListItem nextItem;
    ArrayList list = new ArrayList();

    public ListItem(int value){
        this.value = value;
        this.nextItem = null;
        this.list.add(this.value);

    }

    public void addItem(int value){
        this.list.add(value);
    }

    public void deleteItem(){
        this.list.remove(this.value);
    }

    public int getValue(){
        return this.value;
    }
    
    public ArrayList getList(){
        if (this.nextItem != null){
            this.list.add(this.nextItem.getValue());
        }
        return this.list;
    }

    public static void main(String[] args) {
        ListItem one = new ListItem(1);
        ListItem two = new ListItem(2);
        ListItem three = new ListItem(3);
        ListItem four = new ListItem(4);

        one.nextItem = two;
        two.nextItem = three;
        three.nextItem = four;

        System.out.println(String.valueOf(one.getValue())+ ","+ String.valueOf(two.getValue()) + "," + String.valueOf(three.getValue())+ "," + String.valueOf(four.getValue()));

        four.addItem(2);
        System.out.println(four.getList().toString());
        System.out.println(one.getValue());
        one.deleteItem();
        System.out.println(one.getList().toString());


    }
}
