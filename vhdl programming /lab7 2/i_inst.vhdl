library ieee;
use ieee.std_logic_1164.all;

entity i_inst is
  port (inst16 : in std_logic_vector(15 downto 0);
        clock : in std_logic;
        result: inout std_logic_vector(3 downto 0));
end i_inst;

architecture behav of i_inst is
  signal t_read1, t_read2,m_out: std_logic_vector(3 downto 0);
  signal t_write : std_logic_vector(3 downto 0) := "0000";
  signal t_cout,t_dead : std_logic;
  --signal t_dead6 : std_logic;
begin
  
  REGISTER1: entity work.register1 port map (
    inst16(5 downto 3), inst16(9 downto 7), inst16(2 downto 0), t_write, clock, t_read1, t_read2);

  MUX: entity work.mux1bit port map(t_read2,inst16(9 downto 6), inst16(15),m_out); 
  ALU: entity work.alu4 port map(t_read1, m_out, inst16(14), inst16(13), inst16(12), inst16(11 downto 10),t_cout, result);
  t_write <=result;  
 
     end behav;
