package xn_Controller;


import java.io.File;
import javax.swing.UIManager;
import xn_Model.TextModel;
import xn_View.TextView;

public class TextController {
	private TextModel model;
	private TextView view;

	public TextController(TextModel model, TextView view) {
		this.model = model;
		this.view = view;
	}

	public void openButtonClicked() {
		File file = view.showOpenDialog();
		if (file != null) {
			model.loadFile(file);
			view.setText(model.getText());
		}
	}

	public void saveButtonClicked() {
		File file = view.showSaveDialog();
		if (file != null) {
			model.saveFile(file, view.getText());
		}
	}
	
	public void removeEmptyLines() {
	        model.removeEmptyLines();
	        view.setText(model.getText());
	}
	public static void main(String[] args) {

			TextModel model = new TextModel();
			TextView view = new TextView(new TextController(model, null));
			view.setVisible(true);
			view.setController(new TextController(model, view));

	}
}
