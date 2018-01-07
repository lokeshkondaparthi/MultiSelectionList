package house.com.multiselectionlist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import house.com.multiselectionlist.models.IdNameModel;
import house.com.multiselectionlist.models.OnItemsSelectorListener;
import house.com.multiselectionlist.models.OnListInDilogClickedItemListener;

/**
 * Created by welcome on 1/7/2018.
 */

public class Utility {
    public static void initiateMultiSelectionDialog(final OnItemsSelectorListener onItemsSelectorListener,
                                                    final Context context,
                                                    final List<IdNameModel> list,
                                                    String title){

        AlertDialog.Builder dialog = new AlertDialog.Builder(context,R.style.MultiDialogStyle);
        final ListView listView = new ListView(context);
        final ListAdapter adapter = new ListAdapter(context,list, new OnListInDilogClickedItemListener() {
            @Override
            public void onItemClick(int position, View view) {
                if(list.get(position).isChecked())
                    list.get(position).setChecked(false);
                else
                    list.get(position).setChecked(true);

            }
        });
        listView.setAdapter(adapter);
        dialog.setTitle(title);
        dialog.setView(listView);
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                List<IdNameModel> idNameModelList = new ArrayList<>();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if(list.get(i2).isChecked())
                        idNameModelList.add(list.get(i2));
                }
                onItemsSelectorListener.onItemsSelected(idNameModelList);
                dialogInterface.dismiss();
            }
        });
        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onItemsSelectorListener.onCancelClicked(true);
                dialogInterface.dismiss();
            }
        });
        dialog.create().getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(context,R.color.colorAccent));

        dialog.show();
    }
}
