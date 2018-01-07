package house.com.multiselectionlist.models;

import java.util.List;

/**
 * Created by welcome on 1/7/2018.
 */

public interface OnItemsSelectorListener {
    void onItemsSelected(List<IdNameModel> selectedModelList);
    void onCancelClicked(boolean closed);
}
