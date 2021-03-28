import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import static javax.media.opengl.GL.GL_BLEND;
import static javax.media.opengl.GL.GL_DEPTH_TEST;
/**
 * @author:- RuM
 */
public class Building {

    float pos;
    private int Red;
    private int Green;
    private int Blue;
    private float WColor;

    public Building(float pos) {
        this.pos = pos;
        Red = (int) (Math.random() * 255);
        Green = (int) (Math.random() * 255);
        Blue = (int) (Math.random() * 255);
        WColor = (179 / 255f);
    }

    public float getPos() {
        return pos;
    }

    public void setPos(float pos) {
        this.pos = pos;
        Red = (int) (Math.random() * 255);
        Green = (int) (Math.random() * 255);
        Blue = (int) (Math.random() * 255);
        WColor = (179 / 255f);
    }

    public void draw(GL gl, GLUT glut, float nPos) {
        gl.glPushMatrix();

        gl.glRotatef(90, 0f, 1f, 0);
        gl.glTranslatef(pos, 0, -nPos);

        gl.glPushMatrix();

        gl.glTranslatef(60, 0.5f, -30);
        gl.glRotatef(180, 0, 1, 0);
        TallBuilding(glut, gl, 2, Red, Green, Blue);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(50, 0.5f, 30);
        TallBuilding(glut, gl, 1, Red, Green, Blue);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(20f, 0.5f, 30);
        TallBuilding(glut, gl, 3, Red, Green, Blue);
        gl.glPopMatrix();

        gl.glPopMatrix();
        // Flush all drawing operations to the graphics card
        gl.glDisable(GL_BLEND);


        gl.glFlush();
    }

    public void TallBuilding(GLUT glut, GL gl, int num, int bs1, int bs2, int bs3) {

        gl.glPushMatrix();

        gl.glEnable(GL_DEPTH_TEST);

        // Building Structure
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -15f);
        gl.glColor3f(bs1 / 255f, bs2 / 255f, bs3 / 255f);
        gl.glScalef(4, 4.5f, 2);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        // windows
        // Right , above
        gl.glPushMatrix();

        gl.glTranslatef(0f, 0f, -2f);

        gl.glPushMatrix();

        gl.glTranslatef(1.2f, 1.5f, 0);

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -14f);
        gl.glColor3f(WColor, WColor, WColor);
        gl.glScalef(0.57f, 0.57f, 0.01f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPopMatrix();

        // Right , below
        gl.glPushMatrix();

        gl.glTranslatef(1.2f, 0.2f, 0);

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -14f);
        gl.glColor3f(WColor, WColor, WColor);
        gl.glScalef(0.57f, 0.57f, 0.01f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPopMatrix();

        // Left , below
        gl.glPushMatrix();

        gl.glTranslatef(-1.2f, 0.2f, 0);

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -14f);
        gl.glColor3f(WColor, WColor, WColor);
        gl.glScalef(0.57f, 0.57f, 0.01f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPopMatrix();

        // Left , above
        gl.glPushMatrix();

        gl.glTranslatef(-1.2f, 1.5f, 0);

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -14f);
        gl.glColor3f(WColor, WColor, WColor);
        gl.glScalef(0.57f, 0.57f, 0.01f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPopMatrix();

        // Middle, above
        gl.glPushMatrix();

        gl.glTranslatef(0f, 1.5f, 0);

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -14f);
        gl.glColor3f(WColor, WColor, WColor);
        gl.glScalef(0.57f, 0.57f, 0.01f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPopMatrix();

        // Middle, below
        gl.glPushMatrix();

        gl.glTranslatef(0f, 0.2f, 0);

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -14f);
        gl.glColor3f(WColor, WColor, WColor);
        gl.glScalef(0.57f, 0.57f, 0.01f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPopMatrix();

        gl.glPopMatrix();

        // Door
        gl.glPushMatrix();

        gl.glTranslatef(0f, -1.8f, -2);

        // black area on the door
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -14f);
        gl.glColor3f(0f, 0f, 0f);
        gl.glScalef(1.5f, 0.9f, 0.01f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        // white area right
        gl.glPushMatrix();
        gl.glTranslatef(-0.36f, -0.05f, -14.01f);
        gl.glColor3f(WColor, WColor, WColor);
        gl.glScalef(.69f, 0.8f, 0.01f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        // white area left
        gl.glPushMatrix();
        gl.glTranslatef(0.36f, -0.05f, -14.01f);
        gl.glColor3f(WColor, WColor, WColor);
        gl.glScalef(.69f, 0.8f, 0.01f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        gl.glPopMatrix();
        // Disable Depth test to The Fragment's output depth value
        gl.glDisable(GL_DEPTH_TEST);

        gl.glPopMatrix();

    }
}
