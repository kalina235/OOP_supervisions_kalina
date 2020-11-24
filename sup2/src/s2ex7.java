public class s2ex7
{
    public static class Person
    {
        String name;
        String surname;
        public Person(String n, String s)
        {
            name = n;
            surname = s;
        }
        @Override
        public String toString()
        {
            return "Overriden person's sout";
        }
    }
    public static void testOutput()
    {
        Person p = new Person("Joe", "Bloggs");
        System.out.println("Person details:"  + p);
    }

    public static void main(String[] args)
    {
        testOutput();
    }
}
