package start;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.scenicview.ScenicView;
import preloader.TestPreloader;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
        primaryStage.setTitle("SENDigger");
        Scene scene=new Scene(root,1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
       // ScenicView.show(scene);
    }

    @Override
    public void init() throws Exception {
        for (int i = 0; i <100 ; i++) {
            Thread.sleep(10);
            LauncherImpl.notifyPreloader(this,new Preloader.ProgressNotification(i));
        }
    }

    public static void main(String[] args) {
        LauncherImpl.launchApplication(Main.class, TestPreloader.class,args);
    }
}
