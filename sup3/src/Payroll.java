import java.util.HashMap;
import java.util.Map;

public class Payroll
{
    private static Payroll instance = new Payroll();
    private int getBankAccountBalance() {
        return 100000;
    }
    private Payroll()
    {
            day = 0;
            last_pay = new HashMap<Integer, Integer>();
            cash_balance = getBankAccountBalance(); // send request to Bank to get payroll budget
    }
    private Map<Integer, Integer> last_pay;
    private int cash_balance;
    int day;
    public static Payroll getInstance()
    {
        return instance;
    }
    public void distributeSalary(Employee emp)
    {
        int id = emp.id;
        int sal = emp.salary;
        if(!last_pay.containsKey(id))
        {
            System.out.println("This employee is not on the Payroll!");
        }
        else
        if (day - last_pay.get(id) > 30)
        {
            if(cash_balance < sal)
            {
                System.out.println("you're bankrupt!");
            }
            System.out.println("payed a salary");
            cash_balance -= 100;
            last_pay.put(id, day);
        }
        else {
            System.out.println("It's not time to pay this employee yet!");
        }
    }

    public void upBalance(int up)
    {
        cash_balance += up;
    }
    public void add_employee(int id)
    {
        last_pay.put(id, day);
    }
}

class Employee
{
    int salary;
    int id;
    Employee(int ssalary, int sid)
    {
        salary = ssalary;
        id = sid;
    }
    public static void main(String[] args)
        {
            Employee empl1 = new Employee(100,1);
            Employee empl2 = new Employee(100000,2);
            Payroll payroll = Payroll.getInstance();
            payroll.distributeSalary(empl1);
            payroll.add_employee(empl1.id);
            payroll.add_employee(empl2.id);
            payroll.distributeSalary(empl1);
            payroll.day+=32;
            payroll.distributeSalary(empl1);
            payroll.distributeSalary(empl2);
            payroll.distributeSalary(empl1);
            Payroll payroll2 = Payroll.getInstance();
            payroll2.upBalance(100000);
            payroll2.distributeSalary(empl2);
        }
}