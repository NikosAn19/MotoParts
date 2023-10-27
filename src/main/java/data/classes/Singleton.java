package data.classes;

import com.example.motoparts.PistonPanelController;

public class Singleton {
    private static Singleton instance;
    private PistonPanelController data;
    private Singleton(PistonPanelController data){
        this.data = data;
    }
    public static Singleton getInstance(){
        return instance;
    }
    public static void setData(PistonPanelController pistonPanelController){
        instance = new Singleton(pistonPanelController);
    }
    public PistonPanelController getData(){
        return data;
    }
}
