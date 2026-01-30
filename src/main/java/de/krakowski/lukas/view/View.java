package de.krakowski.lukas.view;

// =====================================================
// Import Beginn
// =====================================================
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import de.krakowski.lukas.controller.RechnungController;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;   

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
// =====================================================
// Import Ende
// =====================================================

// =====================================================
// Seite Beginn
// =====================================================
public class View extends Application {

    private static final String STARTSEITE = "Startseite";
    // =================================================
    // Attribute
    // =================================================
    private BorderPane root;
    private VBox menu; // Sidebar global
    private RechnungController derController;
    private View dieView;
   

    // Buttons (linkes Menü)
    private Button btnStart;
    private Button btnRechnungErstellen;
    private Button btnOffeneAuftraege;

    // MenuItems (Top-Menü)
    private MenuItem miKlientAnlegen;
    private MenuItem miKlientBearbeiten;
    private MenuItem miKlientenAnsehen;

    // =================================================
    // Seite Laden Beginn
    // =================================================
    @Override
    public void start(Stage stage) {

        derController = new RechnungController(this);

        root = new BorderPane();

        struktur(); // Layout & Menüs
        steuerung(); // Navigation & Events
        design(); // Styles

        setContent(startSeite());

        Scene scene = new Scene(root, 800, 600); // Startgröße
        stage.setTitle("Betreuungs Software");
        stage.setScene(scene);
        stage.show();
    }
    // =================================================
    // Seite Laden Ende
    // =================================================

    // =====================================================
    // Methode 1: STRUKTUR (Menüs & Layout)
    // =====================================================
    private void struktur() {

        // Sidebar erzeugen
        Node left = createLeftMenu();
        root.setLeft(left);

        // TopMenu erzeugen
        Node top = createTopMenu();
        root.setTop(top);
    }

    private Node createLeftMenu() {

        // Buttons
        btnStart = new Button(STARTSEITE);
        btnRechnungErstellen = new Button("Rechnung erstellen");
        btnOffeneAuftraege = new Button("Offene Aufträge");

        btnStart.setMaxWidth(Double.MAX_VALUE);
        btnRechnungErstellen.setMaxWidth(Double.MAX_VALUE);
        btnOffeneAuftraege.setMaxWidth(Double.MAX_VALUE);

        Region spacer0 = new Region();
        VBox.setVgrow(spacer0, Priority.ALWAYS);

        Region spacer1 = new Region();
        VBox.setVgrow(spacer1, Priority.ALWAYS);

        menu = new VBox(
            10,
            btnStart,
            spacer0,
            btnRechnungErstellen,
            spacer1,
            btnOffeneAuftraege
        );

        menu.setPadding(new Insets(10));
        menu.setPrefWidth(180);
        menu.setStyle("-fx-background-color: #c8c6c400;");

        // VBox passt Höhe proportional an Fenster an
        menu.prefHeightProperty().bind(root.heightProperty());

        return menu;
    }

    private Node createTopMenu() {

        // === Datum =====================================
        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Label lblDatum = new Label(today.format(fmt));
        lblDatum.setMaxWidth(Double.MAX_VALUE);
        lblDatum.prefWidthProperty().bind(menu.widthProperty());
        lblDatum.setStyle("-fx-font-size: 14px; -fx-alignment: center-left;");

        // === Menü links ================================
        MenuBar menuLeft = new MenuBar();
        Menu menuDatenbank = new Menu("Datenbank");

        miKlientAnlegen = new MenuItem("Klient anlegen");
        miKlientBearbeiten = new MenuItem("Klient bearbeiten");
        miKlientenAnsehen = new MenuItem("Klienten ansehen");

        menuDatenbank.getItems().addAll(
            miKlientAnlegen,
            miKlientBearbeiten,
            miKlientenAnsehen
        );

        menuLeft.getMenus().add(menuDatenbank);

        // === Menü rechts ===============================
        MenuBar menuRight = new MenuBar();
        menuRight.getMenus().addAll(
            new Menu("Benutzer"),
            new Menu("Abmelden")
        );

        Region spacer = new Region();

        HBox.setHgrow(spacer, Priority.ALWAYS);
        HBox top = new HBox(10, lblDatum, menuLeft, spacer, menuRight);

        top.setPadding(new Insets(5));
        top.setStyle("-fx-background-color: #c8c6c469;");
        top.prefWidthProperty().bind(root.widthProperty());

        return top;
    }

    //======================================================================================================================

    // =====================================================
    // Methode 2: INHALT (Seiten)
    // =====================================================
    private Node startSeite() {

        HBox obereBox = new HBox();
        HBox untereBox = new HBox();
        GridPane centerGrid = new GridPane();

        //Image schreibtisch = new Image(getClass().getResource("/image/Schreibtisch.png").toExternalForm());

        RowConstraints top = new RowConstraints();
        top.setPercentHeight(30);

        RowConstraints bottom = new RowConstraints();
        bottom.setPercentHeight(70);

        centerGrid.getRowConstraints().addAll(top, bottom);

        untereBox.setStyle("-fx-background-color: #0d78dc2b;");

        GridPane.setHgrow(obereBox, Priority.ALWAYS);
        GridPane.setHgrow(untereBox, Priority.ALWAYS);
        obereBox.setMaxWidth(Double.MAX_VALUE);
        untereBox.setMaxWidth(Double.MAX_VALUE);

        // Einfügen in Grid
        centerGrid.add(obereBox, 0, 0);
        centerGrid.add(untereBox, 0, 1);

        centerGrid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        root.setCenter(centerGrid);

        return centerGrid;
    }

    private Node klientAnlegenSeite() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(20));
        box.getChildren().addAll(
            new Label("Klient anlegen"),
            new TextField("Name"),
            new TextField("Alter"),
            new Button("Speichern")
        );
        box.prefHeightProperty().bind(root.heightProperty());
        box.prefWidthProperty().bind(root.widthProperty().subtract(menu.getPrefWidth()));
        return box;
    }

    private Node klientBearbeitenSeite() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(20));
        box.getChildren().addAll(
            new Label("Klient bearbeiten"),
            new ListView<>(),
            new Button("Ändern")
        );
        box.prefHeightProperty().bind(root.heightProperty());
        box.prefWidthProperty().bind(root.widthProperty().subtract(menu.getPrefWidth()));
        return box;
    }

    private Node klientenAnsehenSeite() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(20));
        box.getChildren().addAll(
            new Label("Klienten ansehen"),
            new ListView<>()
        );
        box.prefHeightProperty().bind(root.heightProperty());
        box.prefWidthProperty().bind(root.widthProperty().subtract(menu.getPrefWidth()));
        return box;
    }

    // =====================================================
    // Methode 3: STEUERUNG
    // =====================================================
    private void steuerung() {

        var rechnungController = new RechnungController(this);

        // Linkes Menü ================================
        btnStart.setOnAction(e -> setContent(startSeite()));
        btnRechnungErstellen.setOnAction(e -> setContent(new Label(rechnungController.erstelleRechnungen())));
        btnOffeneAuftraege.setOnAction(e -> setContent(new Label("Offene Aufträge – TODO")));

        // Top-Menü ==================================
        miKlientAnlegen.setOnAction(e -> setContent(klientAnlegenSeite()));
        miKlientBearbeiten.setOnAction(e -> setContent(klientBearbeitenSeite()));
        miKlientenAnsehen.setOnAction(e -> setContent(klientenAnsehenSeite()));
    }

    // =====================================================
    // Methode 4: DESIGN
    // =====================================================
    private void design() {
        // CSS:
        // root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }

    // =====================================================
    // Zentrale Content-Steuerung
    // =====================================================
    private void setContent(Node node) {
        root.setCenter(node);
        
    }
}
