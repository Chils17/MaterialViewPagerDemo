package demo.webmyne.com.materialviewpagerdemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import demo.webmyne.com.materialviewpagerdemo.Model.User;
import demo.webmyne.com.materialviewpagerdemo.R;

/**
 * Created by vaibhavirana on 29-03-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int HEADER = 1;
    private int NORMAL = 2;
    private int CENTER = 3;

    private ArrayList<User> userArrayList;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*View itemView = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new ItemViewHolder(itemView);*/

        View view;

        if (viewType == HEADER) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_header, parent, false);
            return new ItemHeaderViewHolder(view);

        } else if (viewType == NORMAL) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_center, parent, false);
            return new ItemCenterViewHolder(view);

        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.imgView.setImageResource(userArrayList.get(position).getImage());
            viewHolder.textName.setText(userArrayList.get(position).getName());
            viewHolder.textdesc.setText(userArrayList.get(position).getDescript());

        } else if (holder instanceof ItemHeaderViewHolder) {
            ItemHeaderViewHolder headerViewHolder = (ItemHeaderViewHolder) holder;
            headerViewHolder.imageView.setImageResource(userArrayList.get(position).getImage());
            headerViewHolder.header_text.setText(userArrayList.get(position).getName());

        } else {
            ItemCenterViewHolder centerViewHolder = (ItemCenterViewHolder) holder;
            centerViewHolder.imageView1.setImageResource(userArrayList.get(position).getImage());
        }
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER;
        } else if (position == 1 || position == 2 || position == 3) {
            return NORMAL;
        } else {
            return CENTER;
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgView;
        private TextView textName;
        private TextView textdesc;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imgView = (ImageView) itemView.findViewById(R.id.imgView);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textdesc = (TextView) itemView.findViewById(R.id.textDesc);
        }
    }

    public class ItemHeaderViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView header_text;

        public ItemHeaderViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            header_text = (TextView) itemView.findViewById(R.id.header_text);
        }
    }

    public class ItemCenterViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView1;

        public ItemCenterViewHolder(View itemView) {
            super(itemView);
            imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);
        }
    }
}
