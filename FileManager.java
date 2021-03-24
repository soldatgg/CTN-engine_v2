
import java.io.FileWriter;
import java.io.File;

import java.io.BufferedWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class FileManager extends Engine
{
    
    private static boolean status = false;
    
    public static void Init(String File)
    {
        LOG.println("Initialise the File manager");
        
        File file = new File(File);
        
        status = true;
        
    }
    
    public static boolean ReadPropBoolean(boolean ReturnValue)
    {
        if(status){
            
            
            
        }
        
        return ReturnValue;
        
    }
    
    public static void Read()
    {
        
        
    
    }
    
    
}
