package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import librarymanagement.business.User;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

	public static Stage mainStage;
	private static User currentUser;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root  =  FXMLLoader.load(getClass().getResource("../librarymanagement/ui/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../librarymanagement/ui/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			mainStage = primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static User getCurrentUser(){
		if(currentUser == null){
			return null;
		}else return currentUser;
	}
	
	public static void setCurrentUser(User user){
		currentUser = user;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
