--Name : Nisha Patel
library ieee;
use ieee.std_logic_1164.all;

entity mux is
  port(i : in std_logic_vector(3 downto 0);
       s  : in std_logic_vector (1 downto 0);
       o : out std_logic);
end mux;

architecture arch of mux is
begin
  o <= (i(0) and (not s(1)) and (not s(0))) or
       (i(1) and (not s(1)) and s(0)) or
       (i(2) and i(1) and (not s(0))) or
       (i(3) and i(1) and s(0));
end arch;
