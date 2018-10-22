package in.backfour.app.ui.activities.dashboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.backfour.app.R;
import in.backfour.app.base.ActivityContext;
import in.backfour.app.ui.fragments.coaches.CoachesFragment;
import in.backfour.app.ui.fragments.events.EventsFragment;
import in.backfour.app.ui.fragments.grounds.GroundsFragment;
import in.backfour.app.ui.fragments.membership.MembershipFragment;

public class DashboardActivity extends AppCompatActivity implements DashboardContract.View, BottomNavigationView.OnNavigationItemSelectedListener {


    private Context mContext = DashboardActivity.this;
    @Inject
    DashboardPresenter dashboardPresenter;
    Fragment fragment;
    private int backState = 1;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationViewEx;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);


        DaggerDashboardComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        dashboardPresenter.attach(this);
        setupBottomViewer();
        setToolBar();
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(this);

    }

    private void setToolBar() {
        toolbar.setTitle("Grounds");
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        loadFragment(new GroundsFragment());

    }

    private void setupBottomViewer() {
        bottomNavigationViewEx.setTextVisibility(true);
        bottomNavigationViewEx.enableAnimation(true);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextSize(12);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        displaySelectedItem(menuItem.getItemId());

        return true;
    }


    private void displaySelectedItem(int itemId) {
        switch (itemId) {
            case R.id.ic_grounds:
                if (backState != 1) {
                    bottomNavigationViewEx.getMenu().getItem(0).setChecked(true);
                    backState = 1;
                    fragment = new GroundsFragment();
                    toolbar.setTitle("Ground");
                    loadFragment(fragment);
                }
                break;

            case R.id.ic_coaches:
                if (backState != 2) {
                    backState = 2;
                    fragment = new CoachesFragment();
                    toolbar.setTitle("Coaches");
                    loadFragment(fragment);
                }
                break;
            case R.id.ic_membership:
                if (backState != 3) {
                    backState = 3;
                    fragment = new MembershipFragment();
                    toolbar.setTitle("Membership");
                    loadFragment(fragment);
                }
                break;
            case R.id.ic_events:
                if (backState != 4) {
                    backState = 4;
                    fragment = new EventsFragment();
                    toolbar.setTitle("Events");
                    loadFragment(fragment);
                }
                break;
        }
    }


}
