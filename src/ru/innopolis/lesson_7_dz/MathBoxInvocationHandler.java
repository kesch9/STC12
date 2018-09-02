
/*Работаем с проектом из Урока 3

        1.      Создать прокси для класса mathBox (подумайте, что для этого надо добавить к классу)

        2.      В вызов методов класса через прокси добавить логирование в консоль при использовании аннотации Logged

        3.      В вызов методов класса через прокси добавить очистку поля-контейнера при использовании аннотации ClearData у вызванного метода

        Нужные аннотации добавить к проекту

        Дополнительное задание (не на оценку)

        Добавить в проект сериализации объект-прокси, который будет при использовании аннотации UseXml выполнять сериализацию-десериализацию в XML вместо нативной.
        Саму сериализацию-десериализацию можно заглушить. Главное разобраться с прокси и созданием собственных аннотаций.
*/

package ru.innopolis.lesson_7_dz;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MathBoxInvocationHandler implements InvocationHandler {

    private MathBoxInterface mathBox;

    public MathBoxInvocationHandler(MathBoxInterface mathBox) {
        this.mathBox = mathBox;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Annotation annotation: method.getAnnotations()){
            System.out.println(annotation.annotationType().getName());
            if (annotation.annotationType().getName() == "Logged"){
                System.out.println("Log complete in " + System.currentTimeMillis() + " ms");
            }
        }

        return method.invoke(mathBox,args);
    }
}
