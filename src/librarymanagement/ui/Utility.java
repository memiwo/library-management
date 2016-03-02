package librarymanagement.ui;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Utility {

	
	private void openWindow(String windowName){
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
	
	public void openLogin(){
		openWindow("Login.fxml");
	}
	
	public void openDashboard(){
		openWindow("Dashboard.fxml");
	}
	
	public void openAddNewLibraryMember(){
		openWindow("AddNewLibraryMember.fxml");
	}
	
	public void openSearchBook(){
		openWindow("SearchBook.fxml");
	}
	
	public void openCheckinBook(){
		//create the checkinbook.fxml
	}
	
	public void openAddBook(){
		//create addBook window
	}
	
	public void openEditMemberSearch(){
		openWindow("EditMemberSearch.fxml");
	}
	
}
