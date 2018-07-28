package oo.liucx.demo_aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;


public class MyAidlService extends Service {
    public MyAidlService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }


    IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
                               double aDouble, String aString) {
            Log.d("liucx", "basic types is call");
            Log.d("liucx",
                    "anint: " + anInt + "\n" +
                    "Along: " + aLong + "\n" +
                    "aBoolean: " + aBoolean + "\n" +
                    "aFloat: " + aFloat + "\n" +
                    "aDouble: " + aDouble + "\n" +
                        "aString: " + aString + "\n");

        }

        @Override
        public void test() throws RemoteException {

        }

        @Override
        public void registerCallback(IClientInterface IClient) throws RemoteException {

        }
    };
}
