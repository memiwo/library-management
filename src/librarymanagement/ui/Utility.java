package librarymanagement.ui;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Utility {

	
	private  void openWindow(String windowName){
		try{
			Parent root  =  FXMLLoader.load(getClass().getResource("/librarymanagement/ui/"+windowName));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.mainStage.setScene(scene);
			Main.mainStage.show();
			Main.mainStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void OpenLogin(){
		openWindow("Dashboard.fxml");
	}
	
	public  void openAddNewLibraryMember(){
		openWindow("AddNewLibraryMember.fxml");
	}
	
}
