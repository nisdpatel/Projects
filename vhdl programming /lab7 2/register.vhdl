library ieee;
use ieee.std_logic_1164.all;

entity register1 is
  port ( read_reg1, read_reg2 : in std_logic_vector(2 downto 0);
         write_reg : in std_logic_vector(2 downto 0);
         write_data : in std_logic_vector(3 downto 0);
         r_write : in std_logic;
         read_data1, read_data2 : out std_logic_vector(3 downto 0));
end register1;

architecture behav of register1 is

--temporary signals
 --temp for and gates that holds the output from the decoder as one of its input 
  signal tand : std_logic_vector(7 downto 0);
 --temp to perform and operation 
 signal temp: std_logic_vector(7 downto 0);   
  --temp variables that holds the output of each register
  signal q_out1 : std_logic_vector(3 downto 0);
  signal q_out2 : std_logic_vector(3 downto 0);
  signal q_out3 : std_logic_vector(3 downto 0);
  signal q_out4 : std_logic_vector(3 downto 0);
  signal q_out5 : std_logic_vector(3 downto 0);
  signal q_out6 : std_logic_vector(3 downto 0);
  signal q_out7 : std_logic_vector(3 downto 0);
  signal q_out8 : std_logic_vector(3 downto 0);
  signal temp_mux1: std_logic_vector(7 downto 0);
  signal temp_mux2: std_logic_vector(7 downto 0);
  signal temp_mux3: std_logic_vector(7 downto 0);
  signal temp_mux4: std_logic_vector(7 downto 0);
  --signal mout1 : std_logic;
  --signal mout2 : std_logic;
  --signal mout3 : std_logic;
 -- signal mout4 : std_logic;
  --signal mout5 : std_logic;
  --signal mout6 : std_logic;
  --signal mout7 : std_logic;
  --signal mout8 : std_logic;
 
  
 
begin
  
  -- decoder instances
 DECODER: entity work.experiment1 port map(write_reg,tand);
 temp(0) <= (r_write and tand(0));
 temp(1) <= (r_write and tand(1));
 temp(2) <= (r_write and tand(2));
 temp(3) <= (r_write and tand(3));
 temp(4) <= (r_write and tand(4));
 temp(5) <= (r_write and tand(5));
 temp(6) <= (r_write and tand(6));
 temp(7) <= (r_write and tand(7));
 


 
 DFF4A : entity work.dff4 port map(write_data,temp(0),q_out1);
 DFF4B : entity work.dff4 port map(write_data,temp(1),q_out2);
 DFF4C : entity work.dff4 port map(write_data,temp(2),q_out3);
 DFF4D : entity work.dff4 port map(write_data,temp(3),q_out4);
 DFF4E : entity work.dff4 port map(write_data,temp(4),q_out5);
 DFF4F : entity work.dff4 port map(write_data,temp(5),q_out6);
 DFF4G : entity work.dff4 port map(write_data,temp(6),q_out7);
 DFF4H : entity work.dff4 port map(write_data,temp(7),q_out8);

 temp_mux1 <= q_out1 & q_out2;
 temp_mux2 <= q_out3 & q_out4;
 temp_mux3 <= q_out5 & q_out6;
 temp_mux4 <= q_out7 & q_out8;
 
 


  
  MUX1: entity work.mux8 port map(temp_mux1,read_reg1,read_data1(0));
  MUX2: entity work.mux8 port map(temp_mux2,read_reg1,read_data1(1));
  MUX3: entity work.mux8 port map(temp_mux3,read_reg1,read_data1(2));
  MUX4: entity work.mux8 port map(temp_mux4,read_reg1,read_data1(3));
  MUX5: entity work.mux8 port map(temp_mux1,read_reg2,read_data2(0));
  MUX6: entity work.mux8 port map(temp_mux2,read_reg2,read_data2(1));
  MUX7: entity work.mux8 port map(temp_mux3,read_reg2,read_data2(2));
 MUX8: entity work.mux8 port map(temp_mux4,read_reg2,read_data2(3));

 --read_data1 <=( mout1 & mout2 & mout3 & mout4); 
 --read_data2 <=( mout5 & mout6 & mout7 & mout8);


  end behav;
 
  
