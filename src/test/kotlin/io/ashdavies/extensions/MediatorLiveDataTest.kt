package io.ashdavies.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.ashdavies.lifecycle.LiveDataScope
import io.ashdavies.lifecycle.jupiter.InstantTaskExecutorExtension
import io.ashdavies.lifecycle.testing.TestObserver
import io.ashdavies.lifecycle.testing.test
import io.ashdavies.operator.Operator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantTaskExecutorExtension::class)
internal class MediatorLiveDataTest {

  @Test
  fun `should pass through values`() {
    val source: MutableLiveData<Int> = MutableLiveData()
    val mediated: LiveData<Int> = mediatorLiveData(source, PassthroughOperator)
    val observer: TestObserver<Int> = mediated.test()

    source.emit(1, 2, 3)

    observer.expect(1, 2, 3)
  }

  object PassthroughOperator : Operator<Int, Int> {

    override fun invoke(scope: LiveDataScope<Int>, value: Int) = scope.emit(value)
  }
}
