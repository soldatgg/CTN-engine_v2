
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class main
{
    
    public void main()
    {
        Engine.main();
        
        Engine.loop();
        
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
