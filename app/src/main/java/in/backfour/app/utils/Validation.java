package in.backfour.app.utils;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import in.backfour.app.R;

public class Validation {

    public static boolean validateEmail(EditText emailEditText,TextInputLayout emailLayout, Activity activity) {
        String email = emailEditText.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            emailLayout.setError("InValid Email");
           // Toast.makeText(activity,"InValid Email",Toast.LENGTH_LONG).show();
            requestFocus(emailEditText, activity);
            return false;
        }else {
            emailLayout.setErrorEnabled(false);
        }
        return true;
    }
    public static boolean validName(EditText nameEditText,TextInputLayout nameLayout, Activity activity) {
        String name = nameEditText.getText().toString().trim();

        if (name.isEmpty() || !isValidName(name)) {
            nameLayout.setError("InValid Name");
            requestFocus(nameEditText, activity);
            return false;
        }else {
            nameLayout.setErrorEnabled(false);
        }
        return true;
    }

    public static boolean isValidName(String name) {
        String regx = "^[\\p{L} .'-]+$";

        return !TextUtils.isEmpty(name) && name.matches(regx);
    }
    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    public static void requestFocus(View view, Activity activity) {
        if (view.requestFocus()) {
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
