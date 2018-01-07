package house.com.multiselectionlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;

import java.net.IDN;
import java.util.List;

import house.com.multiselectionlist.models.IdNameModel;
import house.com.multiselectionlist.models.OnListInDilogClickedItemListener;

/**
 * Created by welcome on 1/7/2018.
 */

public class ListAdapter extends BaseAdapter implements android.widget.ListAdapter{
    private Context context;
    private List<IdNameModel> list;
    private LayoutInflater inflater;
    private OnListInDilogClickedItemListener  onListInDilogClickedItemListener;
    public ListAdapter(Context context, List<IdNameModel> list,OnListInDilogClickedItemListener  onListInDilogClickedItemListener) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.onListInDilogClickedItemListener = onListInDilogClickedItemListener;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder  holder;
        if (view == null) {
            view = inflater.inflate(R.layout.layout_inflator,null);
            holder = new ViewHolder();
            holder.mTV = view.findViewById(R.id.textView);
            holder.mCB = view.findViewById(R.id.checkbox);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.mTV.setText(list.get(i).getName());
        if(list.get(i).isChecked())
            holder.mCB.setChecked(true);
        else
            holder.mCB.setChecked(false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onListInDilogClickedItemListener.onItemClick(i,view);
                notifyDataSetChanged();
            }
        });
        return view;
    }
    private class ViewHolder {
        TextView mTV;
        CheckBox mCB;
    }
}
