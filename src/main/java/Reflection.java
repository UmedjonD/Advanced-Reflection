import java.lang.reflect.*;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Entity entity = new Entity();
        //три способа для получения объект класса
        Class access = entity.getClass();
        Class access2 = Entity.class;
        Class access3 = Class.forName("Entity");
        //получения инстанс класса без помощи new
        Entity entity1 = (Entity) access.newInstance();
        //Выводим имя класса
        System.out.println("ИМЯ КЛАССА : ");
        System.out.println(access.getName());

        System.out.println("*_*");
        System.out.println("Конструкторы и Параметры : ");
        //получения конструктора класса Entity
        Constructor[] constructors = access.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.print("имя конструктора: " + constructor.getName());
            System.out.println();
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(" значения: " + parameter.getName() + " тип значение: ");
                System.out.println(parameter.getParameterizedType().getTypeName());
            }
        }

        System.out.println("*_*");
        System.out.println("Методы: ");
        Method[] methods = access2.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print("значения: " + parameter.getName() + " тип значение: ");
                System.out.println(parameter.getParameterizedType().getTypeName());
            }
            System.out.print("Модефикаторы метода: ");
            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println(method.getReturnType().getName());
        }

        System.out.println("*_*");
        System.out.println("Fields: ");
        Field[] fields = access3.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("тип: " + field.getType());
            System.out.println("имя: " + field.getName());
            System.out.println("модефикатор: " + Modifier.toString(field.getModifiers()));

        }
        System.out.println("Fields: ");
        Field[] fields2 = access3.getDeclaredFields();
        for (Field field : fields2) {
            field.setAccessible(true);
            System.out.println("начальное значение: " + field.getInt(entity));
            field.setInt(entity, 5);
            System.out.println("новое значение: " + field.getInt(entity));
        }
    }
    /*
    Заметка для себя: если хотим запускать метод , то можно сделать это с помошью invoke и
    передать туда какие нибудь значение!
    method.invoke()
     */
}

