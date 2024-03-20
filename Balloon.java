package balloons;

import java.awt.Polygon;
import gdi.game.sprite.AbstractSpriteWorld;
import gdi.game.sprite.Sprite;

import java.awt.*;


public class Balloon extends Sprite {
   private final Color[] CA = {Color.BLACK, Color.blue, Color.red, Color.green, Color.MAGENTA};
    private final Color c=CA[(int) (Math.random()*5)];
    private final int width=100;
    private final int height=100;
    private int D=1;

    public Balloon(double x, double y, AbstractSpriteWorld w) {
        super(x,y,w);

    }



    @Override
    protected void renderLocal(Graphics2D g) {
        g.setColor(this.c);
        g.fillOval(0, 0, width, height);

        Polygon tip = new Polygon();
        tip.addPoint(40, 115);
        tip.addPoint(40 + 20, 115);
        tip.addPoint(40 + 20 / 2, 115 - 20);
        g.fillPolygon(tip);


    }

   @Override
   public void update(double deltaTime, double time) {


   
        if (getY() <-50) {
           D*=-1;
        }

        if (getY() > 550) {
            D*=-1;
        }

        setY(getY()+ 100 *D* deltaTime);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
