import com.sun.opengl.util.Animator;
import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;
import javax.media.opengl.GL;
import static javax.media.opengl.GL.GL_BLEND;
import static javax.media.opengl.GL.GL_DEPTH_TEST;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * CarRacingGame.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
/**
 * @author:- RuM
 */
public class CarRacingGame implements GLEventListener, KeyListener {
//------------------------------

    GLAutoDrawable drawable;
    static Animator animator;
    GLU glu = new GLU();
    Camera camera = new Camera();

    // global var
    long Time0;
    long Time1;
    long Run;
    int start = 4000;
    int countDown = 3;
    int begin = 1000;
    int rank = 5;

    //----Buttons 
    boolean up = false;
    boolean right = false;
    boolean left = false;
    boolean down = false;
    boolean turbo = false;
    boolean carsExists = false;
    float carsMove = 0.03f;
    //------------------------------
    static float cameraSpeed = 0.02f;
    //------------------------------
    //---------BOT CARS--------------------
    static Objects[] cars = new Objects[4];
    int[] carsXPos = {-4, -2, 2, 4};
    float[] currentPos = new float[4];
    float[] carsSpeeds = new float[4];

    //----------- Trees--------------
    static Tree[] tree = new Tree[9];
    static int[] treePos = {10, 20, 35, 40, 50, 60, 70, 85, 90};
    boolean TreeExists = false;

    //----------- Building------------
    static Building[] buildings = new Building[4];
    static int[] buildingPos = {30, 80, 120, 250};
    boolean buildingExists = false;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Frame frame = new Frame("Car Racing Game");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new CarRacingGame());
        frame.add(canvas);
        frame.setSize(1080, 720);
        animator = new Animator(canvas);

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        animator.start();
    }

    /**
     *
     * @param drawable
     */
    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));
        this.drawable = drawable;
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        drawable.addKeyListener(this);
        // Enable VSync
        gl.setSwapInterval(1);
        playMusic("1.wav");
        float[] speeds = {0.05f, 0.07f, 0.08f, 0.09f, 0.095f, 0.06f, 0.069f, 0.075f, 0.085f, 0.055f};
        for (int i = 0; i < carsSpeeds.length; i++) {
            int rnd = new Random().nextInt(carsSpeeds.length);
            carsSpeeds[i] = speeds[rnd];
        }
        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
        gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
        camera.Position_Camera(0, 2.5f, 7, 0, 2f, 0, 0, 1, 0);
        Time0 = System.currentTimeMillis();

    }

    /*
     * Method to reset all default vaules when user press R
     */
    public void reInit() {
        camera.Position_Camera(0, 2.5f, 7, 0, 2f, 0, 0, 1, 0);
        playMusic("1.wav");
        tree = new Tree[9];
        TreeExists = false;

        Time0 = System.currentTimeMillis();
        countDown = 3;
        begin = 1000;
        rank = 5;
        // Buttons 
        float[] speeds = {0.05f, 0.07f, 0.08f, 0.09f, 0.095f, 0.06f, 0.069f, 0.075f, 0.085f, 0.055f};
        for (int i = 0; i < carsSpeeds.length; i++) {
            int rnd = new Random().nextInt(carsSpeeds.length);
            carsSpeeds[i] = speeds[rnd];
        }
        carsExists = false;
        carsMove = 0.03f;
        cameraSpeed = 0.02f;
        cars = new Objects[4];
        buildingExists = false;

    }

    /**
     *
     * @param drawable
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 200);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    /**
     *
     * @param drawable
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        //----------------------------------------------------------------------
        setUpEnvironment(gl);
        gl.glFlush();

    }

    //----------------------------- Gameplay Methods -------------------------------
    /**
     *
     * @param gl
     */
    public void setUpEnvironment(GL gl) {
        Time1 = System.currentTimeMillis();
        Run = Time1 - Time0;
        GLUT glut = new GLUT();

        // Sky
        gl.glClearColor(204 / 255.f, 242 / 255.f, 252 / 255.f, 0.0f);
        // load identity matrix
        gl.glLoadIdentity();

        glu.gluLookAt(camera.mPos.x, camera.mPos.y, camera.mPos.z,
                camera.mView.x, camera.mView.y, camera.mView.z,
                camera.mUp.x, camera.mUp.y, camera.mUp.z);

        //============Draw the Opjects==========================================
        //----------------------------------------------------------------------
        GreenArea area = new GreenArea();
        area.draw(gl);
        //----------------------------------------------------------------------
        Road signals = new Road();
        signals.draw(gl, 0);
        //----------------------------------------------------------------------
        // setup the Lighting 
        // Turning on the light comonents
        setupLight(gl);
        //----------------------------------------------------------------------
        SELine line = new SELine();
        line.draw(gl);
        //----------------------------------------------------------------------
        Car car = new Car(-camera.mPos.z + 4.5f, 0f, camera.mPos.x);
        // player Car
        car.drawCar(gl, glut, 0 / 255f, 85 / 255f, 156 / 255f);
        // bots Car
        drawCars(gl, glut);
        //----------------------------------------------------------------------
        drawTree(gl, glut);
        //---------------------------------------------------------------------- 
        drawBuildings(gl, glut);
        //----------------------------------------------------------------------

        gamePlay(gl);
        rank();
        Speedometer();
        checkRank();

    }

    /**
     * this method is responsible for drawing the Contestants cars first it will
     * check if car exist if no then create it if its created then add current
     * speed to it position then draw it again
     *
     * @param gl
     * @param glut
     */
    public void drawCars(GL gl, GLUT glut) {
        if (!carsExists || Run < start) {
            if (!carsExists) {
                for (int i = 0; i < cars.length; i++) {
                    cars[i] = new Objects(-1, carsXPos[i]);
                    cars[i].drawCar(gl, glut);
                    currentPos[i] = cars[i].getzPos() + 8;
                }
                carsExists = true;
            } else {
                for (int i = 0; i < cars.length; i++) {
                    cars[i].drawCar(gl, glut);
                }
            }

        } else {
            for (int i = 0; i < cars.length; i++) {
                cars[i].setzPos(cars[i].getzPos() + carsSpeeds[i]);
                cars[i].drawCar(gl, glut);
                currentPos[i] = cars[i].getzPos();
                if (carsSpeeds[i] <= 0.3) {
                    carsSpeeds[i] += carsSpeeds[i];
                }
            }
        }

    }

    /**
     * this method is responsible for drawing the Building first it will check
     * if building exist if no then create it if its created then check if the
     * camera passed 50 unit if yes add 360 then redraw it
     *
     * @param gl
     * @param glut
     */
    public void drawBuildings(GL gl, GLUT glut) {

        if (!buildingExists) {
            for (int i = 0; i < buildings.length; i++) {
                buildings[i] = new Building(buildingPos[i]);
                buildings[i].draw(gl, glut, camera.mPos.x);
            }
            buildingExists = true;
        } else {
            for (int i = 0; i < buildings.length; i++) {
                buildings[i].draw(gl, glut, camera.mPos.x);
                if (Math.abs(camera.mPos.z) > buildings[i].getPos() + 50) {
                    buildings[i].setPos(buildings[i].getPos() + 360);
                }
            }

        }
    }

    /**
     * this method is responsible for drawing the Tree first it will check if
     * Tree exist if no then create it if its created then check if the camera
     * passed current Position if yes add 360 then redraw it
     *
     * @param gl
     * @param glut
     */
    public void drawTree(GL gl, GLUT glut) {
        if (!TreeExists) {
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Tree(treePos[i]);
                tree[i].draw(gl, glut, camera.mPos.x);
            }
            TreeExists = true;
        } else {
            for (int i = 0; i < tree.length; i++) {
                tree[i].draw(gl, glut, -camera.mPos.x);
                if (Math.abs(camera.mPos.z) > tree[i].getPos() + 20) {
                    tree[i].setPos(tree[i].getPos() + 100);
                }
            }

        }
    }

    /*
     * Check player Rank this method is responsible for getting the rank of player
     */
    public void checkRank() {
        int count = 1;
        for (int i = 0; i < currentPos.length; i++) {
            if (Math.abs(camera.mPos.z) < currentPos[i] - 4) {
                count++;
            }
        }

        if (Run <= start + 500) {
            rank = 5;
        } else {
            rank = count;
        }
    }

    /**
     *
     * @param gl
     */
    public void gamePlay(GL gl) {
        if (up && Run > start) {
            camera.Move_Camera(cameraSpeed);
            if (cameraSpeed < 0.1) {
                cameraSpeed += 0.0001;
            }
        } else {
            if (cameraSpeed >= 0.025) {
                cameraSpeed -= 0.0001;
                camera.Move_Camera(cameraSpeed);
            }
        }
        if (right && Run > start) {
            if (camera.mPos.x <= 4) {
                
                camera.strafe_Camera(-0.1f);
            }
        }
        if (left && Run > start) {
            if (camera.mPos.x >= -4.9) {
                
                camera.strafe_Camera(0.1f);
            }
        }
        if (down && Run > start) {
            if (cameraSpeed >= 0.025) {
                cameraSpeed -= 0.0003;
                camera.Move_Camera(cameraSpeed);
            }
            camera.Move_Camera(-cameraSpeed);
        }
        if (turbo && up && Run > start) {
            TextRenderer t = new TextRenderer(new java.awt.Font("Jokerman", java.awt.Font.BOLD, 70));
            t.beginRendering(drawable.getWidth(), drawable.getHeight());
            Color c = new Color((int) (Math.random() * 16777216));
            t.setColor(c);
            t.draw("Turbo!", 450, 560);
            t.endRendering();
            if (cameraSpeed <= 0.2) {
                cameraSpeed += 0.1f;
            }

        }
        if (Run < start) {
            countDown();
            if (Run / begin > 0) {
                countDown--;
                begin += 1000;
            }
        }
        if (Math.abs(camera.mPos.z) >= 2000) {
            End();
        }
    }

    /*
     * count down 
     */
    public void countDown() {
        TextRenderer t = new TextRenderer(new java.awt.Font("Jokerman", java.awt.Font.BOLD, 50));
        t.beginRendering(drawable.getWidth(), drawable.getHeight());
        if (countDown == 0) {
            t.setColor(Color.green);
            t.draw("Go!", 500, 360);
        } else {
            t.setColor(Color.red);
            t.draw("" + countDown, 500, 360);
        }
        t.endRendering();
    }

    /*
     * rank method
     */
    public void rank() {
        TextRenderer t = new TextRenderer(new java.awt.Font("Poor Richard", java.awt.Font.BOLD, 50));
        t.setColor(Color.RED);
        t.beginRendering(drawable.getWidth(), drawable.getHeight());
        if (rank == 1) {
            t.setColor(Color.green);
        } else {
            t.setColor(Color.RED);
        }
        t.draw("" + rank, 50, 50);
        t.endRendering();
    }

    /*
     * speedmeter method
     */
    public void Speedometer() {
        TextRenderer t = new TextRenderer(new java.awt.Font("Jokerman", java.awt.Font.BOLD, 50));
        t.setColor(Color.blue);
        t.beginRendering(drawable.getWidth(), drawable.getHeight());
        String str = String.format("%.2f", (cameraSpeed * 100) - 2);
        t.draw("" + str, 50, 630);
        t.endRendering();
    }

    /*
     * end method
     */
    public void End() {
        TextRenderer t = new TextRenderer(new java.awt.Font("Impact", java.awt.Font.BOLD, 40));

        t.beginRendering(drawable.getWidth(), drawable.getHeight());
        if (rank == 1) {
            t.setColor(Color.green);
            t.draw("You Win", 480, 360);
            t.draw("Your Rank Is : " + rank, 450, 320);
            t.draw("press R to restart the game", 335, 280);
            t.draw("press x to Exit from the game", 330, 240);
        } else {
            t.setColor(Color.red);
            t.draw("You Lose", 480, 360);
            t.draw("Your Rank Is : " + rank, 450, 320);
            t.draw("press R to restart the game", 335, 280);
            t.draw("press x to Exit from the game", 330, 240);
        }
        animator.stop();

        t.endRendering();
    }

    /**
     * this method is responsible for illumination
     *
     * @param gl
     */
    public void setupLight(GL gl) {
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_NORMALIZE);
        gl.glShadeModel(GL.GL_SMOOTH);
        gl.glEnable(GL.GL_COLOR_MATERIAL);

        // Setting different light parameters
        float[] ambientLight = {0.5f, 0.5f, 0.5f, 0f};  // weak white ambient 
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, ambientLight, 0);

        float[] positionLight = {-3f, 2f, 0f};  // coordinates of the light
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, positionLight, 0);

        // Drawing 
        gl.glEnable(GL_BLEND);
        gl.glEnable(GL_DEPTH_TEST);

    }

    public void playMusic(String filepath) {
        InputStream music;
        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (Exception e) {
            System.out.println("somethong wrong!");
        }
    }
//------------------------- Keyboard Input -------------------------------------

    @Override
    public void keyPressed(KeyEvent ke) {

        switch (ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_T:
                turbo = true;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_T:
                turbo = false;
                break;
            case KeyEvent.VK_X:
                if (!animator.isAnimating()) {
                    System.exit(0);
                }
                break;
            case KeyEvent.VK_R:
                if (!animator.isAnimating()) {
                    reInit();
                    animator.start();
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

}
