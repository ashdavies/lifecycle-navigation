package io.ashdavies.lifecycle

internal class MapInstanceOperator<T>(private val kls: Class<T>) : Operator<Any, T> {

  @Suppress("UNCHECKED_CAST")
  override fun invoke(scope: LiveDataScope<T>, value: Any) {
    if (kls.isInstance(value)) {
      scope.emit(value as T)
    }
  }
}
