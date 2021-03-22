public class FPScount
{
    
    private static boolean status = false;
    
    public static long Counter = 0;
    
    public static boolean statusFPSCOUNT = false;
    public static long time_1;
    public static long time_2;
    public static long time;
    public static long FPS;
    
    public static void main()
    {
        //if(FPScount.Show_debug)
        //LOG.debug("call FPScount.main");
        
        //Tick.main();
        
    }
    
    public static void start()
    {
        LOG.debug("Starting the FPS_count part of the engine");
        
        status = true;
        
    }
    
    public static void action()
    {
        if(status){
            if(FPSmanager.Show_debug)
            LOG.debug("An action is call in the counter");
            
            Tick.main();
            
            
            Counter++;
            
            if(statusFPSCOUNT == false){
                if(FPSmanager.Show_debug)
                LOG.debug("if1 is call");
                
                Tick.engineTick();
                time_1 = System.currentTimeMillis();
                statusFPSCOUNT = true;
                
                }
            
            else{
                if(FPSmanager.Show_debug)
                LOG.debug("if2 is call");
                
                time_2 = System.currentTimeMillis();
                statusFPSCOUNT = false;
                
                FPSmanager.calcul();
                
                }
        }
        else{
            LOG.error("Fps function not start , the action call dont count");
        }
        
    }
    
}
