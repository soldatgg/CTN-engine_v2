
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
    private static boolean vSync = true;
    public static boolean OOF_status = true;
    private static boolean DFwindowGLFW = true;
    private static int VsyncFPSLimiterDivider  = 1 ;
    
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
        
        windowManager.initWindow(1280, 720, "CTN-engine", true, true, true);
        
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
        glfwSwapInterval(VsyncFPSLimiterDivider);
        
        glfwShowWindow(window);
        
    }
    
    public static void loop()
    {
        
        LOG.debug("call EngineManager.loop");
        
        GL.createCapabilities();

        // Set the clear color
        //glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        //old engine loop part not need anymore in nopw on the erepare render
        //part of the engine
        
        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        
        //3d model
        float[] vertices = {
        -0.5f, 0.5f, 0f,
        -0.5f, -0.5f, 0f,
        0.5f, -0.5f, 0f,
        0.5f, -0.5f, 0f,
        0.5f, 0.5f, 0f,
        -0.5f, 0.5f, 0f
        };
        
        int[] indices = {
            0,1,3,3,1,2};
        
        RawModel model = loader.loadToVAO(vertices, indices);

        while ( !glfwWindowShouldClose(window) == true) {
            
            LOG.debug("call Engine.loop/while");
            FPScount.action();
            
            renderer.prepare();
            
            renderer.OLDrender(model);
            
            //glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            
            //acctivate it if you want to not display an image /\

            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
            }
            LOG.engine("End of the main Engine loop");
        
        loader.cleanUP();//problem on the cleanup of the vbos
        
    }
    
}
