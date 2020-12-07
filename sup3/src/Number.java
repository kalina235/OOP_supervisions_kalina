public class Number
{
    static int min_val = 0;
    static int max_val = 100;

    private int val;

    public Number(int min, int v, int max)
    {
        min_val = min;
        val = v; //this is static, I want to be able to perform operations on my value
        max_val = max;
    }
    public Number(int v)
    {
        val = v;

    }
    public void increase(){
        val++;
    }
    public boolean isWithin() //this is non-static since I want to be able to check this for every value I create
    {
        //System.out.println(min_val);
        //System.out.println(val);
        // System.out.println(max_val);
        return val <= max_val && val >= min_val;
    }
    public static boolean isReasonable() //this is static, I need to check my bounds are reasonable only once in my program since they're static(encapsulation)
    {

        return max_val >= min_val;
    }
    public static void main(String[] args)
    {
        Number x = new Number(1,2,3);
        Number y = new Number(7);
        System.out.println(Number.isReasonable());
        System.out.println(x.isWithin());
        x.increase(); x.increase();
        System.out.println(x.isWithin());
        System.out.println(y.isWithin());
    }
}
