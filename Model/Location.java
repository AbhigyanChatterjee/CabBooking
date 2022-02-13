package Model;

public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLocation(Location location) {
        this.x = location.getX();
        this.y = location.getY();
    }

    public Double distance(Location to) {
        Double xDis = Math.pow(this.x - to.getX(), 2);
        Double yDis = Math.pow(this.y - to.getY(), 2); 
        return Math.sqrt(xDis + yDis);
    }

    
}
