package planets;

/**
 *
 * @author benjamin
 */
public class Planet {
    

    
    private final double mass; // kg - this does not change once set
    private final double radius; // metres - this does not change once set
    private double x; // scale this to metres at the moment is just coordinates
    private double y; // scale this to metres at the moment is just coordinates
    private double velocity; // metres per second
    private double direction; // degree
  
    public Planet(double mass, double radius, double x, double y, double velocity, double direction) {
        this.mass = mass;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.direction = direction;
    }    

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * @return the x
     */
    public double getX() {
        return x;
    }
    
    /**
     * @return the y
     */
    public double getY() {
        return y;
    }
    
    public int getIntX() {
        return (int) x;
    }
    
    /**
     * @return the y
     */
    public int getIntY() {
        return (int) y;
    }
  
    // Will tell us the gravitation force between this body and another body in Newtons
    
    public double gravitationForce(Planet secondBody) { 
       
        return ((Constants.UNIVERSAL_GRAVIATIONAL_CONSTANT * (this.mass * secondBody.mass))/Math.pow(distance(secondBody),2))/this.mass;
    }
    
    // will tell us the distance between a planet and another planet
    
    public double distance(Planet secondBody) {
        
        return Math.sqrt(Math.pow(this.x - secondBody.x, 2) + Math.pow(this.y - secondBody.y,2));
    }
    
    // returns angle to a second planet in degrees
    public double angleToPlanet(Planet secondBody){
            
        return Math.atan2((int) secondBody.getY() - this.y, (int) secondBody.getX() - this.x) * (180/ Math.PI);
    }
    
    // updatePlanet will update the velocity and direction of the planet given gravitational effects and current velocity and will move the planet
    
    public void updatePlanet(Planet secondBody){
        
        double gravityDirection = angleToPlanet(secondBody);
        double gravity = gravitationForce(secondBody);
        
        // first add together the vectors of the current planet velocity and gravity
        
        double summedVectorX = Math.cos(Math.toRadians(direction))* velocity + Math.cos(Math.toRadians(gravityDirection))* gravity;
        double summedVectorY = Math.sin(Math.toRadians(direction))* velocity + Math.sin(Math.toRadians(gravityDirection))* gravity;
       
        direction = 180/Math.PI * Math.atan2(summedVectorY, summedVectorX);
        velocity = Math.sqrt(Math.pow(summedVectorX, 2) + Math.pow(summedVectorY, 2));
        
        x += Math.cos(Math.toRadians(direction))* velocity;  
        y += Math.sin(Math.toRadians(direction))* velocity;
    }
    
}
