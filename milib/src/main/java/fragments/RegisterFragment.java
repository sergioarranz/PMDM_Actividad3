package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.utad.sergio.milib.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    public EditText etUserReg,etPassReg;
    public Button btnCancel,btnAcc;
    public RegisterFragmentListener listener;

    public RegisterFragment() {
        // Required empty public constructor
    }

    public void setListener(RegisterFragmentListener listener){
        this.listener=listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        etUserReg=v.findViewById(R.id.etUserReg);
        etPassReg=v.findViewById(R.id.etPassReg);
        btnAcc=v.findViewById(R.id.btnAcc);
        btnCancel=v.findViewById(R.id.btnCancel);

        RegisterFragmentEvents events = new RegisterFragmentEvents(this);
        btnAcc.setOnClickListener(events);
        btnCancel.setOnClickListener(events);
        return v;
    }

}

class RegisterFragmentEvents implements View.OnClickListener {

    RegisterFragment registerFragment;

    public RegisterFragmentEvents(RegisterFragment registerFragment){
        this.registerFragment=registerFragment;
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==this.registerFragment.btnAcc.getId()){

            this.registerFragment.listener.OnRegisterFragmentBtnAccClicked(
                    registerFragment.etUserReg.getText().toString(),
                    registerFragment.etPassReg.getText().toString());

        }else if(view.getId()==this.registerFragment.btnCancel.getId()){
            this.registerFragment.listener.OnRegisterFragmentBtnCancelClicked();
        }
    }
}
