package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.utad.sergio.milib.R;

public class LoginFragment extends Fragment {

    public EditText etUser,etPass;
    public Button btnReg,btnLog;
    public LoginFragmentListener listener;
    public LoginFragmentEvents events; // Inicializa la clase para definirla como encargada de gestión de eventos

    public LoginFragment() {
        // Required empty public constructor
    }

    public void setListener(LoginFragmentListener listener){
        this.listener=listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        // Vinculación de elementos visuales con el código
        etUser=v.findViewById(R.id.etUser);
        etPass=v.findViewById(R.id.etPass);
        btnLog=v.findViewById(R.id.btnLog);
        btnReg=v.findViewById(R.id.btnReg);
        events=new LoginFragmentEvents(this); // Centraliza los eventos en la clase posterior
        // Definimos que la clase LFEvents se encargará de los listeners de los botones
        btnLog.setOnClickListener(events);
        btnReg.setOnClickListener(events);

        return v;
    }

}

// Clase encargada de gestión de eventos en el Login compatibilizando OnClickListener
class LoginFragmentEvents implements View.OnClickListener {

    private LoginFragment loginFragment;

    // Constructor pasando como referencia la clase principal para trabajar con sus elementos
    public LoginFragmentEvents(LoginFragment fragment){
        this.loginFragment=fragment;
    }
    @Override
    public void onClick(View view) {
        // Notificamos al MainActivityEvents que se han ejecutado estos métodos
        if (view.getId()==this.loginFragment.btnLog.getId()){
            // Pasamos como parámetros User & Pass introducidos para usarlos donde se gestionará finalmente el evento
            this.loginFragment.listener.OnLogFragmentBtnClicked(
                    this.loginFragment.etUser.getText().toString(),
                    this.loginFragment.etPass.getText().toString());
        } else if (view.getId()==this.loginFragment.btnReg.getId()){
            this.loginFragment.listener.OnRegFragmentBtnClicked();
        }
    }
}


