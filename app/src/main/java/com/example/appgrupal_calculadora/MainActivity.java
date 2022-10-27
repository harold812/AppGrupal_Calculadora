package com.example.appgrupal_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNum1,etNum2;
    TextView tvOperacion,tvResultado;
    Button btnSuma,btnResta,btnMultiplicar,btnDividir,btnResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        tvOperacion = findViewById(R.id.tvOperacion);
        tvResultado = findViewById(R.id.tvResultado);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnResultado = findViewById(R.id.btnResultado);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOperacion.setText("+");
            }
        });
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOperacion.setText("-");
            }
        });
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOperacion.setText("*");
            }
        });
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOperacion.setText("/");
            }
        });

        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RealizarOperacion();
            }
        });
    }
    private void RealizarOperacion()
    {
        try {
            String Operacion = tvOperacion.getText().toString();
            String n1 = etNum1.getText().toString();
            String n2 = etNum2.getText().toString();
            int resultado = 0;
            String Respuesta = "";

            if ((Operacion != "") && (n1 != "") && (n2 != "")){
                int num1 = Integer.parseInt(n1);
                int num2 = Integer.parseInt(n2);
                switch (Operacion){
                    case "+":
                        resultado = num1 + num2;
                        Respuesta = "suma";
                        break;
                    case "-":
                        resultado = num1 - num2;
                        Respuesta = "resta";
                        break;
                    case "/":
                        resultado = num1 / num2;
                        Respuesta = "Division";
                        break;
                    case "*":
                        resultado = num1 * num2;
                        Respuesta = "Multiplicacion";
                        break;
                }
                tvResultado.setText("El resultado de " + Respuesta + "es igual a " +
                        String.valueOf(resultado));
                Toast.makeText(this,"Operacion realizada con exito",Toast.LENGTH_SHORT).show();

            }
            else{
                tvResultado.setText("No se pudo realizar la operacion");
                Toast.makeText(this,"Datos insuficientes para realizar la operacion",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e)
        {
            tvResultado.setText("No se pudo realizar la operacion");
            Toast.makeText(this,"Datos insuficientes para realizar la operacion",Toast.LENGTH_SHORT).show();

        }


    }
}