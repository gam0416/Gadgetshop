/**
 * Write a description of class GadgetShop here.
 *
 * @author Gadaf Malik-Abbas
 * Student ID - 25000098
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class GadgetShop extends Application {
    // text field for gadget model
    private final TextField modelField = new TextField();
    // text field for gadget price
    private final TextField priceField = new TextField();
    // text field for gadget price
    private final TextField weightField = new TextField();
    // text field for gadget size
    private final TextField sizeField = new TextField();
    // text field MP3 available meomory
    private final TextField availableMemoryField = new TextField();
    // text area to display messages and user log
    private final TextArea logArea = new TextArea();
    // initial mobile credit
    private final TextField creditField = new TextField();
    // phone number (call)
    private final TextField phoneNumberField = new TextField();
    // call duration
    private final TextField durationField = new TextField();
    // MP3 download size
    private final TextField downloadSizeField = new TextField();
    // mobile number display
    private final TextField displayNumberField = new TextField();
    private final ArrayList<Gadget> gadgets = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        // text field/box and title for gadget model
        Label modelLabel = new Label("Model:");
        modelLabel.setLayoutX(20);
        modelLabel.setLayoutY(20);

        modelField.setLayoutX(180);
        modelField.setLayoutY(20);

        // text field/box and title for gadget price
        Label priceLabel = new Label("Price (£): ");
        priceLabel.setLayoutX(20);
        priceLabel.setLayoutY(50);

        priceField.setLayoutX(180);
        priceField.setLayoutY(50);

        // text field/box and title for gadget weight
        Label weightLabel = new Label("Weight (g):");
        weightLabel.setLayoutX(20);
        weightLabel.setLayoutY(80);

        weightField.setLayoutX(180);
        weightField.setLayoutY(80);

        // text field/box and title for gadget size
        Label sizeLabel = new Label("Size (mm):");
        sizeLabel.setLayoutX(20);
        sizeLabel.setLayoutY(110);

        sizeField.setLayoutX(180);
        sizeField.setLayoutY(110);

        // text field/box and title for MP3 available memory
        Label availableMemoryLabel = new Label("Available Memory (MB):");
        availableMemoryLabel.setLayoutX(20);
        availableMemoryLabel.setLayoutY(140);

        availableMemoryField.setLayoutX(180);
        availableMemoryField.setLayoutY(140);

        // button feild to add new mobile phone
        Button addMobileButton = new Button("Add Mobile");
        addMobileButton.setLayoutX(400);
        addMobileButton.setLayoutY(20);

        // button feild to add new MP3
        Button addMP3Button = new Button("Add MP3");
        addMP3Button.setLayoutX(400);
        addMP3Button.setLayoutY(60);

        // button feild to to clear all entries
        Button clearButton = new Button("Clear");
        clearButton.setLayoutX(400);
        clearButton.setLayoutY(100);

        // button feild to display all enrtries
        Button displayAllButton = new Button("Display All");
        displayAllButton.setLayoutX(400);
        displayAllButton.setLayoutY(140);

        // button feild to make a call
        Button makeCallButton = new Button("Make A Call");
        makeCallButton.setLayoutX(400);
        makeCallButton.setLayoutY(180);

        // button feild to downlaod music
        Button downloadMusicButton = new Button("Download Music");
        downloadMusicButton.setLayoutX(400);
        downloadMusicButton.setLayoutY(220);

        // text field/box and title for initial credit entry
        Label creditLabel = new Label("Initial Credit (mins):");
        creditLabel.setLayoutX(20);
        creditLabel.setLayoutY(170);

        creditField.setLayoutX(180);
        creditField.setLayoutY(170);

        // text field/box and title for phone number entry (UK format)
        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setLayoutX(20);
        phoneLabel.setLayoutY(200);

        phoneNumberField.setLayoutX(180);
        phoneNumberField.setLayoutY(200);

        // text field/box and title for duration of call entry
        Label durationLabel = new Label("Call Duration (mins):");
        durationLabel.setLayoutX(20);
        durationLabel.setLayoutY(230);

        durationField.setLayoutX(180);
        durationField.setLayoutY(230);

        // text field/box and title for initial credit entry
        Label downloadLabel = new Label("Download Size (MB):");
        downloadLabel.setLayoutX(20);
        downloadLabel.setLayoutY(260);

        downloadSizeField.setLayoutX(180);
        downloadSizeField.setLayoutY(260);

        // this method will add missing display number label + field 
        Label displayNumberLabel = new Label("Display Number (index):");
        displayNumberLabel.setLayoutX(20);
        displayNumberLabel.setLayoutY(290);

        displayNumberField.setLayoutX(180);
        displayNumberField.setLayoutY(290);

        // log area setup
        logArea.setLayoutX(20);
        logArea.setLayoutY(330);
        logArea.setPrefWidth(520);
        logArea.setPrefHeight(120);
        logArea.setEditable(false);

        // this method redirects System.out.println to the logArea so MP3/Mobile/Gadget messages show in the GUI
        System.setOut(new PrintStream(new OutputStream()
                {
                    @Override
                    public void write(int b)
                    {
                        // method to push printed output into the text area 
                        Platform.runLater(() ->
                                logArea.appendText(String.valueOf((char) b))
                        );
                    }
                }));

        // Add Mobile
        addMobileButton.setOnAction(e ->
                {
                    String model = getModel();
                    String size = getSize();
                    double price = getPrice();
                    int weight = getWeight();
                    int credit = getCredit();

                    //  add only if basic string inputs are valid
                    if (model.isEmpty() || size.isEmpty())
                    {
                        showError("Please enter a valid model and size.");
                        return;
                    }

                    Mobile m = new Mobile(model, price, weight, size, credit);
                    gadgets.add(m);
                    log("Added Mobile at index " + (gadgets.size() - 1));
            });

        // Add MP3 button
        addMP3Button.setOnAction(e ->
                {
                    String model = getModel();
                    String size = getSize();
                    double price = getPrice();
                    int weight = getWeight();
                    int memory = getAvailableMemory();

                    if (model.isEmpty() || size.isEmpty())
                    {
                        showError("Please insert a valid model and size.");
                        return;
                    }

                    MP3 mp3 = new MP3(model, price, weight, size, memory);
                    gadgets.add(mp3);
                    log("Added MP3 at index " + (gadgets.size() - 1));
            });

        // Clear all 10 text fields/button
        clearButton.setOnAction(e ->
                {
                    modelField.clear();
                    priceField.clear();
                    weightField.clear();
                    sizeField.clear();
                    creditField.clear();
                    availableMemoryField.clear();
                    phoneNumberField.clear();
                    durationField.clear();
                    downloadSizeField.clear();
                    displayNumberField.clear();

                    log("All fields cleared.");
            });

        // Display All button
        displayAllButton.setOnAction(e ->
                {
                    if (gadgets.isEmpty())
                    {
                        log("No gadgets is available to display.");
                        return;
                    }

                    for (int i = 0; i < gadgets.size(); i++)
                    {
                        log("Display Number: " + i);
                        gadgets.get(i).display();
                    }

                    log("Displayed all gadgets in console output.");
            });

        // Make A Call button
        makeCallButton.setOnAction(e ->
                {
                    int displayNumber = getDisplayNumber();
                    if (displayNumber == -1)
                    {
                        return;
                    }

                    Gadget g = gadgets.get(displayNumber);

                    if (g instanceof Mobile)
                    {
                        // phone number in string (UK phone numbers format  07400 or +44)
                        String phoneNumber = getPhoneNumber();
                        int duration = getDuration();
                        ((Mobile) g).makeCall(phoneNumber, duration);
                        log("Call attempted on Mobile at index " + displayNumber + " (check console for call details).");
                    }
                    else
                    {
                        showError("The gadget at index " + displayNumber + " is not a Mobile phone.");
                    }
            });

        // Download Music button
        downloadMusicButton.setOnAction(e ->
                {
                    int displayNumber = getDisplayNumber();
                    if (displayNumber == -1)
                    {
                        // spec says only use it if it is not -1
                        return; 
                    }

                    Gadget g = gadgets.get(displayNumber);

                    // safe casting to avoid crashes
                    if (g instanceof MP3)
                    {
                        int downloadSize = getDownloadSize();
                        ((MP3) g).downloadMusic(downloadSize);
                        log("Download attempted on MP3 at index " + displayNumber + " (check console for download details).");
                    }
                    else
                    {
                        showError("The gadget at index " + displayNumber + " is not an MP3 player.");
                    }
            });

        // All  the pane
        root.getChildren().addAll(
            modelLabel, modelField,
            priceLabel, priceField,
            weightLabel, weightField,
            sizeLabel, sizeField,
            availableMemoryLabel, availableMemoryField,
            creditLabel, creditField,
            phoneLabel, phoneNumberField,
            durationLabel, durationField,
            downloadLabel, downloadSizeField,
            displayNumberLabel, displayNumberField,
            addMobileButton, addMP3Button, clearButton, displayAllButton, makeCallButton, downloadMusicButton,
            logArea
        );

        stage.setScene(new Scene(root, 560, 500));
        stage.setTitle("Gadget Shop");
        stage.show();
    }

    // Text Field Input Methods

    // return model as a string
    private String getModel()
    {
        return modelField.getText().trim();
    }

    // return size as a string
    private String getSize()
    {
        return sizeField.getText().trim();
    }

    // return price as a double
    private double getPrice()
    {
        try
        {
            return Double.parseDouble(priceField.getText().trim());
        }
        catch (Exception e)
        {
            showError("Price must be a valid number.");
            return 0.0;
        }
    }

    // return weight as an int
    private int getWeight()
    {
        try
        {
            return Integer.parseInt(weightField.getText().trim());
        }
        catch (Exception e)
        {
            showError("Weight must be a whole number.");
            return 0;
        }
    }

    // return initial credit as an int
    private int getCredit()
    {
        try
        {
            return Integer.parseInt(creditField.getText().trim());
        }
        catch (Exception e)
        {
            showError("Initial credit must be a whole number (min).");
            return 0;
        }
    }

    // return initial memory as an int
    private int getAvailableMemory()
    {
        try
        {
            return Integer.parseInt(availableMemoryField.getText().trim());
        }
        catch (Exception e)
        {
            showError("Initial memory must be a whole number (MB).");
            return 0;
        }
    }

    // return phone number as a string (UK phone number formart)
    private String getPhoneNumber()
    {
        return phoneNumberField.getText().trim();
    }

    // return duration as an int
    private int getDuration()
    {
        try
        {
            return Integer.parseInt(durationField.getText().trim());
        }
        catch (Exception e)
        {
            showError("Call duration must be a whole number (min).");
            return 0;
        }
    }

    // return download size as an int
    private int getDownloadSize()
    {
        try
        {
            return Integer.parseInt(downloadSizeField.getText().trim());
        }
        catch (Exception e)
        {
            showError("Download size must be a whole number (MB).");
            return 0;
        }
    }

    // method for display special number
    private int getDisplayNumber()
    {
        // initialise to -1
        int displayNumber = -1;

        try
        {
            displayNumber = Integer.parseInt(displayNumberField.getText().trim());

            // method to check that display number is in the correct range
            if (displayNumber < 0 || displayNumber >= gadgets.size())
            {
                showError("Display number must be between 0 and " + (gadgets.size() - 1) + ".");
                return -1;
            }

            return displayNumber;
        }
        catch (Exception e)
        {
            showError("Display number must be a whole number (integer).");
            return -1;
        }
    }

    //  method to help append messages to the log area
    private void log(String message)
    {
        logArea.appendText(message + System.lineSeparator());
    }

    // method to help show errors using message dialog box
    private void showError(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args)
    {
        launch();
    }
}