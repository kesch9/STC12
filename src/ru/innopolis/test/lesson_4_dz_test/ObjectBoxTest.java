package lesson_4_dz_test;

import ru.innopolis.lesson_4_dz.MyException;
import ru.innopolis.lesson_4_dz.ObjectBox;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ObjectBoxTest {

    @org.junit.Test
    public void addObject() {
        ObjectBox objectBox = new ObjectBox(new Integer[]{1,2,4,6,8});
        objectBox.addObject("sds");
        ObjectBox compareObjectBox = new ObjectBox(new Integer[]{1,2,4,6,8});
        assertNotEquals(objectBox.getArrayList(),compareObjectBox.getArrayList());
    }

    @org.junit.Test
    public void deleteObject() {
        ObjectBox objectBox = new ObjectBox(new Integer[]{1,2,4,6,8});
        objectBox.addObject("sds");
        objectBox.deleteObject("sds");
        ObjectBox compareObjectBox = new ObjectBox(new Integer[]{1,2,4,6,8});
        assertEquals(objectBox.getArrayList(),compareObjectBox.getArrayList());
    }

    @org.junit.Test
    public void dump() {
        ObjectBox objectBox = new ObjectBox(new Integer[]{1,2});
        objectBox.dump();
    }

    @org.junit.Test
    public void summator() throws MyException {
        ObjectBox objectBox = new ObjectBox(new Integer[]{1,2,4,6,8});
        assertEquals(21,objectBox.summator());
        objectBox.addObject(247);
        assertEquals(268,objectBox.summator());
        objectBox.addObject(2);
        assertEquals(270,objectBox.summator());
        objectBox.deleteObject(2);
        assertEquals(268,objectBox.summator());

    }

    @org.junit.Test
    public void splitter() throws MyException {
        ObjectBox objectBox = new ObjectBox(new Integer[]{1,4,6,8});
        ArrayList<Integer> arrayList= new ArrayList<Integer>();
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        assertEquals(arrayList.subList(0,arrayList.size()),objectBox.splitter(2));
        objectBox.addObject(2);
        arrayList.add(1);
        assertEquals(arrayList.subList(0,arrayList.size()),objectBox.splitter(2));
        arrayList.remove((Integer)1);
        objectBox.deleteObject(2);
        assertEquals(arrayList.subList(0,arrayList.size()),objectBox.splitter(2));

    }

    @org.junit.Test
    public void deleteElement() {
        ObjectBox objectBox = new ObjectBox(new Integer[]{1,4,6,8});
        ArrayList<Integer> arrayList= new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(6);
        arrayList.add(8);
        arrayList.remove((Integer)1);
        objectBox.deleteObject((Integer)1);
        assertEquals(arrayList,objectBox.getArrayList());

    }
}
