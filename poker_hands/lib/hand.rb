class Hand
  
  attr_reader :cards, :display
  
  def initialize(card_string)
    @cards = card_string.split(" ").map {|card| Card.new(card)}
  end
  
  def value
    0
  end
  
  def > (other_hand)
   high_card(other_hand) or is_pair 
  end
  
  def high_card(other_hand)
     (sorted_ranks <=> other_hand.sorted_ranks) == 1
  end

  def sorted_ranks
    cards.map{|card| card.rank}.sort.reverse
  end
  
  def ==(other_hand)
    sorted_ranks == other_hand.sorted_ranks
  end
  
  def is_pair 
    sorted_ranks.uniq.size < 5 
  end
  
end