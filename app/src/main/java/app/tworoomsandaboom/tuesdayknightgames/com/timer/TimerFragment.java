package app.tworoomsandaboom.tuesdayknightgames.com.timer;

import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Contains the countdown timer and controls.
 */
public class TimerFragment extends Fragment {

    private TextView mCountDownText;
    private ImageButton mGoBtn;
    private CountDownTimer mCountDownTimer;

    public TimerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mCountDownTimer = new CountDownTimer(5 * 60 * 1000, 100) {
            @Override public void onTick(long millisUntilFinished) {
                long secondsRemaining = millisUntilFinished / 1000;
                mCountDownText.setText(String.format("%d:%02d", secondsRemaining / 60, secondsRemaining % 60));
            }

            @Override public void onFinish() {
                Toast toast = Toast.makeText(getActivity(), "Times up!", Toast.LENGTH_LONG);
                toast.show();
            }
        };

        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        mCountDownText = (TextView) view.findViewById(R.id.countDownText);

        mGoBtn = (ImageButton) view.findViewById(R.id.go_btn);
        mGoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startTimer();
                Toast toast = Toast.makeText(getActivity(), "Start!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        final ImageButton backBtn = (ImageButton) view.findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });

        final ImageButton forwardBtn = (ImageButton) view.findViewById(R.id.forward_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });

        return view;
    }

    private void startTimer() {
        mCountDownTimer.start();
    }

}
