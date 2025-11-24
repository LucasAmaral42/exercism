class AssemblyLine
  def initialize(speed)
    @speed = speed
  end

  def production_rate_per_hour
    result = (@speed * 221)
    
    case @speed
      when 5..8
        result * 0.9
      when 9
        result * 0.8
      when 10
        result * 0.77
    else
      result
    end
  end

  def working_items_per_minute
    (production_rate_per_hour / 60).to_int
  end
end
