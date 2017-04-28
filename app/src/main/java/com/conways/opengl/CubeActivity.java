package com.conways.opengl;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.microedition.khronos.opengles.GL10;

public class CubeActivity extends BaseOpengGLActivity implements DrawContents {

    private float unit = 0.5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        init();
    }

    private void init() {
        renderer = new MyRenderer(this);
        glSurfaceView = (GLSurfaceView) this.findViewById(R.id.surfaceView);
        glSurfaceView.setRenderer(renderer);
    }

    float vertexArray[] = {
            //            //后面
            -unit, 0.0f, -unit,
            unit, 0.0f, -unit,
            -unit, unit, -unit,

            -unit, unit, -unit,
            unit, unit, -unit,
            unit, 0.0f, -unit,
            //右面
            unit, 0.0f, -unit,
            unit, 0.0f, unit,
            unit, unit, unit,

            unit, unit, -unit,
            unit, unit, unit,
            unit, 0.0f, -unit,
            //前面
            -unit, 0.0f, unit,
            unit, 0.0f, unit,
            unit, unit, unit,

            unit, unit, unit,
            -unit, unit, unit,
            -unit, 0.0f, unit,
//            //左面
            -unit, 0.0f, -unit,
            -unit, 0.0f, unit,
            -unit, unit, unit,

            -unit, unit, unit,
            -unit, unit, -unit,
            -unit, 0.0f, -unit,
//            //底面
            -unit, 0.0f, unit,
            unit, 0.0f, unit,
            unit, 0.0f, -unit,

            -unit, 0.0f, -unit,
            -unit, 0.0f, unit,
            -unit, 0.0f, unit,

            //上面
            -unit, unit, unit,
            unit, unit, unit,
            unit, unit, -unit,

            -unit, unit, -unit,
            -unit, unit, unit,
            -unit, unit, unit,

    };

    @Override
    public void draw(GL10 gl) {
        reset(gl);
        gl.glTranslatef(0, 0, -4);
        gl.glRotatef(rotate, 1.0f, 1.0f, 0.0f);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufferUtil(vertexArray));
        gl.glColor4f(0.0f, 1.0f, 1.0f, 0.0f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 30);
        gl.glFinish();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        rotate += 1.5f;
    }
}
