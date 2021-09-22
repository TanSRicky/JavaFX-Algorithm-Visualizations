module ctci {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;
    requires org.dyn4j;
    opens ctci to javafx.fxml;
    exports ctci;
}
