 

public class RawModel
{
    private static int vaoID;
    private int vertexCount;
    
    private boolean test1 = false;
    
    public RawModel(int vaoID, int vertexCount)
    {
        this.vaoID = vaoID;
        this.vertexCount = vertexCount;
        
    }
    
    public static int getVaoId(){
        LOG.get("vaoID");
        return vaoID;
        
    }
    
    public int getVertexCount(){
        LOG.get("VertexCount");
        return vertexCount;
        
    }
    
}
