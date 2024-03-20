package balloons;


import gdi.game.sprite.AbstractSpriteWorld;
import gdi.game.sprite.Sprite;
import java.awt.*;

public class Dart extends Sprite {
    boolean check;

    public Dart(double x, double y, double angle, AbstractSpriteWorld w) {
        super(x, y, angle, w);
    }

    @Override
    protected void renderLocal(Graphics2D x) {
        x.setColor(Color.black);
        x.drawLine(0, 0,60, 0);
    }

    @Override
    public void update(double deltaTime, double time) {
        super.update(deltaTime, time);
        if (check) {

            double y = getY();
            double d = getAngle();
            double x = getX();
            x += 600 * deltaTime;
            setX(x);
            d += 30*deltaTime;
           setAngle(d);
           y += Math.sin(Math.toRadians(d))*450* deltaTime;
           setY(y);

        }
        if(getX()>800||getY()>600){
            check=false;
           resetDart();
        }

    }
    protected void resetDart(){
        setX(0);
        setY(300);
        setAngle(0);
    }
   public double TipX(){
       return getX() + 60 * Math.cos(Math.toRadians(getAngle()));
   }
    public double TipY(){
        return getY() + 60 * Math.sin(Math.toRadians(getAngle()));
    }

}