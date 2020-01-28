package test;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static test.Test.myControllerHandle;

/**
 * FXML Controller class
 *
 * @author humay
 */
public class FXMLController implements Initializable {

    String directory = "";
    double x, y;
    @FXML
    private HBox hboxpressed;
    @FXML
    private FontAwesomeIconView plusicon;
    @FXML
    private FontAwesomeIconView minusicon;
    @FXML
    private FontAwesomeIconView maxicon;
    @FXML
    private FontAwesomeIconView crossicon;
    @FXML
    private TextArea notetextarea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hboxpressed.setOnMousePressed((MouseEvent me) -> {
            if (me.getButton() != MouseButton.MIDDLE) {
                x = me.getSceneX();
                y = me.getSceneY();
            }
        });

        hboxpressed.setOnMouseDragged((MouseEvent me) -> {
            if (me.getButton() != MouseButton.MIDDLE) {
                hboxpressed.getScene().getWindow().setX(me.getScreenX() - x);
                hboxpressed.getScene().getWindow().setY(me.getScreenY() - y);
            }
        });
    }

    @FXML
    private void min(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void max(MouseEvent event) {
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setFullScreenExitHint(" ");
//        stage.setFullScreen(true);
    }

    @FXML
    private void close(MouseEvent event) {
        String path = directory;
        String everything = notetextarea.getText();
//        if (everything.length() > 0) {
//            writeIntofile(everything, path);
//        } else {
//            File file = new File(directory);
//            if (file.delete()) {
//                ((Node) (event.getSource())).getScene().getWindow().hide();
//            } else {
//                
//            }
//        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public TextArea getTextArea() {
        return notetextarea;
    }

    public void setText(String str) {
        notetextarea.setText(str);
    }

    public void setDirectory(String str) {
        directory = str;
    }

    @FXML
    private void addnotesevent(MouseEvent event) throws IOException {
        String path = "C://codes//" + getDateTime().toString() + ".txt";
        System.out.println(path);
        BufferedWriter reader = new BufferedWriter(new FileWriter(path));
        String everything = "";
        reader.write(everything);
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Parent root = loader.load();
        myControllerHandle = (FXMLController) loader.getController();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        myControllerHandle.setText(everything);
        myControllerHandle.setDirectory(path);
        primaryStage.show();
    }

    String getDateTime() {
        String path = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        path = dateFormat.format(date);
        return path;
    }

    @FXML
    private void deletenotepressed(MouseEvent event) {
        String path = directory;
        File file = new File(path);
        System.out.println(path);
        if (file.delete()) {
            System.out.println("deleted");
        } else {
            
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void savenotesiconclicked(MouseEvent event) throws FileNotFoundException, IOException {
        String path = directory;
        String everything = notetextarea.getText();
        //System.out.println(everything);
        if (everything.length() > 0) {
            writeIntofile(everything, path);
        } else {

        }
    }

    void writeIntofile(String str, String path) {
        BufferedWriter writer = null;
        try {
            String timeLog = path;
            File logFile = new File(timeLog);
            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    

}
