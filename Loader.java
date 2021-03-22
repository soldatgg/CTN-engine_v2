


import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.util.List;
import java.util.ArrayList;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;



public class Loader
{
    private List<Integer> vaos = new ArrayList<Integer>();
    private List<Integer> vbos = new ArrayList<Integer>();
    
    public RawModel loadToVAO(float[] positions, int[] indices)
    {
        LOG.debug("call Loader.RawModel");
        bindIndicesBuffer(indices);
        int vaoID = createVAO();
        storeDataInAttributeList(0, positions);
        unbindVAO();
        return new RawModel(vaoID,indices.length);
        
    }
    
    public void cleanUP()
    {
        for(int vao:vaos){
            GL30.glDeleteVertexArrays(vao);
        }
        
        /*for(int vao:vbos){
            GL15.glDeleteBuffers(vbo);
        }*/
        
    }
    
    private int createVAO()
    {
        LOG.debug("createVAO");
        int vaoID = GL30.glGenVertexArrays();
        vaos.add(vaoID);
        GL30.glBindVertexArray(vaoID);
        LOG.println("The VAO is created");
        return vaoID;
        
    }
    
    private void storeDataInAttributeList(int attributeNumber, float[] data)
    {
        LOG.debug("call Loader.storeDataInAttributeList");
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
        LOG.println("My Friend Is A DUM");
        LOG.println("UnBindingVAO ^^");
        GL30.glBindVertexArray(0);
        
    }
    
    private void bindIndicesBuffer(int[] indices)
    {
        int vboID = GL15.glGenBuffers();
        vbos.add(vboID);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
        IntBuffer buffer = storeDataInIntBuffer(indices);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
        
    }
    
    private IntBuffer storeDataInIntBuffer(int[] data)
    {
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
        
    }
    
    private FloatBuffer storeDataInFloatBuffer(float[] data)
    {
        LOG.debug("call Loader.storeDataInBuffer ^^");
        LOG.print("OH GOD THAT WORK");
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
        
    }
    
}
