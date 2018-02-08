library ieee;
use ieee.std_logic_1164.all;


entity register_tb is
end register_tb;

architecture behav of register_tb is
  signal read_reg1,read_reg2,write_reg : std_logic_vector(2 downto 0);
  signal write_data: std_logic_vector(3 downto 0);
  signal r_write : std_logic;
  signal read_data1,read_data2: std_logic_vector (3 downto 0);
  constant clk_period : time := 4 ns;
begin
  
  register0: entity work.register1 port map(read_reg1,read_reg2,write_reg,write_data,r_write,read_data1,read_data2);
  
process
  begin
   -- for i in 1 to 50 loop
      r_write <='0';
      wait for clk_period/2;
      r_write <= '1';
      wait for clk_period/2;
      r_write <= '0';
      wait for clk_period/2;
    --end loop;
end process;
  
process
begin
 
  read_reg1 <="000";
  read_reg2 <="000";
  write_reg <="001";
  write_data <="0001";
 
  wait for 20 ns;
  read_reg1 <="000";
  read_reg2 <="001";
  write_reg <="010";
  write_data <="0010";
  
  wait for 20 ns;
  read_reg1 <="001";
  read_reg2 <="000";
  write_reg <="001";
  write_data <="0001";
 
  wait for 20 ns;
  read_reg1 <="001";
  read_reg2 <="010";
  write_reg <="010";
  write_data <="0010";
  wait for 20 ns;

  read_reg1 <="010";
  read_reg2 <="000";
  write_reg <="001";
  write_data <="0001";

  wait for 20  ns;
  read_reg1 <="000";
  read_reg2 <="110";
  write_reg <="010";
  write_data <="0010";

  wait for 20 ns;
  read_reg1 <="001";
  read_reg2 <="010";
  write_reg <="001";
  write_data <="0001";

  wait for 20 ns;
  read_reg1 <="001";
  read_reg2 <="001";
  write_reg <="010";
  write_data <="0010";
  wait for 20 ns;
  
  read_reg1 <="000";
  read_reg2 <="000";
  write_reg <="001";
  write_data <="0001";

  wait for 20 ns;
  read_reg1 <="000";
  read_reg2 <="001";
  write_reg <="010";
  write_data <="0110";

  wait for 20 ns;
  read_reg1 <="001";
  read_reg2 <="000";
  write_reg <="011";
  write_data <="1001";

  wait for 20  ns;
  read_reg1 <="001";
  read_reg2 <="010";
  write_reg <="110";
  write_data <="0000";
  wait for 20 ns;
 
  

  assert false report "end of test" severity note;
  wait;
end process;
end behav;


  
--Note: I worked with Justin and Chase. 
