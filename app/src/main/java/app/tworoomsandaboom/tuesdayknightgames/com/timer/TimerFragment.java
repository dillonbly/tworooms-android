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
    private RoundTimer mRoundTimer;
    private ImageButton mForwardBtn;
    private ImageButton mBackButton;

    public TimerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRoundTimer = new RoundTimer(3);

        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        mCountDownText = (TextView) view.findViewById(R.id.countDownText);

        mGoBtn = (ImageButton) view.findViewById(R.id.go_btn);
        mGoBtn.setOnClickListener(new GoButtonAction());

        mBackButton = (ImageButton) view.findViewById(R.id.back_btn);
        mBackButton.setOnClickListener(new BackButtonAction());

        mForwardBtn = (ImageButton) view.findViewById(R.id.forward_btn);
        mForwardBtn.setOnClickListener(new ForwardButtonAction());

        return view;
    }

    private class RoundTimer {
        private final int minutes;
        private long millisRemaining;
        private CountDownTimer activeTimer;
        private boolean started;

        RoundTimer(int minutes) {
            this.minutes = minutes;
            this.millisRemaining = minutes * 60 * 1000;
        }

        void start() {
            activeTimer = new CountDownTimer(millisRemaining, 100) {
                @Override public void onTick(long millisUntilFinished) {
                    millisRemaining = millisUntilFinished;
                    updateCountDownText(millisUntilFinished);
                }

                @Override public void onFinish() {
                    Toast toast = Toast.makeText(getActivity(), "Time's up!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }.start();
            this.started = true;
        }

        void pause() {
            activeTimer.cancel();
            this.started = false;
        }

        void reset() {
            this.millisRemaining = minutes * 60 * 1000;
            updateCountDownText(this.millisRemaining);
            this.started = false;
        }

        void updateCountDownText(long millisRemaining) {
            long secondsRemaining = millisRemaining / 1000;
            mCountDownText.setText(String.format("\n\n%d:%02d", secondsRemaining / 60, secondsRemaining % 60));
        }
    }

    private class GoButtonAction implements View.OnClickListener {
        @Override public void onClick(View v) {
            if (mRoundTimer.started) {
                mRoundTimer.pause();
                Toast toast = Toast.makeText(getActivity(), "Paused", Toast.LENGTH_LONG);
                toast.show();
            } else {
                mRoundTimer.start();
                Toast toast = Toast.makeText(getActivity(), "Start!", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    private class ForwardButtonAction implements View.OnClickListener {
        @Override
        public void onClick(View v) {
        }
    }

    private class BackButtonAction implements View.OnClickListener {
        @Override
        public void onClick(View v) {
        }
    }
}
