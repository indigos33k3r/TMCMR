package togos.minecraft.maprend.guistandalone;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GuiMain extends Application {

	private GuiController controller;

	public GuiMain() {

	}

	@Override
	public void start(Stage stage) throws IOException {
		stage.setTitle("TMCMR world renderer");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("scene.fxml"));
		Parent root = (Parent) loader.load();
		controller = (GuiController) loader.getController();

		stage.setScene(new Scene(root, 500, 350));
		stage.show();

		AnchorPane.setTopAnchor(root.lookup("#rightMenu"), root.lookup("#showButton").getBoundsInLocal().getHeight() + 5);
	}

	@Override
	public void stop() {
		controller.panel.shutDown();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}