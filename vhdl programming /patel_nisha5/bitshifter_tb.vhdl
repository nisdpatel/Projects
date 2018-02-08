--Name : Nisha Patel
-- Date: 10/21/16
--File : bitshifter_tb.vhdl

library ieee;
use ieee.std_logic_1164.all;

--A testbench has no ports
entity bitshifter_tb is
end bitshifter_tb;

architecture behav of bitshifter_tb is
  -- specifies which entity is bound with the component
  signal i0 : std_logic_vector(3 downto 0);
  signal s: std_logic :='1';
  signal o : std_logic_vector(3 downto 0);

begin
  --component instantiation
 bitshift: entity work.bitshifter port map (i0,s,o);
  --this process does the real job
  process
  begin
    --pattern
    i0 <= "0000";
    wait for 2 ns;
    i0 <= "0001";
    wait for 2 ns;
    i0 <= "0010";
    wait for 2 ns;
    i0 <= "0011";
    wait for 2 ns;
    i0 <= "0100";
    wait for 2 ns;
    i0 <= "0101";
    wait for 2 ns;
    i0 <= "0110";
    wait for 2 ns;
    i0 <= "0111";
    wait for 2 ns;
    i0 <= "1000";
    wait for 2 ns;
    i0 <= "1001";
    wait for 2 ns;
    i0 <= "1010";
    wait for 2 ns;
    i0 <= "1011";
    wait for 2 ns;
    i0 <= "1100";
    wait for 2 ns;
    i0 <= "1101";
    wait for 2 ns;
    i0 <= "1110";
    wait for 2 ns;
    i0 <= "1111";
    wait for 2 ns;
    
    assert false report "end of test" severity note;
    wait;
  end process;
end behav;
