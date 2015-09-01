package app.tworoomsandaboom.tuesdayknightgames.com.timer;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RoundSettingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RoundSettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoundSettingFragment extends Fragment {

    // the fragment initialization parameters
    private static final String NUM_MINUTES = "numMinutes";
    private static final String NUM_HOSTAGES = "numHostages";

    private NumberPicker mNumMinutesPicker;
    private NumberPicker mNumHostagesPicker;

    private int mNumMinutes;
    private int mNumHostages;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param numMinutes Number of minutes for the round
     * @param numHostages Number of hostages for the round
     * @return A new instance of fragment RoundSettingFragment.
     */
    public static RoundSettingFragment newInstance(int numMinutes, int numHostages) {
        RoundSettingFragment fragment = new RoundSettingFragment();
        Bundle args = new Bundle();
        args.putInt(NUM_MINUTES, numMinutes);
        args.putInt(NUM_HOSTAGES, numHostages);
        fragment.setArguments(args);
        return fragment;
    }

    public RoundSettingFragment() {
        // Required empty public constructor
    }

    public GameSettings.RoundSettings getRoundSettings() {
        return new GameSettings.RoundSettings(
                mNumMinutesPicker.getValue(),
                mNumHostagesPicker.getValue());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNumMinutes = getArguments().getInt(NUM_MINUTES);
            mNumHostages = getArguments().getInt(NUM_HOSTAGES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_round_setting, container, false);
        mNumMinutesPicker = (NumberPicker) view.findViewById(R.id.num_minute_picker);
        mNumHostagesPicker = (NumberPicker) view.findViewById(R.id.num_hostage_picker);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        public void onFragmentInteraction(Uri uri);
    }

}
