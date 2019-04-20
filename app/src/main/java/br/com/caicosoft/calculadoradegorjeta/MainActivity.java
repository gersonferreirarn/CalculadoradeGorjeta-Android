package br.com.caicosoft.calculadoradegorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvPorcentagemGorjeta;
    EditText etValor, etGorjeta, etTotal;
    SeekBar sbGorjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPorcentagemGorjeta = findViewById(R.id.tvPorcentagemGorjeta);
        etValor = findViewById(R.id.etValor);
        etGorjeta = findViewById(R.id.etGorgeta);
        etTotal = findViewById(R.id.etTotal);
        sbGorjeta = findViewById(R.id.sbGorjeta);

        sbGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                calculaGorjeta();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(etValor.getText().toString() == null || etValor.getText().toString().equals("")){
                    sbGorjeta.setProgress(0);
                    etGorjeta.setText("R$ 0.0");
                    tvPorcentagemGorjeta.setText("0%");
                    etTotal.setText("R$ 0.0");
                }
            }
        });
    }

    public void calculaGorjeta(){
        if(etValor.getText().toString() != null && !(etValor.getText().toString().equals(""))){
            Double valor = Double.parseDouble(etValor.getText().toString());
            Integer gorjeta = sbGorjeta.getProgress();
            Double valorGorjeta = (valor*gorjeta)/100;
            etGorjeta.setText("R$ "+valorGorjeta);
            tvPorcentagemGorjeta.setText(sbGorjeta.getProgress()+"%");
            etTotal.setText("R$ "+(valorGorjeta+valor));
        }
    }
}
