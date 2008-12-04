require File.expand_path(File.dirname(__FILE__) + "/../lib/character")

describe Character do
  
  before(:each) do
   @character = Character.new
  end
  
  it "should have a default value of 0" do
    @character.value.should == 0 
  end
end