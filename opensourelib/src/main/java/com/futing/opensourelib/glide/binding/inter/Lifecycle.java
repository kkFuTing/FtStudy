package com.futing.opensourelib.glide.binding.inter;

import androidx.annotation.NonNull;

public interface Lifecycle {

    void addListener(@NonNull LifecycleListener listener);

    void removeListener(@NonNull LifecycleListener listener);

}
