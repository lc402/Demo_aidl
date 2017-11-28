package oo.liucx.demo_aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String test = "test";
        //使用意图对象绑定开启服务
    //在5.0及以上版本必须要加上这个
        Intent intent=new Intent(MainActivity.this,MyAidlService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        setContentView(R.layout.activity_main);
        Log.d("liucx", "basicTypes go to");
        try {
            if(mMyAidlService != null)
                mMyAidlService.basicTypes(1,2,false,1,2,test);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Log.d("liucx", "basicTypes back");
    }

    IMyAidlInterface mMyAidlService;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            Log.e("123", "onServiceDisconnected:" + arg0.getPackageName());
        }
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Log.e("123", "onServiceConnected:" + name.getPackageName());
            // 获取远程Service的onBinder方法返回的对象代理
            String test = "test";
            mMyAidlService = IMyAidlInterface.Stub.asInterface(binder);
            try {
                Log.d("liucx", "basicTypes go to2222");
                if(mMyAidlService != null)
                    mMyAidlService.basicTypes(1,2,false,1,2,test);
                Log.d("liucx", "basicTypes back 22222");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };

}
