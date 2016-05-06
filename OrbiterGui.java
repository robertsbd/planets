package planets;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author benjamin
 */
public class OrbiterGui {
   
    public static void main(String[] args) {

        // Will probably replasce the setting of these initial parameters with user controls
        double bigPlanetMass = 50E12;        
        int bigPlanetRadius = 30;
        int bigPlanetX = 0;
        int bigPanetY = 0;
        double bigPlanetVelocity = 0;
        int bigPlanetDirection = 90;
 
        // Will probably replasce the setting of these initial parameters with user controls
        double smallPlanetMass = 50E8;        
        int smallPlanetRadius = 10;
        int smallPlanetX = -200;
        int smallPanetY = 250;
        double smallPlanetVelocity = 2;
        int smallPlanetDirection = 30;
                
        // create our frame
        JFrame frame = new JFrame("Solar System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // create two planets
        Planet bigPlanet = new Planet(bigPlanetMass,bigPlanetRadius, bigPlanetX, bigPanetY, bigPlanetVelocity, bigPlanetDirection);
        Planet smallPlanet = new Planet(smallPlanetMass,smallPlanetRadius,smallPlanetX,smallPanetY,smallPlanetVelocity, smallPlanetDirection);
        
        // create our solarsystem
        SolarSystem solarSystemGui = new SolarSystem(smallPlanet, bigPlanet);  
        frame.add(solarSystemGui);
        
        // Listener and timer to set the delay of the animation
        MyListener listener = new MyListener(solarSystemGui);
        Timer timer = new Timer(Constants.TIMER_DELAY, listener);
        timer.start();
        
        frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        frame.setVisible(true);

    }
 
}


