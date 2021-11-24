package pos;

import java.util.logging.Level;
import java.util.logging.Logger;
import vista.InicioDeSesion;
import vista.SplashTop;

public class POS {

    public static void main(String[] args) {

        try {
            SplashTop st = new SplashTop();
            st.setVisible(true);
            Thread.sleep(1000);
            st.dispose();
            InicioDeSesion inicio = new InicioDeSesion();
            inicio.setVisible(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(POS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
