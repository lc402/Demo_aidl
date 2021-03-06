// IMyAidlInterface.aidl
package oo.liucx.demo_aidl;

// Declare any non-default types here with import statements
import oo.liucx.demo_aidl.IClientInterface;

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
            void test();
            void registerCallback(IClientInterface IClient);
}
