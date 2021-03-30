
public class main
{
    
    public static void main()
    {
        Engine.main();
        
        Engine.loop();
        
        LOG.FATAL("CTN-Engine have been stoped corectely , exit code 01");
        
    }
    
    
    /*
    private void main2()
    {
        Properties prop = new Properties();
        String propFileName = "config.properties";
    
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        
        if (inputStream != null)
        {
            prop.load(inputStream);
        }
        else{
            throw new FileNotFoundExeption("property file '" + propFileName + "' not found in the classpath");
        }
        
        
        
    }
    */
}
