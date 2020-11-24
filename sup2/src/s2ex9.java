import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class s2ex9
{
    public class Shop
    {
        List<Department> departments;
        public Shop(List<Department> deps)
        {
            departments = deps;
        }
    }
    public class Department
    {
        List<Item> inventory;
        protected Manager manager;
        public Department(List<Item> items)
        {
            inventory = items;
        }
        public Department(List<Item> items, Manager man)
        {
            inventory = items;
            if(man.responsibility != null) throw new IllegalArgumentException("This manager already has a dept");
            manager = man;
        }
    }
    public class Item
    {
        String name;
        Department department;
        double tax_rate;
        public Item(String n, double tax_r, Department dep)
        {
            name = n;
            tax_rate = tax_r;
            department = dep;
        }
    }
    protected abstract class Employee
    {
        String name;  // question: why can't I do lowercase string? do I need an array of chars instead?
        String phone_no;
        int salary;
        abstract void do_work();
    }
    protected class Manager extends Employee
    {
        protected Department responsibility;
        public Manager(String n, String pno, int sal)
        {
            name = n;
            phone_no = pno;
            salary = 2000;
        }
        public Manager(String n, String pno, int sal, Department res)
        {
            name = n;
            phone_no = pno;
            salary = 2000;
            if(res.manager != null) throw new IllegalArgumentException("This dept already has a manager");
            responsibility = res;
        }
        @Override
        void do_work()
        {
            System.out.println("Managed stuff");
        }
    }
    protected class Shop_assistant extends Employee
    {
        protected Shop_assistant(String n, String pno, int sal)
        {
            name = n;
            phone_no = pno;
            salary = 10000;
        }
        @Override
        void do_work()
        {
            System.out.println("did things");
        }
    }
}
