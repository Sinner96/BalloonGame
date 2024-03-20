package balloons;

import gdi.game.sprite.AbstractSpriteWorld;

import java.awt.*;

public class TrojanBalloon extends Balloon{
    private final int width=50;
    private final int height=50;
   Color[] CA = {Color.yellow, Color.gray, Color.white};
   Color c= CA[(int) (Math.random()*3)];
    public TrojanBalloon(double x, double y, AbstractSpriteWorld w) {
        super(x, y, w);
    }
    @Override
    protected void renderLocal(Graphics2D g) {
        g.setColor(c);
        g.fillOval(0, 0, width, height);
        Polygon tip = new Polygon();
        tip.addPoint(20, 60);
        tip.addPoint(20 + 10, 60);
        tip.addPoint(20 + 10 / 2, 60 - 10);
        g.fillPolygon(tip);
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
