require 'spec'

require 'lib/hand'
require 'lib/card'

describe Hand do 
  
  it 'should have card objects' do
    Hand.new("2H 3D 5S 9C KD").cards[0].should be_kind_of Card
  end
  
  it 'should recognize "2H 3D 5S 9C KD" as a high card' do
    Hand.new("2H 3D 5S 9C KD").value.should == 0
  end
  
  it " Greater Than should work" do
    Hand.new('QH 3D 5S 9C KD').should > Hand.new('2C 3H 4S 8C KH')
    Hand.new('3H 4D 5S 9C KD').should_not > Hand.new('2H AC 4S 8C KH')
  end

  
end