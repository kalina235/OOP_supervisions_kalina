public class ex6
{
    int a;
    int b;
    public ex6(int x, int y)
    {
        a=x;
        b=y;
    }
    public static void vectorAdd(ex6 Vec, int dx, int dy)
    {
        Vec.a += dx;
        Vec.b += dy;
    }
    public static void main(String[] args)
    {
            int a = 0;
            int b = 2;
            ex6 VecObj = new ex6(a,b);
            vectorAdd(VecObj,1, 1);
            a = VecObj.a;
            b = VecObj.b;
            System.out.println(a+" "+b);
    }
}
