package com.conways.opengl;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btTriangle;
    private Button btPoint;
    private Button btLine;
    private Button btRectangular;
    private Button btCube;
    private Button btSTL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btTriangle = (Button) this.findViewById(R.id.button_triangle);
        btTriangle.setOnClickListener(this);
        btPoint = (Button) this.findViewById(R.id.button_point);
        btPoint.setOnClickListener(this);
        btLine = (Button) this.findViewById(R.id.button_line);
        btLine.setOnClickListener(this);
        btRectangular = (Button) this.findViewById(R.id.button_rectangular);
        btRectangular.setOnClickListener(this);
        btCube = (Button) this.findViewById(R.id.button_cube);
        btCube.setOnClickListener(this);
        btSTL = (Button) this.findViewById(R.id.button_stl);
        btSTL.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_triangle:
                toTargetActivity(TriangleActivity.class);
                break;
            case R.id.button_point:
                toTargetActivity(PointActivity.class);
                break;
            case R.id.button_line:
                toTargetActivity(LineActivity.class);
                break;
            case R.id.button_rectangular:
                toTargetActivity(RectangularActivity.class);
                break;
            case R.id.button_cube:
                toTargetActivity(CubeActivity.class);
                break;
            case R.id.button_stl:
                toTargetActivity(com.conways.opengl.stl.MainActivity.class);
                break;

            default:
                break;


        }
    }

    private void toTargetActivity(Class<? extends AppCompatActivity> c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
