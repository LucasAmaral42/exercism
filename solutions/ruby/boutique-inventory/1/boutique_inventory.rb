class BoutiqueInventory
  def initialize(items)
    @items = items
  end

  def item_names
    items.map { |item| item[:name] }.sort
  end

  def cheap
    items.select { |item| item[:price] < 30.0 }
  end

  def out_of_stock
    items.select { |item| item[:quantity_by_size].empty? }
  end

  def stock_for_item(name)
    items.select { |item| item[:name] == name }.first[:quantity_by_size]
  end

  def total_stock
    total_stock = 0

    items.each do |item|
      next if item[:quantity_by_size].empty?

      item[:quantity_by_size].each_value { |quantity| total_stock += quantity }
    end

    total_stock
  end

  private
  attr_reader :items
end
