import processing.core.*;

public class Start extends PApplet {
    boolean cencored = false;
    boolean mouseDown = false;
    boolean mousePressed = false;
    boolean mouseReleased = false;
    boolean keyPressed = false;
    boolean keyReleased = false;

    String playerName = "";
    Event currentEvent;
    Boreee b;

    // Important function: don't delete or everything will break
    // I'm not sure why
    public static void bruh_momentum() {
        System.out.print("My name is Liam and I'm here to say ");
        Start.bruh_momentum();
    }

    public static void main(String[] args) {
        String[] appletArgs = new String[]{"Start"};
        PApplet.main(appletArgs);
    }

    public void settings() {
        fullScreen();
        b = new Boreee();
        currentEvent = b.new FadeIn();
    }

    public void draw() {
        currentEvent = currentEvent.foo();

        mousePressed = false;
        mouseReleased = false;
        keyPressed = false;
        keyReleased = false;
    }

    public void keyReleased() {
        keyReleased = true;
    }

    public void keyPressed() {
        keyPressed = true;
    }

    public void mousePressed() {
        mousePressed = true;
        mouseDown = true;
    }

    public void mouseReleased() {
        mouseReleased = true;
        mouseDown = false;
    }


    public class Screen {
        int border = 32;
        int colA = color(0);
        int colB = color(255);


        public Screen() {
        }

        public Screen(int bg, int fg) {
            int colA = color(bg);
            int colB = color(fg);

        }

        public void drawScreen() {
            background(colA);
            int s = width / border;
            fill(colB);
            noStroke();
            rect(s, s, width - s * 2, height - s * 2);
        }
    }

    public class Button {
        public int x, y, width, height;

        public Button(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public boolean mouseOver() {
            if ((mouseX < x + width) && (mouseY < y + height)) {
                if (mouseX > x && mouseY < y) {
                    return true;
                }
            }
            return false;
        }

        public boolean clicked() {
            return (mouseOver() && mouseReleased);
        }

    }

    public abstract class Event {
        // Blueprint type for the Events (things that happen lol)
        // foo() will execute the event and return the next event based on what happens
        public abstract Event foo();
    }

    public abstract class Bruh {
    }

    public class Ishy extends Bruh {
        // Ishy Storyline:
        public class Yeetus extends Event {
            public Event foo() {
                background(200, 100, 0);

                return this;
            }
        }
    }

    public class Boreee extends Bruh {
        // Borella story
        // Wooo

        public class FadeIn extends Event {
            int bg = 0;
            boolean debug = false;


            public Event foo() {
                if (debug == true) {
                    // jump to point in story;

                    AlStory s = new AlStory();
                    return s.new First();
                }

                background(bg);

                bg++;

                if (bg >= 255) {
                    return new Birth();
                }
                else {
                    return this;
                }
            }
        }

        public class Birth extends Event {
            public Event foo() {
                background(100, 100, 125);
                textAlign(CENTER);
                textSize(40);
                text("You are born", width / 2, height / 2);

                if (mousePressed) {
//                   Boreee is = new Start();
                    return new AfterBorn();
                } else {
                    return this;
                }
            }
        }

        public class AfterBorn extends Event {
            int stillTimer = 0;

            public Event foo() {
                if (random(200) == 1) {
                    background(100, 100, 125);
                    textAlign(CENTER);
                    textSize(40);
                    text("Unfortunately, you were stillborn.", width/2, height/2);

                    if (stillTimer >= 150) {
                        textSize(20);
                        text("(Sorry about that.)", width/2, 3*height/4);
                    }

                    if (stillTimer >= 200) exit();

                    stillTimer++;
                }

                else {
                    return new NameChange();
                }

                return this;
            }
        }

        public class NameChange extends Event {
            String name = "";
            String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            public Event foo() {
                background(0, 0, 125);
                textAlign(CENTER);
                textSize(40);
                text("What is your name?", width/2, height/2);

                if (keyPressed) {
                    if (key == BACKSPACE) {
                        if (name.length() > 0) {
                            name = name.substring(0, name.length()-1);
                        }
                    }

                    else if (alph.indexOf(""+key) != -1) name += key;

                    else if (key == ENTER) {
                        return new TheChristening();
                    }
                }

                text(name, width/2, 3*height/4);

                return this;
            }
        }

        public class TheChristening extends Event {
            String name = "";

            public TheChristening() {
                if (random(1) >= 0.5)
                    name = "Greggamendle";

                else
                    name = "Jaxon";

                playerName = name;
            }

            public Event foo() {
                background(0, 0, 125);
                textAlign(CENTER);
                textSize(40);
                text("Did you mean: " + name, width/2, height/2);
                textSize(20);
                text("Press ENTER to confirm", width/2, 3*height/4);

                if (keyPressed) {
                    if (key == ENTER) {
                        return new WaitYears();
                    } else {
                        return new Crawl();
                    }
                }

                return this;
            }
        }

        public class WaitYears extends Event {
            public Event foo() {
                background(200, 60, 0);
                textAlign(CENTER);
                textSize(40);
                text("Wait 15 years?", width/2, height/10);

                text("Yes", width/4, height/2);
                text("No", 3*width/4, height/2);

                if (mouseReleased) {
                    if (mouseX < width/2) {
                        return new FourChan();
                    } else {
                        return new Crawl();
                    }
                }

                return this;
            }
        }

        // branch to is

        public class FourChan extends Event {
            public Event foo() {
                background(60, 60, 0);
                textAlign(CENTER);
                textSize(40);
                text("As you wait your infantile body growls to that of a sickly 15 year old", width/2, height/10);
                text("\nYou are left with but one question.", width/2, height/10);
                text("\n\nDo you browse 4Chan?", width/2, height/10);

                text("Yes", width/4, height/2);
                text("No", 3*width/4, height/2);

                stroke(255);
                strokeWeight(5);
                line(width/2, height/5, width/2, 4*height/5);

                if (mouseReleased) {
                    if (mouseX < width/2) {

                    }
                }

                return this;
            }
        }

        public class Crawl extends Event {
            private BackgroundGen bg;
            public Crawl() {
                bg = new BackgroundGen();
                bg.newGoal(0, 360);
            }
            public Event foo() {
                image(bg.goal, 0, 0);
                fill(255, 255, 255, 150);
                noStroke();
                rect(0, 0, width, height);
                textAlign(CENTER);
                textSize(50);
                fill(255, 255, 255);
                text("YOU ARE BORN TO LOVING PARENTS", width/2, height/5);
                text("\nUNFORTUNATELY THEY LIVE IN DARWIN", width/2, height/5);
                text("\n\nEVEN SO YOUR LIFE IS IN ALL CAPS", width/2, height/5);
                text("\n\n\nCRAWL TO THE LEFT OR TO THE RIGHT?", width/2, height/5);

                if (mouseReleased) {
                    if (mouseButton == LEFT) {
                        //crawl left
                    } else {
                        //crawl right
                    }
                }

                return this;
            }
        }

    }

    public class AlStory extends Bruh {

        // shitty rain with lightning
        // use as background with
        //private RainField bg = new RainField(5, (float)0.2, 10);
        public class RainField {

            private float[][] rain = new float[100][3];
            private boolean light = false;
            private float vel = 0;
            private float variance = 0;


            public RainField(float direction, float vari, float velocity) {
                vel = velocity;
                variance = vari;

                rain_field_init(direction);
            }

            private void rain_field_init(float direction) {
                for (int x = 0; x < 100; x++) {
                    rain[x][0] = random(0, width);
                    rain[x][1] = random(0, height);
                    rain[x][2] = direction + random(-1 * variance, variance);
                }
            }

            private void rain_field() {
                for (int x = 0; x < 100; x++) {
                    if (rain[x][0] >= width || rain[x][1] >= height) {
                        rain[x][0] = random(width + 200) - 100;
                        continue;
                    }

                    float direction = rain[x][2];
                    rain[x][0] = rain[x][0] + (vel * cos(direction)) + random(-20, 20);
                    rain[x][1] = rain[x][1] + (-1 * vel * sin(direction)) + random(-20, 20);
                    if (random(100) > 80) {
                        rain[x][2] += random(-1 * variance, variance);
                    }
                }
            }

            public void draw() {
                rain_field();

                strokeWeight(4);
                stroke(0, 100, 200);
                background(0);
                if (light) {
                    if (random(10) > 2) {
                        background(255);
                    }
                    if (random(10) > 8) {
                        background(0);
                        light = false;
                    }
                } else if (random(10) > 9.8) {
                    background(255);
                    light = true;
                }

                for (int x = 0; x < 100; x++) {
                    float direction = rain[x][2];
                    float x2x = rain[x][0] + (vel * cos(direction));
                    float y2x = rain[x][1] + (-1 * vel * sin(direction));
                    line(rain[x][0], rain[x][1], x2x, y2x);
                }
            }
        }

        public void draw_event(String textone, String texttwo, String textthree, int background) {
            // background
//            background(background);
            textSize(40);
            textAlign(CENTER);
            stroke(255);
            strokeWeight(5);
            line(width/2, height/4, width/2, 3*height/4);
            text(textone, width / 2, 50);
            text(texttwo, width / 4, height/2);
            text(textthree, (width * 3 / 4), height/2);
        }

        public void draw_context(String textone, int background) {
            // background
//            background(background);
            textSize(40);
            textAlign(CENTER);
            text(textone, width / 2, height/3);
        }

        public int get_mouse() {
            if (mousePressed && (mouseX > width / 2)) {
                return(1);
            }
            if (mousePressed && (mouseX <= width / 2)) {
                return(0);
            }
            return(-1);
        }

        public class School extends Event {
            public Event foo() {
                clear();
                draw_context("You sit at school, it is raining.\nThe state has blocked 4chan...life has no\n purpose.");
            }
            if (mousePressed) {
                return(new Dog());
            }
            return(this);
        }

        public class Dog extends Event {
            public Event foo() {
                clear();
                RainField rain = new RainField(5, (float)0.2, 10);
                rain.draw();
                draw_context("Watching the road out the window, nothing\ninterests you until you see a dog,\nit is running around in the rain. A\ncar appears from nowhere and runs over the dog.\nYou see its head explode with blood\n all over the road.\nYou feel nothing.")
                if (mousePressed) {
                    return(new blank_rain_1());
                }

                return this;
            }

        }

        public class blank_rain_1 extends Event {
            public Event foo() {
                clear();
                RainField rain = new RainField(5, (float)0.2, 10);
                rain.draw();
                if (mousePressed) {
                    return(new later())
                }

                return this;
            }

        }

        public class later extends Event {
            BackgroundGen bg;
            public later() {
                bg = new BackgroundGen();

            }

            public Event foo() {
                clear();
                image(bg.goal, 0, 0 );
                


            }

        }

        public class First extends Event {

            public Event foo() {
                clear();
                RainField rain = new RainField(5, (float)0.2, 10);
                rain.draw();

                draw_event("You feel a tense baseline dissatisfaction\n with your success in life so far.\n You tell yourself it's not selfhatred\nbut actually you feel undeserving of\nall you have but regretful that you don't\n have more. But life is good, or as good as\nyou make it.",
                        "Take a sabattical in the\nmountains of South America",
                        "Enrol at UQ", 100);

                return this;

            }
        }

    }

    public class BackgroundGen {
        complx[] mz = new complx[5];
        PImage goal;
        float xcenter = 0;
        float ycenter = 0;
        float xradius = 2;
        float yradius = 2;

        public BackgroundGen() {
            goal = new PImage(width, height);
            newPollynomial(5);
            newGoal(0, 360);
        }

        void newGoal(int huemin, int huemax) {
          goal.loadPixels();
            for (int i = 0; i<goal.pixels.length; i++) {
              float rin = map(i % goal.width, 0, goal.width, xcenter - xradius, xcenter + xradius);
              float iin = map(floor(i/goal.width), 0, goal.height, ycenter - yradius, ycenter + yradius);
              complx num = fz(new complx(rin, iin));
              float hue = map(atan2(num.i, num.r) + PI, 0, 2*PI, huemin, huemax);
              float sat = sqrt(num.i * num.i + num.r * num.r)*50;
              colorMode(HSB, 100);
              goal.pixels[i] = color(hue, sat, 99);
              colorMode(RGB, 255);
            }
          goal.updatePixels();

          image(goal, 0, 0, width, height);
        }

        float sign(float in) {
          if (in > 0) {
            return 1;
          } else {
            return -1;
          }
        }

        void newPollynomial(int order) {
          mz = new complx[order];
          for (int i = 0; i<mz.length; i++) {
            mz[i] = new complx(randomGaussian(), randomGaussian());
          }
        }

        complx fz(complx num) {
          complx out = new complx(0, 0);
          for (int i = 0; i<mz.length; i++) {
            complx temp = num;
            temp = powComplx(temp, i);
            temp = multiComplx(mz[i], temp);
            out = addComplx(temp, out);
          }
          return out;
        }

        class complx {
          float i;
          float r;
          complx(float real, float imag) {
            i = imag;
            r = real;
          }
        }

        complx powComplx(complx one, int num) {
          complx temp = new complx(1, 0);
          for (int i = 0; i<num; i++) {
            temp = multiComplx(one, temp);
          }
          return temp;
        }

        complx multiComplx(complx one, complx two) {
          float r = one.r * two.r - one.i * two.i;
          float i = one.i * two.r + one.r * two.i;
          return new complx(i, r);
        }

        complx addComplx(complx one, complx two) {
          return new complx(one.r + two.r, one.i + two.r);
        }
    }
}
