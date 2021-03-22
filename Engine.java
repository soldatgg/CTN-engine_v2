
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

//import RawModel.*;


public class Engine
{
    
    public static long window;
    private static boolean vSync = false;
    public static boolean OOF_status = true;
    private static boolean DFwindowGLFW = true;
    
    public static void main()
    {
        LOG.debug("call Engine.main");
        
        if(!OOF_status)
        LOG.FATAL("OOF That hurts");
        
        EngineManager.nothing();
        if(DFwindowGLFW)
            glfwDefaultWindowHints();
        GLFWErrorCallback.createPrint(System.err).set();
        
        FPScount.start();
        
        LOG.println("Try to start glfw");
        if( !glfwInit() )
            LOG.FATAL("Unable to start glfw");
        
        LOG.println("glfw started");
        
        LOG.println("Version of LWJGL :");
        LOG.println(Version.getVersion());
        
        init_window(800, 460, "CTN-engine", true, true, true);
        
            MemoryStack stack = stackPush();
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            glfwGetWindowSize(window, pWidth, pHeight);

            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            glfwSetWindowPos(
                window,
                (vidmode.width() - pWidth.get(0)) / 2,
                (vidmode.height() - pHeight.get(0)) / 2
                );
        
        //make the openGL context current
        glfwMakeContextCurrent(window);
        
        if(vSync)
        glfwSwapInterval(1);
        
        glfwShowWindow(window);
        
    }
    
    public static void init_window(int Large ,int High ,String name ,boolean v1 ,boolean v2, boolean v3)
    {
        LOG.println("Initialaise a new window");
        
        if(v1)
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        if(v2)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        
        window = glfwCreateWindow(Large, High, name, NULL, NULL);
        if( window == NULL )
        {
            LOG.FATAL("GLFW can't create the window");
        }
        
        if(v3){
            glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true);});
        }
        
    }
    
    public static void loop()
    {
        
        LOG.debug("call EngineManager.loop");
        
        GL.createCapabilities();

        // Set the clear color
        glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        
        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        
        float[] vertices = {
        -0.5f, 0.5f, 0f,
        -0.5f, -0.5f, 0f,
        0.5f, -0.5f, 0f
        };
        
        int[] indices = {
            0,1,3,3,1,2};
        
        RawModel model = loader.loadToVAO(vertices, indices);

        while ( !glfwWindowShouldClose(window) == true) {
            
            LOG.debug("call Engine.loop/while");
            FPScount.action();
            
            renderer.prepare();
            
            renderer.render(model);
            
            //glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
            }
        
        loader.cleanUP();
        
    }
    
}
