package in.backfour.app.ui.activities.register;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import in.backfour.app.R;
import in.backfour.app.base.ActivityContext;
import in.backfour.app.ui.activities.login.LoginActivity;
import in.backfour.app.ui.activities.login.LoginPresenter;
import in.backfour.app.utils.Validation;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {


    @BindView(R.id.name)
    EditText nameText;
    @BindView(R.id.email)
    EditText emailText;
    @BindView(R.id.mobile)
    EditText mobileText;
    @BindView(R.id.password)
    EditText passwordText;
    @BindView(R.id.register_button)
    Button registerButton;
    @BindView(R.id.sign_in)
    TextView signIn;
    @BindView(R.id.name_layout)
    TextInputLayout nameLayout;
    @BindView(R.id.email_layout)
    TextInputLayout emailLayout;
    @BindView(R.id.mobile_layout)
    TextInputLayout mobileLayout;
    @BindView(R.id.password_layout)
    TextInputLayout passwordLayout;
    @BindView(R.id.c_layout)
    CoordinatorLayout cLayout;
    @Inject
    RegisterPresenter registerPresenter;

    private Context mContext = RegisterActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


        DaggerRegisterComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        registerPresenter.attach(this);
    }

    @OnClick(R.id.register_button)
    public void registerButton() {

        if (nameText.getText().toString().length() < 3) {
            nameLayout.setError("Enter Full Name");
            nameLayout.requestFocus();
            return;
        }
        if (Validation.validName(nameText, nameLayout, RegisterActivity.this)) {

            if (emailText.getText().toString().equals("")) {
                emailLayout.setError("Enter the Email");
                emailLayout.requestFocus();
                return;
            }
            if (Validation.validateEmail(emailText, emailLayout, RegisterActivity.this)) {
                if (mobileText.getText().toString().length() < 10) {
                    mobileLayout.setError("Enter Valid Mobile Number");
                    mobileLayout.requestFocus();
                    return;
                }
                if (passwordText.getText().toString().length() < 8) {
                    passwordLayout.setError("Password Must be at least 8 Characters");
                    passwordLayout.requestFocus();
                    return;
                }

                registerPresenter.registerSuccess(nameText.getText().toString(), emailText.getText().toString(), mobileText.getText().toString(), passwordText.getText().toString());
                // signInPage();
            }
        }

    }

    @OnClick(R.id.sign_in)
    public void signInPage() {
        Intent signInIntent = new Intent(RegisterActivity.this, LoginActivity.class);
        signInIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(signInIntent);
        overridePendingTransition(R.anim.enter_right_to_left, R.anim.exit_left_to_right);
    }

    @Override
    public void registerDOne() {
        Snackbar.make(cLayout,"Successfully Registered",Snackbar.LENGTH_LONG).show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
