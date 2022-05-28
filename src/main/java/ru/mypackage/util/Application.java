package ru.mypackage.util;

import org.flywaydb.core.Flyway;
import ru.mypackage.view.MainView;

public class Application {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/hibernate_books",
                "root", "Mysql_pass_00").load();
        flyway.migrate();

        MainView view = new MainView();
        view.showStartApplication();
    }
}
