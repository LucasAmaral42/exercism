module SavingsAccount
  def self.interest_rate(balance)
    case
      when balance < 0
        return -3.213
      when balance < 1000
        return 0.5
      when balance < 5000
        return 1.621
    else
      return 2.475
    end
  end

  def self.annual_balance_update(balance)
    balance * (1 + interest_rate(balance).abs / 100)
  end

  def self.years_before_desired_balance(current_balance, desired_balance)
    estimated_balance = current_balance
    year_count = 0
    while estimated_balance < desired_balance do
      estimated_balance = annual_balance_update(estimated_balance)
      year_count += 1
    end

    year_count
  end
end
