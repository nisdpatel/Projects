library ieee;
use ieee.std_logic_1164.all;

entity mux_tb is
end mux_tb;

architecture behav of mux_tb is
 
signal i0 : std_logic_vector(3 downto 0);
signal s : std_logic_vector(1 downto 0);
signal o:std_logic;



begin
  mux: entity work.mux port map(i0,s,o);
  
  process
   begin
    --pattern
     i0 <= "0000";
     s <= "00";
     wait for 5 ns;
     s <= "01";
     wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
    
    i0 <= "0001";
     s <= "00";
     wait for 5 ns;
     s <= "01";
     wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
     
     i0 <= "0010";
     s <= "00";
     wait for 5 ns;
     s <= "01";
     wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
    
  
     i0 <= "0011";
     s <= "00";
     wait for 5 ns;
     s <= "01";
      wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
    
    i0 <= "0100";
     s <= "00";
     wait for 5 ns;
     s <= "01";
      wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
     
    i0 <= "0101";
     s <= "00";
     wait for 5 ns;
     s <= "01";
      wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
     
    i0 <= "0110";
     s <= "00";
     wait for 5 ns;
     s <= "01";
      wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
     
    i0 <= "0111";
     s <= "00";
     wait for 5 ns;
     s <= "01";
     wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;

    i0 <= "1000";
     s <= "00";
     wait for 5 ns;
     s <= "01";
     wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
     
    i0 <= "1001";
     s <= "00";
     wait for 5 ns;
     s <= "01";
     wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
     
    i0 <= "1010";
     s <= "00";
     wait for 5 ns;
     s <= "01";
      wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
     
    i0 <= "1011";
     s <= "00";
     wait for 5 ns;
     s <= "01";
      wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
     
    i0 <= "1100";
     s <= "00";
     wait for 5 ns;
     s <= "01";
     wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
     
    i0 <= "1101";
     s <= "00";
     wait for 5 ns;
     s <= "01";
      wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
     
    i0 <= "1110";
     s <= "00";
     wait for 5 ns;
     s <= "01";
     wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
     
    i0 <= "1111";
     s <= "00";
     wait for 5 ns;
     s <= "01";
     wait for 5 ns;
     s <= "10";
     wait for 5 ns;
     s <= "11";
     wait for 5 ns;
      assert false report "end of test" severity note;
      wait;
    end process;
end behav;
  
