--Name : Nisha Patel
-- Date: 10/21/16
--File : experiment1_tb.vhdl

library IEEE;
use IEEE.std_logic_1164.all;
--A testbench has no ports
entity experiment1_tb is
end experiment1_tb;

architecture behav of experiment1_tb is
-- specifies which entity is bound with the component
  signal i0 : std_logic_vector(2 downto 0);
  signal o : std_logic_vector(7 downto 0);

begin
  -- component instantiation
  decoder: entity work.experiment1 port map (i0, o);
-- this process does the real job
  process
  begin
    -- pattern
    i0 <= "00-";
    wait for 2 ns; -- wait for result;
    i0 <= "001";
    wait for 2 ns;
    i0 <= "010";
    wait for 2 ns;
    i0 <= "011";
    wait for 2 ns;
    i0 <= "100";
    wait for 2 ns;
    i0 <= "101";
    wait for 2 ns;
    i0 <= "110";
    wait for 2 ns;
    i0 <= "111";
    wait for 2 ns;

    assert false report "end of test" severity note;
    wait; -- wait forever; this will finish the simulation
  end process;
end behav;
