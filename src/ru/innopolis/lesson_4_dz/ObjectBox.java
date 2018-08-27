
/* Создать класс ObjectBox, который будет хранить коллекцию Object. В нем должны быть все методы из MathBox.
Методы должны работать корректно когда все элементы коллекции-Number.
Если в коллекции есть не Number, должен бросаться Exception, разработанный самостоятельно.


        У класса должен быть метод addObject, добавляющий объект в коллекцию.

        У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции.

        Должен быть метод dump, выводящий содержимое коллекции в строку.

        ___________________

        Вторая часть задания, творческая:

        Получившиеся классы MathBox и ObjectBox не имеют связи между собой. Это неправильно. Логичнее было бы сделать MathBox наследником ObjectBox.
        Необходимо сделать такую связь, правильно распределить поля и методы. Функциональность в целом должна сохраниться.
        Руководствуемся здравым смыслом и своей фантазией.

        Задание выполняется в одной ветке. Каждая часть в отдельном пакете.
*/
package ru.innopolis.lesson_4_dz;

import ru.innopolis.lesson_3_dz.MathBox;

import java.util.ArrayList;
import java.util.Collection;

public class ObjectBox extends MathBox {

    ArrayList<Object> arrayList;

    private Boolean notNumber = false;

    public ObjectBox(Integer[] inputArray) {
        super(inputArray);
        arrayList = new ArrayList<>(super.getSet());
    }


    public void addObject (Object o){
        if (o instanceof Number) {
            super.getSet().add((Integer) o);
        } else {
            notNumber = true;
        }
        arrayList.add(o);
    }

    public void deleteObject (Object o){
        if (o instanceof Number) {
            super.getSet().remove(o);
        }
        arrayList.remove(o);
        if (arrayList.equals(super.getSet())){
            notNumber = false;
        }
    }

    public void dump(){
        StringBuilder stringBuilder = new StringBuilder("Содержимое класса Object: [");
        for (Object i: arrayList){
            stringBuilder.append(i + ", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }


    @Override
    public int summator() throws MyException {
        if (notNumber) {
            throw new MyException();
        }
        return super.summator();
    }

    @Override
    public Collection<Integer> splitter(int div) throws MyException {
        if (notNumber) {
            throw new MyException();
        }
        return super.splitter(div);
    }

    @Override
    public boolean deleteElement(Integer i) throws MyException {
        if (notNumber) {
            throw new MyException();
        }
        return super.deleteElement(i);
    }
}
