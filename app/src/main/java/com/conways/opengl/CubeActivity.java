package com.conways.opengl;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

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


    float[] lightAmbient = new float[]{0.0f,0.0f,0.0f,0.0f};
    float[] lightDiffuse = new float[]{0f,0f,0f,0.0f};
    float[] lightPosition = new float[]{0.0f,0.2f,-4f,0.0f};

    //环境光
    private FloatBuffer AmbientBuffer;
    //漫射光
    private FloatBuffer diffuseBuffer;
    //光源位置
    private FloatBuffer positionBuffer;

    @Override
    public void draw(GL10 gl) {
        reset(gl);
        //环境光
        ByteBuffer ambientbb = ByteBuffer.allocateDirect(lightAmbient.length * 4 * 6);
        ambientbb.order(ByteOrder.nativeOrder());
        AmbientBuffer = ambientbb.asFloatBuffer();
        AmbientBuffer.put(lightAmbient);
        AmbientBuffer.position(0);

        //漫射光
        ByteBuffer diffusebb = ByteBuffer.allocateDirect(lightDiffuse.length * 4 * 6);
        diffusebb.order(ByteOrder.nativeOrder());
        diffuseBuffer = diffusebb.asFloatBuffer();
        diffuseBuffer.put(lightDiffuse);
        diffuseBuffer.position(0);

        //灯光位置
        ByteBuffer positionbb = ByteBuffer.allocateDirect(lightPosition.length * 4 * 6);
        positionbb.order(ByteOrder.nativeOrder());
        positionBuffer = positionbb.asFloatBuffer();
        positionBuffer.put(lightPosition);
        positionBuffer.position(0);

        gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_AMBIENT, AmbientBuffer);
        //设置漫射光
        gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_DIFFUSE, diffuseBuffer);
        //设置灯光位置
        gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_POSITION, positionBuffer);
        //启用1号灯光
        gl.glEnable(GL10.GL_LIGHT1);
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
