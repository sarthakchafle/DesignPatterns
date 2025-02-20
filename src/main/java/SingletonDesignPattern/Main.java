package SingletonDesignPattern;

public class Main {
    public static void main(String[] args) {
        // Getting the single instance
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Display message
        singleton1.showMessage();

        // Checking if both references point to the same instance
        System.out.println(singleton1 == singleton2); // Output: true
    }
}
