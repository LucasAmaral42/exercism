defmodule KitchenCalculator do
  def get_volume({_unit, volume}), do: volume 

  def to_milliliter(volume_pair) do
    case volume_pair do
      {:cup, volume} -> {:milliliter, 240 * volume}
      {:fluid_ounce, volume} -> {:milliliter, 30 * volume}
      {:teaspoon, volume} -> {:milliliter, 5 * volume}
      {:tablespoon, volume} -> {:milliliter, 15 * volume}
      {_, volume} -> {:milliliter, volume}
    end
  end

  def from_milliliter({_milliliter, volume}, unit) do
    case {unit, volume} do
      {:cup, volume} -> {:cup, volume / 240}
      {:fluid_ounce, volume} -> {:fluid_ounce, volume / 30}
      {:teaspoon, volume} -> {:teaspoon, volume / 5}
      {:tablespoon, volume} -> {:tablespoon, volume / 15}
      {_, volume} -> {:milliliter, volume}
    end
  end

  def convert(volume_pair, unit) do
    volume_pair
    |> to_milliliter()
    |> from_milliliter(unit)
  end
end
