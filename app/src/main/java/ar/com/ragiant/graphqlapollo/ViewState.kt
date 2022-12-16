package ar.com.ragiant.graphqlapollo

sealed class ViewState<T> (
    val value: T? = null,
    val message: String? = null
)
{
    class Succes<T>(data: T) : ViewState<T>(data)
    class Error<T>(message: String?, data: T?= null): ViewState<T>(data,message)
    class Loading<T>: ViewState<T>()
}