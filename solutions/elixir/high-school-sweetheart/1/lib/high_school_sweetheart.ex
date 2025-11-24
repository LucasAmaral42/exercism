defmodule HighSchoolSweetheart do
  def first_letter(name) do
    name
    |> String.trim()
    |> String.first()
  end

  def initial(name) do
    name
    |> first_letter()
    |> String.upcase()
    |> Kernel.<>(".")
  end

  def initials(full_name) do
    full_name
    |> String.split
    |> Enum.reduce(fn x, acc -> "#{initial(acc)} #{initial(x)}" end)
  end

  def pair(full_name1, full_name2) do
    f1 = initials(full_name1)
    f2 = initials(full_name2)

    """
         ******       ******
       **      **   **      **
     **         ** **         **
    **            *            **
    **                         **
    **     #{f1}  +  #{f2}     **
     **                       **
       **                   **
         **               **
           **           **
             **       **
               **   **
                 ***
                  *
    """
  end
end
