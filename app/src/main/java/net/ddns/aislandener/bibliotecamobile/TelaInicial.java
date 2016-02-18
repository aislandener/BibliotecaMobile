package net.ddns.aislandener.bibliotecamobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import net.ddns.aislandener.bibliotecamobile.view.Login;

public class TelaInicial extends AppCompatActivity {
    private final int TEMPOESPERA = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_tela_inicial);

        if(getActionBar() != null)
            getActionBar().hide();
         new Thread(new Runnable() {
             @Override
             public void run() {
                 SystemClock.sleep(TEMPOESPERA);
                 Intent it = new Intent(TelaInicial.this, Login.class);
                 startActivity(it);
                 finish();
             }
         }).start();
    }
}
