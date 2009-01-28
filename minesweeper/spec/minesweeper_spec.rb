require "spec"

require "lib/minesweeper"

describe Field do
  it "should have MxN cells" do
    Field.new(2, 2).size.should == [2, 2]
    Field.new(3, 4).size.should == [3, 4]
  end
  
  it "should initialize with empty cells" do
    field = Field.new(2, 2)
    field[0, 0].should == 0
    field[0, 1].should == 0
    field[1, 0].should == 0
    field[1, 1].should == 0
  end
  
  it "should allow placement of bombs" do
    field = Field.new(2, 2)
    
    field.bomb_at(1, 1)
    
    field[1, 1].should == '*'
  end
  
  it "should provide array representation" do
    field = Field.new(2, 2)
    field.bomb_at(1, 1)
    field.to_a.should == [0, 0,
                          0, '*']
  end
  
  describe "(neighbours)" do
    before do
      @field = Field.new(3, 3)
    end
    
    it "should find neighbours around cell" do
      @field.neighbours_at(1, 1).should have(8).neighbours
      @field.neighbours_at(1, 1).should include([0, 0], [0, 1], [0, 2],
                                                [1, 0],         [1, 2],
                                                [2, 0], [2, 1], [2, 2])
    end
  
    it "should ignore neighbours outside the field" do
      @field.neighbours_at(0, 0).should == [       [0, 1],
                                            [1, 0],[1, 1]]
      @field.neighbours_at(2, 2).should == [[1, 1], [1, 2],
                                            [2, 1]        ]
    end
  end
  
  describe "(solve)" do
    before do
      @field = Field.new(3, 3)
      @field.bomb_at(0, 1)
    end
    
    it "should allow looping through the bombs" do
      visited_bombs = 0
      @field.each_bomb do |row, col|
        visited_bombs += 1
        @field[row, col].should == '*'
      end
      visited_bombs.should == 1
    end
    
    it "should increment 1 in bomb's neighbours" do
      @field.solve!
      @field.to_a.should == [1, '*', 1,
                             1,   1, 1,
                             0,   0, 0]
    end
    
    it "should not increment if neighbour is also a bomb" do
      @field.bomb_at(0, 0)
      @field.solve!
      @field.to_a.should == ['*', '*', 1,
                               2,   2, 1,
                               0,   0, 0]
    end
  end
end