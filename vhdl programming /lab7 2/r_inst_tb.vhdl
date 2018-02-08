library ieee;
use ieee.std_logic_1164.all;

entity r_inst_tb is
end r_inst_tb;

architecture behav of r_inst_tb is
  signal inst16 : std_logic_vector(15 downto 0);
  signal  clock : std_logic;
  signal result: std_logic_vector(3 downto 0);
  constant clk_period : time := 4 ns;
begin
  R_INST : entity work. r_inst port map(inst16, clock, result);
  process
  begin
    clock <= '0';
    wait for clk_period/2;
    clock <= '1';
    wait for clk_period/2;
    clock <='0';
    wait for clk_period/2;
  end process;
  process
  begin
    inst16 <="0000000000000000";
    wait for 10 ns;
    inst16 <="1111111111111111";
    wait for 10 ns;
    inst16 <="1010101010101010";
    wait for 10  ns;
    inst16 <="1111000011110000";
    wait for 10  ns;
    inst16 <="1111111100000000";
    wait for 10  ns;
    inst16 <="0000000000000000";
    wait for 10 ns;
    inst16 <="1111111111111111";
    wait for 10 ns;
    inst16 <="1010101010101010";
    wait for 10  ns;
    inst16 <="1111000011110000";
    wait for 10  ns;
    inst16 <="1111111100000000";
    wait for 10  ns;
    inst16 <="0011000000000000";
    wait for 10 ns;
    inst16 <="1110111111111111";
    wait for 10 ns;
    inst16 <="1010101010101010";
    wait for 10  ns;
    inst16 <="1111000011110000";
    wait for 10  ns;
    inst16 <="1100111100000000";
    wait for 10  ns;
    inst16 <="0000000000000000";
    wait for 10 ns;
    inst16 <="1111111111111111";
    wait for 10 ns;
    inst16 <="1010101010101010";
    wait for 10  ns;
    inst16 <="0000000011110000";
    wait for 10  ns;
    inst16 <="1111111100000000";
    wait for 10  ns;
    


    
    assert false report "end of test" severity note;
    wait;
  end process;
end behav;
