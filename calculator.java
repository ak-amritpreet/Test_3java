import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class calculator extends Application {

    private TableView<BMIRange> table;
    private TextField weightField;
    private TextField heightField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BMI Calculator");

        // Create table columns
        TableColumn<BMIRange, String> rangeColumn = new TableColumn<>("BMI Range");
        rangeColumn.setCellValueFactory(new PropertyValueFactory<>("range"));

        TableColumn<BMIRange, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        // Create table
        table = new TableView<>();
        table.getColumns().addAll(rangeColumn, categoryColumn);

        // Create weight and height input fields
        weightField = new TextField();
        heightField = new TextField();

        // Create Calculate button
        Button calculateButton = new Button("Calculate BMI");
        calculateButton.setOnAction(event -> calculateBMI());

        // Create layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(new Label("Weight (kg):"), weightField, new Label("Height (m):"), heightField, calculateButton, table);

        // Set initial table data
        table.setItems(FXCollections.observableArrayList(
                new BMIRange("Below 18.5", "Underweight"),
                new BMIRange("18.5 - 24.9", "Normal weight"),
                new BMIRange("25 - 29.9", "Overweight"),
                new BMIRange("30 or above", "Obese")
        ));

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            double bmi = weight / (height * height);
            highlightBMIRange(bmi);
        } catch (NumberFormatException e) {
            // Handle invalid input
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid weight and height.");
            alert.showAndWait();
        }
    }

    private void highlightBMIRange(double bmi) {
        table.getSelectionModel().clearSelection();

        for (int i = 0; i < table.getItems().size(); i++) {
            BMIRange bmiRange = table.getItems().get(i);
            String[] rangeParts = bmiRange.getRange().split("-");
            double min = Double.parseDouble(rangeParts[0].trim());
            double max = Double.parseDouble(rangeParts[1].trim());

            if (bmi >= min && bmi <= max) {
                table.getSelectionModel().select(i);
                table.scrollTo(i);
                break;
            }
        }
    }
}
