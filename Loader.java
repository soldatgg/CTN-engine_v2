
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;

import java.util.List;
import java.util.ArrayList;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.io.FileInputStream;

public class Loader
{
    private List<Integer> vaos = new ArrayList<Integer>();
    private List<Integer> vbos = new ArrayList<Integer>();
    
    
    public int loadTexture(String fileName)
    {
        Texture texture = null;
        texture = TextureLoader.getTexture("PNG" ,new FileInputStream("res/"+fileName+".png"));
        
    }
    
    
    public RawModel loadToVAO(float[] positions, int[] indices)
    {
        LOG.debug("call Loader.RawModel");
        LOG.loader("Loading the mesh");
        bindIndicesBuffer(indices);
        int vaoID = createVAO();
        storeDataInAttributeList(0, positions);
        unbindVAO();
        return new RawModel(vaoID,indices.length);
        
    }
    
    public void cleanUP()
    {
        LOG.loader("Try to clean up the Engine");
        for(int vao:vaos){
            LOG.CleanUP("#Loader CleanUp the VAO number : ", vao);
            GL30.glDeleteVertexArrays(vao);
        }
        
        for(int vbo:vbos){
            LOG.CleanUP("#Loader CleanUp the VBO number : ", vbo);
            GL15.glDeleteBuffers(vbo);
        }
        
        LOG.loader("Engine CleanUP is finish");
        
    }
    
    private int createVAO()
    {
        LOG.loader("createVAO");
        int vaoID = GL30.glGenVertexArrays();
        vaos.add(vaoID);
        GL30.glBindVertexArray(vaoID);
        LOG.println("The VAO is created");
        return vaoID;
        
    }
    
    private void storeDataInAttributeList(int attributeNumber, float[] data)
    {
        LOG.loader("call Loader.storeDataInAttributeList");
        int vboID = GL15.glGenBuffers();
        vbos.add(vboID);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
        FloatBuffer buffer = storeDataInFloatBuffer(data);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(attributeNumber, 3, GL11.GL_FLOAT, false, 0, 0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
        
    }
    
    private void unbindVAO()
    {
        LOG.loader("unbindVAO");
        GL30.glBindVertexArray(0);
        
    }
    
    private void bindIndicesBuffer(int[] indices)
    {
        LOG.loader("Bind Buffer (indices)");
        int vboID = GL15.glGenBuffers();
        vbos.add(vboID);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
        IntBuffer buffer = storeDataInIntBuffer(indices);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
        
    }
    
    private IntBuffer storeDataInIntBuffer(int[] data)
    {
        LOG.loader("IntBuffer Put data in the int buffer");
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        System.out.print("IntBuffer :");
        System.out.println(buffer);
        return buffer;
        
    }
    
    private FloatBuffer storeDataInFloatBuffer(float[] data)
    {
        LOG.loader("call Loader.storeDataInBuffer");
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        System.out.print("FloatBuffer :");
        System.out.println(buffer);
        return buffer;
        
    }
    
}
