package demo.webmyne.com.materialviewpagerdemo.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import demo.webmyne.com.materialviewpagerdemo.Adapter.RecyclerViewAdapter;
import demo.webmyne.com.materialviewpagerdemo.Model.User;
import demo.webmyne.com.materialviewpagerdemo.R;

/**
 * Created by vaibhavirana on 29-03-2017.
 */

@SuppressLint("ValidFragment")
public class DummyFragment extends Fragment {
    private View view;
    ArrayList<User> userArrayList;

    private String title;//String for tab title

    private RecyclerView recyclerView;

    @SuppressLint("ValidFragment")
    public DummyFragment(String title) {
        this.title = title;//Setting tab title
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dummy_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        setRecyclerView();

        return view;

    }

    //Setting recycler view
    private void setRecyclerView() {

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 6);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 6;
                } else if (position == 1||position == 2||position == 3) {
                    return 2;
                } else {
                    return 3;
                }
            }
        });
        // Attach the layout manager to the recycler view
        recyclerView.setLayoutManager(manager);

        //RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
        //recyclerView.addItemDecoration(itemDecoration);

        userArrayList = new ArrayList<>();

       /* for (int i = 1; i <= 50; i++) {
            User user = new User();
            user.setImage(R.drawable.apple);
            user.setName("Chirag");
            user.setDescript("Navsari");
            userArrayList.add(user);
        }*/

        userArrayList.add(new User(R.drawable.event, getActivity().getString(R.string.event), "Beauty with beast"));
        userArrayList.add(new User(R.drawable.six, getActivity().getString(R.string.event), "Beauty with beast"));
        userArrayList.add(new User(R.drawable.five, getActivity().getString(R.string.event), "Beauty with beast"));
        userArrayList.add(new User(R.drawable.four, getActivity().getString(R.string.event), "Beauty with beast"));

        userArrayList.add(new User(R.drawable.one, getActivity().getString(R.string.natural), getActivity().getString(R.string.Beautywithbeast)));
        userArrayList.add(new User(R.drawable.two, getActivity().getString(R.string.natural), getActivity().getString(R.string.RiverArea)));
        userArrayList.add(new User(R.drawable.three, getActivity().getString(R.string.natural), getActivity().getString(R.string.Forestarea)));
        userArrayList.add(new User(R.drawable.four, getActivity().getString(R.string.natural), getActivity().getString(R.string.MountainSnows)));
        userArrayList.add(new User(R.drawable.five, getActivity().getString(R.string.natural), getActivity().getString(R.string.Mountain)));
        userArrayList.add(new User(R.drawable.six, getActivity().getString(R.string.natural), getActivity().getString(R.string.BunchesofTrees)));

        userArrayList.add(new User(R.drawable.one, getActivity().getString(R.string.natural), getActivity().getString(R.string.Beautywithbeast)));
        userArrayList.add(new User(R.drawable.two, getActivity().getString(R.string.natural), getActivity().getString(R.string.RiverArea)));
        userArrayList.add(new User(R.drawable.three, getActivity().getString(R.string.natural), getActivity().getString(R.string.Forestarea)));
        userArrayList.add(new User(R.drawable.four, getActivity().getString(R.string.natural), getActivity().getString(R.string.MountainSnows)));
        userArrayList.add(new User(R.drawable.five, getActivity().getString(R.string.natural), getActivity().getString(R.string.Mountain)));
        userArrayList.add(new User(R.drawable.six, getActivity().getString(R.string.natural), getActivity().getString(R.string.BunchesofTrees)));

        userArrayList.add(new User(R.drawable.one, getActivity().getString(R.string.natural), getActivity().getString(R.string.Beautywithbeast)));
        userArrayList.add(new User(R.drawable.two, getActivity().getString(R.string.natural), getActivity().getString(R.string.RiverArea)));
        userArrayList.add(new User(R.drawable.three, getActivity().getString(R.string.natural), getActivity().getString(R.string.Forestarea)));
        userArrayList.add(new User(R.drawable.four, getActivity().getString(R.string.natural), getActivity().getString(R.string.MountainSnows)));
        userArrayList.add(new User(R.drawable.five, getActivity().getString(R.string.natural), getActivity().getString(R.string.Mountain)));
        userArrayList.add(new User(R.drawable.six, getActivity().getString(R.string.natural), getActivity().getString(R.string.BunchesofTrees)));


       /* for (int i = 0; i < 20; i++) {
            arrayList.add(title + " Items " + i);//Adding items to recycler view
        }*/
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), userArrayList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        recyclerView.setHasFixedSize(true);

    }
}
