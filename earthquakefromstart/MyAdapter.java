package com.example.earthquakefromstart;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;

public class MyAdapter extends Adapter<MyViewHolder> {
    public ArrayList<Item> mArrayList;
    FragmentB mContext;

    public static class MyViewHolder extends ViewHolder {
        public CardView cardView;
        public TextView date;
        public TextView loc1;
        public TextView loc2;
        public TextView mag;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.mag = (TextView) itemView.findViewById(C1019R.C1022id.mag);
            this.loc1 = (TextView) itemView.findViewById(C1019R.C1022id.loc1);
            this.loc2 = (TextView) itemView.findViewById(C1019R.C1022id.loc2);
            this.date = (TextView) itemView.findViewById(C1019R.C1022id.date);
            this.cardView = (CardView) itemView.findViewById(C1019R.C1022id.card);
        }
    }

    public MyAdapter(FragmentB context, ArrayList<Item> arrayList) {
        this.mArrayList = arrayList;
        this.mContext = context;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(C1019R.layout.itemcardview, parent, false));
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Item item = (Item) this.mArrayList.get(position);
        holder.mag.setText(item.getMagnitude());
        holder.loc1.setText(item.getLocation1());
        holder.loc2.setText(item.getLocation2());
        holder.date.setText(item.getDate());
        holder.cardView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MyAdapter.this.mContext.getContext(), detailActivity.class);
                String str = "Latitude";
                String str2 = "Longitude";
                String str3 = "magnitude";
                String str4 = "date";
                String str5 = "status";
                String str6 = "depth";
                String str7 = "alert";
                String str8 = "forwardtitle";
                intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, item.getLocation2()).putExtra(str, item.getLatitude()).putExtra(str2, item.getLongitude()).putExtra(str3, item.getMagnitude()).putExtra(str4, item.getDate()).putExtra(str5, item.getStatus()).putExtra(str6, item.getDepth()).putExtra(PlusShare.KEY_CALL_TO_ACTION_URL, item.getUrl()).putExtra(str7, item.getAlert()).putExtra(str8, item.getLocation1());
                MyAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.mArrayList.size();
    }
}
