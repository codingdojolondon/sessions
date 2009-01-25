class Roman
  
  
  def convert_from_roman_to_integer( roman )
    romanMap = {"I" => 1, 
                "V" => 5,
                "X" => 10,
                "L" => 50,
                "C" => 100,
                "D" => 500,
                "M" => 1000 } 
   
   result = 0
   lastvalue = 1001
    roman.split( // ).each do |letter|
      value = romanMap[letter]
      if lastvalue < value
        result -= 2*lastvalue
      end
      result += value
      lastvalue = value
    end
    return result
  end
  
  INT_ROMAN = {
    5 => "V",
    1 => "I"
  }
  
  def itor( i )
    res = ""
    INT_ROMAN.each do |int, roman|
      cur, i = i.divmod(int)
      while i > 0
        res += roman
        cur, i = i.divmod(int)
      end
    end
   return res
  end
end
