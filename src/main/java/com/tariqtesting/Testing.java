package com.tariqtesting;
import java.util.Random;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Testing extends Application implements EventHandler<ActionEvent> {

    TextField nameField, emailField, birthField, courseField,courseNoField, instructorField, timeField, dayField;
    Button copyButton,registerButton,clearScheduleButton, clearButton, mainpage, mainpage1,mainpage2, systemButton, checkreg, schedulepage,saveScheduleButton;
    Stage window;
    Scene scene1, scene2, scene3, scene4;
    ComboBox<Advisor> advisorComboBox;
    ComboBox<String> GradeComboBox;
    TableView<Student> tableView;
    TableView<Schedule> scheduleTableView;
    Notification notification;
    Random random;

    Admin admin1;
    Admin admin2;

    ObservableList<Student> studentList;
    ObservableList<Advisor> advisorList;
    ObservableList<String> gradeList;
    ObservableList<Schedule> scheduleList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        notification = new MessageNotification();
        mainpage = new Button("Back To Main Website");
        mainpage1 = new Button("Back To Main Website");
        mainpage2 = new Button("Back To Main Website");
        mainpage.setOnAction(this);
        mainpage2.setOnAction(this);
        mainpage1.setOnAction(this);
        copyButton = new Button("Copy Student");
        copyButton.setOnAction(this);
        systemButton = new Button("Register as a New Student");
        systemButton.setOnAction(this);
        checkreg = new Button("Check Already Registered Students");
        checkreg.setOnAction(this);
        schedulepage = new Button("Schedule Page");
        schedulepage.setOnAction(this);
        window.setTitle("Al Najah School Registration System");
        random = new Random();
        admin1 = new Admin("Tariq","tariq0elyousfy@gmail.com","+20 110 244 8198",5670);
        admin2 = new Admin("Karim","karimtaghian03@gmail.com","+20 111 001 9433",4050);

        // rectangle
        Rectangle strip = new Rectangle();
        strip.setWidth(3000);
        strip.setHeight(120);
        strip.setFill(Color.web("0x282AB2"));


        Label s = new Label("ANPS");
        s.setId("logo-text");

        // School logo
        ImageView logo = new ImageView(new Image("file:C:/Users/Tariq/Downloads/ANPS_logo_0.png"));
        logo.setFitHeight(120);
        logo.setPreserveRatio(true);

        // To hold rectangle and image
        AnchorPane logoPane = new AnchorPane();
        AnchorPane.setLeftAnchor(logo, 0.0);
        AnchorPane.setLeftAnchor(s, 650.0);
        AnchorPane.setBottomAnchor(s, 350.0);
        logoPane.getChildren().addAll(strip, logo, s);

        nameField = new TextField();
        nameField.setPromptText("Enter Name Here");
        nameField.setMaxWidth(200);

        emailField = new TextField();
        emailField.setPromptText("Enter Email Here. name@domain.com");
        emailField.setMaxWidth(300);

        birthField = new TextField();
        birthField.setPromptText("Enter Birthday here. Ensure DD/M/YYYY Format");
        birthField.setMaxWidth(400);



        registerButton = new Button("Register");
        registerButton.setOnAction(this);


        clearButton = new Button("Clear Registered Students");
        clearButton.setOnAction(this);

        clearScheduleButton = new Button("Clear Schedules");
        clearScheduleButton.setOnAction(this);

        saveScheduleButton = new Button("Save Schedule");
        saveScheduleButton.setOnAction(this);



        // ComboBox setup
        studentList = FXCollections.observableArrayList();
        advisorComboBox = new ComboBox<>();
        advisorList = FXCollections.observableArrayList(
                new Advisor("Ahmed Zakaria", "ahmedzakaria40@gmail.com","0001", "+20 109 982 2888"),
                new Advisor("Noor ElDeen", "noor22eldeen@gmail.com", "0002" , "+20 109 084 6568"),
                new Advisor("Ahmed Morsy", "ahmedamorsy10@gmail.com","0003" ,"+20 109 373 9773")
        );
        advisorComboBox.setItems(advisorList);

        GradeComboBox = new ComboBox<>();
        gradeList = FXCollections.observableArrayList(
                "1","2","3","4","5","6","7","8","9","10","11","12"
        );
        GradeComboBox.setItems(gradeList);

        // TableView setup
        tableView = new TableView<>();
        studentList = FXCollections.observableArrayList();

        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Student, String> advisorColumn = new TableColumn<>("Advisor");
        advisorColumn.setMinWidth(350);
        advisorColumn.setCellValueFactory(new PropertyValueFactory<>("advisor"));

        TableColumn<Student, String> gradeColumn = new TableColumn<>("Grade");
        gradeColumn.setMinWidth(100);
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        TableColumn<Student, String> birthColumn = new TableColumn<>("Birthday");
        birthColumn.setMinWidth(200);
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("birthdate"));

        TableColumn<Student, String> IDColumn = new TableColumn<>("Student ID");
        IDColumn.setMinWidth(200);
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));

        tableView.setItems(studentList);
        tableView.getColumns().addAll(nameColumn, emailColumn, advisorColumn, gradeColumn, birthColumn, IDColumn);






        // Schedule TableView setup
        scheduleTableView = new TableView<>();
        scheduleList = FXCollections.observableArrayList();

        TableColumn<Schedule, String> courseNoColumn = new TableColumn<>("Course Number");
        courseNoColumn.setMinWidth(200);
        courseNoColumn.setCellValueFactory(new PropertyValueFactory<>("courseNo"));

        TableColumn<Schedule, String> courseNameColumn = new TableColumn<>("Course Name");
        courseNameColumn.setMinWidth(200);
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));

        TableColumn<Schedule, String> instructorColumn = new TableColumn<>("Instructor");
        instructorColumn.setMinWidth(200);
        instructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));

        TableColumn<Schedule, String> timeColumn = new TableColumn<>("Time");
        timeColumn.setMinWidth(150);
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<Schedule, String> dayColumn = new TableColumn<>("Day");
        dayColumn.setMinWidth(150);
        dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));

        scheduleTableView.setItems(scheduleList);
        scheduleTableView.getColumns().addAll(courseNoColumn,courseNameColumn, instructorColumn, timeColumn, dayColumn);

        // Layout setup
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(
                logoPane,
                new Label("Name:"),
                nameField,
                new Label("Email:"),
                emailField,
                new Label("Birthday:"),
                birthField,
                new Label("Pick Your Advisor:"),
                advisorComboBox,
                new Label("Pick your Grade"),
                GradeComboBox,
                registerButton,
                mainpage,
                new Label("If you're facing problems, Contact the Admins"),
                new Label(admin1.getPhoneNumber() + ", " + admin1.getEmail()),
                new Label(admin2.getPhoneNumber() + ", " + admin2.getEmail())
        );

        Label welcome = new Label("Welcome to the Al Najah Private School Website");
        welcome.setId("welcome-text");

        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(
                logoPane,
                welcome,
                systemButton,
                checkreg,
                schedulepage
        );

        // Schedule Form
        courseNoField = new TextField();
        courseNoField.setPromptText("Course Number");
        courseNoField.setMaxWidth(200);

        courseField = new TextField();
        courseField.setPromptText("Course Name");
        courseField.setMaxWidth(200);

        instructorField = new TextField();
        instructorField.setPromptText("Instructor Name");
        instructorField.setMaxWidth(200);

        timeField = new TextField();
        timeField.setPromptText("Time");
        timeField.setMaxWidth(200);

        dayField = new TextField();
        dayField.setPromptText("Day");
        dayField.setMaxWidth(200);


        Button saveSchedule = new Button("Save Schedule");
        saveSchedule.setOnAction(this);

        VBox layout3 = new VBox(10);
        layout3.getChildren().addAll(
                tableView,
                mainpage2,
                clearButton,
                copyButton
        );

        VBox layout4 = new VBox(10);
        layout4.getChildren().addAll(
                new Label("Add Schedule"),
                courseNoField,
                courseField,
                instructorField,
                timeField,
                dayField,
                saveScheduleButton,
                new Label("Schedule List:"),
                scheduleTableView,
                mainpage1,
                clearScheduleButton
        );


        scene1 = new Scene(layout2, 1000, 700);
        scene2 = new Scene(layout1, 1000, 700);
        scene3 = new Scene(layout3, 1000, 700);
        scene4 = new Scene(layout4, 1000, 700);
        scene1.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        window.setScene(scene1);
        window.show();

        loadData();
    }

    @Override
    public void stop() throws Exception {
        super.stop();

        saveData();
    }


    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == registerButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            int IDNum = 1000 + random.nextInt(8999);
            String ID = "2240" + IDNum;
            String birthdate = birthField.getText();
            Advisor advisor = advisorComboBox.getValue();
            String grade = GradeComboBox.getValue();

            if (!name.isEmpty() && !email.isEmpty() && advisor != null) {
                Student student = new Student(name, email, ID,null, birthdate, advisor, grade);
                notification.showMessage("Your ID is: " + ID + ", Memorize it");
                studentList.add(student);
                nameField.clear();
                emailField.clear();
                birthField.clear();
                advisorComboBox.getSelectionModel().clearSelection();
                GradeComboBox.getSelectionModel().clearSelection();
            }
        }else if (event.getSource() == copyButton) {
            Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                Student copiedStudent = new Student(selectedStudent);
                studentList.add(copiedStudent);
            } else {
                notification.showMessage("No student selected to copy");
            }
        } else if(event.getSource() == saveScheduleButton){
            int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Admin Pin:"));
            if (input == admin1.getPin() || input == admin2.getPin()) {
                String courseNo0 = courseNoField.getText();
                int courseNo = Integer.parseInt(courseNo0);
                String courseName = courseField.getText();
                String instructor = instructorField.getText();
                String time = timeField.getText();
                String day = dayField.getText();

                if (!courseName.isEmpty() && !instructor.isEmpty() && !time.isEmpty() && !day.isEmpty()) {
                    Schedule schedule = new Schedule(courseName, instructor, time, day, courseNo);
                    scheduleList.add(schedule);
                    courseField.clear();
                    instructorField.clear();
                    timeField.clear();
                    dayField.clear();
                    courseNoField.clear();
                }
            }else{
                notification.showMessage("Access Denied. Must be Admin to Perform Action");
            }


        } else if (event.getSource() == clearButton) {
            studentList.clear();
        }else if(event.getSource() == clearScheduleButton){
            int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Admin Pin:"));
            if (input == admin1.getPin() || input == admin2.getPin()) {
                scheduleList.clear();
            }else{
                notification.showMessage("Access Denied. Must be Admin to Perform Action");
            }
        }else if (event.getSource() == systemButton) {
            window.setScene(scene2);
        } else if (event.getSource() == mainpage || event.getSource()==mainpage1 ||event.getSource()==mainpage2 ) {
            window.setScene(scene1);
        }  else if (event.getSource() == checkreg) {
            int input = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Admin Pin"));
            if (input == admin1.getPin()) {
                notification.showMessage("Welcome, " + admin1.getName());
                window.setScene(scene3);
            } else if (input == admin2.getPin()) {
                notification.showMessage("Welcome, " + admin2.getName());
                window.setScene(scene3);
            } else {
                notification.showMessage("Wrong Pin. Access Denied");
            }
        } else if (event.getSource() == schedulepage) {
            window.setScene(scene4);
        }
    }
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(new ArrayList<>(studentList));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("schedules.dat"))) {
            oos.writeObject(new ArrayList<>(scheduleList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            List<Student> students = (List<Student>) ois.readObject();
            studentList.addAll(students);
        } catch (FileNotFoundException e) {
            // File not found, no data to load
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("schedules.dat"))) {
            List<Schedule> schedules = (List<Schedule>) ois.readObject();
            scheduleList.addAll(schedules);
        } catch (FileNotFoundException e) {
            // File not found, no data to load
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
