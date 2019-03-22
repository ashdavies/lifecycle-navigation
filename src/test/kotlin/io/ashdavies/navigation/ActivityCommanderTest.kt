package io.ashdavies.navigation

import androidx.lifecycle.Observer
import com.nhaarman.mockito_kotlin.then
import io.ashdavies.extensions.test
import io.ashdavies.lifecycle.LiveDataEvent
import io.ashdavies.navigation.ActivityCommander.Standard
import io.ashdavies.testing.FakeActivityCommand
import io.ashdavies.testing.InstantTaskExecutorExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantTaskExecutorExtension::class)
internal class ActivityCommanderTest {

  private val commander: ActivityCommander = Standard()
  private val command: ActivityCommand = FakeActivityCommand()

  @Test
  fun `should dispatch command`() {
    val observer: Observer<LiveDataEvent<ActivityCommand>> = commander
        .commands
        .test()

    commander.dispatch(command)

    then(observer)
        .should()
        .onChanged(LiveDataEvent(command))
  }
}