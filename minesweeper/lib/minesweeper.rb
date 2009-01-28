class Field
  def initialize(rows, cols)
    @rows, @cols = rows, cols
    @cells = []
    rows.times do |row|
      @cells[row] = [0] * cols
    end
  end
  
  def size
    [@rows, @cols]
  end
  
  def [](row, col)
    @cells[row][col]
  end
  
  def bomb_at(row, col)
    @cells[row][col] = '*'
  end
  
  def neighbours_at(row, col)
    neighbours = []
    (-1..1).each do |d_row|
      (-1..1).each do |d_col|
        n_row, n_col = row+d_row, col+d_col
        next if d_row == 0 and d_col == 0
        next unless (0...@rows).include?(n_row)
        next unless (0...@cols).include?(n_col)
        neighbours << [n_row, n_col]
      end
    end
    neighbours
  end
  
  def each_bomb(&block)
    (0...@rows).each do |row|
      (0...@cols).each do |col|
        block.call(row, col) if self[row, col] == '*'
      end
    end
  end
  
  def solve!
    each_bomb do |row, col|
      self.neighbours_at(row, col).each do |n_row, n_col|
        @cells[n_row][n_col] += 1 unless @cells[n_row][n_col] == '*'
      end
    end
  end
  
  def to_a
    @cells.flatten
  end
end