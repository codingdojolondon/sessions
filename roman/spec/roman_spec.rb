require File.expand_path(File.dirname(__FILE__) + "/../lib/roman")

describe Roman  do
  
  before(:each) do
   @ROMAN = Roman.new
  end
  
  it "should do return 1" do
	  @ROMAN.convert_from_roman_to_integer("I").should == 1
  end
  
  it "should handle I's" do
    @ROMAN.convert_from_roman_to_integer("II").should == 2
  end
  
    it "should handle atomics" do
    @ROMAN.convert_from_roman_to_integer("I").should == 1
    @ROMAN.convert_from_roman_to_integer("V").should == 5
    @ROMAN.convert_from_roman_to_integer("X").should == 10
    @ROMAN.convert_from_roman_to_integer("L").should == 50
    @ROMAN.convert_from_roman_to_integer("C").should == 100
    @ROMAN.convert_from_roman_to_integer("D").should == 500
    @ROMAN.convert_from_roman_to_integer("M").should == 1000
  end
  
  it "should do right order" do
      @ROMAN.convert_from_roman_to_integer("XXXVIII").should == 38
  end
  
  it "should handle decrements based on order - XXIX" do
      @ROMAN.convert_from_roman_to_integer("XXIX").should == 29 
  end 
  
  it "should handle IV to 4" do
    @ROMAN.convert_from_roman_to_integer("IV").should == 4
  end
       
  it "should handle example cases" do
    @ROMAN.convert_from_roman_to_integer("III").should == 3
    @ROMAN.convert_from_roman_to_integer("XXIX").should == 29
    @ROMAN.convert_from_roman_to_integer("XXXVIII").should == 38
    @ROMAN.convert_from_roman_to_integer("CCXCI").should == 291
    @ROMAN.convert_from_roman_to_integer("MCMXCIX").should == 1999
    
  end
  
  it "should handle arabic to roman" do
      @ROMAN.itor(1).should == "I"
      @ROMAN.itor(2).should == "II"
      @ROMAN.itor(3).should == "III"
      @ROMAN.itor(4).should == "IV"
      @ROMAN.itor(5).should == "V"
      @ROMAN.itor(6).should == "VI"
  end
end
