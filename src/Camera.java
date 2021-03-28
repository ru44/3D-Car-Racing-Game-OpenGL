/**
 * @author:- RuM
 */
public class Camera {

    Vector3f mPos;
    Vector3f mView;
    Vector3f mUp;

    public Camera() {
    }

    /**
     *
     * @param pos_x
     * @param pos_y
     * @param pos_z
     * @param view_x
     * @param view_y
     * @param view_z
     * @param up_x
     * @param up_y
     * @param up_z
     */
    public void Position_Camera(float pos_x, float pos_y, float pos_z,
            float view_x, float view_y, float view_z,
            float up_x, float up_y, float up_z) {

        mPos = new Vector3f(pos_x, pos_y, pos_z);
        mView = new Vector3f(view_x, view_y, view_z);
        mUp = new Vector3f(up_x, up_y, up_z);

    }

    /**
     *
     * @param speed
     */
    public void Move_Camera(float speed) {
        Vector3f vVector = Vector3f.sub(mView, mPos);
        mPos.x = mPos.x + vVector.x * speed;
        mPos.z = mPos.z + vVector.z * speed;
        mView.x = mView.x + vVector.x * speed;
        mView.z = mView.z + vVector.z * speed;
    }

    /**
     *
     * @param speed
     */
    public void strafe_Camera(float speed) {
        mPos.x = mPos.x + -1 * speed;
        mView.x = mView.x + -1 * speed;
    }

}
