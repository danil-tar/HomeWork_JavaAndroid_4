public class Cat {
    public String name;
    public int age;
    public String color;
    private static int catCount = 0;


    public Cat(String name, String color, int age) {
        this.name = name;
        this.age = age;
        this.color = color;
        catCount++;
    }

    public Cat(String name) {
        this.name = name;
        this.color = "серый";
        this.age = 0;
        catCount++;
    }
    public Cat(String name, int age) {
        this.name = name;
        this.color = "серый";
        this.age = age;
        catCount++;
    }
    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
        this.age = 0;
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }
}
