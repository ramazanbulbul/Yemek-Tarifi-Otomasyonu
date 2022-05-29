package utility;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageManager {
	public static void Show(Parent root, int width, int height) {
		Stage stage = new Stage();
    	Scene scene = new Scene(root,width,height);
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.show();
	}
	public static void Show(Parent root, int width, int height, boolean setResziable) {
		Stage stage = new Stage();
    	Scene scene = new Scene(root,width,height);
    	stage.setScene(scene);
    	stage.setResizable(setResziable);
    	stage.show();
	}
	public static void Show(Parent root, int width, int height, boolean setResziable, boolean setFullscreen) {
		Stage stage = new Stage();
    	Scene scene = new Scene(root,width,height);
    	stage.setScene(scene);
    	stage.setResizable(setResziable);
    	stage.setFullScreen(setFullscreen);
    	stage.show();
	}

}
