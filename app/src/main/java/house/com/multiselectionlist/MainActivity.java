package house.com.multiselectionlist;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import house.com.multiselectionlist.models.IdNameModel;
import house.com.multiselectionlist.models.OnItemsSelectorListener;

public class MainActivity extends AppCompatActivity {

    private List<IdNameModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();

        createIdNameModelList();

    }
    public void createIdNameModelList(){
        for (int i = 0; i < 20 ; i++) {
            IdNameModel model = new IdNameModel();
            model.setId(i);
            model.setName("Row "+i);
            if(i%3 == 0)
                model.setChecked(true);
            else
                model.setChecked(false);
            list.add(model);
        }
    }
    public void showDialog(View view){
        Utility.initiateMultiSelectionDialog(new OnItemsSelectorListener() {
            @Override
            public void onItemsSelected(List<IdNameModel> selectedModelList) {
                for (int i = 0; i <selectedModelList.size() ; i++) {
                    Log.d("MainActivity", "onItemsSelected: "+selectedModelList.get(i).getName());
                }
            }

            @Override
            public void onCancelClicked(boolean closed) {

            }
        }, this,list,"Multi selection dialog");
    }
}
