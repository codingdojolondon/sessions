class Hand
  
  attr_reader :cards
  
  def initialize(card_string)
    @cards = card_string.split(" ").map {|card| Card.new(card)}
  end
  
  def value
    0
  end
  
  def > (other_hand) 
    @cards[0].rank > other_hand.cards[0].rank
    @cards <=>
  end
end