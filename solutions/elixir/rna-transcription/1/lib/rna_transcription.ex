defmodule RnaTranscription do
  @doc """
  Transcribes a character list representing DNA nucleotides to RNA

  ## Examples

  iex> RnaTranscription.to_rna('ACTG')
  'UGAC'
  """
  @spec to_rna([char]) :: [char]
  def to_rna(dna) do
    mapping = %{
      'A' => 'U',
      'T' => 'A',
      'G' => 'C',
      'C' => 'G',
    }

    Enum.reduce(dna, [], fn(letter, acc) ->
      acc ++ Map.get(mapping, [letter]) 
    end)
  end
end

IO.puts(RnaTranscription.to_rna('ACGTGGTCTTAA'))