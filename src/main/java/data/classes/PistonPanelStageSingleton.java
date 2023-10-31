package data.classes;


import javafx.stage.Stage;

public class PistonPanelStageSingleton {
    private static PistonPanelStageSingleton instance;
    private Stage stage;
    private PistonPanelStageSingleton(Stage stage){this.stage = stage;}
    public static PistonPanelStageSingleton getInstance(){return instance;}
    public static void setData(Stage stage){instance = new PistonPanelStageSingleton(stage);}
    public Stage getData(){
        return stage;
    }



}
