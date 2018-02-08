--Name : Nisha Patel
-- Date: 10/21/16
--File : nibble_tb.vhdl


library ieee;
use ieee.std_logic_1164.all;

entity nibble_tb is
end nibble_tb;

architecture behav of nibble_tb is    
--inputs
  signal a,b: std_logic_vector (3 downto 0);
  signal cin : std_logic := '0'; -- you can change it to 1 if you want to test both cases s=0 or s=1

  --outputs
  signal s: std_logic_vector(3 downto 0);
  signal cout : std_logic;

begin
  --component instantiation
  nibble1: entity work.nibble port map(a,b,cin,s,cout); --a=>a ,b=>b, cin=>cin, s=>s, cout=>cout);
  -- this porces does the real job
process 
  begin
    a <= "0110";
    b <= "1100";
    wait for 200 ns;
    a <= "1111";
    b <= "1100";
    wait for 200 ns;
    a <= "0110";
    b <= "0111";
    wait for 200 ns;
    a <= "0110";
    b <= "1110";
    wait for 200 ns;
    a <= "1111";
    b <= "1111";
    wait for 200 ns;
    assert false report "end of test" severity note;
    wait;
  end process;
end behav;
