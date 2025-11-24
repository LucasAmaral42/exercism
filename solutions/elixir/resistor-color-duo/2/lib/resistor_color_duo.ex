defmodule ResistorColorDuo do
  @doc """
  Calculate a resistance value from two colors
  """

   @resistor_colors %{
    black: 0,
    brown: 1,
    red: 2,
    orange: 3,
    yellow: 4,
    green: 5,
    blue: 6,
    violet: 7,
    grey: 8,
    white: 9
  }

  @spec value(colors :: [atom]) :: integer
  def value(colors) do
    colors
    |> Enum.take(2)
    |> Enum.map(&Map.get(@resistor_colors, &1))
    |> Integer.undigits()
  end
end
