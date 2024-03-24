module proyectofinal.unieventos {
    requires javafx.controls;
    requires javafx.fxml;

    opens proyectofinal.unieventos.controladores to javafx.fxml;
    exports proyectofinal.unieventos;
}
