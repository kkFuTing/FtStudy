/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package myaidlserver;
// Declare any non-default types here with import statements
public interface IMsgManager extends android.os.IInterface
{
  /** Default implementation for IMsgManager. */
  public static class Default implements com.ft.myaidlserver.IMsgManager
  {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    // 发消息
    @Override public void sendMsg(com.ft.myaidlserver.bean.Msg msg) throws android.os.RemoteException
    {
    }
    // 客户端注册监听回调
    @Override public void registerReceiveListener(com.ft.myaidlserver.IReceiveMsgListener listener) throws android.os.RemoteException
    {
    }
    // 客户端取消监听回调
    @Override public void unregisterReceiveListener(com.ft.myaidlserver.IReceiveMsgListener listener) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.ft.myaidlserver.IMsgManager
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.ft.myaidlserver.IMsgManager interface,
     * generating a proxy if needed.
     */
    public static com.ft.myaidlserver.IMsgManager asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.ft.myaidlserver.IMsgManager))) {
        return ((com.ft.myaidlserver.IMsgManager)iin);
      }
      return new com.ft.myaidlserver.IMsgManager.Stub.Proxy(obj);
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
        case TRANSACTION_sendMsg:
        {
          com.ft.myaidlserver.bean.Msg _arg0;
          _arg0 = _Parcel.readTypedObject(data, com.ft.myaidlserver.bean.Msg.CREATOR);
          this.sendMsg(_arg0);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_registerReceiveListener:
        {
          com.ft.myaidlserver.IReceiveMsgListener _arg0;
          _arg0 = com.ft.myaidlserver.IReceiveMsgListener.Stub.asInterface(data.readStrongBinder());
          this.registerReceiveListener(_arg0);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_unregisterReceiveListener:
        {
          com.ft.myaidlserver.IReceiveMsgListener _arg0;
          _arg0 = com.ft.myaidlserver.IReceiveMsgListener.Stub.asInterface(data.readStrongBinder());
          this.unregisterReceiveListener(_arg0);
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
    private static class Proxy implements com.ft.myaidlserver.IMsgManager
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
      // 发消息
      @Override public void sendMsg(com.ft.myaidlserver.bean.Msg msg) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _Parcel.writeTypedObject(_data, msg, 0);
          boolean _status = mRemote.transact(Stub.TRANSACTION_sendMsg, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      // 客户端注册监听回调
      @Override public void registerReceiveListener(com.ft.myaidlserver.IReceiveMsgListener listener) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongInterface(listener);
          boolean _status = mRemote.transact(Stub.TRANSACTION_registerReceiveListener, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      // 客户端取消监听回调
      @Override public void unregisterReceiveListener(com.ft.myaidlserver.IReceiveMsgListener listener) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongInterface(listener);
          boolean _status = mRemote.transact(Stub.TRANSACTION_unregisterReceiveListener, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
    }
    static final int TRANSACTION_sendMsg = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_registerReceiveListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_unregisterReceiveListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
  }
  public static final String DESCRIPTOR = "com.ft.myaidlserver.IMsgManager";
  /**
   * Demonstrates some basic types that you can use as parameters
   * and return values in AIDL.
   */
  // 发消息
  public void sendMsg(com.ft.myaidlserver.bean.Msg msg) throws android.os.RemoteException;
  // 客户端注册监听回调
  public void registerReceiveListener(com.ft.myaidlserver.IReceiveMsgListener listener) throws android.os.RemoteException;
  // 客户端取消监听回调
  public void unregisterReceiveListener(com.ft.myaidlserver.IReceiveMsgListener listener) throws android.os.RemoteException;
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
