package si.vei.pedram.bottomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

import si.vei.pedram.bottomnavigation.adapter.GlobalCreateAdapter;
import si.vei.pedram.bottomnavigation.model.GlobalCreateRowItem;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener,
        BottomNavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {

    private TextView mTextMessage;
    private ListPopupWindow listPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        BottomNavigationViewHelper.disableShiftMode(navigation);


        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        PopupMenu popupMenu = new PopupMenu(this, navigation, Gravity.RIGHT);
        popupMenu.inflate(R.menu.global_create_menu);

        //noinspection RestrictedApi
        final MenuPopupHelper menuHelper = new MenuPopupHelper(this,
                (MenuBuilder) popupMenu.getMenu(), navigation.findViewById(R.id.navigation_more));
        menuHelper.setForceShowIcon(true);
        menuHelper.setGravity(Gravity.RIGHT);

        menuHelper.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                fab.setVisibility(View.VISIBLE);
            }
        });

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // menuHelper.show();
//                //mPopupWindow.showAtLocation(navigation, Gravity.BOTTOM, 0, 0);
//                fab.setVisibility(View.GONE);
//            }
//        });


        mTextMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });


//        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//
//        View customView = inflater.inflate(R.layout.global_create, null);
//
//        mPopupWindow = new PopupWindow(
//                customView,
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        );

//        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                fab.setVisibility(View.VISIBLE);
//            }
//        });

        ArrayList<GlobalCreateRowItem> items = new ArrayList<>();
        items.add(new GlobalCreateRowItem(getString(R.string.title_global_create_event),
                R.drawable.ic_calendar_black_24dp));
        items.add(new GlobalCreateRowItem(getString(R.string.title_global_create_task),
                R.drawable.ic_tasks_black_24dp));
        items.add(new GlobalCreateRowItem(getString(R.string.title_global_create_expense),
                R.drawable.ic_expenses_on_black_24dp));


        listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setAdapter(new GlobalCreateAdapter(this, R.layout.global_create_list_item, items));
        listPopupWindow.setAnchorView(fab);
        listPopupWindow.setWidth(300);
        listPopupWindow.setHeight(400);

        listPopupWindow.setModal(true);
        listPopupWindow.setOnItemClickListener(this);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listPopupWindow.show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        listPopupWindow.dismiss();
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
        }
        return false;
    }
}
