package planets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author benjamin
 */
public class MyListener implements ActionListener{

        private final SolarSystem solarSystem;

        public MyListener(SolarSystem solarSystem){
            this.solarSystem = solarSystem;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            solarSystem.movePlanets();
        }
}

