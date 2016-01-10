import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 * Created by vpuik on 12.12.15.
 */
public class ProgrammiAken {

    private static Stage aken = new Stage();
    //private static BorderPane raamistik = new BorderPane();
    private static StackPane kuvakihid = new StackPane();
    private static Scene stseen = new Scene(kuvakihid);


    public ProgrammiAken(){

        kuvaAken();

    }

    public class Postkaart {
        public Image esikylg;
        public Image tagakylg;

        public Postkaart() {
            this.esikylg= new Image("http://ajapaik.ee/media/uploads/DIGAR_" + andmebaas.getPostkaart_id() + "_1.jpg", true);
            this.tagakylg = new Image("http://ajapaik.ee/media/uploads/Digar_postkaartide_tagakyljed/DIGAR_" + andmebaas.getPostkaart_id() + "_2.jpg", true);

        }

    }

    public void kuvaAken() {

        // ekraanisuuruse määramine
        Rectangle2D ekraanipiirid = Screen.getPrimary().getVisualBounds();
        System.out.println(ekraanipiirid);

        aken.setScene(stseen);
        //aken.setFullScreen(true);
        aken.setWidth(ekraanipiirid.getWidth());
        aken.setHeight(ekraanipiirid.getHeight());
        aken.setTitle("Postcarding");
        aken.show();

        //pildi näitamine -- kas peaks üldse eraldi klassi tegema selleks?

        Postkaart postkaart = new Postkaart();

        ImageView pildikuva = new ImageView();

        pildikuva.setImage(postkaart.esikylg);
        pildikuva.setFitWidth(ekraanipiirid.getWidth());
        pildikuva.setFitHeight(ekraanipiirid.getHeight());
        pildikuva.setPreserveRatio(true);

        //rotate'imine peaks minema nupu alla
        //pildikuva.setRotate(90);

        kuvakihid.getChildren().addAll(pildikuva);

        kuvakihid.isFocused();

        aken.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            System.out.println(event.getCode() == KeyCode.SPACE);
            if (event.getCode() == KeyCode.SPACE) {
                andmebaas.m2rgiTekstiga();
            }
        });


        /*
        kuvakihid.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent klahvivajutus) {
                System.out.println("Vajutatud klahv: " + klahvivajutus.getText());
                andmebaas.m2rgiTekstiga();
            }
        });
        */


        kuvakihid.setOnMouseClicked(event -> {
            pildikuva.setImage(postkaart.tagakylg);

            /**/
            andmebaas.logiVaatamine();
            andmebaas.kysiPostkaardiID();

            Postkaart pk = new Postkaart();
            pildikuva.setImage(pk.tagakylg);
            /**/

            pildikuva.setFitWidth(ekraanipiirid.getWidth());
            pildikuva.setFitHeight(ekraanipiirid.getHeight());
            pildikuva.setPreserveRatio(true);

        });



        /*
        kuvakihid.setOnMouseClicked(event -> {

            Andmebaas andmebaas = new Andmebaas();
            pildikuva.setImage(postkaart.esikylg);

        });*/

    }





    Andmebaas andmebaas = new Andmebaas();

}
