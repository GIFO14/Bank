package caixer.automàtic;

public class CaixerAutomàtic_Thread3 extends CaixerAutomàtic_Thread1 {

    private CaixerAutomàtic_Thread1 fil1 = new CaixerAutomàtic_Thread1();
    //private CaixerAutomàtic_Thread2 fil2= new CaixerAutomàtic_Thread2();
    private CaixerAutomàtic_Mètodes noSe= new CaixerAutomàtic_Mètodes();
    
    private boolean ifYes=true;
    @Override
    public void run() {
        try {
            fil1.sleep(10000);
            if (ifYes) {
                System.out.println("Sortint definitivament del caixer...");
                noSe.setCheckktrue(false);
            }else{
                noSe.setCheckktrue(true);
            }
        } catch (Exception e) {
            System.out.println("Hi ha hagut un error");
        }
    }

    public void setIfYes(boolean ifYes) {
        this.ifYes = ifYes;
    }

}
