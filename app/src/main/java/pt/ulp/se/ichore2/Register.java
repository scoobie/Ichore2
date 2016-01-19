package pt.ulp.se.ichore2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText ET_REG_NOME,ET_REG_EMAIL,ET_REG_PASS;
    String lognome,email,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ET_REG_NOME=(EditText)findViewById(R.id.EditText_RegNome);
        ET_REG_EMAIL=(EditText)findViewById(R.id.EditText_RegEmail);
        ET_REG_PASS=(EditText)findViewById(R.id.EditText_RegPassword);

        Button botaoRegisto=(Button)findViewById(R.id.btnRegistar);
        Button botaoLogin=(Button)findViewById(R.id.btn_RegLogin);

        botaoRegisto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                userReg(v);
            }
        });

        botaoLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }



    public void userReg(View view){
        lognome=ET_REG_NOME.getText().toString();
        email=ET_REG_EMAIL.getText().toString();
        pass=ET_REG_PASS.getText().toString();
        String method="register";
        BackGroudTask backGroudTask=new BackGroudTask(this);
        backGroudTask.execute(method,lognome,email,pass);

    }
}
