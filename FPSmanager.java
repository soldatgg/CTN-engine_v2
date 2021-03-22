
/**
 * Write a description of class autoTestFPS here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FPSmanager
{
    
    private static boolean Show_counter = true;
    private static boolean Show_FPS = true;
    private static boolean Show_ping = true;
    public static boolean Show_debug = false;
    
    public static int ErrorFrameCount = 0;
    
    public static void main()
    {
        ErrorFrameCount++;
        
    }
    
    public static void calcul()
    {
        if(Show_debug)
        LOG.debug("The calcul function is call");
        
        FPScount.time = FPScount.time_2 - FPScount.time_1;
        
        if(FPScount.time == 0){
            reset();
            }
        
        if(FPScount.time != 0){
        FPScount.FPS = 1000 / FPScount.time;
            }
        
        if(Show_counter){
            LOG.print("Frame number : ");
            LOG.printFPS(FPScount.Counter);
            }
        
        if(Show_FPS){
            LOG.print("FPS : ");
            LOG.printFPS(FPScount.FPS);
            }
            
        if(Show_ping){
            LOG.print("Ping : ");
            LOG.printFPS(FPScount.time);
            }
        
    }
    
    public static void error()
    {
        if(Show_debug)
        LOG.debug("call FPSmanager.error");
        
        
        
    }
    
    private static void reset()
    {
        LOG.error("The FPS of the game is too high for get count , the counter is reset");
        FPScount.statusFPSCOUNT = false;
        
        ErrorFrameCount++;
        
    }
    
    
}
