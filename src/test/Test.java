package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Test extends Application {

    static FXMLController myControllerHandle;
    static FXMLController myControllerHandle2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Start");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
//        Parent root = loader.load();
//        myControllerHandle = (FXMLController)loader.getController();
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
//        myControllerHandle.setText("humayan kabir");
//        myControllerHandle.setDirectory("directroy - humayan kabir");
//        primaryStage.show(); 

//        loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
//        root = loader.load();
//        myControllerHandle = (FXMLController)loader.getController();
//        Scene scene1 = new Scene(root);
//        Stage primaryStage1 = new Stage();
//        primaryStage1.setScene(scene1);
//        primaryStage1.initStyle(StageStyle.TRANSPARENT);
//        myControllerHandle.setText("humayir");
//        myControllerHandle.setDirectory("directroy - humayir");
//        primaryStage1.show(); 
        loadeverything();

    }

    void loadeverything() throws FileNotFoundException, IOException {
        File aDirectory = new File("C:/codes");
        aDirectory.mkdir();
        String[] filesInDir = aDirectory.list();
        int previousCnt = 0;
        for (String str : filesInDir) {
            String path = "C://codes//" + str;
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = reader.readLine();
            }
            String everything = sb.toString();
            if (everything.length() > 0) {
                previousCnt++;
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
        }
        if (previousCnt == 0) {
            previousCnt++;
            String path = "C://codes//" + getDateTime().toString() + ".txt";
            System.out.println(path);
            //BufferedWriter reader = new BufferedWriter(new FileWriter(path));
            String everything = "";
           // reader.write(everything);
            writeIntofile(everything, path);
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

    }

    String getDateTime() {
        String path = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        path = dateFormat.format(date);
        return path;
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
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }

}
