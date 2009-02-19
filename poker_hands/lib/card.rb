class Card
  attr_reader :rank, :suit
  
  VALUES = {
    'T' => 10,
    'J' => 11,
    'Q' => 12,
    'K' => 13,
    'A' => 14
  }
  
  SUITS = {
    'C' => :clubs,
    'D' => :diamonds,
    'H' => :hearts,
    'S' => :spades
  }

  def initialize(str)
    rank = str[0, 1].upcase
    suit = str[1,1]
    @rank = VALUES[rank] || rank.to_i
    @suit = SUITS[suit]
  end
  
  def compare(car)
    
  end
end
