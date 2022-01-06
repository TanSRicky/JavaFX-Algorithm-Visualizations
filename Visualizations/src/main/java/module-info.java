module ctci {
    requires transitive  javafx.controls;
    requires transitive  javafx.fxml;
	requires transitive  javafx.graphics;
	requires transitive  javafx.base;
	requires java.desktop;

    opens ctci to javafx.fxml;
    exports ctci;
}
