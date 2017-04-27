package com.conways.opengl;

import android.opengl.GLSurfaceView;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.microedition.khronos.opengles.GL10;

public class RectangularActivity extends BaseOpengGLActivity implements DrawContents {


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
            //这里的能闭合，绘制4个就行glDrawArrays（，，4）
//            -1.0f, 1.0f, 0.0f,
//            1.0f, 1.0f, 0.0f,
//            -1.0f, -1.0f, 0.0f,
//            1.0f, -1.0f, 0.0f,
            //这里绘制4个会缺失一块 glDrawArrays（，，5）
            -1.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
    };

    @Override
    public void draw(GL10 gl) {
        reset(gl);
        gl.glTranslatef(0, 0, -8);
        gl.glRotatef(rotate, 0.0f, 1.0f, 0.0f);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufferUtil(vertexArray));
        gl.glColor4f(1.0f, 1.0f, 0.0f, 0.0f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 5);
        gl.glFinish();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        rotate += 1.5;
        Log.d(TAG, "draw: " + rotate);
    }
}
