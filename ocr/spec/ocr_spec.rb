require File.expand_path(File.dirname(__FILE__) + "/../lib/ocr")

describe OCR do
  
  before(:each) do
   @ocr = OCR.new
  end
  
  it "should parse two" do
    chunk = [" _ ",
             " _|",
             "|_ "]   
    @ocr.parse(chunk).should == [2]
  end
  
  it "should parse one" do
    chunk = ["   ",
             "  |",
             "  |"]   
    @ocr.parse(chunk).should == [1]
  end
    
end