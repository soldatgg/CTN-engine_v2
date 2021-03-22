

public class Tick
{
    
    private static boolean status = false;
    private static boolean loop = false;
    private static long time_1;
    private static long time_2;
    private static long time;
    public static long Tick;
    public static long Tick2;
    private static boolean Show_debug = true;
    
    private static boolean Show_EngineTPS = false;
    
    private static long EngineTick = 0;
    
    public static void engineTick()
    {
        EngineTick++;
        
        if(Show_EngineTPS){
            LOG.print("EngineTPS : ");
            LOG.printFPS(EngineTick);
            }
        
    }
    
    public static boolean start(boolean value)
    {
        status = true;
        return value;
        
    }
    
    public static void main()
    {
        
        
    }
    
    public static boolean autoTest(boolean Value)
    {
        
        
        return Value;
        
    }
    
    
}
