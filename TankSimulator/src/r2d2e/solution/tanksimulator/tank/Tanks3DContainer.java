package r2d2e.solution.tanksimulator.tank;

import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import r2d2e.solution.tanksimulator.tank.ObjLoader;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform;
import javax.media.j3d.*;
import java.awt.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author Diogo da Costa
 */
public class Tanks3DContainer extends Container {

    private SimpleUniverse universe = null;
    GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    Canvas3D canvas = new Canvas3D(config);
    TransformGroup Coluna1TransGroup = new TransformGroup();
    Transform3D Coluna1Trans3d = new Transform3D();
    TransformGroup Coluna2TransGroup = new TransformGroup();
    Transform3D Coluna2Trans3d = new Transform3D();

    public Tanks3DContainer() {

        this.setLayout(new BorderLayout());
        this.add("Center", canvas);

        // Cria um sub-grafo de conteúdo
        BranchGroup scene = criaGrafoDeCena();
        TransformGroup sceneTrans = new TransformGroup();
        universe = new SimpleUniverse(canvas);


        // O código abaixo faz com que a ViewPlatform seja
        // movida um pouco para trás, para que os objetos
        // possam ser visualizados.
        universe.getViewingPlatform().setNominalViewingTransform();

        ViewingPlatform viewingPlatform = universe.getViewingPlatform();
        viewingPlatform.setNominalViewingTransform();

        // O código abaixo altera o field-of-view para
        // permitir a visualização de todos objetos
        View view = universe.getViewer().getView();

        //view.setFieldOfView(view.getFieldOfView() * 1.2);

        // Adiciona "mouse behaviors" à "viewingPlatform"
        // (equivale a trocar a posição do "observador virtual")
        OrbitBehavior orbit = new OrbitBehavior(canvas, OrbitBehavior.REVERSE_ALL | OrbitBehavior.DISABLE_ROTATE) ;
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 200.0);
        orbit.setSchedulingBounds(bounds);
        viewingPlatform.setViewPlatformBehavior(orbit);

        Background background = new Background(new Color3f(0.4f,0.4f,0.5f));
        background.setApplicationBounds(bounds);

        scene.addChild(background);

        universe.addBranchGraph(scene);
        setSize(getPreferredSize());
        setVisible(true);

    }

    public void setCanvasSize(Dimension d) {
        canvas.setSize(d);
    }

    public void setColuna01(double h) {
        if (h > 0) {
            Coluna1Trans3d.setTranslation(new Vector3d(-0.08, 0.079 + ((h * 0.015) * 0.843), -0.21));
            Coluna1Trans3d.setScale(new Vector3d(1.0, h * 0.843, 1.0));
        } else {
            Coluna1Trans3d.setScale(new Vector3d(0.0, 0.0, 0.0));
        }
        Coluna1TransGroup.setTransform(Coluna1Trans3d);
    }

    public void setColuna02(double h) {
        if (h > 0) {
            Coluna2Trans3d.setTranslation(new Vector3d(-0.08, -0.85 + ((h * 0.015) * 0.843), -0.13));
            Coluna2Trans3d.setScale(new Vector3d(1.0, h * 0.843, 1.0));
        } else {
            Coluna2Trans3d.setScale(new Vector3d(0.0, 0.0, 0.0));
        }
        Coluna2TransGroup.setTransform(Coluna2Trans3d);
    }

    private BranchGroup criaGrafoDeCena() {

        BranchGroup objRaiz = new BranchGroup();
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 500.0);

        Coluna1TransGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        Coluna1TransGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        Coluna2TransGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        Coluna2TransGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        // Carrega Modelo 3d dos Tanques
        TransformGroup TanksTransGroup = new TransformGroup();
        ObjLoader TanksObj = new ObjLoader("Tanks_Quanser.obj");
        TanksTransGroup.addChild(TanksObj.criaNo());
        objRaiz.addChild(TanksTransGroup);


        // Define Aparencia e material

        Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
	Color3f white = new Color3f(1.0f, 1.0f, 1.0f);
        Color3f agua = new Color3f(0.5f, 0.6f, 1.0f);

        Appearance AguaApp = new Appearance();

        Material material = new Material(agua, black, agua, new Color3f(0.4f, 0.4f, 0.4f), 60.0f);

        AguaApp.setMaterial(material);

        TransparencyAttributes transparencia = new TransparencyAttributes();
        transparencia.setTransparencyMode(transparencia.BLENDED);
        transparencia.setTransparency(0.35f);
        //AguaApp.setTransparencyAttributes(transparencia);


        Cylinder Coluna1 = new Cylinder((float) 0.06, (float) 0.03);
        Cylinder Coluna2 = new Cylinder((float) 0.06, (float) 0.03);

        Coluna1.setAppearance(AguaApp);
        Coluna2.setAppearance(AguaApp);

        //Desenha Coluna 01 d'agua
        setColuna01(0.0);
        Coluna1TransGroup.addChild(Coluna1);
        TanksTransGroup.addChild(Coluna1TransGroup);

        //Desenha Coluna 02 d'agua
        setColuna02(0.0);
        Coluna2TransGroup.addChild(Coluna2);
        TanksTransGroup.addChild(Coluna2TransGroup);

        // Seta transformaçoes no transformgroup dos tanks
        Transform3D TanksRot = new Transform3D();
        TanksRot.rotY(-0.4 * Math.PI);
        TanksTransGroup.setTransform(TanksRot);

        ////////////////////////LUZES
        Color3f corLuz = new Color3f(0.9f, 0.9f, 0.9f);
        Vector3f direcaoLuz1 = new Vector3f(-1.0f, -1.0f, -1.0f);
        Vector3f direcaoLuz2 = new Vector3f(1.0f, -1.0f, -1.0f);
        DirectionalLight luzDir1 = new DirectionalLight(corLuz, direcaoLuz1);
        DirectionalLight luzDir2 = new DirectionalLight(corLuz, direcaoLuz2);
        luzDir1.setInfluencingBounds(bounds);
        luzDir2.setInfluencingBounds(bounds);
        objRaiz.addChild(luzDir1);
        objRaiz.addChild(luzDir2);

        return objRaiz;
    }
}
