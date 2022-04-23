package com.example.watchtracker.viewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.watchtracker.R;

public class MessageListBaseAdapter extends BaseAdapter {

    Context context;
    String personsName[];
    String personsLastMessage[];
    int personsProfilePicture[];
    LayoutInflater inflater;


    public MessageListBaseAdapter(Context context, String[] personsName, String[] personsLastMessage, int [] personsProfilePicture)
    {
        this.personsName = personsName;
        this.personsLastMessage = personsLastMessage;
        this.personsProfilePicture = personsProfilePicture;
        this.context = context;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return personsName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_message_item, null);
        TextView personsNameView = (TextView) view.findViewById(R.id.show_name);
        TextView personsLastMsg = (TextView) view.findViewById(R.id.episode_name);
        ImageView imageView = (ImageView) view.findViewById(R.id.show_image);
        personsNameView.setText(personsName[i]);
        personsLastMsg.setText(personsLastMessage[i]);
        imageView.setImageResource(personsProfilePicture[i]);
        return view;
    }
}
