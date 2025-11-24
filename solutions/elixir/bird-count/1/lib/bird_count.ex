defmodule BirdCount do

  def today([]), do: nil

  def today(list) do
    hd(list)
  end

  def increment_day_count([]), do: [1]

  def increment_day_count(list) do
    [today | list] = list
    [today + 1 | list]
  end

  def has_day_without_birds?(list) do
    case Enum.find(list, false, fn x -> x == 0 end) do
      false -> false
      _ -> true
    end
  end

  def total(list), do: Enum.sum(list)

  def busy_days(list) do
    Enum.filter(list, fn x -> x >= 5 end) |> length()
  end
end
