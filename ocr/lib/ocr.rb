class OCR
  def parse(chunk)
    if     chunk[0] =="   " \
        && chunk[1] =="  |" \
        && chunk[2] =="  |"
      [1]
    elsif  chunk[0] ==" _ " \
        && chunk[1] ==" _|" \
        && chunk[2] =="|_ "
      [2] 
    end
  end
end