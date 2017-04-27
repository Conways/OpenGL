package com.conways.opengl;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Conways on 2017/4/27.
 */

public class TriangleActivity extends BaseOpengGLActivity implements DrawContents {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
            0.0f, 1.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
    };

    @Override
    public void draw(GL10 gl) {
        reset(gl);
        gl.glTranslatef(0, 0, -6);
        gl.glRotatef(rotate, 0.0f, 1.0f, 0.0f);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufferUtil(vertexArray));
        gl.glColor4f(0.0f, 0.0f, 1.0f, 0.0f);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
        gl.glFinish();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        rotate += 1.5;
        Log.d(TAG, "draw: " + rotate);
    }
}
