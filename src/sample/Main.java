package sample;

import chat.Server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent serverRoot = FXMLLoader.load(getClass().getResource("serverGUI.fxml"));
        Parent clientRoot = FXMLLoader.load(getClass().getResource("clientGUI.fxml"));

        Stage serverStage = new Stage();
        Stage clientStage = new Stage();

        serverStage.setTitle("Simple chat server");
        clientStage.setTitle("Simple chat client");

        serverStage.setScene(new Scene(serverRoot, 600, 335));
        clientStage.setScene(new Scene(clientRoot, 800, 450));

        serverStage.show();
        clientStage.show();
        serverStage.toFront();

    }


    public static void main(String[] args) {
        Server s = new Server(5000);

        try
        {
            s.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        launch(args);
    }
}
