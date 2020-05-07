package com.example.th112;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SettingsFragment extends Fragment {

    EditText Fontti;
    EditText Leveys;
    EditText Rivit;
    EditText Väri;
    Button button;
    ArrayList<String> lista = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = getView().findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fontti = getView().findViewById(R.id.editText1);
                Leveys = getView().findViewById(R.id.editText2);
                Rivit = getView().findViewById(R.id.editText4);
                Väri = getView().findViewById(R.id.editText3);

                String fonttiS = Fontti.getText().toString();
                String leveysS = Leveys.getText().toString();
                String rivitS = Rivit.getText().toString();
                String väriS = Väri.getText().toString();

                lista.add(fonttiS);
                lista.add(leveysS);
                lista.add(rivitS);
                lista.add(väriS);
                ((MainActivity) getActivity()).editTextView();
                System.out.println("lisäys onnistui, vika teksti");

            }
        });
    }

    public ArrayList<String> sendInfo (){
        System.out.println("Lähettäminen onnistui");
        return lista;
    }
}
