--Name : Nisha Patel
-- Date: 10/21/16
--File : fulladder_tb.vhdl

library IEEE;
use ieee.std_logic_1164.all;
--A testbench has no ports
entity fulladder_tb is
end fulladder_tb;

architecture behav of fulladder_tb is
  --specifies which entity is bound with the component
  signal a,b,cin: std_logic;
  signal sum,cout :std_logic;

begin
  --component instantiation
  fulladder1: entity work.fulladder port map (a,b,cin,sum,cout);
  -- this process does the real job
  process
  begin
    a <=   '0';
    b <=   '0';
    cin <= '0';
    wait for 2 ns;
    a <=   '0';
    b <=   '0';
    cin <= '1';
    wait for 2 ns;
    a <=   '0';
    b <=   '1';
    cin<=  '0';
    wait for 2 ns;
    a <=   '0';
    b <=   '1';
    cin<=  '1';
    wait for 2 ns;
    a <=   '1';
    b <=   '0';
    cin<=  '0';
    wait for 2 ns;
    a <=   '1';
    b <=   '0';
    cin <= '1';
    wait for 2 ns;
    a <=  '1';
    b <=  '1';
    cin<= '0';
    wait for 2 ns;
    a <=   '1';
    b <=   '1';
    cin <= '1';
    wait for 2 ns;
    assert false report "end of test" severity note;
    wait;
  end process;
end behav;
