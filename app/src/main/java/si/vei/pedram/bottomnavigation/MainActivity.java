package si.vei.pedram.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        BottomNavigationViewHelper.disableShiftMode(navigation);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.global_create_event:

                return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mTextMessage.setText(R.string.title_home);
                return true;
            case R.id.navigation_calendar:
                mTextMessage.setText(R.string.title_calendar);
                return true;
            case R.id.navigation_matters:
                mTextMessage.setText(R.string.title_matters);
                return true;
            case R.id.navigation_more:
                mTextMessage.setText(R.string.title_more);
                return true;
            case R.id.navigation_global_create:

                item.setChecked(false);

                View menuItemView = findViewById(R.id.navigation_global_create);
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, menuItemView);
                popupMenu.inflate(R.menu.global_create_menu);

                //noinspection RestrictedApi
                MenuPopupHelper menuHelper = new MenuPopupHelper(MainActivity.this,
                        (MenuBuilder) popupMenu.getMenu(), menuItemView);
                menuHelper.setForceShowIcon(true);
                menuHelper.show();

                return false;
        }
        return false;
    }
}
