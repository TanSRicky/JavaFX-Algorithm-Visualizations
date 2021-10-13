module ctci {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;

    opens ctci to javafx.fxml;
    exports ctci;
}
