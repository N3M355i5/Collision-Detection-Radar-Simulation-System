package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller implements Initializable{
	@FXML
	private Button enterButton;
	@FXML
	private AnchorPane introPane;
	
	public void changeScreen(ActionEvent e) {
//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("radarSystem.fxml"));
//			root = loader.load();
//			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//			scene = new Scene(root);
//			stage.setScene(scene);
//			stage.show();
//			
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		makeFadeOut();
		System.out.println("Button Clicked");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void makeFadeOut() {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(500));
		fadeTransition.setNode(introPane);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0.0);
		fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				loadNextScene();
			}
		});
		fadeTransition.play();
	}
	private void loadNextScene() {
		Parent secondView;
		try {
			secondView = (AnchorPane) FXMLLoader.load(getClass().getResource("radarSystem.fxml"));
			
			Scene newScene = new Scene(secondView);
			Stage currentStage = (Stage) introPane.getScene().getWindow();
			currentStage.setScene(newScene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
