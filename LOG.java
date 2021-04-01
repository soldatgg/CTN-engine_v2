
public class LOG
{
    
    private static boolean debug = false;
    private static boolean debugGet = false;
    private static long value2 = 0;
    
    public static void engine(String value)
    {
        System.out.print("#Engine ");
        System.out.println(value);
        
    }
    
    public static void CleanUP(String value, int v)
    {
        System.out.print(value);
        System.out.println(v);
        
    }
    
    public static void render(String value)
    {
        System.out.print("#Render ");
        System.out.println(value);
        
    }
    
    public static void loader(String value)
    {
        System.out.print("#Loader ");
        System.out.println(value);
        
    }
    
    public static void model(String value)
    {
        System.out.print("#model ");
        System.out.println(value);
        
    }
    
    public static void get(String value)
    {
        if(debugGet){
        System.out.print("[debug GET] ");
        System.out.println(value);
    }
        
    }
    
    public static void printfloat(float value)
    {
        System.out.println(value);
        
    }
    
    public static void printVersion(String value)
    {
        System.out.print("[Version] ");
        System.out.println(value);
        
    }
    
    public static void printLong(long value)
    {
        System.out.println(value);
        
    }
    
    public static void printFPS(long value)
    {
        System.out.print(value);
        System.out.println("Ns");
        value2 = value / 1000000;
        System.out.print(value2);
        System.out.println("Ms");
        
    }
    
    public static void println(String value)
    {
        System.out.println(value);
        
    }
    
    public static void print(String value)
    {
        System.out.print(value);
        
    }
    
    public static void error(String value)
    {
        System.out.print("[ERROR] ");
        System.out.println(value);
        
    }
    
    public static void FATAL(String value)
    {
        System.out.print("!!!FATAL!!! ");
        System.out.println(value);
        System.exit(1);
        
    }
    
    public static void debug(String value)
    {
        if(debug){
        System.out.print("[Debug] ");
        System.out.println(value);
        }
        
    }
}
