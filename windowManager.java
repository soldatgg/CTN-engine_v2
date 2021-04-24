
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class windowManager extends Engine
{
    
    public static void initWindow(int Large ,int High ,String name ,boolean v1 ,boolean v2, boolean v3)
    {
        LOG.println("Initialaise a new window");
        
        if(v1)
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        if(v2)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        
        window = glfwCreateWindow(Large, High, name, NULL, NULL);
        if( window == NULL ){
            LOG.FATAL("GLFW can't create the window");
            
        }
        
        if(v3){
            glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> 
            {
                if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true);
            
            }
            );
        }
        
    }
    
    public void createWindow()
    {
        
        
    }
    
}
