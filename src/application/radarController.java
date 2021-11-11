package application;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class radarController implements Initializable{
	@FXML
	private Line radarLine;
	@FXML
	private Rectangle radarRect;
	@FXML
	private Button startButton;
	@FXML
	private Label clockLabel;
	
	private RotateTransition rt, rt2;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		startButton.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("Radar Started");
//			}
//		});
		movePivot(radarLine, -144, -0.0);
		rt = new RotateTransition();
		rt.setNode(radarLine);
		rt.setDuration(Duration.millis(3000));
		rt.setToAngle(360);
		rt.setCycleCount(Timeline.INDEFINITE);
		rt.setInterpolator(Interpolator.LINEAR);
		
		movePivot(radarRect, -144, 37.0);
		rt2 = new RotateTransition();
		rt2.setNode(radarRect);
		rt2.setDuration(Duration.millis(3000));
		rt2.setToAngle(360);
		rt2.setCycleCount(Timeline.INDEFINITE);
		rt2.setInterpolator(Interpolator.LINEAR);
		
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			LocalTime currentTime = LocalTime.now();
			clockLabel.setText(currentTime.getHour()+":"+currentTime.getMinute()+":"+currentTime.getSecond());
			}),
				new KeyFrame(Duration.seconds(1))
		);
		
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}
	public void startAnimation(ActionEvent event) {
		if(startButton.getText().equals("OFF")) {
			startButton.setText("ON");
			startButton.setStyle("-fx-background-color:#37ff00; -fx-text-fill:#222222");
			System.out.println("Radar ON");
			rt.play();
			rt2.play();
		}
		else {
			startButton.setText("OFF");
			startButton.setStyle("-fx-background-color:transparent; -fx-text-fill:#37ff00; -fx-border-color:#37ff00");
			System.out.println("Radar OFF");
			rt.pause();
			rt2.pause();
		}
	}
	private void movePivot(Node node, double x, double y) {
		// TODO Auto-generated method stub
		node.getTransforms().add(new Translate(-x, -y));
		node.setTranslateX(x);
		node.setTranslateY(y);
	}
	
	
}
