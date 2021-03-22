
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Renderer
{
    public void prepare()
    {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL11.glClearColor(1, 0, 0, 1);
        
    }
    
    public void render(RawModel model)
    {
        //LOG.render("Rendering a new frame !! (old render method)");
        GL30.glBindVertexArray(RawModel.getVaoId());
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.getVertexCount());//Falure here
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
        
    }
    
}
