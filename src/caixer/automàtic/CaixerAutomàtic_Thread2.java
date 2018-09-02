package caixer.automàtic;

import static caixer.automàtic.CaixerAutomàtic_Mètodes.IniciSessió_Principal;
import java.util.Scanner;

public class CaixerAutomàtic_Thread2 extends Thread {

    Scanner sc;
    private String gg;
    
    @Override
    public void run() {
        
        if (gg.equals("Entrar")) {
            IniciSessió_Principal();
        }
    }


    public void setGg(String gg) {
        this.gg = gg;
    }
}
