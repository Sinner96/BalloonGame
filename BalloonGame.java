package balloons;
import gdi.game.events.KeyEvent;
import gdi.game.sprite.SpriteWorld;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BalloonGame extends SpriteWorld {


    Random random = new Random();

    boolean check,checkTough, checkTrojan;

     ArrayList <Balloon> Balloons;
    public BalloonGame(int width, int height) {
        super(width, height);
        Balloons = new ArrayList<>();
        Balloon b1 = new Balloon(random.nextInt(800 / 3, 700), random.nextInt(600), this);
        Balloons.add(b1);
        Balloon b2 = new Balloon(random.nextInt(800 / 3, 700), random.nextInt(600), this);
        Balloons.add(b2);
        Balloon b3 = new Balloon(random.nextInt(800 / 3, 700), random.nextInt(600), this);
        Balloons.add(b3);
    }


    @Override
    protected void setupWorld() {
        this.setTitle("Balloon Game");
    }

    protected void renderBackground(Graphics2D x) {
        Color lightblue = new Color(0, 255, 255);

        x.setColor(lightblue);
        x.fillRect(0, 0, 800, 600);
    }


    Dart d = new Dart(0, 300, 0, this);



    @Override
    protected void keyDown(KeyEvent ke) {

        int x = ke.getKeyCode();
        if (x == 38 && d.getAngle() > -90&& !d.check)
            d.setAngle(d.getAngle() - 5);
        if (x == 40 && d.getAngle() < 90&& !d.check)
            d.setAngle(d.getAngle() + 5);

    }

    @Override
    protected void keyUp(KeyEvent ke) {
        int x = ke.getKeyCode();
        if (x == 32) {
            d.check = true;
        }
    }
    @Override
    public void update(double deltaTime, double time) {
        super.update(deltaTime, time);

        for (int i=0;i < Balloons.size();i++) {

            if (checkCollision(i)) {
                int z=random.nextInt(4);
                removeSprite(Balloons.get(i));
                d.resetDart();
                d.check = false;
                if(z==1 && !checkTough){
                    ToughBalloon x = new ToughBalloon(Balloons.get(i).getX(), Balloons.get(i).getY() , this);
                    Balloons.add(x);
                   checkTough=true;
                }
                if(z==3&& !checkTrojan){
                    TrojanBalloon x = new TrojanBalloon(random.nextDouble( Balloons.get(i).getX()-50, Balloons.get(i).getX()+50), random.nextDouble( Balloons.get(i).getY()-50, Balloons.get(i).getY()+50), this);
                    TrojanBalloon x2 = new TrojanBalloon(random.nextDouble( Balloons.get(i).getX()-50, Balloons.get(i).getX()+50), random.nextDouble( Balloons.get(i).getY()-50, Balloons.get(i).getY()+50), this);
                    Balloons.add(x);
                    Balloons.add(x2);
                   checkTrojan =true;
                }
                Balloons.remove(i);
            }

        }

        if (Balloons.size()==0 ) {
            stop();
            check = true;
        }

    }

    protected void renderForeground(Graphics2D g){
        if(check) {
            g.setColor(Color.gray);
            g.fillRect(275, 190, 200, 100);

            g.setColor(Color.black);
            g.drawString("You won",350,240);

       }
    }
    private boolean checkCollision(int i){
        return (d.TipX() >= Balloons.get(i).getX() && d.TipX() < Balloons.get(i).getX() + Balloons.get(i).getWidth() &&
                d.TipY() >= Balloons.get(i).getY() && d.TipY() < Balloons.get(i).getY() + Balloons.get(i).getHeight());
    }

}












