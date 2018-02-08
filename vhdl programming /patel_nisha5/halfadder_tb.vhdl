--Name : Nisha Patel
-- Date: 10/21/16
--File : halfadder.vhdl

library IEEE;
use ieee.std_logic_1164.all;
-- A testbench has no ports
entity halfadder_tb is
end halfadder_tb;

architecture behav of halfadder_tb is
  -- specifies which entity is bound with the component
  signal a,b : std_logic;
  signal sum,carry : std_logic;
 
  
begin
  -- component instantiation
  halfadder1: entity work.halfadder port map (a, b, sum, carry);
  -- this process does the real job
  process
  begin
    a <= '1';
    --wait for 10 ns;
    b <= '0';
    wait for 10 ns; -- wait for results;
    a <= '0';
   -- wait for 10 ns;
    b <= '1';
    wait for 10 ns;
    a <= '0';
   -- wait for 10 ns;
    b <= '0';
    wait for 10 ns;
    a <= '1';
     --wait for 10 ns;
    b <= '1';
    wait for 10 ns;
    assert false report "end of test" severity note;
    wait;
  end process;
end behav;

