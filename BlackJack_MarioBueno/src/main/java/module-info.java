module blackjack.blackjack {
    requires javafx.controls;
    requires javafx.fxml;

    opens blackjack.blackjack to javafx.fxml;
    exports blackjack.blackjack;
    exports blackjack.blackjack.controllers;
    opens blackjack.blackjack.controllers to javafx.fxml;
}