import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        String nameThreadMain = Thread.currentThread().getName();
        System.out.println(nameThreadMain);

        Thread invisibleCat = new Thread(new InvisibleCat());
        invisibleCat.start();

        HashMap<String, Cat> catHashMap = new HashMap<>();

        catHashMap.put("Мурзик", new Cat("Мурзик"));
        catHashMap.put("Барсик", new Cat("Барсик"));
        catHashMap.put("Мурка", new Cat("Мурка"));
        catHashMap.put("Рыжик", new Cat("Рыжик", "рыжий"));
        catHashMap.put("Васька", new Cat("Васька", "белый"));
        catHashMap.put("Пушок", new Cat("Пушок", 2));
        catHashMap.put("Том", new Cat("Том", 4));
        catHashMap.put("Симба", new Cat("Симба", "рыжий", 6));
        catHashMap.put("Масяня", new Cat("Масяня", "черный", 1));
        catHashMap.put("Борис", new Cat("Борис", "белый", 8));


        System.out.println("Count of cats =" + Cat.getCatCount() + "  MainThread");
        System.out.println("-----------------");
        System.out.println("Sorted by name:");
        catHashMap.entrySet().stream().sorted(Comparator.comparing(entry -> entry.getValue().name))
                .forEach(entry -> System.out.println(entry.getValue().name + " "
                        + entry.getValue().color + " "
                        + entry.getValue().age));
        System.out.println("-----------------");
        System.out.println("Sorted by age:");
        catHashMap.entrySet().stream().sorted(Comparator.comparing(entry -> entry.getValue().age))
                .forEach(entry -> System.out.println(entry.getValue().name + " "
                        + entry.getValue().color + " "
                        + entry.getValue().age));
    }

    private static class InvisibleCat implements Runnable {
        private HashMap<String, Cat> catHashMap = new HashMap<>();

        @Override
        public void run() {
            String nameThreadInvisibleCat = Thread.currentThread().getName();
            System.out.println(nameThreadInvisibleCat);
            try {
                Thread.sleep(1000); //  если убрать задержку, то в консоли будет видно,
                // что потоки работают параллельно

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            InvisibleCat.addCat(catHashMap);
            System.out.println("Size MapInvisibleCat" + catHashMap.size());

        }

        static void addCat(HashMap<String, Cat> catHashMap) {
            catHashMap.put("Невидимка", new Cat("Невидимка", "невидимый", 10));
            System.out.println("Count of cats =" + Cat.getCatCount() + " InvisibleCatThread");
            System.out.println(Thread.currentThread().getName() + " added invisible cat");
            System.out.println("-----------------");
        }
    }
}