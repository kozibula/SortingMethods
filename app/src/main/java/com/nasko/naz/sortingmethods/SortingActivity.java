package com.nasko.naz.sortingmethods;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.nasko.naz.sortingmethods.R.id.six_edit_text;


public class SortingActivity extends Activity {

    EditText elementOneEditText;
    EditText elementTwoEditText;
    EditText elementThreeEditText;
    EditText elementFourEditText;
    EditText elementFiveEditText;
    EditText elementSixEditText;
    TextView sortedArrayTextView;
    TextView sortingMethodMessage;
    TextView functionTextView;
    ImageView functionImageView;
    private static String chosenMethod;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sorting_layout);
        Intent sortingIntent = getIntent();
        String sortingMethod = sortingIntent.getExtras().getString("sortingMethod");

        elementOneEditText = (EditText) findViewById(R.id.one_edit_text);
        elementTwoEditText = (EditText) findViewById(R.id.two_edit_text);
        elementThreeEditText = (EditText) findViewById(R.id.three_edit_text);
        elementFourEditText = (EditText) findViewById(R.id.four_edit_text);
        elementFiveEditText = (EditText) findViewById(R.id.five_edit_text);
        elementSixEditText = (EditText) findViewById(R.id.six_edit_text);
        sortedArrayTextView = (TextView) findViewById(R.id.sorted_array_text);
        sortingMethodMessage = (TextView) findViewById(R.id.sorting_method_text);
        functionTextView = (TextView) findViewById(R.id.function_text);
        functionImageView = (ImageView) findViewById(R.id.function_image);

        sortingMethodMessage.append(" " + sortingMethod);

        chosenMethod = sortingMethod;

        if (chosenMethod.toLowerCase().matches("bubble")) {
            getActionBar().setTitle("   " + getString(R.string.button_bubble));
        } else if (chosenMethod.toLowerCase().matches("insertion")) {
            getActionBar().setTitle("   " + getString(R.string.button_insertion));
        } else if (chosenMethod.toLowerCase().matches("selection")) {
            getActionBar().setTitle("   " + getString(R.string.button_selection));
        }
    }

    public void onSortButtonClick(View view) {

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        if (elementOneEditText.getText().toString().trim().equals("") ||
                elementTwoEditText.getText().toString().trim().equals("") ||
                elementThreeEditText.getText().toString().trim().equals("") ||
                elementFourEditText.getText().toString().trim().equals("") ||
                elementFiveEditText.getText().toString().trim().equals("") ||
                elementSixEditText.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "All fields are required!", Toast.LENGTH_LONG).show();
        } else {

            try {
                int elementOne = Integer.valueOf(elementOneEditText.getText().toString());
                int elementTwo = Integer.valueOf(elementTwoEditText.getText().toString());
                int elementThree = Integer.valueOf(elementThreeEditText.getText().toString());
                int elementFour = Integer.valueOf(elementFourEditText.getText().toString());
                int elementFive = Integer.valueOf(elementFiveEditText.getText().toString());
                int elementSix = Integer.valueOf(elementSixEditText.getText().toString());
                int[] numbers = {elementOne, elementTwo, elementThree, elementFour, elementFive, elementSix};

                if (chosenMethod.toLowerCase().matches("bubble")) {
                    bubbleSortMethod(numbers);
                    functionTextView.setText(R.string.bubble_sort_function);
                    functionImageView.setImageResource(R.drawable.bubble_sort);
                } else if (chosenMethod.toLowerCase().matches("insertion")) {
                    insertionSortMethod(numbers);
                    functionTextView.setText(R.string.insertion_sort_function);
                    functionImageView.setImageResource(R.drawable.insertion_sort);
                } else if (chosenMethod.toLowerCase().matches("selection")) {
                    selectionSortMethod(numbers);
                    functionTextView.setText(R.string.selection_sort_function);
                    functionImageView.setImageResource(R.drawable.selection_sort);
                }

                sortedArrayTextView.setText(numbers[0] + ", " + numbers[1] + ", " + numbers[2] + ", " + numbers[3] + ", " +
                        numbers[4] + ", " + numbers[5]);

            } catch (Exception e) {
            }
        }
    }

    public void bubbleSortMethod(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public void selectionSortMethod(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int index_of_min = i;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[index_of_min] > numbers[j]) {
                    index_of_min = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[index_of_min];
            numbers[index_of_min] = temp;
        }
    }

    public void insertionSortMethod(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {
            int temp = numbers[i];
            int j = i;
            while (j > 0 && numbers[j - 1] > temp) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = temp;
        }
    }
}
