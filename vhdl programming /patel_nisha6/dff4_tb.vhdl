library ieee;
use ieee.std_logic_1164.all;

entity dff4_tb is
end dff4_tb;

architecture behav of dff4_tb is
  signal d, q: std_logic_vector(3 downto 0);
  signal clock: std_logic;

begin
  DFF4: entity work.dff4 port map(d=>d,clock=>clock,q=>q);
  process
  begin
    for i  in 1 to 50 loop
      clock <='1';
      wait for 10 ns;
      clock <= '0';
      wait for 10 ns;
      exit;
    end loop;
  end process;
  process
  begin
    d <="1111";
    wait for 5 ns;
    d <="1111";
    wait for 5 ns;
    d <="1100";
    wait for 5 ns;
    d <="1100";
    wait for 5 ns;
    d <="0011";
    wait for 5 ns;
    d <="0011";
    wait for 5 ns;
    d <="1001";
    wait for 5 ns;
    d <="1001";
    wait for 5 ns;
    d <="1000";
    wait for 5 ns;
    d <="1000";
    wait for 5 ns;
    d <="0010";
    wait for 5 ns;
    d <="0010";
    wait for 5 ns;
    d <="0001";
    wait for 5 ns;
    d <="0001";
    wait for 5 ns;
    d <="0110";
    wait for 5 ns;
    d <="0110";
    wait for 5 ns;
    d <="0000";
    wait for 5 ns;
    d <="0000";
    wait for 5 ns;
    d <="1111";
    wait for 5 ns;
    d <="1111";
    wait for 5 ns;
    d <="1100";
    wait for 5 ns;
    d <="1100";
    wait for 5 ns;
    d <="0011";
    wait for 5 ns;
    d <="0011";
    wait for 5 ns;
    assert false report "end of test" severity note;
    wait;
   
   end process;
end behav;
  
