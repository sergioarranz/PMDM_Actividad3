package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utad.sergio.milib.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesListFragment extends Fragment {

    public RecyclerView recyclerView;

    public MessagesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_messages_list, container, false);
        recyclerView=v.findViewById(R.id.msgList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        MessagesListAdapter messagesListAdapter = new MessagesListAdapter();
        recyclerView.setAdapter(messagesListAdapter);

        return v;
    }

}
