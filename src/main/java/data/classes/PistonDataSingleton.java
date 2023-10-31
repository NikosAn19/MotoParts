package data.classes;

import com.example.motoparts.PistonPanelController;

public class PistonDataSingleton {
    private static PistonDataSingleton instance;
    private Piston piston;
    private PistonDataSingleton(Piston piston){
        this.piston = piston;
    }
    public static PistonDataSingleton getInstance(){
        return instance;
    }
    public static void setData(Piston piston){
        instance = new PistonDataSingleton(piston);
    }
    public Piston getData(){
        return piston;
    }
}
