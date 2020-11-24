public class s2ex5
{
    public static class Employee
    {
        int number;
        void behave()
        {
            System.out.println("normal behaviour");
        }
        public boolean is_Ninja()
        {
            if(this instanceof Ninja) System.out.println("OH NO");
            else System.out.println("you're safe");
            return (this instanceof Ninja);
        }
    }
    interface Ninja
    {
        default void behave2()
        {
            System.out.println("Kills everyone");
        }
    }
    static class NinjaEmployee extends Employee implements Ninja
    {
    }
    public static void main(String[] args) {
        Employee empl = new Employee();
        empl.is_Ninja();
        empl = new NinjaEmployee();
        empl.is_Ninja();
    }
}
