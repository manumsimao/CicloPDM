package com.ifsp.pdm.emanoela.ciclopdm;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ifsp.pdm.emanoela.ciclopdm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //constante de filtro do LogCat
    private final String CICLO_PDM_TAG = "CICLO_PDM_TAG";

    private final String TELEFONE = "TELEFONE";

    private ActivityMainBinding activityMainBinding;

    private TextView telefoneTV;
    private EditText telefoneET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        telefoneTV = new TextView(this);
        telefoneTV.setText("Telefone");
        telefoneET = new EditText(this);
        telefoneET.setInputType(InputType.TYPE_CLASS_PHONE);

        activityMainBinding.linearLayout.addView(telefoneTV);
        activityMainBinding.linearLayout.addView(telefoneET);

        Log.v(CICLO_PDM_TAG, "onCreate: Iniciando ciclo COMPLETO");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(CICLO_PDM_TAG, "onStart: Iniciando ciclo VISÍVEL");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(CICLO_PDM_TAG, "onResume: Iniciando ciclo em PRIMEIRO PLANO");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(CICLO_PDM_TAG, "onPause: Finalizando ciclo em PRIMEIRO PLANO");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(CICLO_PDM_TAG, "onStop: Finalizando ciclo VISÍVEL");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(CICLO_PDM_TAG, "onDestroy: Finalizando ciclo VISÍVEL");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(CICLO_PDM_TAG, "onRestart: Preparando para chamar o onStart");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TELEFONE, telefoneET.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        telefoneET.setText(savedInstanceState.getString(TELEFONE, ""));
    }
}