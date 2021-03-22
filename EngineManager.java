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

public class EngineManager extends Engine {
    
    
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
            glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> 
            {if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )glfwSetWindowShouldClose(window, true);   });
        }
        
    }

    
    /*s
    public boolean OOF_status = true;
    public long FPS = 0;
    public boolean showFps = true;
    */
    
    
/*
    public void run() {
        
        LOG.debug("call EngineManager.run");
        
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        
        if(OOF_status == false)
        {
            LOG.FATAL("OFF That hurts");
        }

        init();
        loop();

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback.
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
*/
/*
    private void init() {
        
        LOG.debug("call EngineManager.init");
        
        FPScount.start();
        
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(800, 460, "Hello World!", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
        });

        // Get the thread stack and push a new frame
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                window,
                (vidmode.width() - pWidth.get(0)) / 2,
                (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);
    }
*/
/*
    private void loop() {
        
        LOG.debug("call EngineManager.loop");
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // Set the clear color
        glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while ( !glfwWindowShouldClose(window) == true) {
            
            LOG.debug("call Engine.loop/while");
            
            FPScount.action();
            
            if(showFps)
            LOG.printFPS(FPS);
            
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }*/

    //public static void main(String[] args) {
    //    LOG.debug("call EngineManager.main");
    //    new EngineManager().run();
    //}
    
    public static void nothing()
    {
        LOG.println("Engine Manager is present and detected");
    }

}