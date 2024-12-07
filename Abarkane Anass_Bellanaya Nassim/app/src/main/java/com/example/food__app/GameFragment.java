package com.example.food__app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameFragment extends Fragment {

    private EditText inputNumber;
    private Button checkButton;
    private Button resetButton;
    private TextView resultTextView;
    private int secretNumber;

    public GameFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        inputNumber = view.findViewById(R.id.inputNumber);
        checkButton = view.findViewById(R.id.checkButton);
        resetButton = view.findViewById(R.id.resetButton);
        resultTextView = view.findViewById(R.id.resultTextView);

        generateSecretNumber();

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        return view;
    }

    private void generateSecretNumber() {
        secretNumber = (int) (Math.random() * 900) + 100; // Generate a random 3-digit number
    }

    private void checkGuess() {
        String guess = inputNumber.getText().toString();
        if (guess.length() == 3) {
            int guessNumber = Integer.parseInt(guess);
            if (guessNumber == secretNumber) {
                resultTextView.setText("Félicitations ! Vous avez deviné le bon numéro.");
            } else {
                resultTextView.setText("Réessayez !");
            }
        } else {
            resultTextView.setText("Veuillez entrer un nombre de 3 chiffres.");
        }
        resultTextView.setVisibility(View.VISIBLE);
    }

    private void resetGame() {
        generateSecretNumber();
        inputNumber.setText("");
        resultTextView.setText("");
        resultTextView.setVisibility(View.GONE);
    }
}
