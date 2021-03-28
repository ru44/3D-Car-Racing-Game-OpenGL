import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
/**
 * @author:- RuM
 */
public class Objects {

    private float xPos;
    private float zPos;
    private final float Red;
    private final float Green;
    private final float Blue;

    public Objects(float x, float z) {
        this.xPos = x;
        this.zPos = z;
        Red = (float) (Math.random());
        Green = (float) (Math.random());
        Blue = (float) (Math.random());
    }

    public void setzPos(float zPos) {
        this.xPos = zPos;

    }

    public float getzPos() {
        return xPos;
    }

    public float getxPos() {
        return zPos;
    }

    public void drawCar(GL gl, GLUT glut) {

        /* top of cube*/
        //************************FRONT BODY****************************************
        gl.glColor3f(Red, Green, Blue);

        gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);

        gl.glTranslatef(xPos, 0, zPos);
        gl.glColor3f(Red, Green, Blue);
        float[][] fb_top = {{0.2f, 0.4f, 0.6f},
        {0.6f, 0.5f, 0.6f},
        {0.6f, 0.5f, 0.2f},
        {0.2f, 0.4f, 0.2f}};
        drawQuads(gl, fb_top);

        /* front of cube*/
        float[][] fb_front = {{0.2f, 0.2f, 0.6f},
        {0.2f, 0.4f, 0.6f},
        {0.2f, 0.4f, 0.2f},
        {0.2f, 0.2f, 0.2f}};
        drawQuads(gl, fb_front);

        /* back of cube.*/
        float[][] fb_back = {{0.6f, 0.2f, 0.6f},
        {0.6f, 0.5f, 0.6f},
        {0.6f, 0.5f, 0.2f},
        {0.6f, 0.2f, 0.2f}};
        drawQuads(gl, fb_back);

        /* left of cube*/
        float[][] fb_left = {{0.2f, 0.2f, 0.6f},
        {0.6f, 0.2f, 0.6f},
        {0.6f, 0.5f, 0.6f},
        {0.2f, 0.4f, 0.6f}};
        drawQuads(gl, fb_left);

        /* Right of cube */
        float[][] fb_right = {{0.2f, 0.2f, 0.2f},
        {0.6f, 0.2f, 0.2f},
        {0.6f, 0.5f, 0.2f},
        {0.2f, 0.4f, 0.2f}};
        drawQuads(gl, fb_right);

//****************************************************************************
        //top cover
        float[][] fb_top_cover = {{0.7f, 0.65f, 0.6f},
        {0.7f, 0.65f, 0.2f},
        {1.7f, 0.65f, 0.2f},
        {1.7f, 0.65f, 0.6f}};
        drawQuads(gl, fb_top_cover);

//***************************back guard******************************
        gl.glColor3f(Red, Green, Blue);

        float[][] bk = {{1.8f, 0.5f, 0.6f},
        {1.8f, 0.5f, 0.2f},
        {2.1f, 0.4f, 0.2f},
        {2.1f, 0.4f, 0.6f}};
        drawQuads(gl, bk);

        /* back of cube.*/
        float[][] bk_back = {{2.1f, 0.4f, 0.6f},
        {2.1f, 0.4f, 0.2f},
        {2.1f, 0.2f, 0.2f},
        {2.1f, 0.2f, 0.6f}};
        drawQuads(gl, bk_back);

        /* left of cube*/
        float[][] bk_left = {{1.8f, 0.2f, 0.2f},
        {1.8f, 0.5f, 0.2f},
        {2.1f, 0.4f, 0.2f},
        {2.1f, 0.2f, 0.2f}};
        drawQuads(gl, bk_left);

        /* Right of cube */
        float[][] bk_right = {{1.8f, 0.2f, 0.6f},
        {1.8f, 0.5f, 0.6f},
        {2.1f, 0.4f, 0.6f},
        {2.1f, 0.2f, 0.6f}};
        drawQuads(gl, bk_right);

//******************MIDDLE BODY************************************
        float[][] mb = {{0.6f, 0.5f, 0.6f},
        {0.6f, 0.2f, 0.6f},
        {1.8f, 0.2f, 0.6f},
        {1.8f, 0.5f, 0.6f}};
        drawQuads(gl, mb);

        /* back of cube.*/
        float[][] mb_back = {{0.6f, 0.5f, 0.2f},
        {0.6f, 0.2f, 0.2f},
        {1.8f, 0.2f, 0.2f},
        {1.8f, 0.5f, 0.2f}};
        drawQuads(gl, mb_back);

//*********************ENTER WINDOW**********************************
        gl.glColor3f(0.3f, 0.3f, 0.3f);

        //quad front window
        float[][] front_window = {{0.77f, 0.63f, 0.2f},
        {0.75f, 0.5f, 0.2f},
        {1.2f, 0.5f, 0.2f},
        {1.22f, 0.63f, 0.2f}};
        drawQuads(gl, front_window);

        //quad back window
        float[][] back_window = {{1.27f, 0.63f, .2f},
        {1.25f, 0.5f, 0.2f},
        {1.65f, 0.5f, 0.2f},
        {1.67f, 0.63f, 0.2f}};
        drawQuads(gl, back_window);

        gl.glColor3f(Red, Green, Blue);

        //first separation
        float[][] first_seperation = {{0.7f, 0.65f, 0.2f},
        {0.7f, 0.5f, .2f},
        {0.75f, 0.5f, 0.2f},
        {0.77f, 0.65f, 0.2f}};
        drawQuads(gl, first_seperation);

        //second separation
        float[][] second_seperation = {{1.2f, 0.65f, 0.2f},
        {1.2f, 0.5f, .2f},
        {1.25f, 0.5f, 0.2f},
        {1.27f, 0.65f, 0.2f}};
        drawQuads(gl, second_seperation);

        //3d separation
        float[][] third_seperation = {{1.65f, 0.65f, 0.2f},
        {1.65f, 0.5f, .2f},
        {1.7f, 0.5f, 0.2f},
        {1.7f, 0.65f, 0.2f}};
        drawQuads(gl, third_seperation);

        //line strip
        float[][] line_strip = {{0.75f, 0.65f, 0.2f},
        {0.75f, 0.63f, 0.2f},
        {1.7f, 0.63f, 0.2f},
        {1.7f, 0.65f, 0.2f}};
        drawQuads(gl, line_strip);

        //line strip
        float[][] line_strip2 = {{0.75f, 0.65f, 0.6f},
        {0.75f, 0.63f, 0.6f},
        {1.7f, 0.63f, 0.6f},
        {1.7f, 0.65f, 0.6f}};
        drawQuads(gl, line_strip2);

        gl.glColor3f(0.3f, 0.3f, 0.3f);

        //quad front window
        float[][] front_window2 = {{0.77f, 0.63f, 0.6f},
        {0.75f, 0.5f, 0.6f},
        {1.2f, 0.5f, 0.6f},
        {1.22f, 0.63f, 0.6f}};
        drawQuads(gl, front_window2);

        //quad back window
        float[][] back_window2 = {{1.27f, 0.63f, .6f},
        {1.25f, 0.5f, 0.6f},
        {1.65f, 0.5f, 0.6f},
        {1.67f, 0.63f, 0.6f}};
        drawQuads(gl, back_window2);

        gl.glColor3f(Red, Green, Blue);
        //first separation

        float[][] first_seperation2 = {{0.7f, 0.65f, 0.6f},
        {0.7f, 0.5f, .6f},
        {1.75f, 0.5f, 0.6f},
        {0.77f, 0.65f, 0.6f}};
        drawQuads(gl, first_seperation2);

        //second separation
        float[][] second_seperation2 = {{1.2f, 0.65f, 0.6f},
        {1.2f, 0.5f, .6f},
        {1.25f, 0.5f, 0.6f},
        {1.27f, 0.65f, 0.6f}};
        drawQuads(gl, second_seperation2);

        float[][] third_seperation2 = {{1.65f, 0.65f, 0.6f},
        {1.65f, 0.5f, .6f},
        {1.7f, 0.5f, 0.6f},
        {1.7f, 0.65f, 0.6f}};
        drawQuads(gl, third_seperation2);

        /* top of cube*/
        gl.glColor3f(0.3f, 0.3f, 0.3f);
        //quad front window

        float[][] top_front_window = {{0.6f, 0.5f, 0.6f},
        {0.6f, 0.5f, 0.2f},
        {0.7f, 0.65f, 0.2f},
        {0.7f, 0.65f, 0.6f}};
        drawQuads(gl, top_front_window);

        //quad back window
        float[][] top_back_window = {{1.7f, 0.65f, .6f},
        {1.7f, 0.65f, 0.2f},
        {1.8f, 0.5f, 0.2f},
        {1.8f, 0.5f, 0.6f}};
        drawQuads(gl, top_back_window);

        /* start drawing the cube.*/
 /* top of cube*/
        gl.glColor3f(0.3f, 0.3f, 0.3f);
        //tri front window

        float[][] tri_front_window = {{0.6f, 0.5f, 0.6f},
        {0.7f, 0.65f, 0.6f},
        {0.7f, 0.5f, 0.6f},
        {0.6f, 0.5f, 0.2f},
        {0.7f, 0.65f, 0.2f},
        {0.7f, 0.5f, 0.2f}};
        drawTriangles(gl, tri_front_window);

        //tri back window
        float[][] tri_back_window = {{1.7f, 0.65f, 0.2f},
        {1.8f, 0.5f, 0.2f},
        {1.7f, 0.5f, 0.2f},
        {1.7f, 0.65f, 0.6f},
        {1.8f, 0.5f, 0.6f},
        {1.7f, 0.5f, 0.6f}};
        drawTriangles(gl, tri_back_window);

        float angle = 0;
        gl.glColor3f(0.7f, 0.7f, 0.7f);
        gl.glPushMatrix();
        float[][] tires = {{0.6f, 0.2f, 0.62f},
        {0.6f, 0.2f, 0.18f},
        {1.7f, 0.2f, 0.18f},
        {1.7f, 0.2f, 0.62f}};
        drawLineStrip(gl, tires, angle);
        gl.glPopMatrix();

        // tires
        gl.glTranslatef(0.6f, 0.2f, 0.6f);
        gl.glColor3f(0, 0, 0);
        glut.glutSolidTorus(0.025, 0.07, 10, 25);

        gl.glTranslatef(0, 0, -0.4f);
        glut.glutSolidTorus(0.025, 0.07, 10, 25);

        gl.glTranslatef(1.1f, 0, 0);
        glut.glutSolidTorus(0.025, 0.07, 10, 25);

        gl.glTranslatef(0, 0, 0.4f);
        glut.glutSolidTorus(0.025, 0.07, 10, 25);
        gl.glPopMatrix();
    }

    public static void drawQuads(GL gl, float[][] array) {

        gl.glBegin(gl.GL_QUADS);

        for (int i = 0; i < array.length; i++) {
            gl.glVertex3f(array[i][0], array[i][1], array[i][2]);
        }
        gl.glEnd();
    }

    public static void drawTriangles(GL gl, float[][] array) {

        gl.glBegin(gl.GL_TRIANGLES);

        for (int i = 0; i < array.length; i++) {
            gl.glVertex3f(array[i][0], array[i][1], array[i][2]);
        }
        gl.glEnd();
    }

    public static void drawLineStrip(GL gl, float[][] array, float angle) {

        for (int i = 0; i < array.length; i++) {
            gl.glBegin(gl.GL_LINE_STRIP);
            for (float theta = 0; theta < 360; theta = theta + 20) {
                gl.glVertex3f(array[i][0], array[i][1], array[i][2]);
                gl.glVertex3f(array[i][0] + (float) (0.08f * (Math.cos(((theta + angle) * 3.14f) / 180))),
                        (float) (array[i][1] + (0.08f * (Math.sin(((theta + angle) * 3.14f) / 180)))), array[i][2]);
            }
            gl.glEnd();
        }

    }
}
