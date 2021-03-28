import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
/**
 * @author:- RuM
 */
public class Tree {

    float pos;

    public Tree(float pos) {
        this.pos = pos;
    }

    public float getPos() {
        return pos;
    }

    public void setPos(float pos) {
        this.pos = pos;
    }

    /**
     *
     * @param gl
     * @param glut
     */
    public void draw(GL gl, GLUT glut, float nPos) {
        gl.glPushMatrix();

        gl.glRotatef(90, 0f, 1f, 0);
        gl.glTranslatef(pos, -1.5f, 12 + nPos);
        gl.glPushMatrix();

        gl.glScalef(0.5f, 1f, 0.5f);
        tree(gl, glut);
        gl.glPopMatrix();
        gl.glTranslatef(0.5f, 0, -24);
        gl.glPushMatrix();

        gl.glScalef(0.7f, 1f, 0.7f);
        tree(gl, glut);
        gl.glPopMatrix();
        gl.glPopMatrix();
    }

    /**
     *
     * @param gl
     * @param glut
     */
    public static void tree(GL gl, GLUT glut) {

        gl.glPushMatrix();

        // Tree trunk
        gl.glPushMatrix();
        gl.glColor3f(166 / 255f, 100 / 255f, 100 / 255f);
        gl.glScalef(0.5f, 1f, 0.5f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();

        // Tree top
        gl.glPushMatrix();
        gl.glTranslatef(0f, 1.5f, 0f);
        gl.glColor3f(58 / 255f, 150 / 255f, 99 / 255f); //tree green
        gl.glScalef(0.5f, 0.8f, 0.5f);
        glut.glutSolidDodecahedron();
        gl.glPopMatrix();

        gl.glPopMatrix();

    }
}
