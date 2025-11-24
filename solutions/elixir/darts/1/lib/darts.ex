defmodule Darts do
  @type position :: {number, number}

  @doc """
  Calculate the score of a single dart hitting a target
  """
  @spec score(position) :: integer
  def score({x, y}) do
    (x * x + y * y)
    |> score_by_position()
  end

  defp score_by_position(pos) do
    cond do
      pos > 100 -> 0
      pos > 25 -> 1
      pos > 1 -> 5
      true -> 10
    end
  end
end
