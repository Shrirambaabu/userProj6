package in.backfour.app.ui.activities.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import in.backfour.app.R;
import in.backfour.app.base.ActivityContext;
import in.backfour.app.ui.activities.dashboard.DashboardActivity;
import in.backfour.app.ui.activities.register.RegisterActivity;
import in.backfour.app.utils.Validation;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {


    @BindView(R.id.email_login)
    EditText emailText;
    @BindView(R.id.password)
    EditText passwordText;
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.coordinate_layout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.relative_main)
    RelativeLayout relativeLayout;
    @BindView(R.id.email_layout)
    TextInputLayout emailLayout;
    @BindView(R.id.password_layout)
    TextInputLayout passwordLayout;
    @Inject
    LoginPresenter loginPresenter;

    private Context mContext = LoginActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


        DaggerLoginComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        loginPresenter.attach(this);

    }

    @OnClick(R.id.login_button)
    public void login() {
/*
        if (emailText.getText().toString().equals("")) {
            emailLayout.setError("Enter the Email");
            emailLayout.requestFocus();
            return;
        }
        if (Validation.validateEmail(emailText, emailLayout, LoginActivity.this)) {

            if (passwordText.getText().toString().equals("") || passwordText.getText().toString().length() < 3) {
                passwordLayout.setError("Enter Full Password");
                passwordLayout.requestFocus();

            } else {
                emailLayout.setErrorEnabled(false);
                passwordLayout.setErrorEnabled(false);
                loginPresenter.loginAttempt(emailText.getText().toString(), passwordText.getText().toString());
            }

        }*/
        loginSuccess();
    }

    @OnClick(R.id.register_now)
    public void registerNow() {

        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_right_to_left, R.anim.exit_left_to_right);
    }


    @Override
    public void loginSuccess() {
        emailText.setText("");
        passwordText.setText("");
        Snackbar.make(coordinatorLayout, "Login Success", Snackbar.LENGTH_LONG).show();

        Intent dashBoardIntent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(dashBoardIntent);
        overridePendingTransition(R.anim.enter_right_to_left, R.anim.exit_left_to_right);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
