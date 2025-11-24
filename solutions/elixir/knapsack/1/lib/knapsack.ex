defmodule Knapsack do
  @doc """
  Return the maximum value that a knapsack can carry.
  """
  @spec maximum_value(items :: [%{value: integer, weight: integer}], maximum_weight :: integer) ::
          integer
  def maximum_value(items, maximum_weight) do
    items
    |> Enum.reject(&(&1.weight > maximum_weight))
    |> get_items(maximum_weight)
  end

  defp get_items(_, 0), do: 0
  defp get_items([], _), do: 0
  defp get_items([head | tail], max_weight) when head.weight > max_weight, do: get_items(tail, max_weight)
  defp get_items([head | tail], max_weight), do: [head.value + get_items(tail, max_weight - head.weight), get_items(tail, max_weight)] |> Enum.max()
end
