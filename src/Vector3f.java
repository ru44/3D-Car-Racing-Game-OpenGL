/**
 * @author:- RuM
 */
// vector class  Store X Y Z for camera and loockat
public class Vector3f {

     float x;
     float y;
     float z;

    public Vector3f() {
    }

    public Vector3f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f(double x, double y, double z) {
        this.x = (float) x;
        this.y = (float) y;
        this.z = (float) z;
    }

    public static Vector3f sub(Vector3f v1, Vector3f v2) {

        return new Vector3f(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

}
