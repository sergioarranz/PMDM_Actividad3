package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utad.sergio.milib.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {

    public RecyclerView recyclerView;

    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_messages_list, container, false);
        recyclerView=v.findViewById(R.id.msgList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

        /*ArrayList<String> mData=new ArrayList<>();
        mData.add("MENSAJE 1");
        mData.add("MENSAJE 2");
        mData.add("MENSAJE 3");
        mData.add("MENSAJE 4");*/

        //MessagesListAdapter messagesListAdapter = new MessagesListAdapter(mData);
        //recyclerView.setAdapter(messagesListAdapter);

        return v;
    }

    /*public void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter){
        recyclerView.setAdapter(adapter);
    }*/

}
