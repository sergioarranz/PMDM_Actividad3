package fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utad.sergio.milib.R;

import java.util.ArrayList;

/**
 * Created by sergio on 18/12/17.
 */

public class MessagesListAdapter extends RecyclerView.Adapter<MessagesViewHolder> {

    private ArrayList<String> messages;

    public MessagesListAdapter(ArrayList<String> messages){
        this.messages=messages;
    }
    @Override
    public MessagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos XML de la Celda
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_cell_layout,null);
        MessagesViewHolder messagesViewHolder = new MessagesViewHolder(view);
        return messagesViewHolder;
    }

    @Override
    public void onBindViewHolder(MessagesViewHolder holder, int position) {
        holder.txtMsg.setText(messages.get(position));
    }

    @Override
    public int getItemCount() {

        return messages.size();
    }
}

class MessagesViewHolder extends RecyclerView.ViewHolder {

    public TextView txtMsg;

    public MessagesViewHolder(View itemView) {

        super(itemView);
        txtMsg=itemView.findViewById(R.id.txtMsg);
    }
}