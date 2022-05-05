# Task 3.2 - Сериализация Java-класса, архивация
Лекция «Потоки ввода-вывода. Работа с файлами. Сериализация».  
Задача 2 - "Сохранение".   

## Описание
В данной задаче Вы потренируетесь сериализовывать Java класс, используя интерфейс `Serializable`, записывать сериализованные файлы на жесткий диск, используя класс `FileOutputStream`, и упаковывать их в архив с помощью `ZipOutputStream`.

Для дальнейшей работы потребуется создать класс `GameProgress`, хранящий информацию об игровом процессе. Предлагаем следующую реализацию:
```java
public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
}
```

Таким образом, для выполнения задания потребуется проделать следующие шаги:
1. Создать три экземпляра класса `GameProgress`.
2. Сохранить сериализованные объекты `GameProgress` в папку `savegames` из предыдущей задачи.
3. Созданные файлы сохранений из папки `savegames` запаковать в архив `zip`.
4. Удалить файлы сохранений, лежащие вне архива.
