package com.qiqi.edmond.qishop.activitys.base;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.qiqi.edmond.qishop.R;

/**
 * Created by edmond on 16-8-15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private String TAG = "BaseActivity";
    private PackageManager pm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pm = getPackageManager();
        try {
            PackageInfo pack = pm.getPackageInfo(getPackageName(),PackageManager.GET_PERMISSIONS);
            String[] permissionStrings = pack.requestedPermissions;
            for(String permissionString:permissionStrings){
                int permission = ActivityCompat.checkSelfPermission(this, permissionString);
                int REQUEST_PERMISSION = 1;

                if(permission!=PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(this,permissionStrings,REQUEST_PERMISSION);
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.mainColor));
//            window.setNavigationBarColor(getResources().getColor(R.color.mainColor));
        }
    }

    public PackageManager getPm() {
        return pm;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d(TAG,"FREE");
    }
}
