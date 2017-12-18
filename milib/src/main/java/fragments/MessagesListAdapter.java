package fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utad.sergio.milib.R;

/**
 * Created by sergio on 18/12/17.
 */

public class MessagesListAdapter extends RecyclerView.Adapter<MessagesViewHolder> {
    @Override
    public MessagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos XML de la Celda
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_cell_layout,null);
        MessagesViewHolder messagesViewHolder = new MessagesViewHolder(view);
        return messagesViewHolder;
    }

    @Override
    public void onBindViewHolder(MessagesViewHolder holder, int position) {
        holder.txtMsg.setText("POSICION "+position);
    }

    @Override
    public int getItemCount() {

        return 5;
    }
}

class MessagesViewHolder extends RecyclerView.ViewHolder {

    public TextView txtMsg;

    public MessagesViewHolder(View itemView) {

        super(itemView);
        txtMsg=itemView.findViewById(R.id.txtMsg);
    }
}