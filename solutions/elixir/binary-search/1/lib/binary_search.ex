defmodule BinarySearch do
  @doc """
    Searches for a key in the tuple using the binary search algorithm.
    It returns :not_found if the key is not in the tuple.
    Otherwise returns {:ok, index}.

    ## Examples

      iex> BinarySearch.search({}, 2)
      :not_found

      iex> BinarySearch.search({1, 3, 5}, 2)
      :not_found

      iex> BinarySearch.search({1, 3, 5}, 5)
      {:ok, 2}

  """

  @spec search(tuple, integer) :: {:ok, integer} | :not_found
  def search({}, _), do: :not_found
  def search(numbers, key) when elem(numbers, 0) > key, do: :not_found
  def search(numbers, key) when elem(numbers, tuple_size(numbers) - 1) < key, do: :not_found
  
  def search(numbers, key) when tuple_size(numbers) == 1 do
    case elem(numbers, 0) do
      key -> {:ok, 0}
      _ -> :not_found
    end
  end

  def search(numbers, key), do: binary_search(numbers, key, 0, tuple_size(numbers) - 1)

  def binary_search(_, _, initial_position, last_position) when initial_position > last_position, do: :not_found
  
  def binary_search(numbers, key, initial_position, last_position) do
    index = initial_position + div(last_position - initial_position, 2)
    number = elem(numbers, index) 

    cond do
      number == key -> {:ok, index}
      number > key -> binary_search(numbers, key, initial_position, index - 1)
      number < key -> binary_search(numbers, key, index + 1, last_position)
    end  
  end
end

{1, 2, 3, 4, 5, 6, 7}
