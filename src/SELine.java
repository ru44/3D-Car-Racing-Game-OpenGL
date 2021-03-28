import javax.media.opengl.GL;

/**
 * @author:- RuM
 */
public class SELine {

    /**
     *
     * @param gl
     */
    public void draw(GL gl) {
        float bColor = 0 / 255f;
        float wColor = 255 / 255f;
        float x1 = -4.5f;
        float x2 = -4.5f;
        float y = 0f;
        float zStart = -5;
        float zStart2 = -7;
        float zEnd = -2000;
        float zEnd2 = -2002;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                //==================================================================
                gl.glColor3d(wColor, wColor, wColor);
                gl.glPushMatrix();
                gl.glTranslatef(x1, y, zStart);
                draw1(gl);
                gl.glPopMatrix();

                //==================================================================
                gl.glColor3d(bColor, bColor, bColor);
                gl.glPushMatrix();
                gl.glTranslatef(x1, y, zStart2);
                draw1(gl);
                gl.glPopMatrix();
                x1 += 1;

                //==================================================================
                gl.glColor3d(wColor, wColor, wColor);
                gl.glPushMatrix();
                gl.glTranslatef(x2, y, zEnd);
                gl.glBegin(GL.GL_QUAD_STRIP);
                draw1(gl);
                gl.glPopMatrix();

                //==================================================================
                gl.glColor3d(bColor, bColor, bColor);
                gl.glPushMatrix();
                gl.glTranslatef(x2, y, zEnd2);
                draw1(gl);
                gl.glPopMatrix();
                x2 += 1;
            } else {
                //==================================================================
                gl.glColor3d(bColor, bColor, bColor);
                gl.glPushMatrix();
                gl.glTranslatef(x1, y, zStart);
                draw1(gl);
                gl.glPopMatrix();

                //==================================================================
                gl.glColor3d(wColor, wColor, wColor);
                gl.glPushMatrix();
                gl.glTranslatef(x1, y, zStart2);
                draw1(gl);
                gl.glPopMatrix();
                x1 += 1;

                //==================================================================
                gl.glColor3d(bColor, bColor, bColor);
                gl.glPushMatrix();
                gl.glTranslatef(x2, y, zEnd);
                draw1(gl);
                gl.glPopMatrix();

                //==================================================================
                gl.glColor3d(wColor, wColor, wColor);
                gl.glPushMatrix();
                gl.glTranslatef(x2, y, zEnd2);
                draw1(gl);
                gl.glPopMatrix();
                x2 += 1;
            }
        }
    }

    /**
     *
     * @param gl
     */
    public void draw1(GL gl) {
        gl.glPushMatrix();
        gl.glBegin(GL.GL_QUAD_STRIP);
        gl.glVertex3f(-0.5f, 0f, -0.01f);
        gl.glVertex3f(-0.5f, 0f, 2);
        gl.glVertex3f(0.5f, 0f, -0.01f);
        gl.glVertex3f(0.5f, 0f, 2);
        gl.glEnd();
        gl.glPopMatrix();
    }
    // Done Drawing The QUAD STRIP

}
