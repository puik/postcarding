import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import postcarding.Andmebaas;


/**
 * Created by vpuik on 12.12.15.
 */
public class ProgrammiAken {

    private static Stage aken = new Stage();
    private static BorderPane raamistik = new BorderPane();
    private static Scene stseen = new Scene(raamistik);

    public ProgrammiAken(){

        kuvaAken();

    }

    public void kuvaAken() {
        //Postkaart postkaart = new Postkaart();

        //pildi laadimine
        //Image postkaart = new Image("http://ajapaik.ee/media/uploads/DIGAR_58746_1.jpg", true); //Landscape pilt
        //Image postkaart = new Image("http://ajapaik.ee/media/uploads/DIGAR_56509_1.jpg", true); //NB pystipidine pilt 56509
        Image postkaart = new Image("http://ajapaik.ee/media/uploads/Digar_postkaartide_tagakyljed/DIGAR_" + andmebaas.getPostkaart_id() + "_2.jpg", true);

        // ekraanisuuruse määramine
        Rectangle2D ekraanipiirid = Screen.getPrimary().getVisualBounds();

        //pildi näitamine -- kas peaks üldse eraldi klassi tegema selleks?
        ImageView pildikuva = new ImageView();
        pildikuva.setImage(postkaart);
        pildikuva.setFitWidth(ekraanipiirid.getWidth());
        pildikuva.setFitHeight(ekraanipiirid.getHeight());
        pildikuva.setPreserveRatio(true);

        //rotate'imine peaks minema nupu alla
        //pildikuva.setRotate(90);



        System.out.println(ekraanipiirid);


        aken.setScene(stseen);
        //aken.setFullScreen(true);
        aken.setWidth(ekraanipiirid.getWidth());
        aken.setHeight(ekraanipiirid.getHeight());
        aken.setTitle("Postcarding");
        aken.show();

        raamistik.getChildren().addAll(pildikuva);

    }



    Andmebaas andmebaas = new Andmebaas(); //ei tea, kas see on õige koht, varem oli see mul Mainis
}
