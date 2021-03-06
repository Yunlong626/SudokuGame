package com.example.sudoku.recycleutil;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sudoku.R;
import com.example.sudoku.RecordBitmap;

import java.util.List;

public class RecordViewAdapter extends RecyclerView.Adapter<RecordViewAdapter.ViewHolder> {
    public List<RecordBitmap> myRecords;
    public static final int[] level_resource=new int[]{R.drawable.level_easy,R.drawable.level_normal,R.drawable.level_dif};
    public RecordViewAdapter(List<RecordBitmap> list){
        myRecords=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sing_record,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (myRecords.size() != 0) {
            RecordBitmap record = myRecords.get(position);
            if (record != null) {
                holder.comp_time.setText(record.getCompletedate());
                holder.comp_date.setText(record.getDate());
                holder.img_origin.setImageURI(Uri.parse(record.getOriginurl()));
                holder.img_answer.setImageURI(Uri.parse(record.getAnswerurl()));
                holder.img_level.setImageResource(level_resource[record.getLevel() - 1]);
            }
        }
    }

    @Override
    public int getItemCount() {
        return myRecords.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_origin;
        private ImageView img_answer;
        private TextView comp_time;
        private TextView comp_date;
        private ImageView img_level;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_origin=itemView.findViewById(R.id.record_img_origin);
            img_answer=itemView.findViewById(R.id.record_img_answer);
            comp_time=itemView.findViewById(R.id.record_time);
            comp_date=itemView.findViewById(R.id.record_date);
            img_level=itemView.findViewById(R.id.img_level);

        }
    }
}
