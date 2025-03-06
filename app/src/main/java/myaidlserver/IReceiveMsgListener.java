/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package myaidlserver;
//AIDL 文件中的 import 并不会自动导入，需要开发者自行添加。
// Declare any non-default types here with import statements
public interface IReceiveMsgListener extends android.os.IInterface
{
  /** Default implementation for IReceiveMsgListener. */
  public static class Default implements com.ft.myaidlserver.IReceiveMsgListener
  {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    @Override public void onReceive(com.ft.myaidlserver.bean.Msg msg) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.ft.myaidlserver.IReceiveMsgListener
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.ft.myaidlserver.IReceiveMsgListener interface,
     * generating a proxy if needed.
     */
    public static com.ft.myaidlserver.IReceiveMsgListener asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.ft.myaidlserver.IReceiveMsgListener))) {
        return ((com.ft.myaidlserver.IReceiveMsgListener)iin);
      }
      return new com.ft.myaidlserver.IReceiveMsgListener.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      String descriptor = DESCRIPTOR;
      if (code >= android.os.IBinder.FIRST_CALL_TRANSACTION && code <= android.os.IBinder.LAST_CALL_TRANSACTION) {
        data.enforceInterface(descriptor);
      }
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
      }
      switch (code)
      {
        case TRANSACTION_onReceive:
        {
          com.ft.myaidlserver.bean.Msg _arg0;
          _arg0 = _Parcel.readTypedObject(data, com.ft.myaidlserver.bean.Msg.CREATOR);
          this.onReceive(_arg0);
          reply.writeNoException();
          break;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
      return true;
    }
    private static class Proxy implements com.ft.myaidlserver.IReceiveMsgListener
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      /**
       * Demonstrates some basic types that you can use as parameters
       * and return values in AIDL.
       */
      @Override public void onReceive(com.ft.myaidlserver.bean.Msg msg) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _Parcel.writeTypedObject(_data, msg, 0);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onReceive, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
    }
    static final int TRANSACTION_onReceive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
  }
  public static final String DESCRIPTOR = "com.ft.myaidlserver.IReceiveMsgListener";
  /**
   * Demonstrates some basic types that you can use as parameters
   * and return values in AIDL.
   */
  public void onReceive(com.ft.myaidlserver.bean.Msg msg) throws android.os.RemoteException;
  /** @hide */
  static class _Parcel {
    static private <T> T readTypedObject(
        android.os.Parcel parcel,
        android.os.Parcelable.Creator<T> c) {
      if (parcel.readInt() != 0) {
          return c.createFromParcel(parcel);
      } else {
          return null;
      }
    }
    static private <T extends android.os.Parcelable> void writeTypedObject(
        android.os.Parcel parcel, T value, int parcelableFlags) {
      if (value != null) {
        parcel.writeInt(1);
        value.writeToParcel(parcel, parcelableFlags);
      } else {
        parcel.writeInt(0);
      }
    }
  }
}
