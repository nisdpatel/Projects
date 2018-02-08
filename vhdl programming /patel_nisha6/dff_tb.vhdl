library ieee;
use ieee.std_logic_1164.all;

entity dff_tb is
end dff_tb;

architecture behav of dff_tb is
  signal d, clock : std_logic;
  signal q: std_logic;
 
begin
  DFF: entity work.dff port map(d=>d, clock=>clock, q=>q);
  process
  begin
    d <= '1';
    clock <= '0';
    wait for 5 ns;
    d <= '1';
    clock <= '1';
    wait for 5 ns;
    d <= '0';
    clock <= '1';
    wait for 5 ns;
    d <= '0';
    clock <= '0';
    wait for 5 ns;
    d <= '1';
    clock <= '0';
    wait for 5 ns;
    d <= '1';
    clock <= '0';
    wait for 5 ns;
    d <= '0';
    clock <= '0';
    wait for 5 ns;
    d <= '0';
    clock <= '1';
    wait for 5 ns;
    d <= '1';
    clock <= '1';
    wait for 5 ns;
    d <= '1';
    clock <= '1';
    wait for 5 ns;
    d <= '0';
    clock <= '0';
    wait for 5 ns;

    assert false report "end of test" severity note;
    wait;
  end process;
  end behav;
