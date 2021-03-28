import javax.media.opengl.GL;

/**
 * @author:- RuM
 */
public class GreenArea {

    public GreenArea() {
    }

    /**
     *
     * @param gl
     *
     */
    public void draw(GL gl) {
        // Left Grrean area 
        float z = 3000;
        float y = 0;
        float xEnd = 100;
        float xStart = 5;
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3d(26 / 255.f, 101 / 255.f, 26 / 255.f);
        gl.glVertex3f(-xStart, y, -z);
        gl.glVertex3f(-xStart, y, z);
        gl.glVertex3f(-xEnd, y, -z);
        gl.glVertex3f(-xEnd, y, z);
        gl.glEnd();
        //------------------------------------------------------------------
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3d(26 / 255.f, 101 / 255.f, 26 / 255.f);
        gl.glVertex3f(xStart, y, -z);
        gl.glVertex3f(xStart, y, z);
        gl.glVertex3f(xEnd, y, -z);
        gl.glVertex3f(xEnd, y, z);
        gl.glEnd();

    }
}
