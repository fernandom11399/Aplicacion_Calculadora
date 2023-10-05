package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import org.apache.commons.math3.analysis.function.Add;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;



public class MainActivity extends AppCompatActivity {

    Button cero;
    Button uno;
    Button dos;
    Button tres;
    Button cuatro;
    Button cinco;
    Button seis;
    Button siete;
    Button ocho;
    Button nueve;
    Button igual;
    Button mas;
    Button menos;
    Button por;
    Button division;
    Button porcentaje;
    Button parentesis;
    boolean clickparentesis = false;
    Button letrac;
    Button punto;
    boolean clickpunto = false;
    TextView contenedor;
    Button masmenos;

    TextView resultado;

    ScrollView contenedor_de_numeros;
    boolean clickmasmenos = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contenedor_de_numeros = findViewById(R.id.contenedor_de_numeros);


        contenedor_de_numeros.post(new Runnable() {
            @Override
            public void run() {
                contenedor_de_numeros.fullScroll(View.FOCUS_DOWN);
            }
        });

        contenedor = findViewById(R.id.operaciones);
        uno = findViewById(R.id.uno);

        uno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "1");
            }
        });
        dos = findViewById(R.id.dos);

        dos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "2");
            }
        });

        tres = findViewById(R.id.tres);

        tres.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "3");
            }
        });
        cuatro = findViewById(R.id.cuatro);

        cuatro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "4");
            }
        });
        cinco = findViewById(R.id.cinco);

        cinco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "5");
            }
        });
        seis = findViewById(R.id.seis);

        seis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "6");
            }
        });
        siete = findViewById(R.id.siete);

        siete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "7");
            }
        });
        ocho = findViewById(R.id.ocho);

        ocho.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "8");
            }
        });
        nueve = findViewById(R.id.nueve);

        nueve.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "9");
            }
        });
        cero = findViewById(R.id.cero);

        cero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                int largo = existingText.length();
                if(largo>=1) {
                contenedor.setText(existingText + "0");
                }
            }
        });
        igual = findViewById(R.id.igual);
        resultado = findViewById(R.id.resultado);

        igual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                Expression expression = new ExpressionBuilder(existingText).build();
                try {
                double result = expression.evaluate();
                int result1 =  (int) result;
                if((result-result1) == 0){
                    resultado.setText(String.valueOf(result1));
                }else {
                    resultado.setText(String.valueOf(result));
                }
                } catch (Exception e) {
                    resultado.setText("Operación invalida...");
                }
            }
        });
        mas = findViewById(R.id.mas);

        mas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "+");
                clickpunto = false;
            }
        });
        menos = findViewById(R.id.menos);

        menos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "-");
                clickpunto = false;
            }
        });
        por = findViewById(R.id.por);

        por.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "*");
                clickpunto = false;
            }
        });
        division = findViewById(R.id.division);

        division.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "/");
                clickpunto = false;
            }
        });
        porcentaje = findViewById(R.id.porcentaje);

        porcentaje.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                contenedor.setText(existingText + "%");
                clickpunto = false;
            }
        });

        parentesis = findViewById(R.id.parentesis);

        parentesis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                if (!clickparentesis) {
                    contenedor.setText(existingText +"(");
                    clickparentesis = true;
                } else {
                    contenedor.setText(existingText + ")");
                    clickparentesis = false;
                }
            }
        });



        letrac = findViewById(R.id.letrac);
        resultado = findViewById(R.id.resultado);

        letrac.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                contenedor.setText("");
                resultado.setText("0");
                clickpunto = false;
            }
        });
        punto = findViewById(R.id.punto);

        punto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!clickpunto) {
                    String existingText = contenedor.getText().toString();
                    contenedor.setText(existingText + ".");
                    clickpunto = true;
                }
            } 
        });

        masmenos = findViewById(R.id.masmenos);

        masmenos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String existingText = contenedor.getText().toString();
                int largo = existingText.length();
                if(largo>0 && !existingText.equals("0")){
                    String menosunnumero = existingText.substring(0, largo -1);
                    contenedor.setText(menosunnumero);
                }

            }
        });

    }
}
