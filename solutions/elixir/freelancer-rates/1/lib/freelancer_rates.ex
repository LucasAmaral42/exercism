defmodule FreelancerRates do
  def daily_rate(hourly_rate), do: hourly_rate * 8.0

  def apply_discount(before_discount, discount), do: before_discount * (1 - discount / 100)

  def monthly_rate(hourly_rate, discount) do
    daily_rate(hourly_rate)
    |> Kernel.*(22)
    |> apply_discount(discount)
    |> Float.ceil()
    |> Kernel.trunc()
  end

  def days_in_budget(budget, hourly_rate, discount) do
    budget / apply_discount(daily_rate(hourly_rate), discount)
    |> Float.floor(1)
  end
end

