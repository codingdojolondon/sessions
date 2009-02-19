require 'spec'

require 'lib/card'

describe Card do
  it "should have rank" do
    Card.new('2H').rank.should == 2
    Card.new('3C').rank.should == 3
    Card.new('4D').rank.should == 4
    Card.new('5S').rank.should == 5
    Card.new('6C').rank.should == 6
    Card.new('7H').rank.should == 7
    Card.new('8D').rank.should == 8
    Card.new('9C').rank.should == 9    
    Card.new('TC').rank.should == 10
    Card.new('JC').rank.should == 11
    Card.new('QC').rank.should == 12
    Card.new('KC').rank.should == 13  
    Card.new('AC').rank.should == 14
  end
  
  it 'should understand lowercase rank' do
    Card.new('jC').rank.should == 11
    Card.new('qH').rank.should == 12
    Card.new('kS').rank.should == 13  
    Card.new('aD').rank.should == 14
  end
  
  it 'should have a suit' do
    Card.new('2H').suit.should == :hearts
    Card.new('2D').suit.should == :diamonds
    Card.new('2C').suit.should == :clubs
    Card.new('2S').suit.should == :spades
  end
  
end