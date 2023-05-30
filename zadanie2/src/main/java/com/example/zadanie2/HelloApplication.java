package com.example.zadanie2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Простые компоненты");
        Label label1 = new Label( "Выберите товар:");

        CheckBox checkBox1 = new CheckBox("Книги");
        CheckBox checkBox2 = new CheckBox("Диски");
        CheckBox checkBox3 = new CheckBox("Игрушки");

        Label label2 = new Label("Выберите способ оплаты:");
        RadioButton radioButton1 = new RadioButton("Почтовым переводом");
        RadioButton radioButton2 = new RadioButton("Кредитной картой");
        ToggleGroup paymentToggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(paymentToggleGroup);
        radioButton2.setToggleGroup(paymentToggleGroup);

        Button continueButton = new Button("Продолжить");
        Button cancelButton = new Button("Отменить");
        Button exitButton = new Button("Выйти");

        // Обработка событий кнопок
        continueButton.setOnAction(event -> {
            System.out.println("Нажата кнопка Продолжить");
        });

        cancelButton.setOnAction(event -> {
            System.out.println("Нажата кнопка Отменить");
        });

        exitButton.setOnAction(event -> {
            System.out.println("Нажата кнопка Выйти");
            primaryStage.close();
        });

        // Создание контейнера и добавление элементов
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(label1, checkBox1, checkBox2, checkBox3, label2, radioButton1, radioButton2,
                continueButton, cancelButton, exitButton);

        // Создание сцены и отображение окна
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
