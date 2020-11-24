public class s2ex2
{
    public static abstract class Person //##a simple class representing a person with 2 constructors, 2 fields and a method
    {
        int age;
        String name;
        public void say_smth()
        {
            System.out.println("Hello");
        }
    }
    public static class Engineer extends Person
    {
        String specialisation;
        public Engineer(String n, int a, String spec)
        {
            age = a;
            name = n;
            specialisation = spec;
        }
        @Override
        public void say_smth() {
            System.out.println("Hello World");
        }
    }
    public class Humanist extends Person
    {
        public Humanist(String n, int a)
        {
            age = a;
            name = n;
        }
    }
    public static void main(String[] args)
    {
        Person p = new Engineer("Kalina", 19, "CS");
        p.say_smth();
    }
}