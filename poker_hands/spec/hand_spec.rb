require 'lib/hand'
require 'lib/card'

describe Hand do
  KQ_HIGH = Hand.new('QH 3D 5S 9C KD')
  KQ_HIGH_DIFFERENT_SUIT = Hand.new('QH 3D 5S 9C KH')
  K8_HIGH = Hand.new('2C 3H 4S 8C KH')
  ACE_HIGH = Hand.new('2H AC 4S 8C KH')
  LOW_PAIR = Hand.new('2H 2H 3S 4S 5S')
  HIGH_PAIR = Hand.new('KH KH 3S 4S 5S')
  
  it 'should have card objects' do
    Hand.new("2H 3D 5S 9C KD").cards[0].should be_kind_of Card
  end
  
  it 'should recognize "2H 3D 5S 9C KD" as a high card' do
    Hand.new("2H 3D 5S 9C KD").value.should == 0
  end
  
  describe "when one card is higher" do
    it "should recognise that the hand with the lower card is not greater" do
      KQ_HIGH.should_not > ACE_HIGH
    end
    
    it "should recognise that the hand with the higher card is greater" do
      ACE_HIGH.should > KQ_HIGH
    end
  end
  
  describe "when the highest card is the same" do
    it "should recognise that the hand with the next highest card is greater" do
      KQ_HIGH.should > K8_HIGH
    end
    
    it 'should recognise that the hands are tied' do
      KQ_HIGH.should == KQ_HIGH
    end
    
    it 'should regonise that the hands are tied if only suits are different' do
      KQ_HIGH.should == KQ_HIGH_DIFFERENT_SUIT
    end
    
  end
  
 
  
  describe 'pair' do
    it "should recognise a pair" do
       LOW_PAIR.is_pair.should == true
    end 

    it "should recognise that pair beats high card" do 
       LOW_PAIR.should > KQ_HIGH
     end
     
    it 'high pair should beat lo pair'
  end
  
end