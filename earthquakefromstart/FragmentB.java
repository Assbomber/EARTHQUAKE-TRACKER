package com.example.earthquakefromstart;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class FragmentB extends Fragment {
    public static ArrayList<Item> arrayList = new ArrayList<>();
    public static int[] counts = new int[4];
    TextView day;
    TextView hour;
    LayoutManager layoutManager;
    MyAdapter mAdapter;
    Context mContext;
    TextView month;
    RecyclerView recyclerView;
    TextView week;

    public FragmentB(Context context) throws MalformedURLException {
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C1019R.layout.fragment_b, container, false);
        this.hour = (TextView) v.findViewById(C1019R.C1022id.pasthourcount);
        this.day = (TextView) v.findViewById(C1019R.C1022id.pastdaycount);
        this.week = (TextView) v.findViewById(C1019R.C1022id.past7dayscount);
        this.month = (TextView) v.findViewById(C1019R.C1022id.past30dayscount);
        TextView textView = this.hour;
        StringBuilder sb = new StringBuilder();
        sb.append(counts[0]);
        String str = "";
        sb.append(str);
        textView.setText(sb.toString());
        TextView textView2 = this.day;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(counts[1]);
        sb2.append(str);
        textView2.setText(sb2.toString());
        TextView textView3 = this.week;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(counts[2]);
        sb3.append(str);
        textView3.setText(sb3.toString());
        TextView textView4 = this.month;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(counts[3]);
        sb4.append(str);
        textView4.setText(sb4.toString());
        this.mAdapter = new MyAdapter(this, arrayList);
        this.layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView2 = (RecyclerView) v.findViewById(C1019R.C1022id.recyclerview);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(this.layoutManager);
        this.recyclerView.setAdapter(this.mAdapter);
        return v;
    }
}
