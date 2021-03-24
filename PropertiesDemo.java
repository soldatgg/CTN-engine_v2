
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.File;


public class PropertiesDemo {
    
    private static boolean value_1 = false;
    
    
    public static void init()
    {
        File file = new File("C://CTN-engine/config.txt");
        
        if(!file.exists()){
            try
            {
                file.createNewFile();
            }
            catch (java.io.IOException ioe)
            {
                ioe.printStackTrace();
            }
            
        }
        
        else{
            try{
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("CTN-engine config file");
            bw.newLine();
            bw.write("[Warning] This file contain some critical value can broke the Engine");
            bw.close();
            writer.close();
            }catch(IOException e){
                LOG.FATAL("Can't modify a file");
            }
            
        }
       
    }
    
        public static void write(Properties props, String fileLocation, String comments) throws FileNotFoundException,IOException
        {
        OutputStream out = new FileOutputStream(fileLocation);
        props.store(out, comments);
        out.flush();
        out.close();
        
    }
    
    public PropertiesDemo() {
        super();
    }
    
    
    /**
     * Cette méthode stocke le fichier Properties à l'emplacement spécifié
     * 
     * @param props Le fichier à stocker
     * @param fileLocation L'emplacement où le fichier doit être stocké
     * @param comments Commentaires à insérer en tête du fichier
     * @throws FileNotFoundException
     * @throws IOException si une erreur est survenue lors de l'écriture du fichier
     */
    public void saveProperties(Properties props, String fileLocation, String comments) throws FileNotFoundException,
            IOException {
        OutputStream out = new FileOutputStream(fileLocation);
        props.store(out, comments);
        out.flush();
        out.close();
    }
    
    
    public Properties loadProperties(String propertiesFileLocation) throws FileNotFoundException, IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(propertiesFileLocation));
        return props;
    }

    
    /**
     * 
     * Cette méthode affiche cahque paire [clé,valuer] d'un fichier Properties
     * 
     * @param props Le fichier à afficher
     */
    public void displayProperties(Properties props) {
        Iterator it = props.keySet().iterator();
        while (it.hasNext()) {
            String propertyName = (String) it.next();
            String propertyValue = props.getProperty(propertyName);
            System.out.println(propertyName + "=" + propertyValue);
        }
    }
    
    public static void main(String[] args) {
        LOG.println("start");
        PropertiesDemo demo = new PropertiesDemo();

        //Emplacement où sera stocké le fichier
        String FLloc = "C:/CTN-engine/myProperties.properties";
        
        //On instancie un nouvel objet Properties
        Properties myProps = new Properties();
        
        try{
            Properties loadedProps = demo.loadProperties(FLloc);
            demo.displayProperties(loadedProps);
        }catch(IOException c){
            LOG.FATAL("Can't read");
        }
        
        //On y insère des paires [clé,valeur]
        
        myProps.setProperty("user.name","HackTrack");
        myProps.setProperty("os.name","Linux");
        myProps.setProperty("java.ide","Eclipse3.2");
        myProps.setProperty("java.applicationserver.name","JBoss AS");
        myProps.setProperty("java.applicationserver.version","4.0.5");
        myProps.setProperty("user.function","Developer");
        myProps.setProperty("user.age","You are too curious!");
        myProps.setProperty("Vsync","lll");
        
        try {
            //On stocke le fichier sur le disque
            demo.saveProperties(myProps, propertiesFileLocation, "This is a demo on Properties by HackTrack");
            //On crée un nouvel objet Properties en lisant le fichier sur le disque
            Properties loadedProps = demo.loadProperties(propertiesFileLocation);
            //On affiche le contenu du fichier
            demo.displayProperties(loadedProps);
            } catch (FileNotFoundException e) {
            e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
            }
            
    }
}