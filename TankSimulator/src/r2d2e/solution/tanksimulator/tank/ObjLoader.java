package r2d2e.solution.tanksimulator.tank;

import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.loaders.*;
import javax.media.j3d.*;

/**
 *
 * @author Tiberio
 * @author Diogo
 */
public class ObjLoader {

    private String objeto;
    private BranchGroup objRoot;

    public ObjLoader(String obj) {
        objeto = obj;
    }

    public BranchGroup criaNo() {

        objRoot = new BranchGroup();
        TransformGroup tg = new TransformGroup();
        try {
            Scene s = null;
            ObjectFile f = new ObjectFile();
            f.setFlags(ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);

            String s1 = objeto;
            s = f.load(s1);
            tg.addChild(s.getSceneGroup());

        } catch (java.io.FileNotFoundException ex) {
        }
        
        objRoot.addChild(tg);
        return objRoot;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public BranchGroup getObjRoot() {
        return objRoot;
    }

    public void setObjRoot(BranchGroup objRoot) {
        this.objRoot = objRoot;
    }
}

