/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package myaidlserver;
// Declare any non-default types here with import statements
public interface IUserManager extends android.os.IInterface
{
  /** Default implementation for IUserManager. */
  public static class Default implements com.ft.myaidlserver.IUserManager
  {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    @Override public java.util.List<com.ft.myaidlserver.bean.User> getUser() throws android.os.RemoteException
    {
      return null;
    }
    @Override public void addUser(com.ft.myaidlserver.bean.User user) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.ft.myaidlserver.IUserManager
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.ft.myaidlserver.IUserManager interface,
     * generating a proxy if needed.
     */
    public static com.ft.myaidlserver.IUserManager asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.ft.myaidlserver.IUserManager))) {
        return ((com.ft.myaidlserver.IUserManager)iin);
      }
      return new com.ft.myaidlserver.IUserManager.Stub.Proxy(obj);
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
        case TRANSACTION_getUser:
        {
          java.util.List<com.ft.myaidlserver.bean.User> _result = this.getUser();
          reply.writeNoException();
          _Parcel.writeTypedList(reply, _result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          break;
        }
        case TRANSACTION_addUser:
        {
          com.ft.myaidlserver.bean.User _arg0;
          _arg0 = _Parcel.readTypedObject(data, com.ft.myaidlserver.bean.User.CREATOR);
          this.addUser(_arg0);
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
    private static class Proxy implements com.ft.myaidlserver.IUserManager
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
      @Override public java.util.List<com.ft.myaidlserver.bean.User> getUser() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.util.List<com.ft.myaidlserver.bean.User> _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getUser, _data, _reply, 0);
          _reply.readException();
          _result = _reply.createTypedArrayList(com.ft.myaidlserver.bean.User.CREATOR);
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void addUser(com.ft.myaidlserver.bean.User user) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _Parcel.writeTypedObject(_data, user, 0);
          boolean _status = mRemote.transact(Stub.TRANSACTION_addUser, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
    }
    static final int TRANSACTION_getUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_addUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
  }
  public static final String DESCRIPTOR = "com.ft.myaidlserver.IUserManager";
  /**
   * Demonstrates some basic types that you can use as parameters
   * and return values in AIDL.
   */
  public java.util.List<com.ft.myaidlserver.bean.User> getUser() throws android.os.RemoteException;
  public void addUser(com.ft.myaidlserver.bean.User user) throws android.os.RemoteException;
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
    static private <T extends android.os.Parcelable> void writeTypedList(
        android.os.Parcel parcel, java.util.List<T> value, int parcelableFlags) {
      if (value == null) {
        parcel.writeInt(-1);
      } else {
        int N = value.size();
        int i = 0;
        parcel.writeInt(N);
        while (i < N) {
    writeTypedObject(parcel, value.get(i), parcelableFlags);
          i++;
        }
      }
    }
  }
}
