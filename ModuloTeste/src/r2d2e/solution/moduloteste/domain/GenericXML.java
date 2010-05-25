package r2d2e.solution.moduloteste.domain;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import r2d2e.solution.moduloteste.domain.graph.ConfigGraph;
import r2d2e.solution.moduloteste.view.NovoFrame;

/**
 *
 * @author Rivaldo
 */

public class GenericXML {

    private XStream xstream;
    static String FILE_NAME_GERAIS = "gerais.xml";
    static String FILE_NAME_GRAPHICS = "graphs.xml";
    static String RELATIVE_PATH = "XML\\";

    static String ABSOLUTE_PATH = NovoFrame.ABSOLUTE_PATH + "\\";

    public GenericXML() {

        if ("".equals(NovoFrame.ABSOLUTE_PATH)) {
            ABSOLUTE_PATH = System.getProperty("user.dir") + "\\";
        }

        xstream = new XStream();

    }

    public boolean createXML(Object writeObject) {
        PrintWriter printWriter = null;

        try {

            String contatosEmXML = xstream.toXML(writeObject);

            File ref1 = new File(ABSOLUTE_PATH + RELATIVE_PATH);
            ref1.mkdirs();

            String fileName;

            if (writeObject instanceof ConfigGraph) {
                fileName = FILE_NAME_GRAPHICS;
            } else if (writeObject instanceof ConfigGerais) {
                fileName = FILE_NAME_GERAIS;
            } else {
                return false;
            }

            File ref = new File(ABSOLUTE_PATH + RELATIVE_PATH + fileName);
            ref.createNewFile();

            FileWriter fw = new FileWriter(ref, false);
            printWriter = new PrintWriter(fw);
            printWriter.print(contatosEmXML);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            return false;
        } finally {
            try {
                if(printWriter != null){
                    printWriter.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return true;

    }

    public ConfigGraph readConfigGrafics() {
        Object obj = readXML(FILE_NAME_GRAPHICS);

        if (obj == null) {
            return null;
        }

        ConfigGraph obTmp = null;

        try{
            obTmp = (ConfigGraph) obj;
        }catch (Exception ex){
            obTmp = null;
        }

        return obTmp;
    }

    public ConfigGerais readConfigGerais() {
        Object obj = readXML(FILE_NAME_GERAIS);

        if (obj == null) {
            return null;
        }

        ConfigGerais obTmp = null;

        try{
            obTmp = (ConfigGerais) obj;
        }catch (Exception ex){
            obTmp = null;
        }

        return obTmp;
    }

    private Object readXML(String fileName) {

        Reader reader = null;
        try {
            File ref = new File(ABSOLUTE_PATH + RELATIVE_PATH + fileName);
            reader = new FileReader(ref);

            Object objTcp = (Object) xstream.fromXML(reader);
            return objTcp;
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado : " + ABSOLUTE_PATH + RELATIVE_PATH + fileName + ". Usará configurações padrões.");
        }catch (Exception ex){
            System.out.println("Falha ao processar o arquivo : " + ABSOLUTE_PATH + RELATIVE_PATH + fileName + ". Usará configurações padrões.");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }

            } catch (IOException ex) {
                System.out.println("Falha ao fechar o arquivo " + ABSOLUTE_PATH + RELATIVE_PATH + fileName + ".");
            }
        }

        return null;

    }
}
