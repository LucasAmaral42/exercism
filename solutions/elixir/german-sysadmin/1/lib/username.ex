defmodule Username do
  def sanitize(username) do
    username
    |> Enum.map(&sanitize_char/1)
    |> List.flatten()
    |> Enum.reject(&is_nil/1)
  end

  defp sanitize_char(char) when is_integer(char) and char in ?0..?9, do: nil
  defp sanitize_char(?ä), do: ~c"ae"
  defp sanitize_char(?ö), do: ~c"oe"
  defp sanitize_char(?ü), do: ~c"ue"
  defp sanitize_char(?ß), do: ~c"ss"
  defp sanitize_char(char) when char in ?a..?z or char in [?_, ~c" "], do: char
  defp sanitize_char(_char), do: nil
end
