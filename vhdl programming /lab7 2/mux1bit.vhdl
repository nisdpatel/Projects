library ieee;
use ieee.std_logic_1164.all;

entity mux1bit is
  port( i1,i2 : in std_logic_vector(3 downto 0);
            s : std_logic;
            o : out std_logic_vector(3 downto 0));
end mux1bit;


architecture behav of mux1bit is
begin
  o <= i1 when (s = '1') else i2;
end behav;
