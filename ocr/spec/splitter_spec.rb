require File.expand_path(File.dirname(__FILE__) + "/../lib/splitter")

describe Splitter do
  
  before(:each) do
   @splitter = Splitter.new
  end
  
  it "should check that a line is divisible by 9" do
    line =<<EOS
    _  _     _  _  _  _  _ 
  | _| _||_||_ |_   ||_||_|
  ||_  _|  | _||_|  ||_| _|
EOS
    (@splitter.split(line).length).should == 9 
  end
  
  it "should return one character when given a line that conatins one." do
  line =["       ",
         "       ",
         "       "]
         (@splitter.split(line).length).should == 2 
  end
end