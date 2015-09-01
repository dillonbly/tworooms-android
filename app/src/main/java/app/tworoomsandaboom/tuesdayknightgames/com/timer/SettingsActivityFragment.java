package app.tworoomsandaboom.tuesdayknightgames.com.timer;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;


/**
 * Fragment for changing round settings.
 */
public class SettingsActivityFragment extends Fragment {

    private Spinner mNumRoundsSpinner;
    private GameSettings gameSettings;

    public SettingsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        mNumRoundsSpinner = (Spinner) view.findViewById(R.id.num_round_spinner);

        Spinner spinner = (Spinner) view.findViewById(R.id.num_round_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.round_options, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeRounds(((int) id) - 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    private void changeRounds(int numRounds) {
        gameSettings = gameSettings.toBuilder().setRounds(numRounds).build();
    }



}
