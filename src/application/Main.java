package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import librarymanagement.business.User;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {

	public static Stage mainStage;
	public static User currentUser;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root  =  FXMLLoader.load(getClass().getResource("/librarymanagement/ui/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/librarymanagement/ui/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
			primaryStage.setResizable(false);
			primaryStage.setTitle("Library Management System");
			primaryStage.getIcons().add(new Image("/librarymanagement/ui/lms_icon.jpg"));
			mainStage = primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
