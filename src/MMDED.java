import core.App;

import javax.swing.*;

public class MMDED {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		SwingUtilities.invokeLater(() -> {
			App app = new App();
			app.display();
		});
	}
}