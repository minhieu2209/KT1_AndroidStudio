package com.example.donate.model;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.donate.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DonateAdapter extends RecyclerView.Adapter<DonateAdapter.DonateViewHolder>{

    private Context context;
    private List<Donate> dList;

    public DonateAdapter(Context context) {
        this.context = context;
        this.dList = new ArrayList<>();
    }

    @NonNull
    @Override
    public DonateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_donate, parent, false);
        return new DonateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonateViewHolder holder, int position) {
        Donate donate = dList.get(position);

        if (donate == null)
            return;

        if (donate.getGender() == 1){
            holder.img_gender.setImageResource(R.drawable.man);
            holder.cbgender.setChecked(true);
        } else{
            holder.img_gender.setImageResource(R.drawable.woman);
            holder.cbgender.setChecked(false);
        }

        holder.img_ava.setImageResource(donate.getImg_ava());
        holder.tname.setText(donate.getName());
        holder.tcity.setText(donate.getCity());
        holder.ttime.setText(donate.getTime());
        holder.tdate.setText(donate.getDate());

        holder.btremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dList.size();
    }


    public void add(Donate donate){
        dList.add(donate);
        notifyDataSetChanged();
    }

    public void add(Donate donate, int position){
        dList.set(position, donate);
        notifyDataSetChanged();
    }

    public class DonateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CircleImageView img_gender;
        private ImageView img_ava;
        private TextView tname, tcity, ttime, tdate, tdonate;
        private CheckBox cbgender;
        private Button btremove;

        public DonateViewHolder(@NonNull View view) {
            super(view);
            img_gender = view.findViewById(R.id.img_gender);
            img_ava = view.findViewById(R.id.ava);
            tname = view.findViewById(R.id.tname);
            tcity = view.findViewById(R.id.tcity);
            ttime = view.findViewById(R.id.ttime);
            tdate = view.findViewById(R.id.tdate);
            tdonate = view.findViewById(R.id.tdonate);
            cbgender = view.findViewById(R.id.cbgender);
            btremove = view.findViewById(R.id.btremove);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
