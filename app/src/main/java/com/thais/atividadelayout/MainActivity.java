package com.thais.atividadelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText textNome;
    private EditText textPreco;
    private EditText textDesconto;
    private Button btCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNome = findViewById(R.id.textNome);
        textPreco = findViewById(R.id.textPreco);
        textDesconto = findViewById(R.id.textDesconto);
        btCalculate = findViewById(R.id.btCalcultePriceProduct);

        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textNome.getText().toString().isEmpty() && !textPreco.getText().toString().isEmpty() && !textDesconto.getText().toString().isEmpty()) {
                    String nome = String.valueOf(textNome.getText());
                    double preco = Double.valueOf(textPreco.getText().toString());
                    double desconto = Double.valueOf(textDesconto.getText().toString());

                    Toast.makeText(MainActivity.this, "O valor do produto "
                            + nome + " é " + (preco - (preco / 100 * desconto)), Toast.LENGTH_LONG).show();

                } else if (textNome.getText().toString().isEmpty()) {
                    textNome.setError("Este campo não pode estar vazio");
                } else if (textPreco.getText().toString().isEmpty()) {
                    textPreco.setError("Este campo não pode estar vazio");
                } else if (textDesconto.getText().toString().isEmpty()) {
                    textDesconto.setError("Este campo não pode estar vazio");
                }
            }
        });


    }
}
