package si.vei.pedram.bottomnavigation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        PopupMenu popupMenu = new PopupMenu(this, fab, Gravity.RIGHT);
        popupMenu.inflate(R.menu.global_create_menu);

        //noinspection RestrictedApi
        final MenuPopupHelper menuHelper = new MenuPopupHelper(this,
                (MenuBuilder) popupMenu.getMenu(), fab);
        menuHelper.setForceShowIcon(true);
        menuHelper.setGravity(Gravity.RIGHT);

        menuHelper.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                fab.setVisibility(View.VISIBLE);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuHelper.show();
                //mPopupWindow.showAtLocation(navigation, Gravity.BOTTOM, 0, 0);
                fab.setVisibility(View.GONE);
            }
        });
    }

}
