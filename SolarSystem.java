package planets;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

// This is the SolarSystem Class that contains two planets, it will draw the solar system containing the state of the two planets

public class SolarSystem extends JPanel{
    
    Planet planet1;
    Planet planet2;
    
    SolarSystem(Planet planet1, Planet planet2) {
        this.planet1 = planet1;
        this.planet2 = planet2;    
    }
    
    public void movePlanets(){      
        planet1.updatePlanet(planet2);
        planet2.updatePlanet(planet1);  
        repaint();
    }
    
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        setBackground(Color.BLACK);        
        // draw x-axis
        g.setColor(Color.GRAY); 
        g.drawLine(adjustX(-1*(Constants.FRAME_WIDTH/2)), adjustY(0), adjustX(Constants.FRAME_WIDTH/2), adjustY(0));    
        // draw y-axis     
        g.drawLine(adjustX(0), adjustY(-1*(Constants.FRAME_HEIGHT/2)), adjustX(0), adjustY(Constants.FRAME_HEIGHT/2));    
        
        drawPlanet(planet1, Color.BLUE, g);
        drawPlanet(planet2, Color.YELLOW, g);        
    }
    
    // adjust X to the X Y scaling of the graphics layout
    public int adjustX(int x){
        return x + (Constants.FRAME_WIDTH/2);
    }

    public int adjustY(int y){
        return (-1*y) + (Constants.FRAME_HEIGHT/2);
    }

    public void drawPlanet(Planet planet, Color color, Graphics g){
        g.setColor(color);
        g.fillOval(adjustX(planet.getIntX())-(int)planet.getRadius(), adjustY(planet.getIntY())-(int)planet.getRadius(), (int)planet.getRadius()*2, (int)planet.getRadius()*2);
    }
    
}