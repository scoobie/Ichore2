package pt.ulp.se.ichore2;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ET_LOG_EMAIL,ET_LOG_PASS;
    String email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_LOG_EMAIL=(EditText)findViewById(R.id.EditText_LogEmail);
        ET_LOG_PASS=(EditText)findViewById(R.id.EditText_LogPassword);

        Button botaolog=(Button)findViewById(R.id.btn_Login);
        Button botaoreg=(Button)findViewById(R.id.btn_LogRegisto);

        botaolog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            userLog(v);
            }
        });

        botaoreg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                finish();

            }
        });

    }

    public void userLog(View view){
        email=ET_LOG_EMAIL.getText().toString();
        pass=ET_LOG_PASS.getText().toString();
        String method="login";
        BackGroudTask backGroudTask=new BackGroudTask(this);
        backGroudTask.execute(method, email, pass);

    }

}