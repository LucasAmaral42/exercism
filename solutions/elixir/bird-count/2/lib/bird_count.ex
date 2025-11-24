defmodule BirdCount do

  def today([]), do: nil
  def today([today_count | _]), do: today_count

  def increment_day_count([]), do: [1]
  def increment_day_count([today_count | list]), do: [today_count + 1 | list]

  def has_day_without_birds?([]), do: false
  def has_day_without_birds?([0 | _]), do: true
  def has_day_without_birds?([_ | list]), do: has_day_without_birds?(list)

  def total([]), do: 0
  def total([today_count | list]), do: today_count + total(list)

  def busy_days([]), do: 0
  def busy_days([today_count | list]) when today_count >= 5, do: 1 + busy_days(list)
  def busy_days([_ | list]), do: busy_days(list)
end
