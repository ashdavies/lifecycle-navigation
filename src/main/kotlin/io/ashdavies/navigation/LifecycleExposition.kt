package io.ashdavies.navigation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import io.ashdavies.lifecycle.Event

interface LifecycleExposition<T : LifecycleOwner> {

  val commands: LiveData<Event<LifecycleCommand<T>>>
}
