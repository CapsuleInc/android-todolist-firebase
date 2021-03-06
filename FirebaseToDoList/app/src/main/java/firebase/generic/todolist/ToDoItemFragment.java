package firebase.generic.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.Firebase;

import firebasetodolist.todolist.firebase.com.R;


import firebasetodolist.todolist.firebase.com.firebase.FirebaseHandler;


public class ToDoItemFragment extends ListFragment {



    private OnFragmentInteractionListener mListener;
    private ToDoItemListAdapter mToDoItemListAdapter;
    private Firebase todoItemFirebaseRef;

    public ToDoItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        todoItemFirebaseRef = FirebaseHandler.getInstance().getFirebaseRef("todos");
        mToDoItemListAdapter = new ToDoItemListAdapter(todoItemFirebaseRef,R.layout.fragment_to_do_list2,getActivity());
        setListAdapter(mToDoItemListAdapter);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (null != mListener) {
            //mListener.onFragmentInteraction(DummyContent.ITEMS.get(position).id);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }


    protected void addItem(ToDoItem toDoItem){
        mToDoItemListAdapter.addToDo(toDoItem);
    }

}
