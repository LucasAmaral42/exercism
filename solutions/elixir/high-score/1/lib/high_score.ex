defmodule HighScore do
  def new(), do: %{}

  def add_player(scores, name, score \\ 0), do: Map.put(scores, name, score)

  def remove_player(scores, name), do: Map.delete(scores, name)

  def reset_score(scores, name) do
    case Map.has_key?(scores, name) do
      true -> %{scores | name => 0}
      _ -> add_player(scores, name)
    end
  end

  def update_score(scores, name, score) do
    previous_score = scores[name]

    case Map.has_key?(scores, name) do
      true -> %{scores | name => previous_score + score}
      _ -> add_player(scores, name, score)
    end
  end

  def get_players(scores), do: Map.keys(scores)
end
