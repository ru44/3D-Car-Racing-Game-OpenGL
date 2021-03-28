import javax.media.opengl.GL;
/**
 * @author:- RuM
 */
public class Road {

    /**
     *
     * @param gl
     * @param space
     */
    public void draw(GL gl, float space) {
        float z = 3000;
        float x = 5;
        float y = 0;
        //grey area 
        gl.glColor3d(70 / 255.f, 70 / 255.f, 70 / 255.f);
        gl.glBegin(GL.GL_QUAD_STRIP);
        gl.glVertex3f(-x, y, -z);
        gl.glVertex3f(-x, y, z);
        gl.glVertex3f(x, y, -z);
        gl.glVertex3f(x, y, z);
        gl.glEnd();
        gl.glPushMatrix();

        // road sginels 
        gl.glTranslatef(0, 0, space);
        for (int i = 1; i < z; i += 10) {

            gl.glBegin(GL.GL_QUADS);
            // Set the current drawing color to light blue
            gl.glColor3f(1, 1, 1);
            gl.glVertex3f(-0.5f, y, -i + 3);
            gl.glVertex3f(-0.5f, y, -i);
            gl.glVertex3f(0.5f, y, -i);
            gl.glVertex3f(0.5f, y, -i + 3);
            // Done Drawing The Quad
            gl.glEnd();
        }
        gl.glPopMatrix();

    }
}
