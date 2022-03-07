module sample {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires ojdbc10;
    requires net.bytebuddy;
    requires com.fasterxml.classmate;
    requires java.xml.bind;


    exports sample;
    opens sample to org.hibernate.orm.core, javafx.fxml;

}